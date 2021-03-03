package com.example.adminstudy.controller.api;

import com.example.adminstudy.interfaces.CrudInterface;
import com.example.adminstudy.model.network.Header;
import com.example.adminstudy.model.network.request.UserApiRequest;
import com.example.adminstudy.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse>
{

    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody UserApiRequest userApiRequest)
    {
        return null;
    }

    @GetMapping("/{id}")
    public Header read(@PathVariable Long id)
    {

        return null;
    }

    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody UserApiRequest userApiRequest)
    {
        return null;
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable Long id)
    {
        return null;
    }
}
