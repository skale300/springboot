
package com.learning.service.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping(path = "/users")
	public List<User> getAllUser() {
		return userDaoService.findAll();
	}

	@GetMapping(path ="/users/{id}")
	public User retriveUser(@PathVariable Integer id) {
		
		User user = userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("Id - "+ id);
		}
		return user;
		
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User savedUser = userDaoService.addUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(savedUser.getUserId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void deleteUser(@Valid @PathVariable Integer id) {

		User user = userDaoService.deleteUser(id);
		if (user == null) {
			throw new UserNotFoundException("Id - " + id);
		}

	}

}
