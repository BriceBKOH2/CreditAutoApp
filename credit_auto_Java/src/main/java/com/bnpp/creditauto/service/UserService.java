package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.creditauto.dao.UserDao;
import com.bnpp.creditauto.exception.UserNotFoundException;
import com.bnpp.creditauto.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional(rollbackFor = UserNotFoundException.class)
	public List<User> findByNames(String firstName, String lastName) throws UserNotFoundException {
		return userDao.findByNames(firstName, lastName);
	}
	
	public User findById(Long id) {
		return userDao.findById(id);
	}
}
