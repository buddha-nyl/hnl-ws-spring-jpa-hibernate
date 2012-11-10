package com.hnl.poc.service.ws;

/**
 * @author Hawn Nguyen
 **/

public class HelloServiceImpl implements HelloService{
	
	public String sayHi(String input) {
		System.out.println("Hello invoked : " + input);
		return String.format("Hello '%s'", input);
	}
	
}
	  