package com.example.androidvideoplayerapp.models;

public class VideoModel {
    String fileName;
    String filePath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public VideoModel(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }
}
