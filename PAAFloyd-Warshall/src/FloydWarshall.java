
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joice
 */
public class FloydWarshall {

//metodo para determinar todos os caminhos
    public String algoritmoFloyd(long[][] mAdy) {
        int vertices = mAdy.length;
        long matrizAdjacencia[][] = mAdy;
        String caminhos[][] = new String[vertices][vertices];
        String caminhosAuxiliares[][] = new String[vertices][vertices];
        String caminhosRecorrido = "";

        String caminhoMin = "";
        int i, j, k;
        float temporal1, temporal2, temporal3, temporal4, minimo;

//inicializando a matriz de caminos e caminhos auxiliares
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminhos[i][j] = "";
                caminhosAuxiliares[i][j] = "";
            }
        }

        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temporal1 = matrizAdjacencia[i][j];
                    temporal2 = matrizAdjacencia[i][k];
                    temporal3 = matrizAdjacencia[k][j];
                    temporal4 = temporal2 + temporal3;

//encontrando o caminho minimmo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            caminhosRecorrido = "";
                            caminhosAuxiliares[i][j] = k + "";
                            caminhos[i][j] = caminhoR(i, k, caminhosAuxiliares, caminhosRecorrido) + (k + 1);

                        }
                    }
                    matrizAdjacencia[i][j] = (long) minimo;
                }
            }
        }

        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdjacencia[i][j] != 1000000000) {
                    if (i != j) {
                        if (caminhos[i][j].equals("")) {
                            caminhoMin += "De (" + (i + 1) + "-->" + (j + 1) + ")O caminho mais curto é--->(" + (i + 1) + ", " + (j + 1) + ")\n";
                        } else {
                            caminhoMin += "De (" + (i + 1) + "-->" + (j + 1) + ")O caminho mais curto é--->(" + (i + 1) + ", " + caminhos[i][j] + ", " + (j + 1) + ")\n";
                        }
                    }
                }
            }
        }
        return "Os diferentes caminhos entre os vertices são:\n" + caminhoMin;

    }

    public String caminhoR(int i, int k, String[][] caminhosAuxiliares, String caminhosRecorrido) {
        if (caminhosAuxiliares[i][k].equals("")) {
            return "";
        } else {
            caminhosRecorrido += caminhoR(i, Integer.parseInt(caminhosAuxiliares[i][k].toString()), caminhosAuxiliares, caminhosRecorrido) + (Integer.parseInt(caminhosAuxiliares[i][k].toString()) + 1) + ", ";
            return caminhosRecorrido;
        }
    }
}

//https://www.youtube.com/watch?v=SQ9mXgFNXl8
//apagar tudoque for cadena

