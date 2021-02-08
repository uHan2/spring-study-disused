package com.example.adminstudy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SearchParam
{
    private String account;
    private String email;
    private int page;
}
