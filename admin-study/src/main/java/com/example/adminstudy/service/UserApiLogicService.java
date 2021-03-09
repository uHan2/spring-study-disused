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
        // 1. data
        UserApiRequest userApiRequest = request.getData();

        // 2. id -> user data 찾기
        Optional<User> optional = userRepository.findById(userApiRequest.getId());


        return optional.map(user ->
        {
            // 3. update
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());

            return user;
        })
                .map(user -> userRepository.save(user))  // update -> newUser
                .map(updateUser -> response(updateUser)) // userApiResponse
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id)
    {
        // 1. id -> repository -> user
        Optional<User> optional = userRepository.findById(id);

        // 2. repository -> delete
        optional.map(user ->
                {
                    userRepository.delete(user);

                    return Header.OK();
                }
        ).orElseGet(() -> Header.ERROR("데이터 없음"));

        // 3. response return
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
