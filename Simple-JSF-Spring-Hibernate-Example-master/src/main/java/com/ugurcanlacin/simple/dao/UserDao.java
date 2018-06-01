package com.ugurcanlacin.simple.dao;

import com.ugurcanlacin.simple.model.User;

import java.util.List;

public interface UserDao {
	void saveUser(User user);
	User findUserById(int id);
	void updateUser(User user);
	void deleteUser(User user);

    public List<User> userList();
    public User getByUserPass(String username, String pass);

}
