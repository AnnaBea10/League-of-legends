package useCase;

import entities.Champion;
import exceptions.ChampionNotFoundException;
import repositories.ChampionRepository;
import services.GenerateAiService;

public record AskChampionUseCase(ChampionRepository championRepository, GenerateAiService generateService) {
	
	public String AskChampion(Long id, String question) {
	
	 Champion champion = championRepository.findById(id)
             .orElseThrow(() -> new ChampionNotFoundException(id));
	 
	 String context = champion.generateContextByQuestion(question);
	 String objective = """
             Atue como um assistente com a habilidade de se comportar como os Campeões do League of Legends (LOL).
             Responsa perguntas incorporando a personalidade e estilo de um determinado Campeão.
             Segue a pergunta, o nome do Campeão e sua respectiva lore (história):
             
             """;
	 return generateService.generateContent(objective, context);
	}
}
