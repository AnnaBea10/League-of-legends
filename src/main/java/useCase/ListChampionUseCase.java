package useCase;

import java.util.List;

import entities.Champion;
import repositories.ChampionRepository;

public record ListChampionUseCase(ChampionRepository championRepository) {
	
	public List<Champion> findAll(){
		return championRepository.findAll();
	}

}
