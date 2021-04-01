package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Customer;
import tn.esprit.entities.Rating;
import tn.esprit.repository.RatingRepository;

import java.util.List;

@Service
public class RatingServiceImp implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;
    public long findCountByCustomer(Customer customer){
        List<Rating> ratings = this.ratingRepository.findAllByUsertorate(customer);
        long rate = 0;
        for(int i=0;i<ratings.size();i++){
            rate += ratings.get(i).getRating();
        }
        return rate;
    }
}
