package com.nttdata.customerservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;


@Document(collection = "customers")
@Data
public class Customer {

  @Id
  private ObjectId id;
  private String firstName;
  private String lastName;
  private CustomerType customerType;

  
  
  
}
