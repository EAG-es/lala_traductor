/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.lala.traductor;

import innui.contextos.contextos;
import innui.contextos.textos;
import static innui.lala.traductor.reglas_gramaticales_extendidas.estado_final_bien;
import java.io.File;
import static java.lang.System.out;

/**
 *
 * @author emilio
 */
public class lala_traductores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean ret = true;
        File entrada = null;
        File salida = null;
        File ruta_padre = null;
        String nombre = "";
        int pos;
        String ruta = "";
        String resto_ruta;
        contextos contexto = null;
        boolean es_abierta_lectura = false;
        boolean es_abierta_escritura = false;
        String ruta_con_lala;
        textos error = new textos();
        String resultado;
        lala_reglas_gramaticales lala_regla_gramatical = null;
        lalas_a_javas lala_a_java = null;
        if (args.length != 2) {
            ret = false;
            error.poner("Faltan los datos: <ruta archivo lala> <ruta del proyecto>");
        } else {
            lala_regla_gramatical = new lala_reglas_gramaticales();
            lala_a_java = new lalas_a_javas();
            entrada = new File(args[0]);
            if (entrada.exists()) {
                nombre = entrada.getName();
                if (nombre.endsWith(".la") == false) {
                    ret = false;
                    error.poner("El archivo no tiene la extensión .la ");
                }
            } else {
                ret = false;
                error.poner("El archivo de entrada no existe: " + args[0]);
            }
            if (ret) {
                ruta = entrada.getParent();
                pos = ruta.indexOf(args[1]);
                if (pos != 0) {
                    ret = false;
                    error.poner("La ruta del proyecto no está en el archivo de entrada. ");
                } else {
                    ruta_con_lala = args[1] + "/lala/";
                    ruta_con_lala = ruta_con_lala.replace("//", "/");
                    pos = pos + ruta_con_lala.length();
                    resto_ruta = ruta.substring(pos);
                    ruta = ruta.substring(0, args[1].length());
                    ruta = ruta + "/resultados/java/" + resto_ruta;
                    ruta = ruta.replace("//", "/");
                    nombre = nombre.substring(0,nombre.length() - 3);
                    ruta = ruta + "/" + nombre + ".java";
                    ruta = ruta.replace("//", "/");
                    salida = new File(ruta);
                    ruta_padre = salida.getParentFile();
                    if (ruta_padre.exists() == false) {
                        ret = false;
                        error.poner("No existe la carpeta de salida: " + ruta_padre);
                    }
                }
            }
            if (ret) {
                contexto = new contextos();
                ret = lala_regla_gramatical.configurar(contexto, error);
            }
            if (ret) {
                ret = lala_regla_gramatical.abrir(contexto, entrada, error);
            }
            if (ret) {
                es_abierta_lectura = true;
                ret = lala_a_java.configurar(contexto, lala_regla_gramatical, error);
            }
            if (ret) {
                ret = lala_a_java.abrir(contexto, salida, error);
            }
            if (ret) {
                es_abierta_escritura = true;
                resultado = lala_regla_gramatical.inicio_lala.procesar_regla_gramatical_extendida(contexto, error);
                if (resultado.equals(estado_final_bien)) {
                    error.poner("Archivo generado: " + ruta);
                } else {
                    error.poner("");
                    for (String mensaje: lala_regla_gramatical.inicio_lala.regla_gramatical_extendida.mensajes_error_lista) {
                        error = error.concat(mensaje + "\n");
                    }
                }
            }
            if (es_abierta_lectura) {
                ret = lala_regla_gramatical.cerrar(contexto, error);
            }
            if (es_abierta_escritura) {
                ret = lala_a_java.cerrar(contexto, error);
            }
        }
        out.println(error);
        out.println(reglas_gramaticales_extendidas.leer_traza(contexto, error));
    }
    
}
