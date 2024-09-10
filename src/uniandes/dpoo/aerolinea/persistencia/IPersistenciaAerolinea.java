package uniandes.dpoo.aerolinea.persistencia;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public interface IPersistenciaAerolinea {
	
	void cargarAerolinea(String archivo, Aerolinea aerolinea) throws Exception;
	
    void salvarAerolinea(String archivo, Aerolinea aerolinea) throws Exception;


}
