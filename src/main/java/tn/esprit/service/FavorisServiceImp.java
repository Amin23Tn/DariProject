package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Customer;
import tn.esprit.entities.Favoris;
import tn.esprit.repository.FavorisRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FavorisServiceImp implements FavorisService {

    @Autowired
    private FavorisRepository favorisRepository;

    @Override
    public Favoris addFavoris(Favoris favoris) {
        return this.favorisRepository.save(favoris);
    }


    @Override
    public void deleteFavoris(long favoris_id) {
        Optional<Favoris> ofavoris = this.favorisRepository.findById(favoris_id);
        ofavoris.ifPresent(value -> this.favorisRepository.delete(value));
    }

    @Override
    public List<Favoris> findFavorisByCustomer(Customer customer) {
        return this.favorisRepository.findAllByCustomer(customer);
    }
}
