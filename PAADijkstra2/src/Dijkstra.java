
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joice
 */
public class Dijkstra {

    public void encontrarMenorCaminhoDijkstra(Vertice v) {


        // 1. Pegue o nó não visitado com peso mínimo.
        // 2. Visite todos os seus vizinhos.
        // 3. Atualize as distâncias para todos os vizinhos (na fila prioritária).
        // Repita o processo até que todos os nós conectados sejam visitados.
        v.distanciaMinima = 0;
        PriorityQueue<Vertice> fila = new PriorityQueue<Vertice>();
        fila.add(v);

        while (!fila.isEmpty()) {

            Vertice u = fila.poll();

            for (Aresta vizinho : u.vizinhos) {
                Double newDist = u.distanciaMinima + vizinho.peso;

                if (vizinho.destino.distanciaMinima > newDist) {

// Remove o nó da fila para atualizar o valor da distância.
                    fila.remove(vizinho.destino);
                    vizinho.destino.distanciaMinima = newDist;

// Pegue o caminho visitado até agora e adicione o novo node.s
                    vizinho.destino.caminho = new LinkedList<Vertice>(u.caminho);
                    vizinho.destino.caminho.add(u);

// Reinsira o nó com nova distância.
                    fila.add(vizinho.destino);
                }
            }
        }
    }

}
