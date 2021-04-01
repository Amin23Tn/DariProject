package tn.esprit.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long RatingId;
    @ManyToOne
    Customer usertorate;

    @ManyToOne
    Customer userwhorated;

    @Column(unique = false, nullable = false)
    long rating;


    public Rating(Customer usertorate, Customer userwhorated, long rating) {
        this.usertorate = usertorate;
        this.userwhorated = userwhorated;
        this.rating = rating;
        
    }


    public long getRatingId() {
        return RatingId;
    }

    public void setRatingId(long ratingId) {
        RatingId = ratingId;
    }

    public Customer getUsertorate() {
        return usertorate;
    }

    public void setUsertorate(Customer usertorate) {
        this.usertorate = usertorate;
    }

    public Customer getUserwhorated() {
        return userwhorated;
    }

    public void setUserwhorated(Customer userwhorated) {
        this.userwhorated = userwhorated;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }
}
