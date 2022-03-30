package com.wolff.filesystem;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolff.filesystem.model.Filesystem;
import com.wolff.filesystem.model.Lastdir;
import com.wolff.filesystem.service.FileService;

import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class App {

    public static void main(String[] args){


        try{
        File f = new File("src/main/resources/courses.json");



        String command = "powershell Get-ChildItem \"E:\\moved\\UDEMY\\Courses\\egghead\" | Sort-Object name | ConvertTo-json | Out-file -FilePath  S:\\filesystem\\src\\main\\resources\\courses.json";

        List<Filesystem>listar = new ArrayList<>();

        String line;


            Process process = Runtime.getRuntime().exec(command);
            process.getOutputStream();
            process.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            ObjectMapper mapper = new ObjectMapper();
            Filesystem []filesystem = mapper.readValue(f, Filesystem[].class);

            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}


