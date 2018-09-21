/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_de_busca;

/**
 *
 * @author Joice
 */
public class No {
    //classe nó com os seus gets e sets
    
    private int valor;// Busca - Resultado
	
	private int custo;
	
	private No noPai;	
	private No noEsquerda;
	private No noDireita;
	
	public No(int valor) {
		this.valor = valor;
		this.custo = 0;
	}
	
	public No (int valor, int custo) {
		this.valor = valor;
		this.custo = custo;
	}

	public int getValor() {
		return valor;
	}

	public No getNoEsquerda() {
		return noEsquerda;
	}

	public void setNoEsquerda(No noEsquerda) {
		this.noEsquerda = noEsquerda;
		this.noEsquerda.setNoPai(this);
	}

	public No getNoDireita() {
		return noDireita;
	}

	public void setNoDireita(No noDireita) {
		this.noDireita = noDireita;
		this.noDireita.setNoPai(this);
	}

	public No getNoPai() {
		return noPai;
	}

	public void setNoPai(No noPai) {
		this.noPai = noPai;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}
    
    
    
}
