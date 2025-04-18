package com.ohgiraffers.chap07fileupload;

public class FileDTO {

    private String originFileName;
    private String savedName;
    private String filePath;
    private String fileDescription;

    public FileDTO(){

    } //기본 생성자 만드는 이유 : 일단 생성 -> 주입 (전달 받은 네임의 값과 변수의 이름이 같아야 주입가능)

    public FileDTO(String originFileName, String savedName, String filePath, String fileDescription) {
        this.originFileName = originFileName;
        this.savedName = savedName;
        this.filePath = filePath;
        this.fileDescription = fileDescription;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getSavedName() {
        return savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "originFileName='" + originFileName + '\'' +
                ", savedName='" + savedName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                '}';
    }
}
