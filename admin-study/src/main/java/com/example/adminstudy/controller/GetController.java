package com.example.adminstudy.controller;

import com.example.adminstudy.model.SearchParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController
{
    @GetMapping("/api/getMethod")
    public String getRequest()
    {
        return "Hi getMethod";
    }

    @GetMapping("/api/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam String password)
    {
        System.out.println("id = " + id);
        System.out.println("password = " + password);

        return id + password;
    }

    @GetMapping("/api/getMultiParameter")
    public SearchParam multiParameter(SearchParam searchParam)
    {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getPage());
        System.out.println(searchParam.getEmail());

        return searchParam;
    }

}
