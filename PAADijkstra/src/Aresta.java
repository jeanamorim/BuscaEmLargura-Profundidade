/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JeanAmorim
 */

public class Aresta {

    private int peso;        // Tempo
    private Vertice origem;  // no de Origem
    private Vertice destino; // no de Destino

    public Aresta(Vertice v1, Vertice v2, int p) {
        this.peso = p;
        this.origem = v1;
        this.destino = v2;

    }

    // Retorna a Tempo

    public int getPeso() {
        return peso;
    }

    // Retorna o no de Destino

    public Vertice getDestino() {
        return destino;
    }

    // Retorna o no de Destino

    public Vertice getOrigem() {
        return origem;
    }

}



