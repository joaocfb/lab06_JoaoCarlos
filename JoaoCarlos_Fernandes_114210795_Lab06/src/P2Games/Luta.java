package P2Games;

public class Luta extends Jogo {

	public Luta(String nomeJogo, double precoJogo) throws Exception {
		super(nomeJogo, precoJogo);
	}

	@Override
	public void registraJogada(int score, boolean zerou) {
		
		if (score > super.getTopScore()) {
			super.usuario.setX2P(super.usuario.getX2P() + (score/1000));
			super.setTopScore(score);
		}
		if (zerou) {
			super.setVezesZeradas(super.getVezesZeradas() + 1);
		}
		super.setVezesJogadas(super.getVezesJogadas() + 1);
		
	}

}
