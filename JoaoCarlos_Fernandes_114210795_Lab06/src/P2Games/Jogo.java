package P2Games;

import java.util.ArrayList;

public class Jogo {
	private String nomeJogo, tipoJogo;
	private double precoJogo;
	private int topScore = 0, vezesJogadas = 0, vezesZeradas= 0;
	private ArrayList<String> estiloJogo;
	
	// Construtor
	public Jogo(String nomeJogo, double precoJogo) throws Exception {
		verificaNome(nomeJogo);
		verificaPreco(precoJogo);
		
		this.nomeJogo = nomeJogo;
		this.precoJogo = precoJogo;
	}
	
	
	private void verificaPreco(double precoJogo) throws Exception {
		if (precoJogo <= 0) {
			throw new Exception("Preço não pode ser menor que 0");
		}
	}


	private void verificaNome(String nomeJogo) throws Exception {
		if (nomeJogo == null || nomeJogo.trim().equals("")) {
			throw new Exception("Nome do jogo é vazio ou nulo");
		}
	}

	/**
	 * 
	 * @param score
	 * @param zerou
	 */

	// Metodo que registra jogatina e armazena caso seja o top score
	public void registraJogada(int score, boolean zerou) {
		
		if (score > this.topScore) {
			this.topScore = score;
		}
	}
	
	
	// Setters
	public void setTipoJogo(String tipo) {
		this.tipoJogo = tipo;
	}
	public void setVezesJogadas(int vezes) {
		this.vezesJogadas = vezes;
	}
	public void setVezesZeradas(int zeradas) {
		this.vezesZeradas = zeradas;
	}
	public void setEstiloJogo(String tipo) {
		if (!this.estiloJogo.contains(tipo)) {
			this.estiloJogo.add(tipo);
		}
	}
	
	// Getters
	public String getNomeJogo() {
		return nomeJogo;
	}

	public String getTipoJogo() {
		return tipoJogo;
	}

	public double getPrecoJogo() {
		return precoJogo;
	}

	public int getTopScore() {
		return topScore;
	}

	public int getVezesJogadas() {
		return vezesJogadas;
	}

	public int getVezesZeradas() {
		return vezesZeradas;
	}
	
	public ArrayList<String> getEstiloJogo() {
		return this.estiloJogo;
	}

	
	@Override
	public String toString() {
		return "Jogo [nomeJogo=" + nomeJogo + ", tipoJogo=" + tipoJogo + ", precoJogo=" + precoJogo + ", topScore="
				+ topScore + ", vezesJogadas=" + vezesJogadas + ", vezesZeradas=" + vezesZeradas + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeJogo == null) ? 0 : nomeJogo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precoJogo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipoJogo == null) ? 0 : tipoJogo.hashCode());
		result = prime * result + topScore;
		result = prime * result + vezesJogadas;
		result = prime * result + vezesZeradas;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Jogo)) {
			return false;
		}
		String newObj = (String) obj;
		if (this.nomeJogo.equals(newObj)) {
			return true;
		}
		return false;
	}
	
	
}
