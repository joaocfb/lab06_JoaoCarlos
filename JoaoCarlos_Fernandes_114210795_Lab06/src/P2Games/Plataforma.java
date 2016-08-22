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
			super.setTopScore(score);
		} 
		if (zerou) {
			super.usuario.setX2P(super.usuario.getX2P() + 20);
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
