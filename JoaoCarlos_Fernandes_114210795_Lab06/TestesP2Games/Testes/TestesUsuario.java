package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import P2Games.Jogo;

public class TestesUsuario {
	private P2Games.Usuario joao;
	private P2Games.Usuario pedro;
	private Jogo jogo1, jogo2;
	
	
	@Test
	public void criaUsuario() throws Exception {
		joao = new P2Games.Veterano("joao", "joaocfb", new ArrayList<P2Games.Jogo>());
		joao.setDinheiroCaixa(500.0);
		assertEquals(1000, joao.getX2P());
		
		pedro = new P2Games.Noob("pedro", "pedro_s12", new ArrayList<P2Games.Jogo>());
		pedro.setDinheiroCaixa(100.0);
		assertNotEquals(110.0, pedro.getDinheiroCaixa());
		assertNotEquals(1000, pedro.getX2P());
	}

	@Test
	public void testCompraJogos() throws Exception {
		
		P2Games.Jogo jogo1 = new P2Games.RPG("Final Fantasy", 200.0);
		P2Games.Jogo jogo2 = new P2Games.Luta("Street Fighter", 50.0);
		
		assertTrue(joao.compraJogos(jogo1));
		assertFalse(joao.compraJogos(jogo1));
		assertEquals(4000, joao.getX2P());
		assertEquals("Veterano", joao.getClass().getSimpleName());
		assertEquals(340.0, joao.getDinheiroCaixa());
		
		assertTrue(pedro.compraJogos(jogo2));
		assertFalse(pedro.compraJogos(jogo2));
		assertEquals(500, pedro.getX2P());
		assertEquals("Noob", pedro.getClass().getSimpleName());
		assertEquals(55.0, pedro.getDinheiroCaixa());
	
	}
/*	
	@Before
	public void registrandoJogada() throws Exception {
		joao.registraJogada(jogo1, 5000, true);
		joao.registraJogada(jogo1, 3200, false);
		pedro.registraJogada(jogo2, 250, false);
		pedro.registraJogada(jogo2, 7500, true);
		
	}
	
	@Test
	public void testRegistraJogada() throws Exception {
		assertEquals(2, jogo1.getVezesJogadas());
		assertEquals(1, jogo2.getVezesZeradas());
		assertEquals(4020, joao.getX2P());
		assertEquals(507, pedro.getX2P());
		
		try {
			pedro.registraJogada(jogo2, -150, true);
			fail("Deveria lancar excecao");
		} catch (Exception e) {
			assertEquals("Score não pode ser menor ou igual a 0", e.getMessage());
		}
		
		try {
			joao.registraJogada(jogo1, 0, true);
		} catch (Exception e) {
			assertEquals("Score não pode ser menor ou igual a 0", e.getMessage());
		}
		
	}

	
	@Test
	public void testToString() {
		assertEquals("joaocfb\n joao - Jogador Veterano"
				,joao.toString());
		
		
	}*/

	

}
