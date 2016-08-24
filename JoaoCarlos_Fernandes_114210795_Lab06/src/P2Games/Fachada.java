package P2Games;

import java.util.ArrayList;
/**
 * 
 * @author Joao Carlos Fernandes Bernardo. 114210795.
 *
 */
public class Fachada {
	private ArrayList<Usuario> usuarios;
	
	
	
	/**
	 * Construtor da classe Fachada
	 */
	
	public Fachada() {
		this.usuarios = new ArrayList<Usuario>();
	}

	
	 /**
	  * Metodo que adiciona usuario ao ArrayList<Usuario>
	  */
	
	
	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	
	/**
	 * Metodo que adiciona dinheiro(double) ao usuario
	 * Try, catch para verificar se o dinheiro(double) é valido 
	 * @param login
	 * @param dinheiro
	 */
	
	
	public void addDinheiro(String login, double dinheiro) {
		for (Usuario usuario : this.usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				try {
					usuario.setDinheiroCaixa(dinheiro);
				} catch (Exception e) {
					e.getMessage();
				}
			}
		}
	}
	
	
	/**
	 * Metodo que compra um jogo para um usuario
	 * Try, catch que leva ao exception das subclasses de Usuario
	 * @param login
	 * @param nomeJogo
	 */
	
	
	public void vendaJogos(String login, Jogo nomeJogo) {
		for (Usuario usuario : this.usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				try {
					usuario.compraJogos(nomeJogo);
				} catch (Exception e) {
					e.getMessage();
				}
				
			}
		}
	}
	
	
	/**
	 * Metodo que transforma um usuario Noob em um usuario veterano baseado no seu x2p
	 * Testes de erro para que nao seja permitido um usuario veterano dar o upgrade, nem usuario que tenha x2p menor que 1000(xp2 < 1000) 
	 * @param login
	 * @throws Exception
	 */
	
	
	public void upgrade(String login) throws Exception {
		testaTipo(login);
		testax2p(login);
		Usuario usuario = this.retornaUsuario(login);
		Usuario newUsuario = new Veterano(usuario.getNome(), usuario.getLogin(), usuario.getMeusJogos());
		newUsuario.setDinheiroCaixa(usuario.getDinheiroCaixa()); 
		newUsuario.setX2P(usuario.getX2P());
		int indice = this.usuarios.indexOf(usuario);
		this.usuarios.remove(this.usuarios.get(indice));
		this.usuarios.add(indice, newUsuario);
	}
	
	
	private Usuario retornaUsuario(String login) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)) {
				return usuario;
			}
		}
		return null;
	}
	
	
	/**
	 * Teste para verificacao da classe do usuario, caso veterano retorne Exception
	 * @param login
	 * @throws Exception
	 */
	
	
	public void testaTipo(String login) throws Exception {
		if (usuarios.get(this.usuarios.indexOf(login)).getClass().equals("Veterano")) {
			throw new Exception("Nao pode haver upgrade do usuario, ele ja e veterano.");
		}
	}

	

	/**
	 * Teste para verificacao se o x2p do usuario é maior que 1000, caso seja menor retorne Exception
	 * @param login
	 * @throws Exception
	 */
	
	
	public void testax2p(String login) throws Exception {
		if (this.usuarios.get(this.usuarios.indexOf(login)).getX2P() < 1000) {
			throw new Exception("Usuario nao possui x2p suficiente.");
		}
	}
	
	
	/** 
	 * Override do metodo toString de Java
	 * @param toString() 
	 */
	
	
	@Override
	public String toString() {
		double precototal;
		StringBuilder ex = new StringBuilder("=== Central P2-CG ===\n");
		for (Usuario usuario : usuarios) {
			precototal = 0;
			ex.append(usuario.toString());
			ex.append("Lista de Jogos:\n");
			for (Jogo jogo : usuario.getMeusJogos() ) {
				precototal += jogo.getPrecoJogo();
				ex.append(jogo.toString());
			}
			ex.append("Total de preco dos jogos: R$ " + precototal + "\n");
			ex.append("\n--------------------------------------------");
		}
		return ex.toString();
	}
	
	
	/**
	 * Override do metodo hashcode de Java
	 * @param hashcode 
	 */
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

}
