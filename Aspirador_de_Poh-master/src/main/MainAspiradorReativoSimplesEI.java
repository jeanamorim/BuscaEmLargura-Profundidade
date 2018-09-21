package main;

import ambiente.AmbienteAspiradorReativoSimplesEI;

public class MainAspiradorReativoSimplesEI {
	
	public static void main(String[] args) {
		
		AmbienteAspiradorReativoSimplesEI aspiradorEINoAmbiente = new AmbienteAspiradorReativoSimplesEI(4, 4);
		
		aspiradorEINoAmbiente.randomColocarSujeiras();
		aspiradorEINoAmbiente.randomColocarObstaculos();
		
		System.out.println("- Ambiente antes da limpeza:");
		aspiradorEINoAmbiente.exibirAmbiente();
		
		int i=0;
		while( aspiradorEINoAmbiente.existeSujeira() ) {
			aspiradorEINoAmbiente.executarAspirador();
			i++;
			System.out.println("- Ambiente apos a passo "+i+": ");
			aspiradorEINoAmbiente.exibirAmbiente();
		}
		
		//System.out.println("- Ambiente apos a limpeza: ");
		//aspiradorEINoAmbiente.exibirAmbiente();
		
		aspiradorEINoAmbiente.exibirInfo();
	}
}
