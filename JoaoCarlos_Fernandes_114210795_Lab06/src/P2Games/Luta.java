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
	}

	/**
	 * Override do metodo abstrato registraJogada da classe Jogo
	 * @return 
	 * @throws Exception 
	 */
	
	@Override
	public void registraJogada(int score, boolean zerou) throws Exception {
		this.verificaScore(score);
		if (score > super.getTopScore()) {
			super.usuario.setX2P(super.usuario.getX2P() + (score/1000));
			super.setTopScore(score);
		} 
		
		if (zerou) {
			super.setVezesZeradas(super.getVezesZeradas() + 1);
		} 
		super.setVezesJogadas(super.getVezesJogadas() + 1);
		
	}

	private void verificaScore(int score) throws Exception {
		if (score <= 0) {
			throw new Exception("Score não pode ser menor ou igual a 0");
		}
	}

}
