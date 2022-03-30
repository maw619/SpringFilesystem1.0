package com.wolff.filesystem.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolff.filesystem.model.Directory;
import com.wolff.filesystem.model.Filesystem;
import com.wolff.filesystem.model.Lastdir;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    public String baseE = "E:\\moved\\UDEMY\\Courses\\";
    public String baseEfull;
    public String full;


    public List<Filesystem>getFiles(String name) throws IOException, InterruptedException {
        File f = new File("src/main/resources/courses.json");
        String command = "powershell.exe Get-ChildItem \""+baseE+name+"\" | Sort-Object name | ConvertTo-json | Out-file -FilePath  S:\\filesystem\\src\\main\\resources\\courses.json";
        baseEfull = baseE+name;
        System.out.println("FROM GETFILES: "+baseEfull);
        Process process = Runtime.getRuntime().exec(command);
        process.getOutputStream();
        process.waitFor();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return mapper.readValue(f, new TypeReference<List<Filesystem>>(){});
    }

    public List<Lastdir>getDirectories(String name) throws IOException, InterruptedException {
        File f = new File("src/main/resources/courses2.json");
        String command = "powershell.exe Get-ChildItem '"+baseEfull+"\\"+name+"' -Include *.mp4 -recurse | Sort-Object BaseName | ConvertTo-json | Out-file -FilePath  S:\\filesystem\\src\\main\\resources\\courses2.json";

        System.out.println("FROM GETDIRECTORIES: "+baseEfull+"\\"+name);
        full = baseEfull+"\\"+name;

        Process process = Runtime.getRuntime().exec(command);
        process.getOutputStream();
        process.waitFor();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Lastdir> listar = mapper.readValue(f, new TypeReference<List<Lastdir>>(){});

        return listar;
    }

    public Lastdir getByFile(String name) throws IOException, InterruptedException {
        File f = new File("src/main/resources/courses3.json");
        String command = "powershell.exe Get-ChildItem '"+full+"' -Include *.mp4 -recurse | Sort-Object BaseName | ConvertTo-json | Out-file -FilePath  S:\\filesystem\\src\\main\\resources\\courses3.json";

        System.out.println("FROM GETBYFILE: "+full);
        System.out.println("Name FROM GETBYFILE: "+name);
        Process process = Runtime.getRuntime().exec(command);
        process.getOutputStream();
        process.waitFor();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Lastdir> lastdir = mapper.readValue(f, new TypeReference<List<Lastdir>>(){});
        Lastdir listar = null;
        for(int i = 0;i < lastdir.size();i++){
            System.out.println("+++++++++++++++++++"+lastdir.get(i).getName()+"+++++++++++++++++++");
            if(lastdir.get(i).getName().equals(name)){
                String names = lastdir.get(i).getName();
                int length = lastdir.get(i).getLength();
                Directory directory = lastdir.get(i).getDirectory();
                String fullName = lastdir.get(i).getFullName();
                String baseName = lastdir.get(i).getBaseName();
                listar = new Lastdir(names,length,directory,fullName,baseName);
            }
        }

        return listar;
    }

}
