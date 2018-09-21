package sensores;

import ambiente.Sala;
import ambiente.estadoSala;

/**
 * Sensor que verifica se a sala está suja.
 * Retorna verdadeiro caso esteja suja ou falso caso contrario.
 */

public class SensorSujeira implements Sensor {
	
	@Override
	public boolean ativarSensor(Sala sala){
		boolean flag = false;
		
		if(sala.estado == estadoSala.sujo){
			sala.estado = estadoSala.limpo;
			flag = true;
		}
		return flag;
	}
}
