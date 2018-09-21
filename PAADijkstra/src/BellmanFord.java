
import java.util.Scanner;

public class BellmanFord {

    private final int distancias[];
    private final int numeroDeVertices;
    public static final int MAX_VALUE = 999;
    boolean cicloNegativo = false;

    public BellmanFord(int numeroDeVertices) {
        this.numeroDeVertices = numeroDeVertices;
        distancias = new int[numeroDeVertices + 1];
    }
    
    public void BellmanFord(int origem, int matrizDeAdjacencia[][]) {
        //INICIAÇÃO
        for (int no = 1; no <= numeroDeVertices; no++) {
            distancias[no] = MAX_VALUE;
        }
        //RELAXAMENTO
        distancias[origem] = 0;
        for (int no = 1; no <= numeroDeVertices - 1; no++) {
            for (int noOrigem = 1; noOrigem <= numeroDeVertices; noOrigem++) {
                for (int noDestino = 1; noDestino <= numeroDeVertices; noDestino++) {
                    if (matrizDeAdjacencia[noOrigem][noDestino] != MAX_VALUE) {
                        if (distancias[noDestino] > distancias[noOrigem]
                                + matrizDeAdjacencia[noOrigem][noDestino]) {
                            distancias[noDestino] = distancias[noOrigem]
                                    + matrizDeAdjacencia[noOrigem][noDestino];
                        }
                    }
                }
            }
        }
        //VERIFICAÇÃO DE CICLOS NEGATIVOS
        for (int noOrigem = 1; noOrigem <= numeroDeVertices; noOrigem++) {
            for (int noDestino = 1; noDestino <= numeroDeVertices; noDestino++) {
                if (matrizDeAdjacencia[noOrigem][noDestino] != MAX_VALUE) {
                    if (distancias[noDestino] > distancias[noOrigem]
                            + matrizDeAdjacencia[noOrigem][noDestino]) {
                        System.out.println("O grafo contém ciclos negativos, impossivel calcular o caminho mínimo");
                        System.out.println("Finalizando Aplicação");
                        cicloNegativo = true;
                    }
                }
            }
        }

        if (!cicloNegativo) {
            for (int vertex = 1; vertex <= numeroDeVertices; vertex++) {
                System.out.println("Distancia da origem  " + origem + " para "
                        + vertex + " é " + distancias[vertex]);
            }
        }
    }

    public static void main(String... arg) {
        int numeroDeVertices = 0;
        int origem;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===============Algoritmo de Bellman-Ford===============");

        System.out.println("\nDigite o numero de vértices");
        numeroDeVertices = scanner.nextInt();

        int matrizDeAdjacencia[][] = new int[numeroDeVertices + 1][numeroDeVertices + 1];
        System.out.println("Entre com a matriz de adjacência");
        for (int noOrigem = 1; noOrigem <= numeroDeVertices; noOrigem++) {
            for (int noDestino = 1; noDestino <= numeroDeVertices; noDestino++) {
                matrizDeAdjacencia[noOrigem][noDestino] = scanner.nextInt();
                if (noOrigem == noDestino) {
                    matrizDeAdjacencia[noOrigem][noDestino] = 0;
                    //continue;
                }
                if (matrizDeAdjacencia[noOrigem][noDestino] == 0) {
                    matrizDeAdjacencia[noOrigem][noDestino] = MAX_VALUE;
                }
            }
        }

        System.out.println("Digite o vértice de partida");
        origem = scanner.nextInt();

        BellmanFord bf = new BellmanFord(numeroDeVertices);
        bf.BellmanFord(origem, matrizDeAdjacencia);
        scanner.close();
    }
}
