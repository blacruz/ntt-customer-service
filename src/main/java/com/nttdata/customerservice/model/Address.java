package com.nttdata.customerservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  
  private String name;
  private Boolean active;

}
