package com.vip.springbootweb.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
    private String name, description;

    @Id
    private Integer id;

    public String getName() {
        return name;
    }

    public Topic() {

    }

    public Topic(String name, String description, int id) {
//        super();
        this.name = name;
        this.description = description;
        this.id = id;
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
}
