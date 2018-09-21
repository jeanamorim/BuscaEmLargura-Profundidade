package sensores;

import ambiente.Sala;

/**
 * Interface para todos os sensores.
 * Retorna verdadeiro caso o sensor seja ativado ou falso caso contrario.
 */

public interface Sensor {
	
	boolean ativarSensor(Sala sala);
}
