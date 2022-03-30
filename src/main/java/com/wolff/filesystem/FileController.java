package com.wolff.filesystem;

import com.wolff.filesystem.model.Filesystem;
import com.wolff.filesystem.model.Lastdir;
import com.wolff.filesystem.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) throws IOException, InterruptedException {
        this.fileService = fileService;
    }



    @GetMapping
    public String home(Model model) throws IOException, InterruptedException {
        List<Filesystem> listar = fileService.getFiles("aws");
        model.addAttribute("listar",listar);
        return "index";
    }

    @GetMapping("list/{name}")
    public String listDirectories(@PathVariable("name")String name, Model model) throws IOException, InterruptedException {
        List<Lastdir> listar = fileService.getDirectories(name);
       model.addAttribute("listed",listar);
        return "sublist";
    }

    @GetMapping("/videos")
    public String listByName(@ModelAttribute("name")Lastdir name, Model model) throws IOException, InterruptedException {
        Lastdir last = new Lastdir();
        Lastdir listarone = fileService.getByFile(name.getName());
        model.addAttribute("listbyname",listarone);
        return "sublist";
    }

}
