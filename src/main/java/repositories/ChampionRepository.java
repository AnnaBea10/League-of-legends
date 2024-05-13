package repositories;

import java.util.List;
import java.util.Optional;

import entities.Champion;

public interface ChampionRepository {
	
	List<Champion> findAll();
	
	Optional<Champion> findById(Long id);

}
