package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import tn.esprit.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private AdService adService;
    @Autowired
    private FavorisService favorisService;
    @Autowired
    private RatingService ratingService;

    @GetMapping("search-ad")
    public ResponseEntity<Map<String, Object>> addAd(@RequestBody Map<String, String> json) {
        try {
            long nbBathroom = Long.parseLong(json.get("nbBathroom"));
            long nbGarage = Long.parseLong(json.get("nbGarage"));
            long nbroom = Long.parseLong(json.get("nbroom"));
            float price = Float.parseFloat(json.get("price"));
            Map<String, Object> response = new HashMap<String, Object>();
            List<Ad> ad1 = this.adService.searchAd(nbBathroom, nbGarage, nbroom, price);
            response.put("ads", ad1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("add-ad")
    public ResponseEntity<Map<String, Object>> addAd(Ad ad) {
        try {
            Map<String, Object> response = new HashMap<String, Object>();
            User userDetails = (User) SecurityContextHolder.getContext();
            User user = this.userService.findOneByUsername(userDetails.getNameUser());
            ad.setUser(user);
            Ad ad1 = this.adService.addAd(ad);
            response.put("ad", ad1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("add-rating")
    public ResponseEntity<Map<String, Object>> addrating(@RequestBody Map<String, String> json) {
        try {
            User userDetails = (User) SecurityContextHolder.getContext();
            Customer userwhorated = (Customer) this.userService.findOneByUsername(userDetails.getNameUser());
            long user_id = Long.parseLong(json.get("usertorate_id"));
            int rating = Integer.parseInt(json.get("rating"));
            Customer usertorate = (Customer) this.userService.findCustomerByIdUser(user_id);
            Rating rate = new Rating(usertorate, userwhorated, rating);
            usertorate.setRating(this.ratingService.findCountByCustomer(usertorate));
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("rate", rate);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("add-favoris")
    public ResponseEntity<Map<String, Object>> addFavoris(Ad ad) {
        try {
            Map<String, Object> response = new HashMap<String, Object>();
            User userDetails = (User) SecurityContextHolder.getContext();
            User user = this.userService.findOneByUsername(userDetails.getNameUser());
            Customer customer = (Customer) this.userService.findOneByUsername(user.getNameUser());
            Favoris favoris = new Favoris(customer, ad);
            favoris = this.favorisService.addFavoris(favoris);
            response.put("favoris", favoris);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("favoris")
    public ResponseEntity<Map<String, Object>> listFavoris() {
        try {
            Map<String, Object> response = new HashMap<String, Object>();
            User userDetails = (User) SecurityContextHolder.getContext();
            User user = this.userService.findOneByUsername(userDetails.getNameUser());
            Customer customer = (Customer) this.userService.findOneByUsername(user.getNameUser());
            List<Favoris> favoris = this.favorisService.findFavorisByCustomer(customer);
            response.put("favoris", favoris);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("messages")
    public ResponseEntity<Map<String, Object>> listMessages(@RequestBody Map<String, String> json) {
        try {
            long user_id = Long.parseLong(json.get("withuser"));
            User withuser = this.userService.findOneByIdUser(user_id);
            Map<String, Object> response = new HashMap<String, Object>();
            User userDetails = (User) SecurityContextHolder.getContext();
            User user = this.userService.findOneByUsername(userDetails.getNameUser());
            List<Message> messages = this.messageService.findMessagesByUserSenderAndUserReceiver(user,withuser);
            response.put("message", messages);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("send")
    public ResponseEntity<Map<String, Object>> sendmessage(@RequestBody Map<String, String> json) {
        try {
            long user_id = Long.parseLong(json.get("withuser"));
            String content = json.get("content");
            User withuser = this.userService.findOneByIdUser(user_id);
            Map<String, Object> response = new HashMap<String, Object>();
            User userDetails = (User) SecurityContextHolder.getContext();
            User user = this.userService.findOneByUsername(userDetails.getNameUser());
            Message msg = new Message(content,user,withuser);
            Message message = this.messageService.addMessage(msg);
            response.put("message", message);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getProfile() {
        try {
            Map<String, Object> profile = new HashMap<String, Object>();
            User userDetails = (User) SecurityContextHolder.getContext();
            User user = this.userService.findOneByUsername(userDetails.getNameUser());
            profile.put("user", user);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("user", null);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("")
    public ResponseEntity<Map<String, Object>> editProfile(@RequestBody Customer customer) {
        try {
            Customer userDetails = (Customer) SecurityContextHolder.getContext();

            userDetails.setDescriptionBlock(customer.getDescriptionBlock());
            userDetails.setPassword(customer.getPassword());
            userDetails.setNameUser(customer.getNameUser());
            userDetails.setEmailUser(customer.getEmailUser());

            userDetails.setDescriptionBlock(customer.getDescriptionBlock());
            userDetails.setDescriptionBlock(customer.getDescriptionBlock());
            userService.updateCustomer(userDetails);
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("user", profile);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> profile = new HashMap<String, Object>();
            profile.put("user", null);
            return new ResponseEntity<Map<String, Object>>(profile, HttpStatus.UNAUTHORIZED);
        }
    }
}

