/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.lala.traductor;

import innui.contextos.acciones;
import innui.contextos.contextos;
import innui.contextos.enteros;
import innui.contextos.i_eles;
import innui.contextos.textos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author emilio
 */
public class reglas_gramaticales_extendidas {
    public static String accion_tras_regla_0 = "atr0";
    public static String accion_tras_fin_opcion = "atrfo";
    public static String estado_final_opcion_fallida = "opcion fallida";
    public static String estado_final_error = "error";
    public static String estado_final_bien = "bien";
    public static String lala_traductor_regla_en_curso = "lala_traductor_regla_en_curso";
    public static String lala_traductor_primera_regla_opcional = "lala_traductor_primera_regla_opcional";
    public static String lala_traductor_traza =  "lala_traductor_traza";
    public static String lala_traductor_traza_anidamiento_opcional_num =  "lala_traductor_traza_anidamiento_opcional_num";
    public reglas_gramaticales regla_gramatical = null;
    public int opcional_hasta_num = 0;
    public boolean hay_opcion_vacia = false;
    public String estado = "";
    public List<String> mensajes_error_lista = new ArrayList();
    public textos resultado_temporal_texto = new textos();
    public textos lectura_temporal_texto = new textos();
    public textos devolucion_opcion_fallida_texto = new textos();
    
    public boolean configurar(reglas_gramaticales regla_gramatical, int opcional_hasta_num, boolean hay_opcion_vacia, textos error) {
        this.regla_gramatical = regla_gramatical;
        this.opcional_hasta_num = opcional_hasta_num;
        this.hay_opcion_vacia = hay_opcion_vacia;
        return true;
    }

    public static boolean escribir_traza(contextos contexto, String texto, textos error) {
        boolean ret = true;
        i_eles traza_texto;
        if (texto.isEmpty() == false) {
            traza_texto = contexto.leer(lala_traductor_traza);
            if (traza_texto.no_es()) {
                traza_texto = new textos ();
                contexto.fondear_con_datos(lala_traductor_traza, traza_texto);
            }
            concatenar_texto (texto, (textos) traza_texto, error);
            contexto.modificar(lala_traductor_traza, traza_texto);
        }
        return ret;
    }

    public static boolean escribir_traza_opcional_inicio(contextos contexto, String texto, textos error) {
        boolean ret = true;
        i_eles anidamiento_opcional_num;
        if (texto.isEmpty() == false) {
            anidamiento_opcional_num = contexto.leer(lala_traductor_traza_anidamiento_opcional_num);
            if (anidamiento_opcional_num.no_es()) {
                anidamiento_opcional_num = new enteros (0);
                contexto.fondear_con_datos(lala_traductor_traza_anidamiento_opcional_num, anidamiento_opcional_num);
            }
            ret = escribir_traza(contexto, "\n[" + anidamiento_opcional_num.dar() + "]" + texto, error);
            anidamiento_opcional_num.poner((Long)anidamiento_opcional_num.dar() + 1);
            contexto.modificar(lala_traductor_traza_anidamiento_opcional_num, anidamiento_opcional_num);
        }
        return ret;
    }
    
    public static boolean escribir_traza_opcional_fin(contextos contexto, textos error) {
        boolean ret = true;
        i_eles anidamiento_opcional_num;
        anidamiento_opcional_num = contexto.leer(lala_traductor_traza_anidamiento_opcional_num);
        if (anidamiento_opcional_num.no_es()) {
            anidamiento_opcional_num = new enteros (0);
            contexto.fondear_con_datos(lala_traductor_traza_anidamiento_opcional_num, anidamiento_opcional_num);
        }
        anidamiento_opcional_num.poner((Long)anidamiento_opcional_num.dar() - 1);
        ret = escribir_traza(contexto, "[/" + anidamiento_opcional_num.dar() + "]", error);
        contexto.modificar(lala_traductor_traza_anidamiento_opcional_num, anidamiento_opcional_num);
        return ret;
    }
    
    public static String leer_traza(contextos contexto, textos error) {
        return contexto.leer(lala_traductor_traza).dar();
    }
    
    public reglas_gramaticales_extendidas crear_configurada(reglas_gramaticales_extendidas regla_gramatical_extendida, textos error) {
        reglas_gramaticales_extendidas regla_gramatical_extendida_nueva = new reglas_gramaticales_extendidas();
        if (regla_gramatical_extendida_nueva.configurar(regla_gramatical_extendida.regla_gramatical
                , regla_gramatical_extendida.opcional_hasta_num
                , regla_gramatical_extendida.hay_opcion_vacia
                , error)) {
            return regla_gramatical_extendida_nueva;
        } else {
            return null;
        }
    }
    
    public static boolean concatenar_texto(String concatenable, textos texto, textos error) {
        boolean ret = true;
        int tam = 0;
        char letra;
        if (concatenable.isEmpty() == false) {
            if (texto.isEmpty() == false) {
                tam = texto.length();
                letra = texto.charAt(tam-1);
                if (letra == ' ') {
                    letra = concatenable.charAt(0);
                    if (letra == ' ') {
                        texto.concat(concatenable.substring(1));
                    } else {
                        texto.concat(concatenable);
                    }
                } else {
                    letra = concatenable.charAt(0);
                    if (letra == ' ') {
                        texto.concat(concatenable);
                    } else {
                        texto.concat(" " + concatenable);
                    }
                }
            } else {
                texto.concat(concatenable);
            }
        }
        return ret;
    }


    public String procesar_regla(contextos contexto, textos error) {
        boolean ret = true;
        reglas_gramaticales_extendidas local_regla_gramatical;
        i_eles retorno;
        textos texto = new textos();
        textos mensaje_error = new textos();
        acciones accion_tras_regla;
        Iterator <String> iterator;
        String nombre = "";
        int avance_la = 0;
        int pos = 0;
        int tam;
        if (this.opcional_hasta_num > 0) {
            escribir_traza_opcional_inicio(contexto, "(" + this.regla_gramatical.id + ") ", error);
        } else {
            escribir_traza(contexto, "(" + this.regla_gramatical.id + ")", error);
        }
        estado = estado_final_bien;
        contexto.superponer(lala_traductor_regla_en_curso, this);
        if (this.opcional_hasta_num > 0) {
            local_regla_gramatical = contexto.leer(lala_traductor_primera_regla_opcional).dar();
            if (local_regla_gramatical == null) {
                contexto.superponer(lala_traductor_primera_regla_opcional, this);
            }
        }
        if (this.regla_gramatical.id.equals("(")) {
            nombre = "poner breakpoint.";
        }
        if (this.regla_gramatical.leer_texto != null) {
            retorno = this.regla_gramatical.leer_texto.dar(contexto, texto, error);
            if (retorno.no_es()) {
                mensajes_error_lista.add(error.leer_texto());
                estado = estado_final_error;
                ret = false;
            } else {
                ret = concatenar_texto(texto.leer_texto(), lectura_temporal_texto, error);                
            }
            if (concatenar_texto(texto.leer_texto(), devolucion_opcion_fallida_texto, error) == false) {
                ret = false;
            }
            escribir_traza(contexto, texto.leer_texto(), error);
            if (retorno.no_es()) {
                escribir_traza(contexto, " ((" + this.regla_gramatical.id + ")(ERROR)) ", error);
            }
        }
        if (ret) {
            accion_tras_regla = this.regla_gramatical.acciones_tras_regla_mapa.get(accion_tras_regla_0);
            if (accion_tras_regla != null) {
                contexto.superponer(lala_traductor_regla_en_curso, this);
                retorno = accion_tras_regla.dar(contexto, error);
                if (retorno.no_es()) {
                    ret = false;
                }
            }
        }
        if (ret) {
            pos = 0;
            tam = this.regla_gramatical.reglas_gramaticales_mapa.size();
            iterator = this.regla_gramatical.reglas_gramaticales_mapa.keySet().iterator();
            if (iterator.hasNext()) {
                nombre = iterator.next();
            }
            while (true) {
                if (pos >= tam) {
                    break;
                }
                local_regla_gramatical = this.regla_gramatical.reglas_gramaticales_mapa.get(nombre);
                local_regla_gramatical = crear_configurada(local_regla_gramatical, error);
                if (local_regla_gramatical == null) {
                    mensajes_error_lista.add(error.leer_texto());
                    ret = false;
                    break;
                }
                estado = local_regla_gramatical.procesar_regla(contexto, error);
                if (estado.equals(estado_final_bien)) {
                    ret = concatenar_texto(local_regla_gramatical.resultado_temporal_texto.leer_texto(), resultado_temporal_texto, error);
                    if (ret) {
                        ret = concatenar_texto(local_regla_gramatical.lectura_temporal_texto.leer_texto(), lectura_temporal_texto, error);
                    }
                    if (ret) {
                        accion_tras_regla = this.regla_gramatical.acciones_tras_regla_mapa.get(nombre);
                        if (accion_tras_regla != null) {
                            contexto.superponer(lala_traductor_regla_en_curso, this);
                            retorno = accion_tras_regla.dar(contexto, error);
                            if (retorno.no_es()) {
                                ret = false;
                            }
                        }
                    }
                    if (ret == false) {
                        break;
                    }
                }
                if (local_regla_gramatical.opcional_hasta_num > 0) {
                    // Es una regla opcional
                    if (estado.equals(estado_final_bien)) {
                        avance_la = avance_la + 1;
                        ret = concatenar_texto(local_regla_gramatical.devolucion_opcion_fallida_texto.leer_texto(), devolucion_opcion_fallida_texto, error);
                        if (ret == false) {
                            break;
                        }
                        // Saltar el resto de las opciones
                        while (true) {
                            pos = pos + 1;
                            if (iterator.hasNext() == false) {
                                break;
                            }
                            nombre = iterator.next();
                            local_regla_gramatical = this.regla_gramatical.reglas_gramaticales_mapa.get(nombre);
                            if (local_regla_gramatical.opcional_hasta_num == 0) {
                                break;
                            }
                        }
                    } else if (estado.equals(estado_final_opcion_fallida)) {
                        if (local_regla_gramatical.hay_opcion_vacia == false) {
                            pos = pos + 1;
                            if (iterator.hasNext() == false) {
                                break;
                            }
                            nombre = iterator.next();
                            local_regla_gramatical = this.regla_gramatical.reglas_gramaticales_mapa.get(nombre);
                            if (local_regla_gramatical.opcional_hasta_num == 0) {
                                // Ninguna rama ha sido satisfactoria
                                mensajes_error_lista.add("Elemento no reconocido. Ninguna regla opcional ha sido satisfactoria. Ultimo error: " + error.leer_texto());
                                ret = false;
                                break;
                            }
                        } else {
                            estado = estado_final_bien;
                            pos = pos + 1;
                            if (iterator.hasNext() == false) {
                                break;
                            }
                            nombre = iterator.next();
                        }
                    } else if (estado.equals(estado_final_error)) {
                        mensajes_error_lista.addAll(local_regla_gramatical.mensajes_error_lista);
                        ret = concatenar_texto(local_regla_gramatical.devolucion_opcion_fallida_texto.leer_texto(), devolucion_opcion_fallida_texto, error);
                        ret = false;
                        break;
                    }
                } else {
                    ret = concatenar_texto(local_regla_gramatical.devolucion_opcion_fallida_texto.leer_texto(), devolucion_opcion_fallida_texto, error);
                    if (ret == false) {
                        break;
                    }
                    if (estado.equals(estado_final_bien) == false) {
                        mensajes_error_lista.addAll(local_regla_gramatical.mensajes_error_lista);
                        ret = false;
                        break;
                    } else {
                        avance_la = avance_la + 1;
                        pos = pos + 1;
                        if (iterator.hasNext() == false) {
                            break;
                        }
                        nombre = iterator.next();
                    }
                }
            }
        }
        if (ret == false) {
            if (opcional_hasta_num > 0 && avance_la < opcional_hasta_num) {
                // Es una rama opcional fallida.
                estado = estado_final_opcion_fallida;
                if (this.regla_gramatical.devolver_texto != null) {
                    retorno = this.regla_gramatical.devolver_texto.dar(contexto, devolucion_opcion_fallida_texto, error);
                    if (retorno.no_es()) {
                        mensajes_error_lista.add(error.leer_texto());
                        ret = false;
                    }
                    devolucion_opcion_fallida_texto.poner("");
                }                
            } else {
                // Es un error gramatical
                estado = estado_final_error;
                if (this.regla_gramatical.crear_mensaje_error != null) {
                    retorno = this.regla_gramatical.crear_mensaje_error.dar(contexto, mensaje_error, error);
                    if (retorno.es()) {
                        mensajes_error_lista.add(mensaje_error.leer_texto());
                    } else {
                        mensajes_error_lista.add(error.leer_texto());
                        ret = false;
                    }
                }
            }                
        }
        if (this.opcional_hasta_num > 0) {
            local_regla_gramatical = contexto.leer(lala_traductor_primera_regla_opcional).dar();
            if (local_regla_gramatical == this) {
                contexto.superponer(lala_traductor_primera_regla_opcional, null);
                accion_tras_regla = this.regla_gramatical.acciones_tras_regla_mapa.get(accion_tras_fin_opcion);
                if (accion_tras_regla != null) {
                    contexto.superponer(lala_traductor_regla_en_curso, this);
                    retorno = accion_tras_regla.dar(contexto, error);
                    if (retorno.no_es()) {
                        ret = false;
                    }
                }
            }
        }
        if (this.opcional_hasta_num > 0) {
            escribir_traza_opcional_fin(contexto, error);
        }
        return estado;
    }

}
