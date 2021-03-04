package com.example.adminstudy.service;

import com.example.adminstudy.interfaces.CrudInterface;
import com.example.adminstudy.model.entity.User;
import com.example.adminstudy.model.network.Header;
import com.example.adminstudy.model.network.request.UserApiRequest;
import com.example.adminstudy.model.network.response.UserApiResponse;
import com.example.adminstudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse>
{
    private final UserRepository userRepository;


    /**
     * 1. request data
     * 2. User 생성
     * 3. 생성된 데이터 -> UserApiResponse return
     *
     * @param request
     * @return
     */
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request)
    {
        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        //2. User 생
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);

        // 3. 생성된 데이터 -> userApiResponse return


        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id)
    {
        // id -> repository getOne, getById

        // user -> userApiResponse return

        return userRepository.findById(id).map(user -> response(user))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request)
    {
        return null;
    }

    @Override
    public Header delete(Long id)
    {
        return null;
    }

    private Header<UserApiResponse> response(User user)
    {
        //user -> userApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return
        return Header.OK(userApiResponse);

    }
}
