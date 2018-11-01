package com.tns.maraton.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tns.maraton.model.response.PingResponse;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.services.LoginService;
import com.tns.maraton.util.FileUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

    @Autowired
    private LoginService service;


    @GetMapping("/ping")
    public PingResponse ping(){
        return new PingResponse("Estás conectado!!");
    }

    @PostMapping("/register")
    public RecognizeResponse register(@RequestPart(value = "file") MultipartFile image, @RequestPart(value = "user") String user) throws IOException {
        return service.register(FileUtil.convert(image), user);

    }

    @PostMapping("/compare")
    public RecognizeResponse compare(@RequestPart(value = "file") MultipartFile image, @RequestPart(value = "user") String user) throws IOException {
        return service.compare(FileUtil.convert(image), user);

    }

}
