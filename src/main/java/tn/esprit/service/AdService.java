package tn.esprit.service;

import org.springframework.stereotype.Service;
import tn.esprit.entities.Ad;

import java.util.List;

@Service
public interface AdService {
    Ad addAd(Ad ad);
    Ad updateAd(Ad ad);
    void deleteAd(long Ad_id);
    List<Ad> searchAd(long nbBathroom, long nbGarage, long nbroom, float price);

}
