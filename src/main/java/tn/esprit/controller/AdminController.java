package tn.esprit.controller;

import tn.esprit.entities.Administrator;
import tn.esprit.entities.Agent;
import tn.esprit.entities.Customer;
import tn.esprit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping("/ajoutadmin")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> ajouterAdministrator(@RequestBody Administrator administrator) {
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            Administrator admin = userService.addAdministrator(administrator);
            response.put("error", 0);
            response.put("new admin",admin);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/ajoutagent")
    @ResponseBody
    public  ResponseEntity<Map<String, Object>>  ajouterAgent(@RequestBody Agent agent) {
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            Agent agent1 = userService.addAgent(agent);
            response.put("error", 0);
            response.put("new agent",agent1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/ajoutcustomer")
    @ResponseBody
    public  ResponseEntity<Map<String, Object>>  ajouterCustomer(@RequestBody Customer customer) {
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            Customer customer1 = userService.addCustomer(customer);
            response.put("error", 0);
            response.put("new customer",customer1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listadmins")
    public ResponseEntity<Map<String, Object>> getallAdmins(){
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            List<Administrator> admins= userService.listAdmins();
            response.put("error", 0);
            response.put("admins",admins);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listagents")
    public ResponseEntity<Map<String, Object>> getallagents(){
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            List<Agent> agents= userService.listAgents();
            response.put("error", 0);
            response.put("agents",agents);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listcustomers")
    public ResponseEntity<Map<String, Object>> getallcustomers(){
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            List<Customer> customers= userService.listCustomers();
            response.put("error", 0);
            response.put("customers",customers);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteuser/{iduser}")
    public ResponseEntity<Map<String, Object>> deleteuser(@PathVariable("iduser") int idUser){
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            userService.deleteUser(idUser);
            response.put("error", 0);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/blockuser/{iduser}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> blockuser(@PathVariable("iduser") int idUser) {
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            userService.blockuser(idUser);
            response.put("error", 0);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/unblockuser/{iduser}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> unblockuser(@PathVariable("iduser") int idUser) {
        Map<String, Object> response = new HashMap<String, Object>();
        try{
            userService.unblockuser(idUser);
            response.put("error", 0);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch(Exception e){
            response.put("error", 1);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
