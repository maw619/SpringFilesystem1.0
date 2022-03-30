package com.wolff.filesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Filesystem implements Serializable {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("Parent")
    private Parent parent;

    @JsonProperty("Exists")
    private String exists;

    @JsonProperty("PSParentPath")
    private String pSParentPath;

    @JsonProperty("PSPath")
    private String pSPath;

    @JsonProperty("PSChildName")
    private String pSChildName;


    public Filesystem(){

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {

        this.parent = parent;
    }

    public String getExists() {
        return exists;
    }

    public void setExists(String exists) {
        this.exists = exists;
    }

    public String getpSParentPath() {
        return pSParentPath;
    }

    public void setpSParentPath(String pSParentPath) {
        this.pSParentPath = pSParentPath;
    }

    public String getpSPath() {
        return pSPath;
    }

    public void setpSPath(String pSPath) {
        this.pSPath = pSPath;
    }

    public String getpSChildName() {
        return pSChildName;
    }

    public void setpSChildName(String pSChildName) {
        this.pSChildName = pSChildName;
    }

    @Override
    public String toString() {
        return "Filesystem{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", parent=" + parent +
                ", exists='" + exists + '\'' +
                '}';
    }
}