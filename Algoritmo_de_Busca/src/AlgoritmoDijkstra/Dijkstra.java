package AlgoritmoDijkstra;


import java.util.ArrayList;
import java.util.Collections;
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
public class Dijkstra {

    List<Vertice> menorCaminho = new ArrayList<Vertice>();
// menorCaminho Lista dos vertices pertencentes ao menor caminho
    Vertice caminho = new Vertice("caminho");
// caminho Recebe o vertices de menor caminho
    Vertice atual = new Vertice("atual");
// atual Guarda o vertice que esta sendo visitado
    Vertice vizinho = new Vertice("vizinho");
//  vizinho Marca o vizinho do vertice atualmente visitado
    List<Vertice> naoVisitados = new ArrayList<Vertice>();
// naoVisitados Lista dos vertices que ainda nao foram visitados    

    /*
     * Algoritmo de Dijkstra 
     */
    public List<Vertice> encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice origem, Vertice destino) {
        // Adiciona a origem na lista do menor caminho
        menorCaminho.add(origem);
        // Colocando a distancias iniciais
        for (int i = 0; i < grafo.getVertices().size(); i++) {

            if (grafo.getVertices().get(i).getDescricao().equals(origem.getDescricao())) {
                grafo.getVertices().get(i).setDistancia(0);// Vertice atual tem distancia zero
            } else {
                grafo.getVertices().get(i).setDistancia(9999); //todos os outros, 9999("infinita")
            }
            //Insere o vertice na lista de vertices nao visitados 
            this.naoVisitados.add(grafo.getVertices().get(i));
        }
        Collections.sort(naoVisitados);
        // O algoritmo continua ate que todos os vertices sejam visitados
        while (!this.naoVisitados.isEmpty()) {
            // Toma-se sempre o vertice com menor distancia, que eh o primeiro da lista
            atual = this.naoVisitados.get(0);

            //Para cada vizinho (cada aresta), calcula-se a sua possivel
            //distancia, somando a distancia do vertice atual com a da aresta
            //correspondente. Se essa distancia for menor que a distancia do
            //vizinho, esta eh atualizada.
            for (int i = 0; i < atual.getArestas().size(); i++) {
                vizinho = atual.getArestas().get(i).getDestino();
                if (!vizinho.verificarVisita()) {
                    int distancia = atual.getDistancia() + atual.getArestas().get(i).getPeso();

                    // Comparando a distancia do vizinho com a possivel distancia
                    if (vizinho.getDistancia() > distancia) {
                        vizinho.setDistancia(distancia);
                        vizinho.setPai(atual);
                        // Se o vizinho eh o vertice procurado, e foi feita uma mudanca na distancia, a lista com o menor caminho
                        // anterior eh apagada, pois existe um caminho menor vertices pais, ateh o vertice origem.
                        if (vizinho == destino) {
                            menorCaminho.clear();
                            caminho = vizinho;
                            menorCaminho.add(vizinho);
                            while (caminho.getPai() != null) {
                                menorCaminho.add(caminho.getPai());
                                caminho = caminho.getPai();
                            }
                            // Ordena a lista do menor caminho, para que ele seja exibido da origem ao destino.
                            Collections.sort(menorCaminho);
                        }
                    }
                }
            }
            // Marca o vertice atual como visitado e o retira da lista de nao visitados
            atual.visitar();
            this.naoVisitados.remove(atual);
            // Ordena a lista, para que o vertice com menor distancia fique na primeira posicao
            Collections.sort(naoVisitados);
        }
        return menorCaminho;
    }
}
