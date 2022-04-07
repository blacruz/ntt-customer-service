package com.nttdata.customerservice.model;


import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;


@Document(collection = "customers")
@Data
public class Customer {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  private CustomerType customerType;
  private CustomerStatus customerStatus;
  private LocalDateTime createDate;

  
  
}
