package com.example.adminstudy.controller.api;

import com.example.adminstudy.interfaces.CrudInterface;
import com.example.adminstudy.model.network.Header;
import com.example.adminstudy.model.network.request.UserApiRequest;
import com.example.adminstudy.model.network.response.UserApiResponse;
import com.example.adminstudy.service.UserApiLogicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse>
{
    private final UserApiLogicService userApiLogicService;

    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request)
    {
        log.info("{}",request);
        return userApiLogicService.create(request);
    }

    @GetMapping("/{id}")
    public Header read(@PathVariable Long id)
    {
        log.info("read id : {}", id);
        return userApiLogicService.read(id);
    }

    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest)
    {
        return null;
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable Long id)
    {
        return null;
    }
}
