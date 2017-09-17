package com.ych.service.impl;

import com.ych.admin.dto.UserDTO;
import com.ych.admin.entity.User;
import com.ych.admin.entity.UserExample;
import com.ych.admin.enums.UserResponseEnum;
import com.ych.admin.mapper.UserMapper;
import com.ych.common.enums.CommonResponseEnum;
import com.ych.common.enums.StateEnum;
import com.ych.common.exception.BizException;
import com.ych.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenhao.ye on 2017/9/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public UserDTO findUserByName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            throw new BizException(CommonResponseEnum.PARAM_ERROR);
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName).andStateEqualTo(StateEnum.INVALID.getCode());
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            throw new BizException(CommonResponseEnum.DATA_NULL);
        }
        UserDTO userDTO = new UserDTO();
        return userDTO.convertToUserDTO(users.get(0));
    }

    @Override
    @Transactional
    public void createUser(UserDTO userDTO) {
        if (ObjectUtils.isEmpty(userDTO)) {
            throw new BizException(CommonResponseEnum.PARAM_ERROR);
        }
        UserExample userExample = new UserExample();
        // TODO 验证用户是否已存在(需要优化)
//        if (!StringUtils.isEmpty(userDTO.getNickName())) {
//            userExample.createCriteria().andNickNameEqualTo(userDTO.getNickName()).andStateEqualTo(StateEnum.INVALID.getCode());
//            List<User> users = userMapper.selectByExample(userExample);
//            if (!CollectionUtils.isEmpty(users)) {
//                throw new BizException(UserResponseEnum.USER_EXISTS);
//            }
//        }
//        if (!StringUtils.isEmpty(userDTO.getUserName())) {
//            userExample.createCriteria().andUserNameEqualTo(userDTO.getUserName()).andStateEqualTo(StateEnum.INVALID.getCode());
//            List<User> users = userMapper.selectByExample(userExample);
//            if (!CollectionUtils.isEmpty(users)) {
//                throw new BizException(UserResponseEnum.USER_EXISTS);
//            }
//        }
        User user = userDTO.convertToUser();
        Integer insertCount = userMapper.insert(user);
        if (insertCount <= 0) {
            throw new BizException(UserResponseEnum.USER_CREATE_FAIL);
        }
    }
}
