package com.vip.springbootweb.course;

import com.vip.springbootweb.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
    private String name, description;

    @Id
    private Integer id;
    public String getName() {
        return name;
    }

    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(String name, String description, int id, Topic topic) {
//        super();
        this.name = name;
        this.description = description;
        this.id = id;
        this.topic = topic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
