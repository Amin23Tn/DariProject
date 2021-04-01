package tn.esprit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.HelpCenter;

@Repository
public interface HelpCenterRepository extends CrudRepository<HelpCenter, Long> {

	}


