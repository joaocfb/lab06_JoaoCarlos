package P2Games;

import java.util.ArrayList;

public class Usuario {
	private String nome, tipoUsuario, login;
	private ArrayList<Jogo> meusJogos;
	private double dinheiroCaixa;
	
	public Usuario(String nome,String login,String tipousuario, double dinheiro) {
		
		this.nome = nome; 
		this.login = login; 
		this.tipoUsuario = tipousuario; 
		this.dinheiroCaixa = dinheiro;
	}
	
	public void compraJogos(Jogo nomeJogo) {
		double precodesconto = 0;
		if (this.tipoUsuario.equalsIgnoreCase("Noob")) {
			 precodesconto = 
		}
	}
}
