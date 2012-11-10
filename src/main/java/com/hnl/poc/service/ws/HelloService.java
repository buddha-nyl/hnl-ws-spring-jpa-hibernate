package com.hnl.poc.service.ws;

import javax.jws.WebService;

/**
 * @author Hawn Nguyen
 **/

@WebService
public interface HelloService {
	
	String sayHi(String input);
}
