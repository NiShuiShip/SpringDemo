package com.zxy.Service;

import com.zxy.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    public List<Map<String, String>> getUserAll() {
        return userMapper.getUserAll();
    }
}
