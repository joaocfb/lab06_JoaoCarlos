/* 114210795 - Joao Carlos Fernandes Bernardo: LAB 06 - Turma 1 */
package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import P2Games.Jogo;
import P2Games.Luta;
import P2Games.Noob;
import P2Games.Plataforma;
import P2Games.RPG;
import P2Games.Usuario;
import P2Games.Veterano;

public class TestesUsuario {
	private Usuario joao;
	private Usuario pedro;
	private Jogo jogo1, jogo2, jogo3;
	
	@Before
	public void criaUsuario() throws Exception {
		ArrayList<Jogo> jogos = new ArrayList<>();
		joao = new Veterano("joao", "joaocfb",  jogos);
		pedro = new Noob("pedro", "pedro_s12", jogos);
		joao.setDinheiroCaixa(500.0);
		pedro.setDinheiroCaixa(100.0);
	}
	
	@Test
	public void testaUsuario() throws Exception {
		assertEquals(1000, joao.getX2P());
		assertEquals(500.0, joao.getDinheiroCaixa(), 0.0001);

		assertEquals(100.00, pedro.getDinheiroCaixa(), 0.00001);
		assertNotEquals(1000, pedro.getX2P());
	}
	
	@Before
	public void criaJogos() throws Exception {
		jogo1 = new RPG("Final Fantasy", 200.0);
		jogo2 = new Luta("Street Fighter", 50.0);
		jogo3 = new Plataforma("Super Mario World", 30.0);
	}
		
	@Test
	public void testCompraJogos() throws Exception {
		try {
			joao.compraJogos(jogo1);
		} catch (Exception e) {
			fail("Nao deveria lancar excecao");
		}
		
		assertEquals(4000, joao.getX2P());
		assertEquals("Veterano", joao.getClass().getSimpleName());
		assertEquals(340.0, joao.getDinheiroCaixa(), 0.0001);
		
		
		try {
			pedro.compraJogos(jogo2);
		} catch (Exception e) {
			fail("Nao deveria lancar excecao");
		}
	
		assertEquals(750, pedro.getX2P());
		assertEquals("Noob", pedro.getClass().getSimpleName());
		assertEquals(55.0, pedro.getDinheiroCaixa(), 0.00001);
	
	}

	@Test
	public void testRegistraJogada() throws Exception {
		
		try {
			joao.registraJogada(jogo1, 5000, true);
		} catch (Exception e) {
			fail("Nao deveria lancar excecao");
		}
		
		try {
			joao.registraJogada(jogo1, 3200, false);
		} catch (Exception e) {
			fail("Nao deveria lancar excecao");
		}
		
		try {
			pedro.registraJogada(jogo2, 250, false);
		} catch (Exception e) {
			fail("Nao deveria lancar excecao");
		}
		
		try {
			pedro.registraJogada(jogo2, 7500, true);
		} catch (Exception e) {
			fail("Nao deveria lancar excecao");
		}
		
		assertEquals(2, jogo1.getVezesJogadas());
		assertEquals(1, jogo2.getVezesZeradas());
		assertEquals(1020, joao.getX2P());
		assertEquals(7, pedro.getX2P());
		
		try {
			pedro.registraJogada(jogo2, -150, true);
			fail("Deveria lancar excecao");
		} catch (Exception e) {
			assertEquals("Score nao pode ser menor ou igual a 0", e.getMessage());
		}
		
		try {
			joao.registraJogada(jogo1, 0, true);
		} catch (Exception e) {
			assertEquals("Score nao pode ser menor ou igual a 0", e.getMessage());
		}
		
	}
}
