package xyz.esp8266.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.esp8266.community.mapper.UserMapper;
import xyz.esp8266.community.model.User;
import xyz.esp8266.community.model.UserExample;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> Users = userMapper.selectByExample(userExample);
        if (Users.size() == 0) {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            User dbUser = Users.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            userExample.createCriteria().andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser, userExample);
        }
    }
}
