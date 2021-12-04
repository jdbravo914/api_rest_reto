package com.example.apirest_27_11_2021;

public class ObjectoEjercicio {

    private String id;
    private String userId;
    private String title;

    public ObjectoEjercicio(String id, String userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
