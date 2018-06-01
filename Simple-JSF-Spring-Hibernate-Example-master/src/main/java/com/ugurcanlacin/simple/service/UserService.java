package com.ugurcanlacin.simple.service;

import com.ugurcanlacin.simple.model.User;

import java.util.List;

public interface UserService {
	void saveUser(User user);
	User findUserById(int id);
	void updateUser(User user);
	void deleteUser(User user);

    List<User> userList();
    User getByUserPass(String username, String pass);


}
