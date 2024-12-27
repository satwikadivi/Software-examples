package com.sathya.springbootrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
      @GetMapping("/pincodedetails/{pincode}")
      public ResponseEntity<String> getPincodeDetails(@PathVariable("pincode") String pincode)
      {
    	  RestTemplate restTemplate=new RestTemplate();
    	  ResponseEntity<String> response=restTemplate.getForEntity("https://api.postalpincode.in/pincode/"+pincode, String.class);
          return ResponseEntity.status(HttpStatus.OK)
        		               .header("status","Data read success")
        		               .body(response.getBody());
      }
      
      
      @GetMapping("/quotes/{id}")
      public ResponseEntity<String> geQuotes(@PathVariable("id") String id)
      {
    	  RestTemplate restTemplate=new RestTemplate();
    	  ResponseEntity<String> responseEntity=restTemplate.getForEntity("https://dummyjson.com/quotes/"+id, String.class);
          return ResponseEntity.status(HttpStatus.OK)
        		               .header("status","Data read success")
        		               .body(responseEntity.getBody());


      }
      
      
      @GetMapping("/recipes/{id}")
      public ResponseEntity<String> geRecipes(@PathVariable("id") String id)
      {
    	  RestTemplate restTemplate=new RestTemplate();
    	  ResponseEntity<String> responseEntity=restTemplate.getForEntity("https://dummyjson.com/recipes/"+id, String.class);
          return ResponseEntity.status(HttpStatus.OK)
        		               .header("status","Data read success")
        		               .body(responseEntity.getBody());


      }
      
}
