package org.sodex.web.sophia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Menstrul {
    
    @GetMapping(value="/test")
    public String getTest() {
        return "hello webflex";
    }
}
