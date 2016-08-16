
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
	 */
	public Usuario(String nome,String login, ArrayList<Jogo> jogos) {
		
		this.nome = nome; 
		this.login = login; 
		this.meusJogos = new ArrayList<Jogo>(jogos);
		this.x2p= 0;
	}
	
	
	/**
	 * Metodo Abstrato que leva ao metodo dos subtipos de Usuario
	 */
	
	
	public abstract void compraJogos(Jogo novoJogo); 
	
	
	/**
	 * Metodo que chama o metodo registraJogada da classe Jogo
	 * Podendo setar novo topscore e incrementar vezesZeradas
	 */
	
	
	public void registraJogada(Jogo nomeDoJogo, int score, boolean zerou) {
		nomeDoJogo.registraJogada(score, zerou);
	}

	
	/** 
	 * Getters
	 */
	
	
	public int getX2P() {
		return this.x2p;
	}
	public double getDinheiroCaixa() {
		return dinheiroCaixa;
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
	
	
	public void setDinheiroCaixa(double dinheiro) {
		this.dinheiroCaixa = dinheiro;
	}
	
	public void setX2P(int experience) {
		this.x2p = experience;
	}
}
