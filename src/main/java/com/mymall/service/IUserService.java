package com.mymall.service;

import com.mymall.common.ServerResponse;
import com.mymall.pojo.User;



public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse selectQuestion(String username);

    ServerResponse<String> forgetCheckAnswer(String username,String question,String answer);

    ServerResponse<String> forgetResetPassword (String username,String passwordNew,String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    ServerResponse<User> updateUserInfo(User user);

    ServerResponse<User> getInfo(Integer userId);
}
