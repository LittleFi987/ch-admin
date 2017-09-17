package com.ych.admin.dto;

import com.google.common.base.Converter;
import com.ych.admin.entity.User;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenhaoye on 2017/9/17.
 */
public class UserDTO implements Serializable {
    private Long id;

    private String userName;

    private String nickName;

    private String pwd;

    private String salt;

    private Integer state;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 密码盐.
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.userName + this.salt;
    }

    public User convertToUser(UserDTO userDTO) {
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        return userDTOConvert.doForward(userDTO);
    }

    public UserDTO convertToUserDTO(User user) {
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        return userDTOConvert.doBackward(user);
    }

    public User convertToUser() {
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        User user = userDTOConvert.doForward(this);
        return user;
    }


    private static class UserDTOConvert extends Converter<UserDTO, User> {
        @Override
        protected User doForward(UserDTO userDTO) {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            return user;
        }

        @Override
        protected UserDTO doBackward(User user) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        }
    }

}
