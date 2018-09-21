/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JeanAmorim
 */
public class Testes {

    public static void main(String[] args) {

            //criando vertice com nos, tipo arvore binaria
        //direita/esqueda/direita/esquerda e assim por diante
        No no0 = new No(0);
        No no1 = new No(1);
        No no2 = new No(2);
        No no3 = new No(3);
        No no4 = new No(4);
        No no5 = new No(5);
        No no6 = new No(6);
        No no7 = new No(7);
        No no8 = new No(8);
        No no9 = new No(9);
        No no10 = new No(10);
        No no11 = new No(11);
        No no12 = new No(12);
        No no13 = new No(13);
        No no14 = new No(14);

        no0.setNoEsquerda(no1);
        no0.setNoDireita(no2);

        no1.setNoEsquerda(no3);
        no1.setNoDireita(no4);

        no2.setNoEsquerda(no5);
        no2.setNoDireita(no6);

        no3.setNoEsquerda(no7);
        no3.setNoDireita(no8);

        no4.setNoEsquerda(no9);
        no4.setNoDireita(no10);

        no5.setNoEsquerda(no11);
        no5.setNoDireita(no12);

        no6.setNoEsquerda(no13);
        no6.setNoDireita(no14);

        System.out.println("Busca em Profundidade");
        //define um vertice e ele irá percorrer do vertice 0 ate o informado abaixo
        BuscaEmProfundidade bp = new BuscaEmProfundidade(12);//digitei 12
        bp.buscarResultado(no12);//chama o meto buscaResultado passando 12
        bp.exibirTextoResultado();//exibe o resultadochamando o metodo 

        System.out.println("Busca em Largura");
        //define um vertice e ele irá percorrer do vertice 0 ate o informado abaixo
        BuscaEmLargura bl = new BuscaEmLargura(12);//digitei 12
        bl.buscarResultado(no12);//chama o meto buscaResultado passando 12
        bl.exibirTextoResultado();//exibe o resultadochamando o metodo 

    }

}
