/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_de_busca;

/**
 *
 * @author Joice
 */
public abstract class Busca {
//método abstrato 
	private int valorBusca;
	private String textoResposta;
	
	public abstract boolean buscarResultado(No no);
	public abstract int contarNosFolha();
	
	protected void obterResultadoPaternal(No no) {
		
		String retorno = "";
		No noValor = no;
		retorno += noValor.getValor();
		while (noValor.getNoPai() != null) {
			noValor = noValor.getNoPai();
			retorno = noValor.getValor() + " " + retorno;
		}
		this.textoResposta = retorno;
	}
	//exibe o Resultado
	public void exibirTextoResultado() {
		if (this.textoResposta != null) {
                    //imprime o resultado do caminho
			System.out.println("O caminho percorrido será: " + this.textoResposta);
		} else {
                    //caso nao for encontradoo melhorcaminho
			System.out.println("O valor " + this.valorBusca + " não foi encontrado.");
		}
	}
	
	public String getTextoResposta() {
		return textoResposta;
	}

	public void setTextoResposta(String textoResposta) {
		this.textoResposta = textoResposta;
	}
	
	public void setValorBusca(int valorBusca) {
		this.valorBusca = valorBusca;
	}
	
	public boolean isResultadoBusca(No no) {
		return no.getValor() == valorBusca;
	}
	
	public int getValorBusca() {
		return valorBusca;
	}
	
}
