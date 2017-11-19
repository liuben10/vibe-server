package com.example.java.gettingstarted;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UsersController {

  private final UserRepository userRepository;

  public UsersController(
          @Autowired UserRepository userRepository
  ) {
    this.userRepository = userRepository;
  }

  @RequestMapping(value = "/api/users", method = GET)
  @ResponseBody
  public List<User> getNearbyUsers(@RequestParam("long") Double longitude,
                                   @RequestParam("lat") Double latitude) {
    System.out.println("Received lookup request "
            + "for longitude={" + longitude + "} and latitude={" + latitude + "}");
    return new ArrayList<>();
  }

  @RequestMapping(value = "/api/users", method = POST)
  @ResponseBody
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }
}
