
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
public class Grafo {

    // Lista de vertices do Grafo

    private List<Vertice> vertices = new ArrayList<Vertice>();
    // Lista das arestas do Grafo
    private List<Aresta> arestas = new ArrayList<Aresta>();

    // Adiciona os vertices ao Grafo

    public void setVertice(Vertice novoVertice) {
        this.vertices.add(novoVertice);
    }

    // Retorna a lista de vertices

    public List<Vertice> getVertices() {
        return this.vertices;
    }

    //Metodo que retorna o vertice cuja descricao é igual ao procurada.

    public Vertice encontrarVertice(String nome) {
        for (int i = 0; i < this.getVertices().size(); i++) {
            if (nome.equalsIgnoreCase(this.getVertices().get(i).getDescricao())) {
                return this.getVertices().get(i);
            }
        }
        return null;
    }

    // Adiciona todas as Arestas dos Vertices ao Grafo

    public void setArestas() {
        for (int i = 0; i < this.getVertices().size(); i++) {
            for (int j = 0; j < this.getVertices().get(i).getArestas().size(); j++) {
                this.arestas.add(this.getVertices().get(i).getArestas().get(j));
            }
        }
    }

    // Retorna a aresta a apartir dos vertices de origem e destino

    public Aresta encontrarAresta(Vertice origem, Vertice destino) {
        for (int i = 0; i < this.arestas.size(); i++) {
            if ((arestas.get(i).getOrigem() == origem) && (arestas.get(i).getDestino() == destino)) {
                return arestas.get(i);
            }
        }
        return null;
    }

}
