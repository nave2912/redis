package com.redis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

   @Autowired
   private StringRedisTemplate template;

   @RequestMapping("/")
   // Define the Hello World controller.
   public String hello() {

      ValueOperations<String, String> redisservice = this.template.opsForValue();

      // Add a Hello World string to your cache.
      String key = "greeting";
      if (!this.template.hasKey(key)) {
    	  redisservice.set(key, "Hello World!");
      }

      // Return the string from your cache.
      return redisservice.get(key);
   }
}