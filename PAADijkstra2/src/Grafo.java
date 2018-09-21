
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joice
 */
public class Grafo {

    private ArrayList<Vertice> vertices;

    public Grafo(int numeroVertices) {
        vertices = new ArrayList<Vertice>(numeroVertices);
        for (int i = 0; i < numeroVertices; i++) {
            vertices.add(new Vertice("v" + Integer.toString(i)));
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        Vertice s = vertices.get(origem);
        Aresta new_Aresta = new Aresta(vertices.get(destino), peso);
        s.vizinhos.add(new_Aresta);
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public Vertice getVertex(int vert) {
        return vertices.get(vert);
    }
}
