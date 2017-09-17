package com.ych.service;

import com.ych.admin.dto.UserDTO;

/**
 * Created by chenhao.ye on 2017/9/17.
 */
public interface UserService {

    UserDTO findUserByName(String userName);

    void createUser(UserDTO userDTO);

}
