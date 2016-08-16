package P2Games;

import java.util.ArrayList;

public class Fachada {
	private ArrayList<Usuario> usuarios;
	
	public Fachada() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void addDinheiro(String login, double dinheiro) {
		for (Usuario usuario : this.usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				usuario.setDinheiroCaixa(dinheiro);
			}
		}
	}
	
	public void vendaJogos(String login, Jogo nomeJogo) {
		for (Usuario usuario : this.usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				usuario.compraJogos(nomeJogo);
			}
		}
	}
	
	public void upgrade(String login) throws Exception {
		testaTipo(login);
		testax2p(login);
		int i = this.usuarios.indexOf(login);
		Usuario usuario = new Veterano(this.usuarios.get(i).getNome(),this.usuarios.get(i).getLogin(), this.usuarios.get(i).getMeusJogos());
		usuario.setX2P(this.usuarios.get(i).getX2P());
		usuario.setDinheiroCaixa(this.usuarios.get(i).getDinheiroCaixa());
		this.usuarios.remove(i);
		this.usuarios.add(usuario);
	}
	
	public void testaTipo(String login) throws Exception {
		if (usuarios.get(this.usuarios.indexOf(login)).getClass().getName().equalsIgnoreCase("Veterano")) {
			throw new Exception("Nao pode haver upgrade do usuario, ele ja e veterano.");
		}
	}
	
	public void testax2p(String login) throws Exception {
		if (this.usuarios.get(this.usuarios.indexOf(login)).getX2P() < 1000) {
			throw new Exception("Usuario nao possui x2p suficiente.");
		}
	}
	
	@Override
	public String toString() {
		double precototal;
		StringBuilder ex = new StringBuilder("=== Central P2-CG ===/n");
		for (Usuario usuario : usuarios) {
			precototal = 0;
			ex.append(usuario.getLogin() + "/n");
			ex.append(usuario.getNome() + " - Jogador " + usuario.getClass().getName() + "/n");
			ex.append("Lista de Jogos:/n");
			for (Jogo jogo : usuario.getMeusJogos() ) {
				precototal += jogo.getPrecoJogo();
				ex.append("+ " + jogo.getNomeJogo() + " - " + jogo.getClass().getName() + ":/n");
				ex.append("==> Jogou " + jogo.getVezesJogadas() + "vez(es)");
				ex.append("==> Zerou " + jogo.getVezesZeradas() + "vez(es)");
				ex.append("==> Maior Score: " + jogo.getTopScore() + "/n");
			}
			ex.append("Total de preco dos jogos: R$ " + precototal + "/n");
			ex.append("/n--------------------------------------------");
		}
		return ex.toString();
	}
	
}
