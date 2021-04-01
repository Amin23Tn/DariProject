package tn.esprit.repository;

import tn.esprit.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByNameUser(String username);
    User findOneByIdUser(long id);
}
