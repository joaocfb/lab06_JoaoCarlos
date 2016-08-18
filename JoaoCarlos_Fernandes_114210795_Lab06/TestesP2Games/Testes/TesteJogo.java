/**
 * 
 */
package Testes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Joao Carlos Fernandes Bernardo
 *
 */
public class TesteJogo {
	private P2Games.Jogo jogo1, jogo2, jogo3;
	
	@Before
	public void criaJogos() throws Exception {
		jogo1 = new P2Games.RPG("World of Warcraft", 15.0);
		jogo2 = new P2Games.Luta("Mortal Kombat", 35.0);
		jogo3 = new P2Games.Plataforma("Mario Bros", 40.0);
		
	}
	
	@Test
	public void testJogos(){
		assertEquals("World of Warcraft",jogo1.getNomeJogo());
		assertEquals("Mortal Kombat", jogo2.getNomeJogo());
		assertNotEquals("Sonic Origins", jogo3.getNomeJogo());
		assertEquals("Plataforma", jogo3.getClass().getSimpleName());
		assertNotEquals("Luta", jogo1.getClass().getSimpleName());
		
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
			P2Games.Luta jogo8 = new P2Games.Luta("Street Fighter", -1.0);
			fail("Deveria ter lancado excecao de preco");
		} catch (Exception e) {
			assertEquals("Preco nao pode ser menor que 0.", e.getMessage());
		}
		
	}
	
	@Before
	public void criaRegistraJogada() throws Exception {
		jogo1.registraJogada(50000, true);
		jogo2.registraJogada(80000, false);
		jogo3.registraJogada(5000, true);
	}
	
	@Test
	public void testRegistraJogada() {
		assertEquals(1, jogo1.getVezesZeradas());
		assertNotEquals(2, jogo1.getVezesZeradas());
		assertEquals(80000, jogo2.getTopScore());
		assertEquals(1, jogo3.getVezesJogadas());
	}
	
}
