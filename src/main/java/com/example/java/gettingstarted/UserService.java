package com.example.java.gettingstarted;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 */
@Service
public class UserService {

  private final ObjectMapper objectMapper;

  private final UserRepository repository;

  public UserService(
          @Autowired ObjectMapper objectMapper,
          @Autowired UserRepository userRepository
  ){
    this.objectMapper = objectMapper;
    this.repository = userRepository;
  }

  @Transactional
  public User createUser(User userToCreate) {
    return this.repository.save(userToCreate);
  }

  @Transactional
  public User patchUser(Long id, JsonPatch patch) {
    User toPatch = this.repository.findOne(id);
    JsonNode node = this.objectMapper.valueToTree(toPatch);
    JsonNode patchedNode = null;
    try {
      patchedNode = patch.apply(node);
      User patchedUser = objectMapper.treeToValue(patchedNode, User.class);
      return patchedUser;
    } catch (JsonPatchException e) {
      e.printStackTrace();
      throw new RuntimeException("Could not patch");
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new RuntimeException("Could not patch");
    }
  }

  @Transactional(readOnly = true)
  public List<User> findClosestUsers(Coordinate coordinate) {
    return repository.nearestUsers(coordinate.getLongitude(), coordinate.getLatitude());
  }
}
