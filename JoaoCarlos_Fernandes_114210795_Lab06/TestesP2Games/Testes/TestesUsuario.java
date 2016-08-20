package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestesUsuario {
	private P2Games.Usuario joao;
	private P2Games.Usuario pedro;
	
	
	@Test
	public void criaUsuario() throws Exception {
		joao = new P2Games.Veterano("joao", "joaocfb", new ArrayList<P2Games.Jogo>());
		joao.setDinheiroCaixa(500.0);
		assertEquals(500.0, joao.getDinheiroCaixa());
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
		assertEquals();
		
		assertTrue(pedro.compraJogos(jogo2));
		assertFalse(pedro.compraJogos(jogo2));
		assertEquals(500, pedro.getX2P());
	
	}

	@Test
	public void testRegistraJogada() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetX2P() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDinheiroCaixa() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMeusJogos() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNomeUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLoginUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDinheiroCaixa() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetX2P() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
