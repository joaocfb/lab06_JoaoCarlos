/* 114210795 - Joao Carlos Fernandes Bernardo: LAB 06 - Turma 1 */
package P2Games;

/**
 * @author Joao Carlos Fernandes Bernardo. 114210795.
 */

public class Luta extends Jogo {
	
	
	/**
	 * Construtor da SubClasse Luta
	 * @param nomeJogo
	 * @param precoJogo
	 * @throws Exception
	 */
	
	
	public Luta(String nomeJogo, double precoJogo) throws Exception {
		super(nomeJogo, precoJogo);
		super.setNomeJogo(nomeJogo);
		super.setPrecoJogo(precoJogo);
	}

	@Override
	protected int getBonus() {
		return (super.getTopScore()/1000);
	}


}
