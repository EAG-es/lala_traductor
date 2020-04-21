/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.lala.traductor;

import innui.contextos.contextos;
import innui.contextos.textos;
import static innui.lala.traductor.reglas_gramaticales_extendidas.lala_traductor_primera_regla_opcional;
import static innui.lala.traductor.reglas_gramaticales_extendidas.lala_traductor_regla_en_curso;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import static innui.lala.traductor.reglas_gramaticales_extendidas.estado_bien;
import static innui.lala.traductor.reglas_gramaticales_extendidas.estado_con_errores;

/**
 *
 * @author emilio
 */
public class lala_resultados {
    public static String lala_resultados_salida_archivo = "lala_resultados_salida_archivo";
    public PrintStream printStream;
    
    public boolean abrir(File salida, textos error) {
        boolean ret = true;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(salida);
            ret = abrir(fileOutputStream, error);
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("abrir. " + error.dar());
            ret = false;
        }
        return ret;
    }

    public boolean abrir(FileOutputStream salida, textos error) {
        boolean ret = true;
        try {
            printStream = new PrintStream(salida, true, "UTF-8"); //NOI18N
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("abrir. " + error.dar());
            ret = false;
        }
        return ret;
    }
    
    public boolean cerrar(textos error) {
        boolean ret = true;
        try {
            printStream.close();
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("cerrar. " + error.dar());
            ret = false;
        }
        return ret;
    }

    public boolean escribir_temporal(String texto, textos temporal, textos error)
    {
        boolean ret = true;
        temporal.concat(texto);
        return ret;
    }

    public boolean hacer_temporal_definitivo(textos temporal, textos error)
    {
        boolean ret = true;
        printStream.print(temporal.leer_texto());
        eliminar_temporal(temporal, error);
        return ret;
    }

    public boolean eliminar_temporal(textos temporal, textos error)
    {
        boolean ret = true;
        temporal.poner("");
        return ret;
    }

    public boolean escribir(contextos contexto, String texto, textos error)
    {
        boolean ret = true;
        reglas_gramaticales_extendidas regla_en_curso = null;
        reglas_gramaticales_extendidas primera_regla_opcional = null;
        regla_en_curso = contexto.leer(lala_traductor_regla_en_curso).dar();
        primera_regla_opcional = contexto.leer(lala_traductor_primera_regla_opcional).dar();
        if (primera_regla_opcional == null) {
            if (regla_en_curso.estado.equals(estado_bien)
//                    || regla_en_curso.estado.equals(estado_con_errores)
                    ) {
                ret = hacer_temporal_definitivo(regla_en_curso.resultado_temporal_texto, error);
                if (ret) {
                    printStream.print(texto);
                }
            } else {
                ret = eliminar_temporal(regla_en_curso.resultado_temporal_texto, error);
            }
        } else {
            if (regla_en_curso.estado.equals(estado_bien)
//                    || regla_en_curso.estado.equals(estado_con_errores)
                    ) {
                ret = escribir_temporal(texto, regla_en_curso.resultado_temporal_texto, error);
            } else {
                ret = eliminar_temporal(regla_en_curso.resultado_temporal_texto, error);
            }
        }
        return ret;
    }

    public boolean hacer_temporal_definitivo(contextos contexto, textos error)
    {
        boolean ret = true;
        reglas_gramaticales_extendidas regla_en_curso = null;
        regla_en_curso = contexto.leer(lala_traductor_regla_en_curso).dar();
        ret = hacer_temporal_definitivo(regla_en_curso.resultado_temporal_texto, error);
        return ret;
    }

}
