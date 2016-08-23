package P2Games;
/**
 * @author Joao Carlos Fernandes. 114210795.
 */


public abstract class Jogo {
	private String nomeJogo;
	private double precoJogo;
	private int topScore, vezesJogadas, vezesZeradas;
	protected Usuario usuario;
	
	
	/**
	 * Construtor da classe Jogo
	 * @param nomeJogo
	 * @param precoJogo
	 * @throws Exception
	 */
	
	
	public Jogo(String nomeJogo, double precoJogo) throws Exception {
		
		this.setNomeJogo(nomeJogo);
		this.setPrecoJogo(precoJogo);;
		this.topScore = 0;
		this.vezesJogadas = 0;
		this.vezesZeradas = 0;
	}
	
	

	
	/**
	 * Metodo que registra jogatina e armazena caso seja o top score
	 * @param int
	 * @param boolean
	 * @return int
	 * @throws Exception 
	 */
	
	
	public int registraJogada(int score, boolean zerou) throws Exception {
		this.verificaScore(score);
		if (score > this.getTopScore()) {
			this.setTopScore(score);
		} 
		if (zerou) {
			this.setVezesZeradas(this.getVezesZeradas() + 1);
		} 
		this.setVezesJogadas(this.getVezesJogadas() + 1);
		return this.getBonus(score);
	}
	
	protected abstract int getBonus(int score);

	private void verificaScore(int score) throws Exception {
		if (score <= 0) {
			throw new Exception("Score não pode ser menor ou igual a 0");
		}
	}
	
	/**
	 * Setters
	 * @throws Exception 
	 */
	
	
	public void setNomeJogo(String nomeJogo) throws Exception {
		if (nomeJogo == null || nomeJogo.trim().equals("")) {
			throw new Exception("Nome do jogo nao pode ser vazio ou nulo.");
		}
		this.defineNome(nomeJogo);
	}
	
	private void defineNome(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}
	
	public void setPrecoJogo(double precoJogo) throws Exception {
		if (precoJogo <= 0) {
			throw new Exception("Preco nao pode ser menor que 0.");
		}
		this.definePrecoJogo(precoJogo);
	}
	
	private void definePrecoJogo(double precoJogo) {
		this.precoJogo = precoJogo;
	}

	public void setTopScore(int topScore) throws Exception {
		if (topScore <= 0) {
			throw new Exception("Score não pode ser menor ou igual a 0");
		}
		this.defineTopScore(topScore);
	}
	
	private void defineTopScore(int topScore) {
		this.topScore = topScore;
	}
	
	public void setVezesJogadas(int vezes) throws Exception {
		if (vezes <= 0) {
			throw new Exception("Nao e possivel por um numero menor ou igual a 0");
		}
		this.defineVezesJogadas(vezes);;
	}
	
	private void defineVezesJogadas(int vezes) {
		this.vezesJogadas = vezes;
	}
	
	public void setVezesZeradas(int zeradas) throws Exception {
		if (zeradas <= 0) {
			throw new Exception("Nao e possivel por um numero menor ou igual a 0");
		}
		this.defineVezesZeradas(zeradas);
	}

	private void defineVezesZeradas(int zeradas) {
		this.vezesZeradas = zeradas;
	}
	
	/**
	 * Getters 
	 */
	
	
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
	
	
	/**
	 * Override do toString de Java
	 * @param toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder ex = new StringBuilder();
		ex.append("+ " + this.getNomeJogo() + " - " + this.getClass().getSimpleName() + ":\n");
		ex.append("==> Jogou " + this.getVezesJogadas() + "vez(es)\n");
		ex.append("==> Zerou " + this.getVezesZeradas() + "vez(es)\n");
		ex.append("==> Maior Score: " + this.getTopScore() + "\n");
		return ex.toString();
	}

	
	/**
	 * Override do hashcode de Java
	 * @param hashcode 
	 */
	
	
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

	
	/**
	 * Override do equals de Java
	 * @param equals
	 */
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo) {
			Jogo novojogo = (Jogo) obj;
			return this.getNomeJogo().equals(novojogo.getNomeJogo());
		}
		return false;
	}
}
