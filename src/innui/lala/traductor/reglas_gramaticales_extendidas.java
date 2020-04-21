/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.lala.traductor;

import innui.contextos.acciones;
import innui.contextos.bools;
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
    public static String id_mapa_tras_regla_0 = "imtr0";
    public static String id_mapa_tras_regla_final = "imtrf";
    public static String id_mapa_tras_fin_opcion = "imtfo";
    public static String estado_opcion_fallida = "opcion fallida";
    public static String estado_error = "error";
    public static String estado_error_fatal = "error fatal";
    public static String estado_error_continuable = "error continuable";
    public static String estado_bien = "bien";
    public static String estado_con_errores = "con errores";
    public static String lala_traductor_regla_en_curso = "lala_traductor_regla_en_curso";
    public static String lala_traductor_primera_regla_opcional = "lala_traductor_primera_regla_opcional";
    public static String lala_traductor_traza =  "lala_traductor_traza";
    public static String lala_traductor_traza_anidamiento_opcional_num =  "lala_traductor_traza_anidamiento_opcional_num";
    public reglas_gramaticales regla_gramatical = null;
    public int error_continuable_desde_num = 1;
    public int opcional_hasta_num = 0;
    public boolean hay_opcion_vacia = false;
    public String estado = "";
    public List<String> mensajes_error_lista = new ArrayList();
    public textos resultado_temporal_texto = new textos();
    public textos lectura_temporal_texto = new textos();
    public textos devolucion_opcion_fallida_texto = new textos();
    public textos ultima_lectura_bien = new textos();
    
    public boolean configurar_opcional(reglas_gramaticales regla_gramatical, int opcional_hasta_num, boolean hay_opcion_vacia, textos error) {
        this.regla_gramatical = regla_gramatical;
        this.opcional_hasta_num = opcional_hasta_num;
        this.hay_opcion_vacia = hay_opcion_vacia;
        return true;
    }

    public boolean configurar_obligatoria(reglas_gramaticales regla_gramatical, int error_continuable_desde_num, textos error) {
        this.regla_gramatical = regla_gramatical;
        this.error_continuable_desde_num = error_continuable_desde_num;
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
            ret = escribir_traza(contexto, "\n[" + anidamiento_opcional_num.dar() + ", " + texto + "]", error);
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
    
    /**
     * Se crea una nueva regla gramatical, copia de la definida en la anterior.
     * De esa manera, los atributos extendidos no se escriben en la regla de origen. Que se podría estar repitiendo. Y debe renovarse en cada uso.
     * @param regla_gramatical_extendida
     * @param error
     * @return 
     */
    public reglas_gramaticales_extendidas crear_configurada(reglas_gramaticales_extendidas regla_gramatical_extendida, textos error) {
        boolean ret = true;
        reglas_gramaticales_extendidas regla_gramatical_extendida_nueva = new reglas_gramaticales_extendidas();
        if (regla_gramatical_extendida.opcional_hasta_num > 0) {
            ret = regla_gramatical_extendida_nueva.configurar_opcional(regla_gramatical_extendida.regla_gramatical
                , regla_gramatical_extendida.opcional_hasta_num
                , regla_gramatical_extendida.hay_opcion_vacia
                , error);
        } else {
            ret = regla_gramatical_extendida_nueva.configurar_obligatoria(regla_gramatical_extendida.regla_gramatical
                , regla_gramatical_extendida.error_continuable_desde_num
                , error);
        }
        if (ret) {
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

    public boolean leer_y_comprobar_tras_regla(contextos contexto, reglas_gramaticales_extendidas destino_regla_gramatical, String id, bools es_error_continuable, textos error) {
        boolean ret = true;
        textos texto = new textos();
        textos estado_texto = new textos();
        i_eles retorno;
        acciones lectura_y_comprobacion_tras_regla;
        lectura_y_comprobacion_tras_regla = regla_gramatical.lecturas_y_comprobaciones_tras_regla_mapa.get(id);
        if (lectura_y_comprobacion_tras_regla != null) {
            estado_texto.poner(estado);
            retorno = lectura_y_comprobacion_tras_regla.dar(contexto, texto, estado_texto, error);
            if (retorno.no_es()) {
                if (error.isEmpty() == false) {
                    destino_regla_gramatical.mensajes_error_lista.add(error.leer_texto());
                }
                estado = estado_error;
                ret = false;
            } else {
                estado = estado_texto.leer_texto();
                ret = concatenar_texto(texto.leer_texto(), destino_regla_gramatical.ultima_lectura_bien, error);
                if (ret == false) {
                    estado = estado_error_fatal;
                }
                ret = concatenar_texto(texto.leer_texto(), destino_regla_gramatical.lectura_temporal_texto, error);
                if (ret == false) {
                    estado = estado_error_fatal;
                }
            }
            if (concatenar_texto(texto.leer_texto(), destino_regla_gramatical.devolucion_opcion_fallida_texto, error) == false) {
                estado = estado_error_fatal;
                ret = false;
            }
            escribir_traza(contexto, texto.leer_texto(), error);            
        }
        if (tratar_continuable (contexto, es_error_continuable, error, error) == false) {
            ret = false;
        };
        return ret;
    }

    public boolean tratar_continuable(contextos contexto, bools es_error_continuable, textos ultimo_error, textos error) {
        boolean ret = true;
        int pos_ini;
        int pos_fin;
        String linea_texto = "";
        pos_ini = ultimo_error.indexOf("(");
        pos_fin = ultimo_error.indexOf(")");
        if (pos_ini >= 0 && pos_fin > pos_ini) {
            linea_texto = ultimo_error.leer_texto().substring(pos_ini, pos_fin + ")".length());
        }
        if (estado.equals(estado_con_errores)) {
            es_error_continuable.poner(true);
            escribir_traza(contexto, "[CON ERRORES]", error);
        } else if (estado.equals(estado_error_continuable)) {
            es_error_continuable.poner(true);
            escribir_traza(contexto, "[ERROR CONTINUABLE]", error);
        } else if (estado.equals(estado_opcion_fallida)) {
            escribir_traza(contexto, "[OPCION FALLIDA]", error);
        } else if (estado.equals(estado_error)) {
            escribir_traza(contexto, "[" + this.regla_gramatical.id + ", ERROR " + linea_texto + "]", error);
        } else if (estado.equals(estado_error_fatal)) {
            escribir_traza(contexto, "[" + this.regla_gramatical.id + ", ERROR FATAL " + linea_texto + "]", error);
        }
        return ret;
    }
    
    public boolean llamar_accion_tras_regla(contextos contexto, String id, textos error) {
        boolean ret = true;
        i_eles retorno;
        acciones accion_tras_regla;
        accion_tras_regla = this.regla_gramatical.acciones_tras_regla_mapa.get(id);
        if (accion_tras_regla != null) {
            contexto.superponer(lala_traductor_regla_en_curso, this);
            retorno = accion_tras_regla.dar(contexto, error);
            if (retorno.no_es()) {
                estado = estado_error;
                ret = false;
            }
        }
        return ret;
    }

    public boolean llamar_devolver_texto(contextos contexto, textos error) {
        boolean ret = true;
        i_eles retorno;
        if (this.regla_gramatical.devolver_texto != null) {
            retorno = this.regla_gramatical.devolver_texto.dar(contexto, devolucion_opcion_fallida_texto, error);
            if (retorno.no_es()) {
                if (error.isEmpty() == false) {
                    mensajes_error_lista.add(error.leer_texto());
                }
                estado = estado_error;
                ret = false;
            }
            devolucion_opcion_fallida_texto.poner("");
        }                
        return ret;
    }
    
    public String procesar_regla(contextos contexto, textos error) {
        boolean ret = true;
        bools es_error_continuable = new bools(false);
        reglas_gramaticales_extendidas local_regla_gramatical;
        Iterator <String> iterator;
        String nombre = "";
        int avance_la = 0;
        int pos = 0;
        int tam;
        if (this.opcional_hasta_num > 0) {
            escribir_traza_opcional_inicio(contexto, this.regla_gramatical.id, error);
        } else {
            escribir_traza(contexto, "[" + this.regla_gramatical.id + "]", error);
        }
        estado = estado_bien;
        contexto.superponer(lala_traductor_regla_en_curso, this);
        if (this.opcional_hasta_num > 0) {
            local_regla_gramatical = contexto.leer(lala_traductor_primera_regla_opcional).dar();
            if (local_regla_gramatical == null) {
                contexto.superponer(lala_traductor_primera_regla_opcional, this);
            }
        }
        // Quitar el if (solo está para depuración)
        if (this.regla_gramatical.id.equals("llamada_metodo")) {
            nombre = "poner breakpoint.";
        }
        ret = leer_y_comprobar_tras_regla(contexto, this, id_mapa_tras_regla_0, es_error_continuable, error);
        // Quitar el if (solo está para depuración)
        if (error.startsWith("(24)")) {
            nombre = "poner breakpoint.";
        }        
        if (ret) {
            ret = llamar_accion_tras_regla(contexto, id_mapa_tras_regla_0, error);
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
                    estado = estado_error_fatal;
                    ret = false;
                    break;
                }
                estado = local_regla_gramatical.procesar_regla(contexto, error);
                if (estado.equals(estado_error_fatal)) {
                    ret = false;
                    break;
                }
                ret = leer_y_comprobar_tras_regla(contexto, local_regla_gramatical, nombre, es_error_continuable, error);
                if (ret == false) {
                    if (estado.equals(estado_error_fatal)) {
                        ret = false;
                        break;
                    }
                }
                if (estado.equals(estado_bien)) {
                    ret = concatenar_texto(local_regla_gramatical.resultado_temporal_texto.leer_texto(), resultado_temporal_texto, error);
                    if (ret) {
                        // No operar de nuevo 
                        local_regla_gramatical.resultado_temporal_texto.poner("");
                        ret = concatenar_texto(local_regla_gramatical.lectura_temporal_texto.leer_texto(), lectura_temporal_texto, error);
                    } else {
                        estado = estado_error_fatal;
                    }
                    if (ret) {
                        // No operar de nuevo 
                        local_regla_gramatical.lectura_temporal_texto.poner(""); 
                        ret = llamar_accion_tras_regla(contexto, nombre, error);
                    } else {
                        estado = estado_error_fatal;
                    }
                    if (ret == false) {
                        break;
                    }
                }
                if (local_regla_gramatical.opcional_hasta_num > 0) {
                    // Es una regla opcional
                    if (estado.equals(estado_bien)
                    || estado.equals(estado_con_errores)) {
                        if (estado.equals(estado_con_errores)) {
                            mensajes_error_lista.addAll(local_regla_gramatical.mensajes_error_lista);
                        }
                        avance_la = avance_la + 1;
                        ret = concatenar_texto(local_regla_gramatical.devolucion_opcion_fallida_texto.leer_texto(), devolucion_opcion_fallida_texto, error);
                        if (ret == false) {
                            estado = estado_error_fatal;
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
                    } else if (estado.equals(estado_opcion_fallida)) {
                        if (local_regla_gramatical.hay_opcion_vacia == false) {
                            pos = pos + 1;
                            if (iterator.hasNext() == false) {
//                                mensajes_error_lista.addAll(local_regla_gramatical.mensajes_error_lista);
                                mensajes_error_lista.add("Ninguna regla opcional ha sido satisfactoria. Último error: " + error.leer_texto());
                                ret = false;
                                break;
                            }
                            nombre = iterator.next();
                            local_regla_gramatical = this.regla_gramatical.reglas_gramaticales_mapa.get(nombre);
                            if (local_regla_gramatical.opcional_hasta_num == 0) {
                                // Ninguna rama ha sido satisfactoria
                                mensajes_error_lista.add("Opciones no encontradas. Ninguna regla opcional ha sido satisfactoria. Último error: " + error.leer_texto());
                                ret = false;
                                break;
                            }
                        } else {
                            if (es_error_continuable.es()) {
                                estado = estado_con_errores; 
                            } else {
                                estado = estado_bien;                                
                            }
                            pos = pos + 1;
                            if (iterator.hasNext() == false) {
                                break;
                            }
                            nombre = iterator.next();
                        }
                    } else if (estado.equals(estado_error)
                            || estado.equals(estado_error_continuable)) {
                        mensajes_error_lista.addAll(local_regla_gramatical.mensajes_error_lista);
                        ret = concatenar_texto(local_regla_gramatical.devolucion_opcion_fallida_texto.leer_texto(), devolucion_opcion_fallida_texto, error);
                        if (ret == false) {
                            estado = estado_error_fatal;
                            break;
                        } else {
//                        if (estado.equals(estado_error)) {
//                            ret = false;
//                            break;
//                        }
                            if (avance_la < opcional_hasta_num) {
                                ret = false;
                                break;
                            } else {
                                estado = estado_error_continuable;
                                if (tratar_continuable(contexto, es_error_continuable, error, error) == false) {
                                    estado = estado_error_fatal;
                                    break;
                                }
                                pos = pos + 1;
                                if (iterator.hasNext() == false) {
                                    ret = false;
                                    break;
                                }
                                nombre = iterator.next();
                            }
                        }
                    }
                } else {
                    ret = concatenar_texto(local_regla_gramatical.devolucion_opcion_fallida_texto.leer_texto(), devolucion_opcion_fallida_texto, error);
                    if (ret == false) {
                        estado = estado_error_fatal;
                        break;
                    }
                    if (estado.equals(estado_bien)
                     || estado.equals(estado_con_errores)) {
                        if (estado.equals(estado_con_errores)) {
                            mensajes_error_lista.addAll(local_regla_gramatical.mensajes_error_lista);
                        }
                    } else {
                        mensajes_error_lista.addAll(local_regla_gramatical.mensajes_error_lista);
                        if (avance_la < error_continuable_desde_num) {
                            // Si la primera subregla falla; falla toda la regla.
                            ret = false;
                            break;
                        } else if (opcional_hasta_num > 0 && avance_la < opcional_hasta_num) {
                            // Si la regla es opcional; no seguimos.
                            ret = false;
                            break;
                        } else {
                            estado = estado_error_continuable;                        
                            if (tratar_continuable(contexto, es_error_continuable, error, error) == false) {
                                estado = estado_error_fatal;
                                break;
                            }
                        }
//                        if (estado.equals(estado_error)) {
//                            ret = false;
//                            break;
//                        }
                    }
                    avance_la = avance_la + 1;
                    pos = pos + 1;
                    if (iterator.hasNext() == false) {
                        break;
                    }
                    nombre = iterator.next();
                }
            }
        }
        if (leer_y_comprobar_tras_regla(contexto, this, id_mapa_tras_regla_final, es_error_continuable, error) == false) {
            ret = false;
        }
        if (ret) {
            ret = llamar_accion_tras_regla(contexto, id_mapa_tras_regla_final, error);
        }
        if (ret == false) {
            if (opcional_hasta_num > 0 && avance_la < opcional_hasta_num) {
                // Es una rama opcional fallida.
                estado = estado_opcion_fallida;                    
                ret = llamar_devolver_texto(contexto, error);
            } else {
                // Es un error gramatical
                if (es_error_continuable.es()) {
                    estado = estado_error_continuable;
                } else {
                    estado = estado_error;
                }
            }                
        } else {
            if (es_error_continuable.es()) {
                estado = estado_con_errores;
            }
        }
        if (this.opcional_hasta_num > 0) {
            local_regla_gramatical = contexto.leer(lala_traductor_primera_regla_opcional).dar();
            if (local_regla_gramatical == this) {
                contexto.superponer(lala_traductor_primera_regla_opcional, null);
                ret = llamar_accion_tras_regla(contexto, id_mapa_tras_fin_opcion, error);
            }
        }
        if (this.opcional_hasta_num > 0) {
            escribir_traza_opcional_fin(contexto, error);
        }
        return estado;
    }

}
