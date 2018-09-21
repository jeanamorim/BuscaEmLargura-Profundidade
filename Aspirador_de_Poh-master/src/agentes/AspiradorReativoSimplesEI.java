package agentes;

import java.util.ArrayList;

import sensores.SensorObstaculo;
import sensores.SensorSujeira;
import agentes.DirecaoAspirador;

/**
 * Agente Aspirador Reativo Simples com Estado Interno. Armazena em seu estado
 * interno as salas que já visitou para que não repita os mesmos caminhos.
 */

public class AspiradorReativoSimplesEI extends Aspirador {
	
	// classe interna a AspiradorReativoSmplesEI 
	// que representa as salas já percorridas.
	private class SalaVisitada {
		int x, y;
		
		public SalaVisitada(int coordX, int coordY) {
			this.x = coordX;
			this.y = coordY;
		}
	}
	
	DirecaoAspirador direcao;
	// ArrayList que contem as salas jah visitadas.
	ArrayList<SalaVisitada> salasVisitadas;
	
	public AspiradorReativoSimplesEI() {
		this.posX = 1;
		this.posY = 1;
		
		sensorSujeira = new SensorSujeira();
		sensorObstaculo = new SensorObstaculo();
		
		this.direcao = DirecaoAspirador.baixo;
		this.salasVisitadas = new ArrayList<AspiradorReativoSimplesEI.SalaVisitada>();
	}
	
	// verifica a partir das coordenadas se a sala jah foi visitada.
	public boolean ehSalaVisitada(int coordX, int coordY) {
		boolean flag = false;
		
		for (SalaVisitada sv : salasVisitadas) {
			if(sv.x == coordX && sv.y == coordY){
				flag = true;
			}
		}
		return flag;
	}
	
	// Transforma os deslocamentos em posicoes efetivas (pos + desl).
	public void efetuarMovimentacao() {
		// add a sala corrente no arraylist de salas visitadas.
		this.salasVisitadas.add(new SalaVisitada(this.posX, this.posY));
		// setando direcao.
		this.setDirecao(this.direcao);
		System.out.println("Moveu para " + this.direcao);
		// setando posicao efetiva.
		this.posX += this.deslX;
		this.posY += this.deslY;
	}
	
	// rotaciona o aspirador em noveta graus.
	public void girarNoventaGraus(){
		switch (this.direcao) {
		case baixo:
			this.direcao = DirecaoAspirador.direita;
			System.out.println("Girou 90 graus para direita.\n");
			break;
		case direita:
			this.direcao = DirecaoAspirador.cima;
			System.out.println("Girou 90 graus para cima.\n");
			break;
		case cima:
			this.direcao = DirecaoAspirador.esquerda;
			System.out.println("Girou 90 graus para esquerda.\n");
			break;
		case esquerda:
			this.direcao = DirecaoAspirador.baixo;
			System.out.println("Girou 90 graus para baixo.\n");
			break;
		default:
			break;
		}
		this.setDirecao(this.direcao);
	}
}
