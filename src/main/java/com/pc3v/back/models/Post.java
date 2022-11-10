package com.pc3v.back.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name = "posts")
@Table(name = "posts")
public class Post implements Serializable {

    private static final long serialVersionUID = 4235393151425571253L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="content",columnDefinition = "TEXT")
    private String content;

    @Column(name="created_at",updatable = false, nullable = false)
    private Date createAt;

    @Column(name="updated_at",nullable = false)
    private Date updatedAt;

    public Post() {
    }

    @PrePersist
    protected void onCreate() {
        this.createAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createAt;
    }

    public void setCreatedAt(Date created_at) {
        this.createAt = created_at;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updatedAt = updated_at;
    }
}
