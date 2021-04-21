package com.learning.service.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static Integer uesrCount = 3;

	static {
		users.add(new User(1, "Swapnil", new Date()));
		users.add(new User(2, "Adam", new Date()));
		users.add(new User(3, "Eve", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(Integer userId) {
		for (User user : users) {
			if (user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub

		if (user.getUserId() == null) {
			user.setUserId(++uesrCount);
		}
		users.add(user);
		return user;
	}
	
	public User deleteUser(Integer id) {
		
		Iterator<User> iterator =  users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getUserId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
