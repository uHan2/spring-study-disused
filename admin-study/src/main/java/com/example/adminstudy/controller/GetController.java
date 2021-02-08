package com.example.adminstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController
{
    @GetMapping("/api/getMethod")
    public String getRequest()
    {
        return "Hi getMethod";
    }

}
