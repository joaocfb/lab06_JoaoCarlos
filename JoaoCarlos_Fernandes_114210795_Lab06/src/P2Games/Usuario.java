package P2Games;

import java.util.ArrayList;

public abstract class Usuario {
	private String nome, login;
	private ArrayList<Jogo> meusJogos;
	private double dinheiroCaixa;
	private Jogo jogo;
	
	public Usuario(String nome,String login, ArrayList<Jogo> jogos) {
		
		this.nome = nome; 
		this.login = login; 
		this.meusJogos = new ArrayList<Jogo>(jogos);
	
	}
	
	public void CompraJogos(Jogo novoJogo) {
		if (this.dinheiroCaixa >= novoJogo.getPrecoJogo()) {
			this.setDinheiroCaixa(this.dinheiroCaixa - (novoJogo.getPrecoJogo() * 0.9));
		}
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
	
	public void setDinheiroCaixa(double dinheiro) {
		this.dinheiroCaixa = dinheiro;
	}
	
	
}
