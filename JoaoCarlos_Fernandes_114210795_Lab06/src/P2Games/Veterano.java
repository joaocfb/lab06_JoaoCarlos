package P2Games;

import java.util.ArrayList;

public class Veterano extends Usuario{

	public Veterano(String nome, String login, ArrayList<Jogo> jogos) {
		super(nome, login, jogos);
		super.setX2P(1000);
	}

	@Override
	public void CompraJogos(Jogo novoJogo) {
		if (super.getDinheiroCaixa() >= novoJogo.getPrecoJogo()) {
			super.setX2P((int) (15 * novoJogo.getPrecoJogo()));
			super.setDinheiroCaixa(super.getDinheiroCaixa() - ((novoJogo.getPrecoJogo() * 20) / 100));
		}
	}
}
