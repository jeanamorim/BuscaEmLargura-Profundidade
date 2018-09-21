package ambiente;

public abstract class Ambiente {

	/**
	 * Ambiente padrao. Eh constituido por uma matriz quadrada (largura x
	 * altura) de salas.
	 */

	protected int largura;
	protected int altura;
	protected Sala[][] ambiente;

	public Ambiente(int largura, int altura) {
		// verificacao de ambiente n x n e sua instanciacao.
		if (largura == altura) {
			this.largura = largura + 2;
			this.altura = altura + 2;
			this.ambiente = new Sala[this.largura][this.altura];
		} else {
			System.out.println("O ambiente deve ser quadrado!");
		}

		// formando o ambiente.
		for (int l = 0; l < this.largura; l++) {
			for (int h = 0; h < this.altura; h++) {
				if (ehParede(l, h, this.largura, this.altura))
					ambiente[l][h] = new Sala(estadoSala.obstaculo);
				else
					ambiente[l][h] = new Sala();
			}
		}
	}

	// Retorna verdadeiro caso a posicao seja uma parede (obstaculo).
	public boolean ehParede(int l, int h, int largura, int altura) {
		boolean flag = false;

		if (l == 0 || h == 0 || l == (largura - 1) || h == (altura - 1))
			flag = true;
		return flag;
	}

	// Retorna verdadeiro caso a posicao nao tenha obstaculos.
	public boolean posicaoValida(int l, int h) {
		boolean flag = false;

		if ((l > 0 && l < this.largura) && (h > 0 && h < this.largura)
				&& (this.ambiente[l][h].estado != estadoSala.obstaculo))
			flag = true;
		return flag;
	}

	// Retorna verdadeiro caso ainda exista sujeira no ambiente, ou falso caso
	// contrario.
	public boolean existeSujeira() {
		boolean flag = false;

		for (int x = 0; x < this.largura; x++) {
			for (int y = 0; y < this.altura; y++) {
				if (this.ambiente[x][y].estado == estadoSala.sujo)
					flag = true;
			}
		}
		return flag;
	}
	
	public void randomColocarSujeiras(){
		int k = (int) (Math.random() * (getAltura()));
		
		for (int i = 0; i < k; i++) {
			int random1 = (int) (getLargura() * Math.random());
			int random2 = (int) (getLargura() * Math.random());
			if (random1 != 1 && random2 != 1) {// é a posicao inicial?
				if (getAmbiente()[random1][random2].estado.toString().equals("limpo")) { // esta  limpo?
					setSujeira(random1, random2);
				} else {
					i--;
				}
			} else {
				i--;
			}
		}
	}
	
	public void randomColocarObstaculos(){
		int k = (int) (Math.random() * getAltura());
		
		for (int i = 0; i < k; i++) {
			int random1 = (int) (getLargura() * Math.random());
			int random2 = (int) (getLargura() * Math.random());
			if (random1 != 1 && random2 != 1) {// é a posicao inicial?
				if (getAmbiente()[random1][random2].estado.toString().equals("limpo")) { // esta  limpo?
					setObstaculo(random1, random2);
				} else {
					i--;
				}
			} else {
				i--;
			}
		}
	}

	public abstract void executarAspirador();

	public abstract void exibirInfo();

	public abstract void exibirAmbiente();

	/******** SETTERS *********/

	// Deposita sujeita nas coordenadas passadas por parametro.
	public void setSujeira(int l, int h) {
		if (posicaoValida(l, h))
			this.ambiente[l][h].estado = estadoSala.sujo;
	}

	// Constroe um obstaculo nas coordenadas passadas por parametro.
	public void setObstaculo(int l, int h) {
		if (posicaoValida(l, h))
			this.ambiente[l][h].estado = estadoSala.obstaculo;
	}

	/******** GETTERS *********/

	public int getLargura() {
		return this.largura;
	}

	public int getAltura() {
		return this.altura;
	}

	public Sala[][] getAmbiente() {
		return this.ambiente;
	}
}
