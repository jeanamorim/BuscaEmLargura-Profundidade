package AlgoritmoDijkstra;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JeanAmorim
 */
public class Vertice implements Comparable<Vertice>{
        
        private String descricao;
        private int distancia;
        private boolean visitado = false;
        private Vertice pai;
        private List<Aresta> arestas = new ArrayList<Aresta>();
        
        public Vertice(String nome) {
        	  this.descricao = nome;
		}

        public String getDescricao(){
        	return descricao;
        }
        
        public void visitar(){
        	this.visitado = true;
        }
        
        public boolean verificarVisita(){
        	return visitado;
        }
        
        public void setDistancia(int distancia){
        	this.distancia = distancia;
        }
        
        public int getDistancia(){
        	return this.distancia;
        }
        
        public void setPai(Vertice pai){
        	this.pai = pai;
        }
        
        public Vertice getPai(){
        	return this.pai;
        }

        public void setAresta(Aresta aresta){
        	this.arestas.add(aresta);
        }        
        
        public List<Aresta> getArestas() {
        	return arestas;
        }

        @Override
        public int compareTo(Vertice vertice) {
                  if(this.getDistancia() < vertice.getDistancia()) return -1;
          else if(this.getDistancia() == vertice.getDistancia()) return 0;
          
          return 1;
        }
        
        @Override
        public boolean equals(Object obj) {
                if(obj instanceof Vertice){
                        Vertice vRef = (Vertice) obj;
                        if(this.getDescricao().equals(vRef.getDescricao())) return true;
                }
                return false;
        }
        
        @Override
        public String toString() {
                String s = " ";
                s+= this.getDescricao();
                return s;
        }
}

