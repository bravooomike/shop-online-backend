package com.example.shoponline.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/shop/auth")
public class UserAuthentificationController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public void getIdentity() {

    }
}
