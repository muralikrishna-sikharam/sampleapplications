package com.example.sampleapplications;

public class CourseModel {

    //      "id": "1",
    //      "service": "Dry Cleaning & Laundry",
    //      "image": "http://richlabz.com/sparkles_app/uploads/services/drycleaning.png",
    //      "position": "1",
    //      "added_on": "2023-09-05 13:08:25",
    //      "status": "1",
    //      "addedOn": "2023-09-05 13:08:25"

    private String id;
    private String service_Name;
    private String image_Url;
    private String position;
    private String added_on;
    private String status;
    private String addedOn;
    private String avatar_url;

    public CourseModel(String id, String avatar_url) {
        this.id = id;
        this.avatar_url = avatar_url;
    }

    public String getService_Name() {
        return service_Name;
    }

    public void setService_Name(String service_Name) {
        this.service_Name = service_Name;
    }

    public String getImage_Url() {
        return image_Url;
    }

    public void setImage_Url(String image_Url) {
        this.image_Url = image_Url;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAdded_on() {
        return added_on;
    }

    public void setAdded_on(String added_on) {
        this.added_on = added_on;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

