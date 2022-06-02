package com.neosoft.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Document()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
    private Long userId;

	private String name;
    private String phone;
     
    List<Contact> contacts=new ArrayList<>();
	
	
	 
	  
	 	
	
	
    
}
