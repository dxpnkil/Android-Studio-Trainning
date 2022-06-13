package com.example.mail_app_ui;

public class Item {
    private String name;
    private String header;
    private String content;
    private boolean toggle;

    public Item(String name, String header, String content) {
        this.name = name;
        this.header = header;
        this.content = content;
        this.toggle = false;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }
}
