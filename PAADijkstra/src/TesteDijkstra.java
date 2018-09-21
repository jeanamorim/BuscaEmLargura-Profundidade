
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
public class TesteDijkstra {
    /*
     * Criar o Grafo adicionanado todas as vertices do grafo
     */

    public static Grafo criarGrafo() {
        Grafo novoGrafo = new Grafo();

        Vertice e01 = new Vertice("01");
        novoGrafo.setVertice(e01);
        Vertice e02 = new Vertice("02");
        novoGrafo.setVertice(e02);
        Vertice e03 = new Vertice("03");
        novoGrafo.setVertice(e03);
        Vertice e04 = new Vertice("04");
        novoGrafo.setVertice(e04);
        Vertice e05 = new Vertice("05");
        novoGrafo.setVertice(e05);
        Vertice e06 = new Vertice("06");
        novoGrafo.setVertice(e06);
        Vertice e07 = new Vertice("07");
        novoGrafo.setVertice(e07);
        Vertice e08 = new Vertice("08");
        novoGrafo.setVertice(e08);
        Vertice e09 = new Vertice("09");
        novoGrafo.setVertice(e09);
        Vertice e10 = new Vertice("10");
        novoGrafo.setVertice(e10);
        Vertice e11 = new Vertice("11");
        novoGrafo.setVertice(e11);

        //Criar arestas e vizinhos de cada vertice 
        e01.setAresta(new Aresta(e01, e02, 1));
        e01.setAresta(new Aresta(e01, e04, 2));
        e01.setAresta(new Aresta(e01, e05, 6));

        e02.setAresta(new Aresta(e02, e01, 1));
        e02.setAresta(new Aresta(e02, e03, 2));
        e02.setAresta(new Aresta(e02, e05, 5));
        e02.setAresta(new Aresta(e02, e06, 3));
        e02.setAresta(new Aresta(e02, e07, 9));

        e03.setAresta(new Aresta(e03, e02, 2));
        e03.setAresta(new Aresta(e03, e07, 7));
        e03.setAresta(new Aresta(e03, e08, 9));
        

        e04.setAresta(new Aresta(e04, e01, 2));
        e04.setAresta(new Aresta(e04, e09, 1));
        e04.setAresta(new Aresta(e04, e05, 8));
        

        e05.setAresta(new Aresta(e05, e04, 8));
        e05.setAresta(new Aresta(e05, e01, 6));
        e05.setAresta(new Aresta(e05, e02, 5));
        e05.setAresta(new Aresta(e05, e06, 1));
        e05.setAresta(new Aresta(e05, e10, 2));
        e05.setAresta(new Aresta(e05, e09, 7));

        e06.setAresta(new Aresta(e06, e02, 3));
        e06.setAresta(new Aresta(e06, e07, 6));
        e06.setAresta(new Aresta(e06, e10, 4));
        e06.setAresta(new Aresta(e06, e05, 1));
       

        e07.setAresta(new Aresta(e07, e02, 9));
        e07.setAresta(new Aresta(e07, e03, 7));
        e07.setAresta(new Aresta(e07, e08, 2));
        e07.setAresta(new Aresta(e07, e11, 1));
        e07.setAresta(new Aresta(e07, e10, 3));
        e07.setAresta(new Aresta(e07, e06, 6));

        e08.setAresta(new Aresta(e08, e03, 9));
        e08.setAresta(new Aresta(e08, e07, 2));
        e08.setAresta(new Aresta(e08, e11, 4));
        

        e09.setAresta(new Aresta(e09, e04, 1));
        e09.setAresta(new Aresta(e09, e05, 7));
        e09.setAresta(new Aresta(e09, e10, 9));
        

        e10.setAresta(new Aresta(e10, e09, 9));
        e10.setAresta(new Aresta(e10, e05, 2));
        e10.setAresta(new Aresta(e10, e06, 4));
        e10.setAresta(new Aresta(e10, e07, 3));
        e10.setAresta(new Aresta(e10, e11, 1));

        e11.setAresta(new Aresta(e11, e10, 1));
        e11.setAresta(new Aresta(e11, e07, 1));
        e11.setAresta(new Aresta(e11, e08, 4));
        // Alimento o Grafo com todas as arestas dos vertices
        novoGrafo.setArestas();
        // Retorna o grafo 
        return novoGrafo;
    }

 
    public static void main(String args[]) {
        //
        Grafo novoGrafo = criarGrafo();
        List<Vertice> menorCaminho = new ArrayList<Vertice>();
        Dijkstra algoritmoDijkstra = new Dijkstra();
        // Add o nó de origem     
        Vertice origem = novoGrafo.encontrarVertice("04");
        // Add o nó de destino
        Vertice destino = novoGrafo.encontrarVertice("08");
        // Calcular o caminho minimo
        menorCaminho = algoritmoDijkstra.encontrarMenorCaminhoDijkstra(novoGrafo, origem, destino);
        // Mostrar o caminho minimo
        for (int i = 0; i < menorCaminho.size(); i++) {
            if (i == menorCaminho.size() - 1) {
                System.out.print(menorCaminho.get(i).getDescricao());
            } else {
                System.out.print(menorCaminho.get(i).getDescricao() + " -> ");
            }
        }
    }
}

