package com.ds.collectionsJava;

import java.util.HashMap;

public class CertifiedTrainer {

    public static void main(String[] args){

      java.util.Map<String,Boolean> inputMap = new HashMap<>();

      inputMap.put("Java", true);
      inputMap.put("Spring Boot", true);
      inputMap.put("Java", true);
      inputMap.put("Kafka", false);
      inputMap.put("Kafka", true);

      inputMap.entrySet().stream().distinct().filter(entry-> entry.getValue()).forEach(System.out::println);


    }
}
