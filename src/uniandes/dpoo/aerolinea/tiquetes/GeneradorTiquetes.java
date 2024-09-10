package uniandes.dpoo.aerolinea.tiquetes;

import java.util.HashSet;
import java.util.Set;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

/**
 * Esta clase representa al módulo del sistema que es capaz de generar nuevos tiquetes, asignándole a cada uno un código único.
 */
public class GeneradorTiquetes {

    private static Set<String> codigos = new HashSet<String>();

    // Método para generar un código único de 7 dígitos para el tiquete
    public static String generarCodigo() {
        int numero = (int) (Math.random() * 10e7);
        String codigo = "" + numero;
        while (codigos.contains(codigo)) {
            numero = (int) (Math.random() * 10e7);
            codigo = "" + numero;
        }

        while (codigo.length() < 7) {
            codigo = "0" + codigo;
        }

        return codigo;
    }

    public static Tiquete generarTiquete(Vuelo vuelo, Cliente cliente, int tarifa) {
        // Usamos el nuevo método generarCodigo para crear el código del tiquete
        String codigo = generarCodigo();
        return new Tiquete(codigo, vuelo, cliente, tarifa);
    }

    public static void registrarTiquete(Tiquete unTiquete) {
        codigos.add(unTiquete.getCodigo());
    }

    public static boolean validarTiquete(String codigoTiquete) {
        return codigos.contains(codigoTiquete);
    }
}
