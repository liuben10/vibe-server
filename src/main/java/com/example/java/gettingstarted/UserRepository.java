package com.example.java.gettingstarted;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 */
public interface UserRepository extends CrudRepository<User, Long> {

  @Query(value=
          "SELECT "
                  + "u.id as id,"
                  + "u.name as name, "
                  + "u.status as status, "
                  + "u.longitude as longitude, "
                  + "u.latitude as latitude from users u" +
                  " where ((u.longitude * u.longitude) - ((:longitude) * (:longitude))) + ((u.latitude * u.latitude) - ((:latitude) * (:latitude))) < .001 limit 100",
          nativeQuery = true
  )
  List<User> nearestUsers(@Param("longitude") Double longitude, @Param("latitude") Double latitude);


}
