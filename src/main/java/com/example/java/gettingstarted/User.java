package com.example.java.gettingstarted;

import static javax.persistence.GenerationType.AUTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

  private static final long serialVersionUID = -3009157732242241606L;

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private String status;

  @Column(name = "longitude")
  private Double longitude;

  @Column(name = "latitude")
  private Double latitude;


}
