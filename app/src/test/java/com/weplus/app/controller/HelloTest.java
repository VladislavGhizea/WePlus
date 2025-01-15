package com.weplus.app.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class HelloTest {

    @Test
    void isHello (){
        Hello hello = new Hello();
        assertEquals("Hello World", hello.sayHello());
    }

}