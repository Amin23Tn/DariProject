package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Ad;
import tn.esprit.repository.AdRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdServiceImp implements AdService {
    @Autowired
    private AdRepository adRepository;

    @Override
    public Ad addAd(Ad ad) {
        return adRepository.save(ad);
    }

    @Override
    public Ad updateAd(Ad ad) {
        return this.adRepository.save(ad);
    }

    @Override
    public void deleteAd(long Ad_id) {
        Optional<Ad> ad = this.adRepository.findById(Ad_id);
        ad.ifPresent(value -> this.adRepository.delete(value));
    }

    public List<Ad> searchAd(long nbBathroom, long nbGarage, long nbroom, float price) {
        return  this.adRepository.findAllByNbBathroomGreaterThanOrNbGarageGreaterThanOrNbRoomGreaterThanOrPriceLessThan
                (nbBathroom,  nbGarage, nbroom, price);
    }
}
