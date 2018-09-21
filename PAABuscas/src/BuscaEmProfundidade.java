/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Stack;
/**
 *
 * @author JeanAmorim
 */
public class BuscaEmProfundidade extends Busca{

	private Stack<No> pilhaNos;
	
	private int valorBusca;
	
	public BuscaEmProfundidade(int valorBusca) {
		this.pilhaNos = new Stack<>();
		
		this.valorBusca = valorBusca;
	}
	
	
	public boolean isResultadoBusca(No no) {
		return no.getValor() == valorBusca;
	}

	@Override
	public boolean buscarResultado(No no) {
		if (isResultadoBusca(no)) {
			// Exibir o caminho
			obterResultadoPaternal(no);
			return true;
		} else {
			// Expandir os próximos nós (esquerda -> direita)
			if (no.getNoDireita() != null) {
				this.pilhaNos.push(no.getNoDireita());
			}
			if (no.getNoEsquerda() != null) { 
				this.pilhaNos.push(no.getNoEsquerda());
			}
			
		}
		No noPonta = this.pilhaNos.pop();
		if (noPonta != null && buscarResultado(noPonta)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int contarNosFolha() {
		if (this.pilhaNos != null) {
			return this.pilhaNos.size();
		}
		return 0;
	}
    
}
