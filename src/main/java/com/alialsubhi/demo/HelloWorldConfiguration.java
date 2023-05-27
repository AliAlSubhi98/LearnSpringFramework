package com.alialsubhi.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name , int age, Address address){};

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
    @Primary
    public Person person(){
        var person = new Person("Ahmed AlSubhi",23, new Address("Qariat Bani Subh","AlHamra"));
        return person;
    }

    @Bean(name = "address2")
    @Primary
    public Address address(){
        var address = new Address("Al Maabilah","Seeb");
        return address;
    }

    @Bean(name = "address3")
    @Qualifier("address3Qualifier")
    public Address address3(){
        var address = new Address("Liwan","Bahla");
        return address;
    }


    @Bean
    public Person person2MethodCall(){
        var person = new Person(name(),age(), address());
        return person;
    }

    @Bean
    public Person person3Parameters(String name , int age , Address address3){
        var person = new Person(name, age, address3);
        return person;
    }

    @Bean
    public Person person4Parameters(String name , int age , Address address){
        var person = new Person(name, age, address);
        return person;
    }

    @Bean
    public Person person5Qualifier(String name , int age ,@Qualifier("address3Qualifier")
    Address address){
        var person = new Person(name, age, address);
        return person;
    }

}
