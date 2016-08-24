
package P2Games;

import java.util.ArrayList;


/**
 * @author Joao Carlos Fernandes Bernardo. 114210795.
 */


public abstract class Usuario {
	

	private String nome, login;
	private ArrayList<Jogo> meusJogos;
	private double dinheiroCaixa;
	private int x2p;

	
	/**
	 * Construtor da classe Usuario
	 * @param nome
	 * @param login
	 * @param jogos
	 * @throws Exception 
	 */
	
	
	public Usuario(String nome,String login, ArrayList<Jogo> jogos) throws Exception {
		
		this.setNomeUsuario(nome);
		this.setLoginUsuario(login);
		this.meusJogos = new ArrayList<Jogo>(jogos);
		this.x2p= 0;
	}


	/**
	 * Metodo Abstrato que leva ao metodo dos subtipos de Usuario
	 * @throws Exception 
	 */
	
	
	public void compraJogos(Jogo novoJogo) throws Exception {
		for (Jogo jogo : meusJogos) {
			if (jogo.equals(novoJogo)) {
				throw new Exception("O Usuario ja possui este jogo");
			}
		}
		verificaDinheiro(novoJogo);
		this.setX2P(this.getX2P() + (int) (15 * novoJogo.getPrecoJogo()));
		this.setDinheiroCaixa(this.getDinheiroCaixa() - (novoJogo.getPrecoJogo() - getDesconto(novoJogo)));
	}
	
	protected abstract double getDesconto(Jogo novoJogo);

	private void verificaDinheiro(Jogo novoJogo) throws Exception {
		if (this.getDinheiroCaixa() < novoJogo.getPrecoJogo()) {
			throw new Exception("O Usuario nao possui dinheiro suficiente");
		}
	}
	
	/**
	 * Metodo que chama o metodo registraJogada da classe Jogo
	 * Podendo setar novo topscore e incrementar vezesZeradas
	 * @throws Exception 
	 */
	
	
	public void registraJogada(Jogo nomeDoJogo, int score, boolean zerou) throws Exception {
		int valor = nomeDoJogo.registraJogada(score, zerou);
		this.setX2P(this.getX2P() + valor);
		
	}

	
	/** 
	 * Getters
	 */
	
	
	public int getX2P() {
		return this.x2p;
	}
	public double getDinheiroCaixa() {
		return this.dinheiroCaixa;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public ArrayList<Jogo> getMeusJogos() {
		return this.meusJogos;
	}
	
	
	/**
	 * Setters
	 */
	
	public void setNomeUsuario(String nome) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome invalido (Nulo ou vazio)");
		}
			this.defineNomeUsuario(nome); 
	}
	
	private void defineNomeUsuario(String nome) {
		this.nome = nome;
	}
	
	public void setLoginUsuario(String login) throws Exception {
		if (login == null || login.trim().equals("")) {
			throw new Exception("Login invalido (Nulo ou vazio)");
		}
		this.defineLoginUsuario(login);
	}
	
	private void defineLoginUsuario(String login) {
		this.login = login;
	}
	
	public void setDinheiroCaixa(double dinheiro) throws Exception {
		if (dinheiro < 0) {
			throw new Exception("Quantidade invalida (Menor que 0)");
		}
		this.dinheiroCaixa = dinheiro;
	}
	
	public void setX2P(int experience) throws Exception {
		if (experience < 0) {
			throw new Exception("Naoo e possivel adicionar X2P menor que 0");
		}
		this.defineX2P(experience);
	}
	
	private void defineX2P(int experience) {
		this.x2p = experience;
	}

	
	/**
	 * Override do metodo toString de Java
	 * @param toString()
	 */
	
	
	@Override
		public String toString() {
		StringBuilder ex = new StringBuilder();
		ex.append(this.getLogin() + "\n");
		ex.append(this.getNome() + " - Jogador " + this.getClass().getSimpleName() + "\n");
		return ex.toString();
	}
	
	
	/**
	 * Override do metodo equals de Java
	 * @param equals
	 */
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario usuario = (Usuario) obj;
			return (this.getNome().equals(usuario.getNome()) || this.getLogin().equals(usuario.getLogin()));
		}
		return false;
	}
}