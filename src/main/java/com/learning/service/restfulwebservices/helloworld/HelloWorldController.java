package com.learning.service.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//GET
	//URI - /hello
	//method "Hello world"
	
	/*
	 * @Autowired private UserDaoService userDaoService;
	 */
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World bhai";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldNew helloWorldBean() {
		return new HelloWorldNew("Hello World");
	}
	
	@GetMapping(path = "/hello-world/path-varible/{name}")
	public HelloWorldNew helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldNew(String.format("Hello World, %s", name));
	}
	
	/*
	 * @GetMapping(path = "/users") public List<User> getAllUser(){ return
	 * userDaoService.findAll(); }
	 */

}