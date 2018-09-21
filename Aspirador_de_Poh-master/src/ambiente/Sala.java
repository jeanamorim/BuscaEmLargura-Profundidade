package ambiente;

public class Sala {
	/**
	 * Estrutura que forma o ambiente.
	 * Armazena informacoes sobre o estado de cada sala.
	 */
	
	// estado de cada sala (limpo, sujo, obstaculo).
	public estadoSala estado;
	
	public Sala(){
		// toda sala sempre inicia limpa.
		this.estado = estadoSala.limpo;
	}
	
	public Sala(estadoSala estado){
		this.estado = estado;
	}
	
	public String getDescricaoSala(){
		String sala = " ";
		
		switch(this.estado){
		case limpo:
			sala = "- ";
			break;
		case sujo:
			sala = "* ";
			break;
		case obstaculo:
			sala = "# ";
			break;
		default:
			break;
		}
		
		return sala;
	}
}
