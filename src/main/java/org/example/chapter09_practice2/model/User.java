package org.example.chapter09_practice2.model;


import org.example.chapter09_practice2.util.DateUtil;

public class User {
    private int id;
    private String name;
    private String email;
    private String createdAt;
    private String updatedAt;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = DateUtil.now();
        this.updatedAt = DateUtil.now();

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return
                " 학번='" + id +
                ", 이름='" + name + '\'' +
                ", 이메일='" + email + '\'' +
                ", 생성날짜='" + createdAt + '\'' +
                ", 수정날짜='" + updatedAt + '\'' +
                '}';
    }
}
