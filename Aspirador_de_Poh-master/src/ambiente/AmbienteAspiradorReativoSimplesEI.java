package ambiente;

import agentes.AspiradorReativoSimplesEI;

public class AmbienteAspiradorReativoSimplesEI extends Ambiente {
	
	protected AspiradorReativoSimplesEI aspiradorEI;
	protected int pontuacaoAspiradorEI;
	protected int totalMovimentos;

	public AmbienteAspiradorReativoSimplesEI(int largura, int altura) {
		// informa dimensoes do ambiente para classe pai (Ambiente).
		super(largura, altura);
		// instancia do aspirador reativo simples com EI.
		this.aspiradorEI = new AspiradorReativoSimplesEI();
		this.pontuacaoAspiradorEI = 0;
		this.totalMovimentos = 0;
	}

	@Override
	public void executarAspirador() {
		
		if( aspiradorEI.sensorSujeira.ativarSensor(this.getSala()) ){
			this.pontuacaoAspiradorEI++;
		} else {
			
			// verifica se a proxima sala para onde o aspirador vai mover-se tem obstaculo.
			boolean salaOcupada = aspiradorEI.sensorObstaculo.ativarSensor(this.getProximaSala());
			// verifica se a proxima sala para onde o aspirador vai mover-se jah foi visitada.
			int coordX = aspiradorEI.getProximaPosX();
			int coordY = aspiradorEI.getProximaPosY();
			boolean salaVisitada = aspiradorEI.ehSalaVisitada(coordX, coordY);
			
			if(salaOcupada || salaVisitada)
				aspiradorEI.girarNoventaGraus();
			
			aspiradorEI.efetuarMovimentacao();
			this.totalMovimentos++;
		}
	}

	@Override
	public void exibirAmbiente() {
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
				   		   "\n Pontuação Aspirador Reativo Simples com EI: " + this.pontuacaoAspiradorEI +
				   		   "\n Total de Movimentos: " + this.totalMovimentos);
	}
	
	/******** GETTERS *********/
	
	protected Sala getSala() {
		return this.ambiente[aspiradorEI.getPosX()][aspiradorEI.getPosY()];
	}
	
	protected Sala getProximaSala() {
		return this.ambiente[aspiradorEI.getProximaPosX()][aspiradorEI.getProximaPosY()];
	}

}
