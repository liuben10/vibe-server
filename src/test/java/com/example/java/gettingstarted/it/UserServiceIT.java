/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.java.gettingstarted.it;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.example.java.gettingstarted.Coordinate;
import com.example.java.gettingstarted.User;
import com.example.java.gettingstarted.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:test.properties")
@SuppressWarnings("checkstyle:abbreviationaswordinname")
@Transactional
public class UserServiceIT {

  @Autowired
  private UserService userService;

  @Test
  public void canFindNearestUser() throws Exception {
    User createdUser = userService.createUser(User.builder().latitude(35.0).longitude(35.0).name("foo").build());
    User anotherCreatedUser = userService.createUser(User.builder().latitude(500.0).longitude(500.0).name("baz").build());
    List<User> closestUsers = userService.findClosestUsers(new Coordinate(35.0, 35.0));
    assertThat(closestUsers.size(), equalTo(1));
    assertThat(closestUsers.get(0).getId(), equalTo(createdUser.getId()));
  }

  @Test
  public void canPatchUserLocation() throws Exception {
    
  }
}
