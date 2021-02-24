package com.example.adminstudy.controller.api;

import com.example.adminstudy.interfaces.CrudInterface;
import com.example.adminstudy.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface
{

    @PostMapping("")
    public Header create()
    {
        return null;
    }

    @GetMapping("/{id}")
    public Header read(@PathVariable Long id)
    {

        return null;
    }

    @PutMapping("")
    public Header update()
    {
        return null;
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable Long id)
    {
        return null;
    }
}
