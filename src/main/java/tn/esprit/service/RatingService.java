package tn.esprit.service;

import org.springframework.stereotype.Service;
import tn.esprit.entities.Customer;

@Service
public interface RatingService {
    long findCountByCustomer(Customer customer);
}
