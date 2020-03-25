/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.lala.traductor;

import innui.contextos.textos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;

/**
 *
 * @author emilio
 */
public class textos_gramaticales {
    public Reader reader;
    public String devueltos_texto = "";
    public String historico_lectura = "";
    public String repetir_lectura = "";
    public char devuelta_letra = ((char) -1);
    public int linea_num = 1;
    
    public boolean abrir(File entrada, textos error) {
        boolean ret = true;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(entrada);
            ret = abrir(fileInputStream, error);
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

    public boolean abrir(InputStream entrada, textos error) {
        boolean ret = true;
        InputStreamReader inputStreamReader; 
        try {
            linea_num = 1;
            inputStreamReader = new InputStreamReader(entrada, "UTF-8"); //NOI18N
            reader = new BufferedReader(inputStreamReader);
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
            reader.close();
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
    
    public boolean devolver_texto(String texto, textos error) {
        boolean ret = true;
        int pos = 0;
        if (devueltos_texto.isEmpty()) {
            devueltos_texto = texto + repetir_lectura;
        } else {
            if (texto.endsWith(" ")) {
                devueltos_texto = texto + repetir_lectura + devueltos_texto;
            } else {
                devueltos_texto = texto + " " + repetir_lectura + devueltos_texto;
            }
        }
        repetir_lectura = "";
        pos = 0;
        while (true) {
            pos = texto.indexOf("\n", pos);
            if (pos < 0) {
                break;
            }
            linea_num = linea_num - 1;
            pos = pos + 1;
        }
        return ret;
    }
    
    public char leer(textos error) {
        char letra;
        try {
            if (devueltos_texto.isEmpty() == false) {
                letra = devueltos_texto.charAt(0);
                devueltos_texto = devueltos_texto.substring(1);
            } else if (repetir_lectura.isEmpty() == false) {
                letra = repetir_lectura.charAt(0);
                repetir_lectura = repetir_lectura.substring(1);
            } else {
                letra = (char) reader.read();
            }
            if (letra == '\n') {
                linea_num = linea_num + 1;
            }
            historico_lectura = historico_lectura + letra;
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("(" + linea_num + ") " + "leer. " + error.dar());
            letra = ((char) -1);
        }
        return letra;
    }
    
    public boolean validar_lectura(boolean es_valida) {
        int pos;
        if (es_valida == false) {
            pos = 0;
            while (true) {
                pos = historico_lectura.indexOf("\n", pos);
                if (pos < 0) {
                    break;
                }
                linea_num = linea_num - 1;
                pos = pos + 1;
            }
            if (devueltos_texto.isEmpty()) {
                repetir_lectura = historico_lectura + repetir_lectura;
            } else {
                devueltos_texto = historico_lectura + devueltos_texto;
            }
        }
        if (devuelta_letra != ((char) -1)) {
            repetir_lectura = repetir_lectura + devuelta_letra;
            if (devuelta_letra == '\n') {
                linea_num = linea_num - 1;
            }
            devuelta_letra = ((char) -1);
        }
        historico_lectura = "";
        return es_valida;
    }
    
    public boolean leer_texto_entre_espacios(textos texto_entre_espacios, textos error) {
        boolean ret = true;
        String texto = "";
        char letra;
        boolean es_letra = false;
        try {
            while (true) {
                letra = leer(error);
                if (letra == ((char) -1)) {
                    error.poner("(" + linea_num + ") " + "Fin de archivo inesperado. ");
                    ret = false;
                    break;
                }
                if (Character.isWhitespace(letra)) {
                    if (es_letra) {
                        devuelta_letra = letra;
                        break;
                    } else {
                        if (letra == '\n') {
                            error.poner("(" + linea_num + ") " + "Se ha encontrado: " + letra + " en lugar un comienzo de texto válido. ");
                            ret = false;
                            break;
                        }
                    }
                } else {
                    es_letra = true;
                }
                texto = texto + letra;
            }
            if (ret) {
                texto_entre_espacios.poner(texto);
            } else {
                texto_entre_espacios.poner("");
            }
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("(" + linea_num + ") " + "leer_token_entre_espacios. " + error.dar());
            ret = false;
        }
        return validar_lectura(ret);
    }
    
    public boolean leer_nueva_linea(textos error) {
        boolean ret = true;
        char letra;
        try {
            while (true) {
                letra = leer(error);
                if (letra == ((char) -1)) {
                    error.poner("(" + linea_num + ") " + "Fin de archivo inesperado. ");
                    ret = false;
                    break;
                }
                if (letra == '\n') {
                    break;
                } else if (Character.isWhitespace(letra) == false) {
                    devuelta_letra = letra;
                    error.poner("(" + linea_num + ") " + "Se ha encontrado: " + letra + " en lugar de nueva-linea. ");
                    ret = false;
                    break;
                }
            }
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("(" + linea_num + ") " + "leer_nueva_linea. " + error.dar());
            ret = false;
        }
        return validar_lectura(ret);
    }

    public boolean leer_espacios(int num, textos texto, textos error) {
        boolean ret = true;
        char letra;
        String leido = "";
        int i = 0;
        try {
            while (true) {
                if (i >= num) {
                    break;
                }
                letra = leer(error);
                if (letra == ((char) -1)) {
                    error.poner("(" + linea_num + ") " + "Fin de archivo inesperado. ");
                    ret = false;
                    break;
                }
                if (letra != ' ') {
                    error.poner("(" + linea_num + ") " + "Se ha encontrado: " + letra + " en lugar de " + num + " espacios. ");
                    ret = false;
                    break;
                } else {
                    leido = leido + letra;
                }
                i = i + 1;
            }
            if (ret) {
                texto.poner(leido);
            } else {
                texto.poner("");
            }
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("(" + linea_num + ") " + "leer_espacios. " + error.dar());
            ret = false;
        }
        return validar_lectura(ret);
    }

    public boolean leer_blancos_hasta_fin_archivo(textos error) {
        boolean ret = true;
        char letra;
        try {
            while (true) {
                letra = leer(error);
                if (letra == ((char) -1)) {
                    break;
                }
                if (Character.isWhitespace(letra) == false) {
                    error.poner("(" + linea_num + ") " + "Se ha encontrado: " + letra + " en lugar de espacio blanco. ");
                    ret = false;
                    break;
                }
            }
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("(" + linea_num + ") " + "leer_blancos_hasta_fin_archivo. " + error.dar());
            ret = false;
        }
        return validar_lectura(ret);
    }

    public boolean leer_texto_con_limite(String limite, textos texto_libre, textos error) {
        boolean ret = true;
        String texto = "";
        char letra;
        int tam;
        char [] buffer_array;
        int i = 0;
        int j = 0;
        try {
            tam = limite.length();
            buffer_array = new char[tam];
            while (true) {
                if (i >= tam) {
                    break;
                }
                letra = leer(error);
                if (letra == ((char) -1)) {
                    error.poner("(" + linea_num + ") " + "Fin de archivo inesperado. ");
                    ret = false;
                    break;
                }
                buffer_array[i] = letra;
                i = i + 1;
            }
            while (true) {
                if (limite.equals(new String(buffer_array))) {
                    break;
                }
                texto = texto + buffer_array[0];
                j = 0;
                while (true) {
                    if (j >= tam-1) {
                        break;
                    }
                    buffer_array[j] = buffer_array[j+1];
                    j = j + 1;
                }
                letra = leer(error);
                if (letra == ((char) -1)) {
                    ret = false;
                    error.poner("(" + linea_num + ") " + "Fin de archivo alcanzado. " + error.dar());
                    break;
                }
                buffer_array[tam-1] = letra;
            }
            if (ret) {
                texto_libre.poner(texto + new String(buffer_array));
//                repetir_lectura = repetir_lectura + new String(buffer_array);
            } else {
                texto_libre.poner("");
            }
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("(" + linea_num + ") " + "leer_texto_libre. " + error.dar());
            ret = false;
        }
        return validar_lectura(ret);
    }

    public boolean leer_linea(textos texto_libre, textos error) {
        boolean ret = true;
        String texto = "";
        char letra;
        try {
            while (true) {
                letra = leer(error);
                if (letra == ((char) -1)) {
                    error.poner("(" + linea_num + ") " + "Fin de archivo inesperado. ");
                    ret = false;
                    break;
                }
                if (letra == '\n') {
                    devuelta_letra = letra;
                    break;
                }
                texto = texto + letra;
            }
            if (ret) {
                texto_libre.poner(texto);
            } else {
                texto_libre.poner("");
            }
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("(" + linea_num + ") " + "leer_texto_libre. " + error.dar());
            ret = false;
        }
        return validar_lectura(ret);
    }

    public boolean leer_nombre_m(boolean es_primera_lectura, textos nombre, textos error) {
        boolean ret = true;
        String texto = "";
        String texto_prueba = "";
        char letra;
        try {
            while (true) {
                letra = leer(error);
                if (letra == ((char) -1)) {
                    error.poner("(" + linea_num + ") " + "Fin de archivo inesperado. ");
                    ret = false;
                    break;
                }
                if (Character.isWhitespace(letra)) {
                    if (texto.isEmpty() == false) {
                        devuelta_letra = letra;
                        break;
                    } else {
                        if (letra == '\n') {
                            error.poner("(" + linea_num + ") " + "Se ha encontrado: " + letra + " en lugar del comienzo de nombre válido. ");
                            ret = false;
                            break;
                        }
                    }
                } else {
                    texto_prueba = "" + letra;
                    if (es_primera_lectura) {
                        es_primera_lectura = false;
                        if (texto_prueba.matches("[a-zñçáéíóú]")) {
                            texto = texto + texto_prueba;
                        } else {
                            error.poner("(" + linea_num + ") " + "Se ha encontrado: " + letra + " en lugar del comienzo de nombre válido. ");
                            ret = false;
                            break;
                        }
                    } else {
                        if (texto_prueba.matches("[a-zñçáéíóú0-9]")) {
                            texto = texto + texto_prueba;
                        } else {
                            error.poner("(" + linea_num + ") " + "Se ha encontrado: " + letra + " en lugar de una letra válida. ");
                            ret = false;
                            break;
                        }
                    }
                }
            }
            if (ret) {
                nombre.poner(texto);
            } else {
                nombre.poner("");
            }
        } catch( Exception e) {
            error.poner(e.getMessage());
            if (error.es_nulo()) {
                error.poner(""); //NOI18N
            }
            error.poner("(" + linea_num + ") " + "leer_nombre. " + error.dar());
            ret = false;
        }
        return validar_lectura(ret);
    }

    public boolean leer_nombres_m_singular(textos texto_singular, textos error) {
        boolean ret = true;
        textos texto = new textos();
        String nombre = "";
        boolean es_primera_vez = true;
        while (true) {
            ret = leer_nombre_m(es_primera_vez, texto, error);
            if (ret == false) {
                break;
            }
            es_primera_vez = false;
            if (nombre.isEmpty()) {
                nombre = texto.leer_texto();
            } else {
                nombre = nombre + " " + texto.leer_texto();
            }
        }
        if (nombre.isEmpty()) {
            ret = false;
        } else {
            ret = true;
        }
        if (ret) {
            ret = validar_nombre_singular(nombre, error);
            texto_singular.poner(nombre);
        } else {
            texto_singular.poner("");
        }
        return ret;
    }

    public static boolean validar_nombre_singular(String texto_singular, textos error) {
        boolean ret = true;
        if (texto_singular == null || texto_singular.trim().isEmpty()) {
            ret = false;
            error.poner("texto no indicado. ");
        } else {
            texto_singular = texto_singular.trim();
            if (texto_singular.endsWith("s")) {
                ret = false;
                error.poner( texto_singular + ": deben estar en singular. ");
            }
        }
        return ret;
    }                    

    public boolean leer_verbo(textos verbo, textos error) {
        boolean ret = true;
        ret = leer_nombre_m(true, verbo, error);
        if (ret) {
            ret = validar_verbo(verbo.leer_texto(), error);
        }
        return ret;
    }

    public static boolean validar_verbo(String verbo, textos error) {
        boolean ret = true;
        Locale locale;
        if (verbo == null || verbo.trim().isEmpty()) {
            ret = false;
            error.poner("Verbo no indicado. ");
        } else {
            verbo = verbo.trim();
            locale = Locale.getDefault();
            if (locale.getLanguage().equals("es")) {
                if (verbo.endsWith("ar") == false
                 && verbo.endsWith("er") == false
                 && verbo.endsWith("ir") == false) {
                    ret = false;
                    error.poner("El verbo no está en infinitivo: " + verbo);
                }
            }
        }
        return ret;
    }  
    
    public boolean leer_numero(textos numero_texto, textos error)
    {
        boolean ret = true;
        ret = leer_texto_entre_espacios(numero_texto, error);
        if (ret) {
            if (numero_texto.leer_texto().trim().matches("-?[0-9]+([\\.,]?[0-9]+)?([eE]-?[0-9]+)?") == false) {
                error.poner("(" + linea_num + ") " + "Se esperaba un número con el formato (-?[0-9]+([.,]?[0-9]+)?([eE]-?[0-9]+)?), pero se ha encontrado: " + numero_texto);
                ret = false;
            }
        }
        return ret;
    }

//    public boolean descartar_hasta_texto(String limite, textos error)
//    {
//        boolean ret = true;
//        textos texto = new textos();
//        devueltos_texto = "";
//        ret = leer_texto_con_limite(limite, texto, error);
//        if (ret) {
//            ret = leer_texto_entre_espacios(texto, error);
//        }
//        return ret;
//    }
    
    public boolean leer_esperado(String esperado_texto, textos leido_texto, textos error)
    {
        boolean ret = true;
        ret = leer_texto_entre_espacios(leido_texto, (textos) error);
        if (ret) {
            if (leido_texto.leer_texto().trim().equals(esperado_texto) == false) {
                ret = false;
                error.poner("(" + linea_num + ") " + "Se esperaba: " + esperado_texto + " y se ha encontrado: " + leido_texto.leer_texto());
            }
        }
        return ret;
    }

    public boolean leer_texto_no_lala(textos texto_libre, textos error) {
        boolean ret = true;
        int pos;
        String resto;
        ret = leer_texto_con_limite("/no_lala", texto_libre, error);
        if (ret) {
            pos = texto_libre.lastIndexOf("\n");
            if (pos > 0) {
                resto = texto_libre.leer_texto().substring(pos);
                texto_libre.substring(0, pos);
                if (resto.trim().isEmpty() == false) {
                    ret = false;
                    error.poner("(" + linea_num + ") " + "El texto no_lala debe terminar en nueva-linea. ");                    
                }
                ret = devolver_texto(resto, error);
            }
        }
        return ret;
    }

}
