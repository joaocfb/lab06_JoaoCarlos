package P2Games;
/**
 * @author Joao Carlos Fernandes Bernardo
 */
public class Plataforma extends Jogo {

	
/**
 * Construtor da SubClasse Plataforma
 * @param nomeJogo
 * @param precoJogo
 * @throws Exception
 */
	
	
	public Plataforma(String nomeJogo, double precoJogo) throws Exception {
		super(nomeJogo, precoJogo);
		super.setNomeJogo(nomeJogo);
		super.setPrecoJogo(precoJogo);
	}


	@Override
	protected int getBonus(int score) {
		return 20;
	}

}
