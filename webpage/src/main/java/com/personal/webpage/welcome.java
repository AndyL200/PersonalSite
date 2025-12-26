package com.personal.webpage;

import org.springframework.stereotype.Component;

@Component
public class welcome {
    String getWelcomeMessage() {
        return "Welcome to My Personal Webpage!";
    }
}
