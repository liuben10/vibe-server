package com.example.java.gettingstarted;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("user")
@Data
public class User {

  @Id
  Long id;
  String name;
  String status;
}
