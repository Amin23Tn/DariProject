package tn.esprit.repository;

import tn.esprit.entities.Agent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {
    List<Agent> findAll();
}
