package com.SpringBootApp.service;

import com.SpringBootApp.dao.UserDao;
import com.SpringBootApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    UserDao userDao;

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    @Transactional
    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
