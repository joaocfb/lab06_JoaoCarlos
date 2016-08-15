/**
 * 
 */
package Testes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Melissa
 *
 */
public class TesteJogo {
	private P2Games.Jogo jogo1, jogo2, jogo3;
	
	@Before
	public void criaJogos() throws Exception {
		jogo1 = new P2Games.RPG("Jogo1", 15.0);
		jogo2 = new P2Games.Luta("Jogo2", 35.0);
		jogo3 = new P2Games.Plataforma("Jogo3", 40.0);
		
	}
	
	@Test
	public void testJogos(){
		assertEquals("Jogo1",jogo1.getNomeJogo());
		assertEquals("Jogo2", jogo2.getNomeJogo());
		assertNotEquals("Jogo5", jogo3.getNomeJogo());
	
		//testa nome vazio
		try {
			P2Games.RPG jogo6 = new P2Games.RPG("", 10.0);
			fail("Deveria ter lancado excecao de nome");
			
		} catch (Exception e) {
			assertEquals("Nome do jogo nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//testa nome null
		try {
			P2Games.Luta jogo7 = new P2Games.Luta(null, 99.0);
			fail("Deveria ter lancado excecao de nome");
		} catch (Exception e) {
			assertEquals("Nome do jogo nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//excecao de preco abaixo de zero
		try {
			P2Games.Luta jogo8 = new P2Games.Luta("Lutinha", -1.0);
			fail("Deveria ter lancado excecao de preco");
		} catch (Exception e) {
			assertEquals("Preco nao pode ser menor que 0.", e.getMessage());
		}
		
	}
	
	@Test
	public void testCompraJogo(){
	}
}
