package com.example.adminstudy.interfaces;

import com.example.adminstudy.model.network.Header;

public interface CrudInterface
{
    Header create();

    Header read(Long id);

    Header update();

    Header delete(Long id);
}
