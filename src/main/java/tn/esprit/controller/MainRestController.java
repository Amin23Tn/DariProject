package tn.esprit.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Administrator;
import tn.esprit.entities.Agent;
import tn.esprit.entities.Customer;
import tn.esprit.entities.User;
import tn.esprit.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class MainRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> json) {
        String username = json.get("username");
        String password = json.get("password");
        String token = null;
        User user = userService.findOneByUsername(username);

        Map<String, Object> tokenMap = new HashMap<String, Object>();
        if (user != null && user.getPassword().equals(password) ) {
            String authoritie = "";
            if(user instanceof Customer){
                authoritie ="Customer";
            } else if(user instanceof Agent){
                authoritie ="Agent";
            } else if(user instanceof Administrator){
                authoritie ="Administrator";
            }

            ArrayList<String> powers = new ArrayList<String>();
            powers.add(authoritie);
            token = Jwts.builder().setSubject(username).claim("authorities",powers).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            tokenMap.put("token", token);
            tokenMap.put("user", user);
            tokenMap.put("authorities", authoritie);
            return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.OK);
        } else {
            tokenMap.put("token", null);
            tokenMap.put("user", null);
            tokenMap.put("authorities", null);
            tokenMap.put("err", "Couldn't login");
            return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/register")
    @ResponseBody
    public  ResponseEntity<Map<String, Object>>  register(@RequestBody Customer customer) {
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            String token = null;
            Customer customer1 = userService.addCustomer(customer);
            String authoritie ="Customer";
            ArrayList<String> powers = new ArrayList<String>();
            powers.add(authoritie);
            token = Jwts.builder().setSubject(customer1.getUsername()).claim("authorities",powers).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
            response.put("error", 0);
            response.put("token", token);
            response.put("user", customer1);
            response.put("authorities", authoritie);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
