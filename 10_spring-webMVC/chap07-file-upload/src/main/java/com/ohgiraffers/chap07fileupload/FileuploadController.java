package com.ohgiraffers.chap07fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller

public class FileuploadController {

    private ResourceLoader resourceLoader; //리소스를 읽어오는 도구(interface) : classpath, 파일 시스템, URL 등에서 파일을 읽어오게 해주는 도우미

    @Autowired //생성자 주입 : 불변성, 의존성이 명확
    public FileuploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    } //생성자

    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile, String singleFileDescription, Model model) throws IOException {
        System.out.println("singleFile " + singleFile);
        System.out.println("singleFileDescription " + singleFileDescription);
    //@RequestParam MultipartFile singleFile : 업로드된 파일을 받는 매개변수, 클라이언트가 보낸 <input type="file" name="singleFile"> 요소의 데이터를 받아옴
    //String singleFileDescription : 파일과 함께 전송되는 설명 텍스트를 받는 매개변수, 일반적인 form 데이터고, 별도로 어노테이션 없어도 잘 매핑됨
    //Model model : View에 데이터를 전달할 때 사용하는 Spring의 Model 객체
        Resource resource = resourceLoader.getResource("classpath:static/img/single"); //리소스 경로 참조할 수 있도록 resourceLoader 사용,
        String filePath = null;
        if(!resource.exists()) {
            String root = "src/main/resources/static/img/single";  //경로 지정
            File file = new File(root); //파일 객체에 넣어줌
            file.mkdirs(); //make 디렉토리
            filePath = file.getAbsolutePath();
        }else{
            filePath = resourceLoader.getResource("classpath:static/img/single").getFile().getAbsolutePath();//존재할 시
            //경로를 리소스 객체로 가져옴, getAbsolutePath(): 절대경로를 문자열로 가져옴
        }

        String originFileName = singleFile.getOriginalFilename(); //원본파일 이름을 가져옴 ex)원본이름.png
        String ext = originFileName.substring(originFileName.lastIndexOf("."));//현재 파일 객체의 뒤에서부터 "."을 찾겠다 -> 확장자 도출 -> .png
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext; //  "-"이 있다면 제거, +ext  -> 랜덤값 13-11-414 -> 1311414 + .png (ext가 갖고있는 png)
        //덮어쓰기 (이름중복) 방지 -> 랜덤하게 생성
        //originFileName(사용자에게 보여주는 용도)와 savedName(파일 저장용도) 둘 다 저장
        //예를 들어 exe 확장자의 파일이 들어올 때 바로 실행될 수도 있음 -> 확장자 분리해서 저장 (알 수 없는 파일이 됨)
        //특정 형식만 받기 -> 컨테인 코드를 통해 ext(확장자 형식이 들어있는 변수) 구분해서 받기 가능

        try{
            // static/img/single/1311414.png
            singleFile.transferTo(new File(filePath +"/"+ savedName)); //파일의 이진데이터를 파일 형식으로 바꿔줌
            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("img", "static/img/single/"+savedName);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패");
        }

        return "result";
    }

    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multipartFiles,
                                  String multiFileDescription, Model model) throws IOException {
        System.out.println("multifile " + multipartFiles);
        System.out.println("multiFileDescription " + multiFileDescription);

        Resource resource = resourceLoader.getResource("classpath:static/img/multi");
        String filePath = null;

        if(!resource.exists()) {
            String root = "src/main/resources/static/img/multi";
            File file = new File(root);
            file.mkdirs();

            filePath = file.getAbsolutePath();
        }else{
            filePath = resourceLoader.getResource("classpath:static/img/multi").getFile().getAbsolutePath();
        }
        System.out.println("multi : " +filePath);

        List<FileDTO> files = new ArrayList<>();
        List<String> saveFiles = new ArrayList<>();

        try{
            for (MultipartFile multipartFile : multipartFiles) {
                String originalFileName = multipartFile.getOriginalFilename(); //현재이름
                String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); //확장자
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext; //저장 이름

                files.add(new FileDTO(originalFileName, savedName, filePath, multiFileDescription));
                multipartFile.transferTo(new File(filePath +"/"+ savedName)); //실질적 저장
                saveFiles.add("static/img/multi/"+savedName);
            }
            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("imgs", saveFiles);
        } catch (Exception e) {
            e.printStackTrace();
            for(FileDTO fileDTO : files){//10개중에 8개 째를 저장하다 실패 -> 다 제거하고 다시 처음부터 저장 (이렇지 않으면 8개가 중복저장) , 캐싱을 쓸 수도 있음
                new File(filePath+"/"+fileDTO.getSavedName()).delete();
            }
            model.addAttribute("message", "파일 업로드 실패");
        }
        return "result";
    }


}