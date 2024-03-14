package com.fsse2401.project_backend.data.user.entity;

import jakarta.persistence.*;

@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer uid;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String firebaseUid;

    public UserEntity() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }
}
