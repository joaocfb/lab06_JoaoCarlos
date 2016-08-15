package P2Games;

import java.util.ArrayList;

public class Façade {
	private ArrayList<Usuario> usuarios;
	
	public Façade() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public void AddUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void AddDinheiro(String login, double dinheiro) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				usuario.setDinheiroCaixa(dinheiro);
			}
		}
	}
	
	public void VendaJogos(String login, Jogo nomeJogo) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				usuario.CompraJogos(nomeJogo);
			}
		}
	}
	
	public void upgrade() throws Exception {
		
	}
	
	
	
	
	
	@Override
	public String toString() {
		double precototal;
		StringBuilder ex = new StringBuilder("=== Central P2-CG ===/n");
		for (Usuario usuario : usuarios) {
			precototal = 0;
			ex.append(usuario.getLogin());
			ex.append("/n");
			ex.append(usuario.getNome() + " - Jogador " + usuario.getClass());
			ex.append("/n");
			ex.append("Lista de Jogos:/n");
			for (Jogo jogo : usuario.getMeusJogos() ) {
				precototal += jogo.getPrecoJogo();
				ex.append("+ " + jogo.getNomeJogo() + " - " + jogo.getClass() + ":/n");
				ex.append("==> Jogou " + jogo.getVezesJogadas() + "vez(es)");
				ex.append("==> Zerou " + jogo.getVezesZeradas() + "vez(es)");
				ex.append("==> Maior Score: " + jogo.getTopScore() + "/n");
			}
			ex.append("Total de preço dos jogos: R$ " + precototal + "/n");
			ex.append("/n--------------------------------------------");
		}
		return ex.toString();
	}
	
}
