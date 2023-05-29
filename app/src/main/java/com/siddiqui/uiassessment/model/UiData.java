package com.siddiqui.uiassessment.model;

public class UiData {
    private String text;
    private int imageResourceId;

    public UiData(String text, int imageResourceId) {
        this.text = text;
        this.imageResourceId = imageResourceId;
    }

    public String getText() {
        return text;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
