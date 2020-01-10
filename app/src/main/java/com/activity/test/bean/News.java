package com.activity.test.bean;

/**
 * Created by hasse on 2020/1/7.
 */

public class News {

    private String title;


    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
