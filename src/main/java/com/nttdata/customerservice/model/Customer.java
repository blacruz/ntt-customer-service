package com.nttdata.customerservice.model;


import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  private CustomerType customerType;
  private CustomerStatus customerStatus;
  private LocalDateTime createDate;

  
  
}
