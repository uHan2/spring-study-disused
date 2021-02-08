package com.example.adminstudy.controller;

import com.example.adminstudy.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController
{
    @PostMapping("/api/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam)
    {
        return searchParam;
    }
}
