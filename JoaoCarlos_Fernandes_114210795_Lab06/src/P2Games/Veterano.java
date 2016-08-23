package P2Games;
/**
 * @author Joao Carlos Fernandes Bernardo. 114210795.
 */
import java.util.ArrayList;

public class Veterano extends Usuario{

	
	/**
	 * Construtor da SubClasse Veterano
	 * @param nome
	 * @param login
	 * @param jogos
	 * @throws Exception 
	 */
	
	
	public Veterano(String nome, String login, ArrayList<Jogo> jogos) throws Exception {
		super(nome, login, jogos);
		super.setX2P(1000);
	}

	
	/**
	 * Override do metodo abstrato compraJogos da classe Usuario
	 * @return 
	 * @throws Exception 
	 */

	@Override
	protected double getDesconto(Jogo novoJogo) {
		return ((novoJogo.getPrecoJogo() * 20) / 100);
	}


}
	
