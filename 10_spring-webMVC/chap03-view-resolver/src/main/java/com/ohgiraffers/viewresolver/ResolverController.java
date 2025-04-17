package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model){
        model.addAttribute("forwardMessage", "문자열로 뷰 이름을 반환함");
        /*
         * 문자열로 뷰 이름을 반환한다는 것은 반환후
         * ThyleafViewResolver에게 resources/templates를 prefix로 .html을 surffix로 하여
         * resources.template/result.html 파일을 응답뷰로 설정하라는 의미가 된다
         *
         * */
        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect(Model model){

        model.addAttribute("test","테스트를 위한 값입니다.");
        //접두사로 redirect: 를 하게되면 forward가 아닌 redirect 시키게 된다 , 로그인을 했는데 비밀번호 오류 : 로그인 다시 해줘 요청할 때 리다이렉트 쓰기도함
        //redirect : 요청에 대한 응답 처리에서 요청 정보를 잃어버리고 다시 요청
        return "redirect:/";
    }
    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttribute(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("flashMessage1","리다이렉트를 사용 redirect");
        //임시저장소에 요청 데이터 저장 (다음 요청시 까지만)

        return "redirect:/";
    }

    @GetMapping("modeladnview")
    public ModelAndView modeladnview(ModelAndView mv){

        mv.addObject("forwardMessage","modelAndView를 사용한 모델과 뷰 반환");
        mv.setViewName("result"); //view 페이지에 이동될 경로
        return mv;
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv){
        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr){

        rttr.addFlashAttribute("flashMessage2","modelAndView르 ㄹ활용한 redirect attr");
        return mv;
    }

}
