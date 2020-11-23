package com.emse.spring.faircorp.hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DummyUserService implements UserService {
    @Autowired
    private GreetingService myGreetingService;

    public void greetAll(){
        ArrayList<String> myStrings = new ArrayList<String>();
        myStrings.add("Elodie"); myStrings.add("Charles");

        for (int i = 0 ; i < myStrings.size() ; i++)
        {
            myGreetingService.greet(myStrings.get(i));
        }
    }
}
