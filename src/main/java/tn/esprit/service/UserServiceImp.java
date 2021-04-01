package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Administrator;
import tn.esprit.entities.Agent;
import tn.esprit.entities.Customer;
import tn.esprit.entities.User;
import tn.esprit.repository.AdminRepository;
import tn.esprit.repository.AgentRepository;
import tn.esprit.repository.CustomerRepository;
import tn.esprit.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public User findOneByUsername(String username) {
        return this.userRepository.findOneByNameUser(username);
    }

    public Customer findCustomerByIdUser(long idUser) {
        return this.customerRepository.findCustomerByIdUser(idUser);
    }

    public User findOneByIdUser(long idUser) {
        return this.userRepository.findOneByIdUser(idUser);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Administrator addAdministrator(Administrator administrator) {
        return this.adminRepository.save(administrator);
    }

    @Override
    public Agent addAgent(Agent agent) {
        return this.agentRepository.save(agent);
    }

    public List<Administrator> listAdmins() {
        return this.adminRepository.findAll();
    }

    public List<Agent> listAgents() {
        return this.agentRepository.findAll();
    }

    public List<Customer> listCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public void deleteUser(long idUser) {
        this.userRepository.deleteById(idUser);
    }

    public void blockuser(long id_User) {
        User user = this.userRepository.findOneByIdUser(id_User);
        user.block();
        this.userRepository.save(user);
    }

    public void unblockuser(long id_User) {
        User user = this.userRepository.findOneByIdUser(id_User);
        user.unblock();
        this.userRepository.save(user);
    }

    public Customer updateCustomer(Customer customer) {
        return this.customerRepository.save(customer);

    }


}
