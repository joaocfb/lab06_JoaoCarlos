package P2Games;
/**
 * 
 * @author Joao Carlos Fernandes Bernardo. 114210795.
 *
 */
public class RPG extends Jogo {

	public RPG(String nomeJogo, double precoJogo) throws Exception {
		super(nomeJogo, precoJogo);
	}

	
	/**
	 * Override do metodo abstrato registraJogada da classe Jogo
	 */
	
	
	@Override
	public void registraJogada(int score, boolean zerou) {
		
		if (score > super.getTopScore()) {
			super.setTopScore(score);
		}
		if (zerou) {
			super.setVezesZeradas(super.getVezesZeradas() + 1);
		}
		super.setVezesJogadas(super.getVezesJogadas() + 1);
		super.usuario.setX2P(super.usuario.getX2P() + 10);
	}

}
