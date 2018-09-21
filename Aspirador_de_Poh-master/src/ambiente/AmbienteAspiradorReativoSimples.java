package ambiente;

import agentes.AspiradorReativoSimples;

/**
 * Constroi o Ambiente onde o Aspirador Reativo Simples ira atuar.
 */

public class AmbienteAspiradorReativoSimples extends Ambiente {
	
	protected AspiradorReativoSimples aspirador;
	protected int pontuacaoAspirador;
	protected int totalMovimentos;

	public AmbienteAspiradorReativoSimples(int largura, int altura) {
		// informa dimensoes do ambiente para classe pai (Ambiente).
		super(largura, altura);
		// instancia do aspirador reativo simples.
		this.aspirador = new AspiradorReativoSimples();
		this.pontuacaoAspirador = 0;
		this.totalMovimentos = 0;
	}
	
	@Override
	public void executarAspirador() {
		
		if( aspirador.sensorSujeira.ativarSensor(this.getSala()) ) {
			this.pontuacaoAspirador++;
			System.out.println("Aspirou\n");
		}
		
		aspirador.direcaoAleatoria();
		
		while( aspirador.sensorObstaculo.ativarSensor( this.getProximaSala() ) )
			aspirador.direcaoAleatoria();
		
		aspirador.efetuarMovimentacao();
		this.totalMovimentos++;
	}
	
	@Override
	public void exibirAmbiente(){
		System.out.println();
		for (int x = 0; x < this.altura; x++) {
			for (int y = 0; y < this.largura; y++) {
				System.out.print(this.ambiente[x][y].getDescricaoSala() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Override
	public void exibirInfo() {
		System.out.println("\n Tamanho do Ambiente: (" + (this.altura - 2) + "," + (this.largura - 2) + ")" +
						   "\n Pontuação Aspirador Reativo Simples: " + this.pontuacaoAspirador +
						   "\n Total de Movimentos: " + this.totalMovimentos);
	}
	
	/******** GETTERS *********/
	
	protected Sala getSala() {
		return this.ambiente[aspirador.getPosX()][aspirador.getPosY()];
	}
	
	protected Sala getProximaSala() {
		return this.ambiente[aspirador.getProximaPosX()][aspirador.getProximaPosY()];
	}
}
