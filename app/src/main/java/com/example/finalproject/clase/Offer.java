package com.example.finalproject.clase;

public class Offer {

    private Integer id;
    private String type;
    private String Description;

    public Offer(Integer id, String type, String description) {
        this.id = id;
        this.type = type;
        Description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
