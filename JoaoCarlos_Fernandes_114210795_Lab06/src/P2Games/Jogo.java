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
		
		verificaNome(nomeJogo);
		verificaPreco(precoJogo);
		
		this.setNomeJogo(nomeJogo);
		this.setPrecoJogo(precoJogo);;
		this.setTopScore(0);
		this.setVezesJogadas(0);
		this.setVezesZeradas(0);
	}
	
	
	/**
	 * Metodo de verificação se precoJogo é valido
	 * @param precoJogo
	 * @throws Exception
	 */
	
	
	private void verificaPreco(double precoJogo) throws Exception {
		if (precoJogo <= 0) {
			throw new Exception("Preco nao pode ser menor que 0.");
		}
	}
	
	
	/**
	 * Metodo de verificação se nome é válido
	 * @param nomeJogo
	 * @throws Exception
	 */
	
	
	private void verificaNome(String nomeJogo) throws Exception {
		if (nomeJogo == null || nomeJogo.trim().equals("")) {
			throw new Exception("Nome do jogo nao pode ser vazio ou nulo.");
		}
	}

	
	/**
	 * Metodo que registra jogatina e armazena caso seja o top score
	 * @param score
	 * @param zerou
	 * @throws Exception 
	 */
	
	
	public abstract void registraJogada(int score, boolean zerou) throws Exception;
	
	
	/**
	 * Setters
	 */
	
	
	public void setNomeJogo(String nomeJogo) {
		this.defineNome(nomeJogo);
	}
	
	private void defineNome(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}
	
	public void setPrecoJogo(double precoJogo) {
		this.definePrecoJogo(precoJogo);
	}
	
	private void definePrecoJogo(double precoJogo) {
		this.precoJogo = precoJogo;
	}

	public void setTopScore(int topScore) {
		this.defineTopScore(topScore);
	}
	
	private void defineTopScore(int topScore) {
		this.topScore = topScore;
	}
	
	public void setVezesJogadas(int vezes) {
		this.defineVezesJogadas(vezes);;
	}
	
	private void defineVezesJogadas(int vezes) {
		this.vezesJogadas = vezes;
	}
	
	public void setVezesZeradas(int zeradas) {
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
