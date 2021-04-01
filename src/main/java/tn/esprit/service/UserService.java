package tn.esprit.service;

import tn.esprit.entities.Administrator;
import tn.esprit.entities.Agent;
import tn.esprit.entities.Customer;
import tn.esprit.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findOneByUsername(String username);
    User findCustomerByIdUser(long idUser);
    User findOneByIdUser(long idUser);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Administrator addAdministrator(Administrator administrator);

    Agent addAgent(Agent agent);

    List<Administrator> listAdmins();

    List<Agent> listAgents();

    List<Customer> listCustomers();

    void blockuser(long id_User);

    void unblockuser(long id_User);

    void deleteUser(long idUser);
}
