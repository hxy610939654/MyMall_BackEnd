package com.mymall.service;

import com.mymall.common.ServerResponse;
import com.mymall.pojo.User;

public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str,String type);
}
