package tn.esprit.service;

import org.springframework.stereotype.Service;
import tn.esprit.entities.Customer;
import tn.esprit.entities.Favoris;

import java.util.List;

@Service
public interface FavorisService {
    Favoris addFavoris(Favoris favoris);

    void deleteFavoris(long favoris_id);

    List<Favoris> findFavorisByCustomer(Customer customer);
}
