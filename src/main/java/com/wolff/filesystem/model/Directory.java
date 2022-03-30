package com.wolff.filesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Directory {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("Parent")
    private String parent;

    @JsonProperty("Exists")
    private boolean exists;

    @JsonProperty("Extension")
    private String extension;

    @JsonProperty("CreationTime")
    private String creationTime;

    @JsonProperty("LastAccessTime")
    private String lastAccessTime;


    public Directory(){

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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", parent='" + parent + '\'' +
                ", exists=" + exists +
                ", extension='" + extension + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", lastAccessTime='" + lastAccessTime + '\'' +
                '}';
    }
}
