
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joice
 */
public class Vertice implements Comparable<Vertice> {
    
      public final String nome;
	public ArrayList<Aresta> vizinhos;
	public LinkedList<Vertice> caminho;
	public double distanciaMinima = Double.POSITIVE_INFINITY;
	public Vertice anterior;
	
	public Vertice(String nome){
		this.nome = nome;
		vizinhos = new ArrayList<Aresta>();
		caminho = new LinkedList<Vertice>();
	}
	public String toString(){
		return nome;
	}	

    @Override
    public int compareTo(Vertice v) {
        return Double.compare(distanciaMinima,v.distanciaMinima);
    }
}
    

