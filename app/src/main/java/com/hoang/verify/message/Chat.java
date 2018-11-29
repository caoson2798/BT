package com.hoang.verify.message;

public class Chat {
    String content;
    int check;

    public Chat(String content, int check) {
        this.content = content;
        this.check = check;
    }

    public Chat() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
