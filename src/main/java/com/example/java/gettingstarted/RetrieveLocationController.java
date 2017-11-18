package com.example.java.gettingstarted;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 */
@RestController
public class RetrieveLocationController {

	@RequestMapping(value = "/api/users", method = GET)
	@ResponseBody
	public List<User> getNearbyUsers(@RequestParam("long") Double longitude, @RequestParam("lat") Double latitude) {
		System.out.println("Received lookup request for longitude={" + longitude + "} and latitude={" + latitude + "}");
		return new ArrayList<>();
	}
}
