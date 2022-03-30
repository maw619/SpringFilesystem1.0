package com.wolff.filesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lastdir {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Length")
    private int length;

    @JsonProperty("Directory")
    private Directory directory;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("BaseName")
    private String baseName;

    public Lastdir(){

    }

    public Lastdir(String name, int length, Directory directory, String fullName, String baseName) {
        this.name = name;
        this.length = length;
        this.directory = directory;
        this.fullName = fullName;
        this.baseName = baseName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getFullName() {
        return fullName.replace("E:\\moved\\UDEMY\\Courses","");
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    @Override
    public String toString() {
        return "Lastdir{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", directory=" + directory +
                '}';
    }
}
