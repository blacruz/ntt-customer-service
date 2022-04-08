package com.nttdata.customerservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "documents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documents {

  
  private String type;
  private Boolean main;
  private String number;
  private Boolean active;
  
 
}
