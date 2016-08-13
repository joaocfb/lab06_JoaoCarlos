package P2Games;

public class Plataforma extends Jogo {

	public Plataforma(String nomeJogo, double precoJogo) throws Exception {
		super(nomeJogo, precoJogo);
	}

	@Override
	public void registraJogada(int score, boolean zerou) {
		 
		if (score > super.getTopScore()) {
			super.setTopScore(score);
		}
		if (zerou) {
			super.usuario.setX2P(super.usuario.getX2P() + 20);
			super.setVezesZeradas(super.getVezesZeradas() + 1);
		}
		super.setVezesJogadas(super.getVezesJogadas() + 1);
		
	}

}
