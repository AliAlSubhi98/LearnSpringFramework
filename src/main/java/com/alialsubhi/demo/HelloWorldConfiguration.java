package com.alialsubhi.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
record Person (String name , int age){};

//Address - firstLine + city
record Address (String firstLine, String city){};
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "ALi AlSubhi Trying";
    }

    @Bean
    public int age(){
        return 25;
    }

    @Bean
    public Person person(){
        var person = new Person("Ahmed AlSubhi",23);
        return person;
    }

    @Bean(name = "address2")
    public Address address(){
        var address = new Address("Al Maabilah","Seeb");
        return address;
    }


    @Bean
    public Person person2MethodCall(){
        var person = new Person(name(),age());
        return person;
    }

}
