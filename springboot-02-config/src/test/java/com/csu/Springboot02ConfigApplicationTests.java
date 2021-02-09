package com.csu;

import com.csu.pojo.Dog;
import com.csu.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    //把狗装配过来
    @Autowired
    private Dog dog;
    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
