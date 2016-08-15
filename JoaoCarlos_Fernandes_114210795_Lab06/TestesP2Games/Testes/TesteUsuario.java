/**
 * 
 */
package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.Luta;
import jogo.RPG;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

/**
 * @author Melissa
 *
 */
public class TesteUsuario {
	private P2Games.Usuario maria;
	private P2Games.Usuario joao;
	private P2Games.Usuario kleber;

	@Before
	public void criaUsuario() throws Exception {
		maria = new P2Games.Noob("Maria", "maria123", 500.0);
		joao = new P2Games.Veterano("Joao", "j123", 10.0);
		kleber = new P2Games.Noob("Kleber", "klebinho", 150);
	}
	
	@Test
	public void testCompraJogo() throws Exception{
		Jogo jogo1 = new P2Games.RPG("Jogo1", 15.0);
		Jogo jogo2 = new P2Games.Luta("Jogo2", 35.0);
		
		assertTrue(maria.compraJogos(jogo2));
		assertFalse(maria.compraJogos(jogo2));
		
		assertTrue(maria.existeJogo(jogo2));
		assertFalse(kleber.existeJogo(jogo1));
	}
	
	@Test
	public void testUsuario(){
		//testa getNome e getLogin
		assertEquals("Joao", joao.getNome());
		assertNotEquals("Lucas", joao.getNome());
		assertEquals("j123", joao.getLogin());
		
		//excecao nome vazio
		try {
			maria = new P2Games.Noob("", "maria1", 5.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//excecao login nulo
		try {
			maria = new P2Games.Veterano("Maria", null, 5.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Login do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//excecao valor dinheiro negativo
		try {
			maria = new P2Games.Veterano("Maria", "mariacg", -2.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Dinheiro precisa ser maior ou igual a zero.", e.getMessage());
		}
	}
}