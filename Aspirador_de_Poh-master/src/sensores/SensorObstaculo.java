package sensores;

import ambiente.Sala;
import ambiente.estadoSala;

/**
 * Sensor que verifica se existe obstaculo numa sala. 
 * Retorna verdadeiro caso exista obstaculo ou falso caso contrario.
 */

public class SensorObstaculo implements Sensor {

	@Override
	public boolean ativarSensor(Sala sala) {
		boolean flag = false;
		
		if(sala.estado == estadoSala.obstaculo){
			flag = true;
		}
		return flag;
	}

}
