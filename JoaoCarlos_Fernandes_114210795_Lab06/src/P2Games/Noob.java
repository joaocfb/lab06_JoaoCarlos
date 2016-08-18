package P2Games;
/**
 * @author Joao Carlos Fernandes Bernardo. 114210795.
 */
import java.util.ArrayList;

public class Noob extends Usuario{

	
	/**
	 * Construtor da SubClasse Noob
	 * @param nome
	 * @param login
	 * @param jogos
	 * @throws Exception 
	 */
	
	
	public Noob(String nome, String login, ArrayList<Jogo> jogos) throws Exception {
		super(nome, login, jogos);
	}

	
	/**
	 * Override do metodo abstrato compraJogos da classe Usuario
	 * @throws Exception 
	 */
	
	
	@Override
	public void compraJogos(Jogo novoJogo) throws Exception {
		if (super.getDinheiroCaixa() >= novoJogo.getPrecoJogo()) {
			super.setX2P(super.getX2P() + (int) (10 * novoJogo.getPrecoJogo()));
			super.setDinheiroCaixa(super.getDinheiroCaixa() - ((novoJogo.getPrecoJogo() * 10) / 100));
		}
	}
}