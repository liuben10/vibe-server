package com.example.java.gettingstarted;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class UsersController {


  private final UserService userService;

  public UsersController(
          @Autowired UserService userService
  ) {
    this.userService = userService;
  }

  @RequestMapping(value = "/api/users", method = GET)
  @ResponseBody
  public List<User> getNearbyUsers(@RequestParam("long") Double longitude,
                                   @RequestParam("lat") Double latitude) {
    System.out.println("Received lookup request "
            + "for longitude={" + longitude + "} and latitude={" + latitude + "}");
    return userService.findClosestUsers(new Coordinate(longitude, latitude));
  }

  @RequestMapping(value = "/api/users/{id}", method = PATCH)
  @ResponseBody
  public User patchUser(@PathVariable("id") Long id, @RequestBody JsonPatch patch) {
    return userService.patchUser(id, patch);
  }

  @RequestMapping(value = "/api/users", method = POST, consumes = APPLICATION_JSON_VALUE)
  @ResponseBody
  public User createUser(@RequestBody User user) {
    return this.userService.createUser(user);
  }
}
