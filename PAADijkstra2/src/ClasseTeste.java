/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joice
 */
public class ClasseTeste {
    
     public static void main(String[] arg){
		
		Dijkstra obj = new Dijkstra();
		
		// Crie um novo gráfico.
		Grafo g = new Grafo(9);
		
		//Adiciona as ligacoes e os pesos entre os verices
		g.adicionarAresta(0, 1, 4); 
                g.adicionarAresta(0, 7, 8);
                
		g.adicionarAresta(1, 2, 8); 
                g.adicionarAresta(1, 7, 11);
                
                g.adicionarAresta(2, 1, 8);
		g.adicionarAresta(2, 8, 2); 
                g.adicionarAresta(2, 5, 4);
                g.adicionarAresta(2, 3, 7);
                
		g.adicionarAresta(3, 2, 7);
                g.adicionarAresta(3, 5, 14); 
                g.adicionarAresta(3, 4, 9);
                
		g.adicionarAresta(4, 3, 9); 
                g.adicionarAresta(4, 5, 10);
                
		g.adicionarAresta(5, 4, 10); 
                g.adicionarAresta(5, 3, 14); 
                g.adicionarAresta(5, 2, 4);
                g.adicionarAresta(5, 6, 2);
                
		g.adicionarAresta(6, 7, 1); 
                g.adicionarAresta(6, 8, 6); 
                g.adicionarAresta(6, 5, 2);
                
		g.adicionarAresta(7, 0, 8); 
                g.adicionarAresta(7, 8, 7);
                g.adicionarAresta(7, 1, 11);
                g.adicionarAresta(7, 6, 1);
                
		g.adicionarAresta(8, 2, 2);
                g.adicionarAresta(8, 7, 7);
                g.adicionarAresta(8, 6, 6);
		
		
		obj.encontrarMenorCaminhoDijkstra(g.getVertex(2));	

		
		for(Vertice v:g.getVertices()){
                    
			System.out.print("Peso - "+ v.distanciaMinima+"--Caminho minimo - ");
			for(Vertice a:v.caminho) {
				System.out.print(a+"->");
                              
			}
			System.out.println(""+v);
		}

	}
    
}
