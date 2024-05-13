package exceptions;

public class ChampionNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ChampionNotFoundException(Long id) {
		super("Champion %d not found".formatted(id));
	}

}
