/* 114210795 - Joao Carlos Fernandes Bernardo: LAB 06 - Turma 1 */
package P2Games;
/**
 * 
 * @author Joao Carlos Fernandes Bernardo. 114210795.
 *
 */
public class RPG extends Jogo {

	public RPG(String nomeJogo, double precoJogo) throws Exception {
		super(nomeJogo, precoJogo);
		super.setNomeJogo(nomeJogo);
	}

	@Override
	protected int getBonus() {
		return 10;
	}

	
	
}
