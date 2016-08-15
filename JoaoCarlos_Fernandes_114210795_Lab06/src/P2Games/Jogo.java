package P2Games;

public abstract class Jogo {
	private String nomeJogo;
	private double precoJogo;
	private int topScore, vezesJogadas, vezesZeradas;
	public Usuario usuario;
	
	// Construtor
	public Jogo(String nomeJogo, double precoJogo) throws Exception {
		verificaNome(nomeJogo);
		verificaPreco(precoJogo);
		
		this.setNomeJogo(nomeJogo);
		this.setPrecoJogo(precoJogo);;
		this.setTopScore(0);
		this.setVezesJogadas(0);
		this.setVezesZeradas(0);
	}
	
	private void verificaPreco(double precoJogo) throws Exception {
		if (precoJogo <= 0) {
			throw new Exception("Preco nao pode ser menor que 0.");
		}
	}

	private void verificaNome(String nomeJogo) throws Exception {
		if (nomeJogo == null || nomeJogo.trim().equals("")) {
			throw new Exception("Nome do jogo nao pode ser vazio ou nulo.");
		}
	}

	// Metodo que registra jogatina e armazena caso seja o top score
	public abstract void registraJogada(int score, boolean zerou);
	
	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}
	
	public void setPrecoJogo(double precoJogo) {
		this.precoJogo = precoJogo;
	}


	public void setTopScore(int topScore) {
		this.topScore = topScore;
	}
	
	public void setVezesJogadas(int vezes) {
		this.vezesJogadas = vezes;
	}
	public void setVezesZeradas(int zeradas) {
		this.vezesZeradas = zeradas;
	}
	
	public String getNomeJogo() {
		return nomeJogo;
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
	
	@Override
	public String toString() {
		return "Jogo [nomeJogo=" + nomeJogo + ", precoJogo=" + precoJogo + ", topScore="
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
		result = prime * result + topScore;
		result = prime * result + vezesJogadas;
		result = prime * result + vezesZeradas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo) {
			Jogo novojogo = (Jogo) obj;
			return this.getNomeJogo().equals(novojogo.getNomeJogo());
		}
		return false;
	}
}
