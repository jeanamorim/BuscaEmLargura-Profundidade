package agentes;

import agentes.DirecaoAspirador;
import sensores.Sensor;

/**
 * Define as funcionalidades padroes de um agente aspirador, como: 
 * posicionamento e deslocamento nos eixos, sensor de sujeira e sensor de obstaculo.
 */

public abstract class Aspirador {
	
	// Posicao (posX, posY) efetiva (atual) onde o aspirador se encontra.
	protected int posX, posY;
	
	/* Deslocamento do aspirador nos eixos */
	protected int deslX, deslY;
	
	// sensores.
	public Sensor sensorSujeira, sensorObstaculo;
	
	public abstract void efetuarMovimentacao();
	
	/******** SETTERS *********/
	
	public void setDirecao(DirecaoAspirador d){
		switch (d) {
		case cima:
			this.deslX = 0;
			this.deslY = -1;
			break;
		case baixo:
			this.deslX = 0;
			this.deslY = 1;
			break;
		case esquerda:
			this.deslX = -1;
			this.deslY = 0;
			break;
		case direita:
			this.deslX = 1;
			this.deslY = 0;
			break;
		default:
			break;
		}
	}
	
	public void setPos(int x, int y) {
		this.posX = x;
		this.posY = y;
	}

	/******** GETTERS *********/
	
	public int getProximaPosX(){
		int coordX = this.posX + this.deslX;
		return coordX;
	}
	
	public int getProximaPosY(){
		int coordY = this.posY + this.deslY;
		return coordY;
	}
	
	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public int getDeslX() {
		return this.deslX;
	}

	public int getDeslY() {
		return this.deslY;
	}
}
