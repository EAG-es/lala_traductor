/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.lala.traductor;

import innui.contextos.acciones;
import innui.contextos.bools;
import innui.contextos.contextos;
import innui.contextos.i_eles;
import innui.contextos.textos;
import java.io.File;

/**
 *
 * @author emilio
 */
public class lala_reglas_gramaticales {
    public textos_gramaticales texto_gramatical;
    public reglas_gramaticales inicio_lala = new reglas_gramaticales();
    public reglas_gramaticales fin_de_archivo = new reglas_gramaticales();
    public reglas_gramaticales programa_lala = new reglas_gramaticales();
    public reglas_gramaticales nueva_linea = new reglas_gramaticales();
    public reglas_gramaticales comentario_multilinea = new reglas_gramaticales();
    public reglas_gramaticales comentario_linea = new reglas_gramaticales();
    public reglas_gramaticales acciones = new reglas_gramaticales();
    public reglas_gramaticales acciones_fin = new reglas_gramaticales();
    public reglas_gramaticales fin_opciones = new reglas_gramaticales();
    public reglas_gramaticales comentarios = new reglas_gramaticales();
    public reglas_gramaticales comentario_doc = new reglas_gramaticales();
    public reglas_gramaticales texto_libre_hasta_param = new reglas_gramaticales();
    public reglas_gramaticales texto_libre_hasta_return = new reglas_gramaticales();
    public reglas_gramaticales texto_libre_hasta_fin_comentario = new reglas_gramaticales();
    public reglas_gramaticales declaracion_accion = new reglas_gramaticales();
    public reglas_gramaticales nombre_accion = new reglas_gramaticales();
    public reglas_gramaticales parametros = new reglas_gramaticales();
    public reglas_gramaticales parametros_subaccion = new reglas_gramaticales();
    public reglas_gramaticales nombre_m_s = new reglas_gramaticales();
    public reglas_gramaticales coma_parametro = new reglas_gramaticales();
    public reglas_gramaticales coma_variable = new reglas_gramaticales();
    public reglas_gramaticales codigo_accion = new reglas_gramaticales();
    public reglas_gramaticales semiconstante_variable_o_parametro = new reglas_gramaticales();
    public reglas_gramaticales nombre_variable_o_parametro = new reglas_gramaticales();
    public reglas_gramaticales constante_logica = new reglas_gramaticales();
    public reglas_gramaticales constante_numero = new reglas_gramaticales();
    public reglas_gramaticales llamada_accion = new reglas_gramaticales();
    public reglas_gramaticales llamada_accion_fin = new reglas_gramaticales();    
    public reglas_gramaticales llamada_acciones = new reglas_gramaticales();
    public reglas_gramaticales llamada_acciones_linea = new reglas_gramaticales();
    public reglas_gramaticales ruta_de_la_accion = new reglas_gramaticales();    
    public reglas_gramaticales suma_4_espacios = new reglas_gramaticales();
    public reglas_gramaticales resta_4_espacios = new reglas_gramaticales();
    public reglas_gramaticales bloque_excepcion = new reglas_gramaticales();
    public reglas_gramaticales bloque_codigo = new reglas_gramaticales();
    public reglas_gramaticales finalmente = new reglas_gramaticales();    
    public reglas_gramaticales variables = new reglas_gramaticales();    
    public reglas_gramaticales variable_nombre = new reglas_gramaticales();    
    public reglas_gramaticales nulo = new reglas_gramaticales();    
    public reglas_gramaticales variable_o_parametro = new reglas_gramaticales();    
    public reglas_gramaticales variable_o_parametro_final = new reglas_gramaticales();    
    public reglas_gramaticales pasa_parametros = new reglas_gramaticales();    
    public reglas_gramaticales pasa_parametro = new reglas_gramaticales();    
    public reglas_gramaticales coma_pasa_parametro = new reglas_gramaticales();    
    public reglas_gramaticales codigo = new reglas_gramaticales();    
    public reglas_gramaticales bloque_si = new reglas_gramaticales();
    public reglas_gramaticales bloque_repetir = new reglas_gramaticales();
    public reglas_gramaticales bloque_repetir_fin = new reglas_gramaticales();
    public reglas_gramaticales subacciones = new reglas_gramaticales();
    public reglas_gramaticales subaccion_o_comentario = new reglas_gramaticales();
    public reglas_gramaticales bloque_no_lala = new reglas_gramaticales();
    public reglas_gramaticales si_inicio = new reglas_gramaticales();
    public reglas_gramaticales bloque_contra = new reglas_gramaticales();
    public reglas_gramaticales bloque_contra_fin = new reglas_gramaticales();
    public reglas_gramaticales condicion = new reglas_gramaticales();
    public reglas_gramaticales salir = new reglas_gramaticales();
    public reglas_gramaticales espacios_bien = new reglas_gramaticales();
    public reglas_gramaticales texto_libre_no_lala = new reglas_gramaticales();
    public int espacios_num = 0;
    public int repetir_num = 0;
    
    public lala_reglas_gramaticales() {
        texto_gramatical = new textos_gramaticales();
    }
    
    public boolean configurar(contextos contexto, textos error) {
        boolean ret = true;
        if (ret) {
            crear_acciones(acciones, error);
        }
        if (ret) {
            crear_acciones_fin(acciones_fin, error);
        }
        if (ret) {
            crear_comentario_linea(comentario_linea, error);
        }
        if (ret) {
            crear_comentario_multilinea(comentario_multilinea, error);
        }
        if (ret) {
            crear_fin_opciones(fin_opciones, error);
        }
        if (ret) {
            ret = crear_nueva_linea(nueva_linea, error);
        }
        if (ret) {
            ret = crear_inicio_lala(inicio_lala, error);
        }
        if (ret) {
            ret = crear_fin_de_archivo(fin_de_archivo, error);
        }
        if (ret) {
            ret = crear_programa_lala(programa_lala, error);
        }
        if (ret) {
            ret = crear_comentarios(comentarios, error);
        }
        if (ret) {
            ret = crear_comentario_doc(comentario_doc, error);
        }
        if (ret) {
            ret = crear_texto_libre_hasta_param(texto_libre_hasta_param, error);
        }
        if (ret) {
            ret = crear_texto_libre_hasta_return(texto_libre_hasta_return, error);
        }
        if (ret) {
            ret = crear_texto_libre_hasta_fin_comentario(texto_libre_hasta_fin_comentario, error);
        }
        if (ret) {
            ret = crear_declaracion_accion(declaracion_accion, error);
        }
        if (ret) {
            ret = crear_nombre_accion(nombre_accion, error);
        }
        if (ret) {
            ret = crear_parametros(parametros, error);
        }
        if (ret) {
            ret = crear_parametros_subaccion(parametros_subaccion, error);
        }
        if (ret) {
            ret = crear_nombre_m_s(nombre_m_s, error);
        }
        if (ret) {
            ret = crear_coma_parametro(coma_parametro, error);
        }
        if (ret) {
            ret = crear_variables(variables, error);
        }
        if (ret) {
            ret = crear_variable_nombre(variable_nombre, error);
        }
        if (ret) {
            ret = crear_coma_variable(coma_variable, error);
        }
        if (ret) {
            ret = crear_codigo_accion(codigo_accion, error);
        }
        if (ret) {
            ret = crear_semiconstante_variable_o_parametro(semiconstante_variable_o_parametro, error);
        }
        if (ret) {
            ret = crear_nombre_variable_o_parametro(nombre_variable_o_parametro, error);
        }
        if (ret) {
            ret = crear_constante_logica(constante_logica, error);
        }
        if (ret) {
            ret = crear_constante_numero(constante_numero, error);
        }
        if (ret) {
            ret = crear_llamada_accion(llamada_accion, error);
        }
        if (ret) {
            ret = crear_llamada_accion_fin(llamada_accion_fin, error);
        }
        if (ret) {
            ret = crear_ruta_de_la_accion(ruta_de_la_accion, error);
        }
        if (ret) {
            ret = crear_suma_4_espacios(suma_4_espacios, error);
        }
        if (ret) {
            ret = crear_resta_4_espacios(resta_4_espacios, error);
        }
        if (ret) {
            ret = crear_bloque_excepcion(bloque_excepcion, error);
        }
        if (ret) {
            ret = crear_bloque_codigo(bloque_codigo, error);
        }
        if (ret) {
            ret = crear_codigo(codigo, error);
        }
        if (ret) {
            ret = crear_finalmente(finalmente, error);
        }
        if (ret) {
            ret = crear_nulo(nulo, error);
        }
        if (ret) {
            ret = crear_variable_o_parametro(variable_o_parametro, error);
        }
        if (ret) {
            ret = crear_variable_o_parametro_final(variable_o_parametro_final, error);
        }
        if (ret) {
            ret = crear_pasa_parametros(pasa_parametros, error);
        }
        if (ret) {
            ret = crear_pasa_parametro(pasa_parametro, error);
        }
        if (ret) {
            ret = crear_coma_pasa_parametro(coma_pasa_parametro, error);
        }
        if (ret) {
            ret = crear_bloque_si(bloque_si, error);
        }
        if (ret) {
            ret = crear_bloque_repetir(bloque_repetir, error);
        }
        if (ret) {
            ret = crear_bloque_repetir_fin(bloque_repetir_fin, error);
        }
        if (ret) {
            ret = crear_subaccion_o_comentario(subaccion_o_comentario, error);
        }
        if (ret) {
            ret = crear_subacciones(subacciones, error);
        }
        if (ret) {
            ret = crear_bloque_no_lala(bloque_no_lala, error);
        }
//        if (ret) {
//            ret = crear_llamada_acciones_simple(llamada_acciones_simple, error);
//        }
        if (ret) {
            ret = crear_llamada_acciones_linea(llamada_acciones_linea, error);
        }
        if (ret) {
            ret = crear_llamada_acciones(llamada_acciones, error);
        }
//        if (ret) {
//            ret = crear_llamada_subaccion(llamada_subaccion, error);
//        }
        if (ret) {
            ret = crear_si_inicio(si_inicio, error);
        }
        if (ret) {
            ret = crear_bloque_contra(bloque_contra, error);
        }
        if (ret) {
            ret = crear_bloque_contra_fin(bloque_contra_fin, error);
        }
        if (ret) {
            ret = crear_condicion(condicion, error);
        }
        if (ret) {
            ret = crear_salir(salir, error);
        }
        if (ret) {
            ret = crear_espacios_bien(espacios_bien, error);
        }
        if (ret) {
            ret = crear_texto_libre_no_lala(texto_libre_no_lala, error);
        }
        return ret;
    }
    
    public boolean abrir(contextos contexto, File entrada, textos error) {
        boolean ret = true;
        ret = texto_gramatical.abrir(entrada, error);
        return ret;
    }
    
    public boolean cerrar(contextos contexto, textos error) {
        boolean ret = true;
        ret = texto_gramatical.cerrar(error);
        return ret;
    }

    public reglas_gramaticales crear_regla_texto(String esperado_texto, textos error) {
        boolean ret = true;
        final reglas_gramaticales regla = new reglas_gramaticales();
        regla.id = esperado_texto;
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                ret = texto_gramatical.leer_esperado(esperado_texto, (textos) texto, (textos) error);
                return new bools(ret);
            }
        };     
        if (ret == false) {
            return null;
        }
        return regla;
    }
    
    public boolean crear_inicio_lala(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "inicio_lala";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("programa_lala", programa_lala, 0, false, error);
        }
        return ret;
    }
    
    public boolean crear_fin_de_archivo(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "fin_de_archivo";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
               boolean ret = true;
               ret = texto_gramatical.leer_blancos_hasta_fin_archivo((textos) error);
               return new bools(ret);
            }
        };     
        return ret;
    }
    
    public boolean crear_programa_lala(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "programa_lala";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("comentario_multilinea", comentario_multilinea, 1, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("comentario_linea", comentario_linea, 1, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("acciones", acciones, 1, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea*", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("programa_lala", programa_lala, 1, true, error);
        }
        return ret;
    }

    public boolean crear_elementos_comunes(reglas_gramaticales regla, textos error) {
        boolean ret = true;
        regla.devolver_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
               boolean ret = true;
               ret = texto_gramatical.devolver_texto(texto.leer_texto(), (textos) error);
               return new bools(ret);
            }
        };
        regla.crear_mensaje_error = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles mensaje, i_eles error) {
               boolean ret = true;
               mensaje.poner("(" + texto_gramatical.linea_num + ") No se cumple la regla: " + regla.id);
               return new bools(ret);
            }
        };
        return ret;
    }

    public boolean crear_nueva_linea(reglas_gramaticales regla, textos error) {
        boolean ret = true;
        regla.id = "nueva_linea";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                ret = texto_gramatical.leer_nueva_linea((textos) error);
                if (ret) {
                    texto.poner("\n");
                }
                return new bools(ret);
            }
        };     
        return ret;
    }
    
    public boolean crear_comentario_multilinea(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "comentario_multilinea";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                textos leido_texto = new textos();
                textos texto_libre = new textos();
                ret = texto_gramatical.leer_esperado("/*", leido_texto, (textos) error);
                if (ret) {
                    ret = texto_gramatical.leer_texto_con_limite("*/", texto_libre, (textos) error);
                    leido_texto.concat(texto_libre);
                }
//                if (ret) {
//                    ret = texto_gramatical.leer_esperado("*/", texto_libre, (textos) error);
//                    leido_texto.concat(texto_libre);
//                }
                texto.poner(leido_texto);
                return new bools(ret);
            }
        };    
        return ret;
    }
    
    public boolean crear_comentario_linea(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "comentario_linea";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                textos leido_texto = new textos();
                textos linea_de_texto_libre = new textos();
                ret = texto_gramatical.leer_esperado("//", leido_texto, (textos) error);
                if (ret) {
                    ret = texto_gramatical.leer_linea(linea_de_texto_libre, (textos) error);
                    if (ret) {
                        leido_texto.concat(" ");
                        leido_texto.concat(linea_de_texto_libre);
                    }
                }
                texto.poner(leido_texto);
                return new bools(ret);
            }
        };    
        return ret;
    }
    
    public boolean crear_acciones(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "acciones";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                if (espacios_num != 0) {
                    ret = false;
                    error.poner("(" + texto_gramatical.linea_num + ") " + "No pueden haber espacios frente a la declaración de una accion. ");
                }
                return new bools(ret);
            }
        };
        if (ret) {
            ret = regla.poner_regla("comentario_doc", comentario_doc, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("declaracion_accion", declaracion_accion, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nombre_accion", nombre_accion, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("(", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("(", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("parametros", parametros, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto(")", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla(")", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("acciones_fin", acciones_fin, 0, false, error);
        }
        return ret;
    }
    
    public boolean crear_acciones_fin(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "acciones_fin";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("suma_4_espacios", suma_4_espacios, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("codigo_accion", codigo_accion, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("retornar", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("retornar", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("llamada_acciones", llamada_acciones, 2, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("semiconstante_variable_o_parametro", semiconstante_variable_o_parametro, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nulo", nulo, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("resta_4_espacios", resta_4_espacios, 0, false, error);
        }
        return ret;
    }
    
    public boolean crear_fin_opciones(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "fin_opciones";
        ret = crear_elementos_comunes(regla, error);
        return ret;
    }
    
    public boolean crear_comentarios(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "comentarios";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("comentario_linea", comentario_linea, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("comentario_multilinea", comentario_multilinea, 1, false, error);
        }
        return ret;
    }

    public boolean crear_comentario_doc(reglas_gramaticales regla, textos error) {
        boolean ret = true;
        regla.id = "comentario_doc";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                ret = texto_gramatical.leer_esperado("/**", (textos) texto, (textos) error);
                return new bools(ret);
            }
        };    
        if (ret) {
            ret = regla.poner_regla("texto_libre_hasta_param", texto_libre_hasta_param, 1, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("fin_opciones", fin_opciones, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("texto_libre_hasta_return", texto_libre_hasta_return, 1, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("texto_libre_hasta_fin_comentario", texto_libre_hasta_fin_comentario, 0, false, error);
        }
        return ret;
    }
        
    public boolean crear_texto_libre_hasta_param(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "texto_libre_hasta_param";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                textos libre_texto = new textos();
                String string;
                int pos_param = 0;
                int pos_return = 0;
                ret = texto_gramatical.leer_texto_con_limite("*/", libre_texto, (textos) error);
                if (ret) {
                    pos_param = libre_texto.indexOf("@param");
                    pos_return = libre_texto.indexOf("@return");
                    if (pos_param >= 0) {
                        if (pos_return >= 0) {
                            if (pos_param > pos_return) {
                                ret = false;
                                error.poner("(" + texto_gramatical.linea_num + ") " + "Se ha encontrado @return antes de @param: " + libre_texto.leer_texto());
                            }
                        } 
                        if (ret) {
                            pos_param = pos_param + "@param".length();
                            string = libre_texto.leer_texto();
                            libre_texto.substring(0, pos_param);
                            ret = texto_gramatical.devolver_texto(string.substring(pos_param), (textos) error);
                        }
                    } else {
                        error.poner("(" + texto_gramatical.linea_num + ") " + "no se ha encontrado @param: " + libre_texto.leer_texto());
                        ret = false;
                    }
                }
                texto.poner(libre_texto);
                return new bools(ret);
            }
        };    
        if (ret) {
            ret = regla.poner_regla("texto_libre_hasta_param", texto_libre_hasta_param, 1, true, error);
        }
        return ret;
    }

    public boolean crear_texto_libre_hasta_return(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "texto_libre_hasta_return";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                textos libre_texto = new textos();
                int pos_return = 0;
                ret = texto_gramatical.leer_texto_con_limite("*/", libre_texto, (textos) error);
                if (ret) {
                    pos_return = libre_texto.indexOf("@return");
                    if (pos_return < 0) {
                        error.poner("(" + texto_gramatical.linea_num + ") " + "No se ha encontrado @return: " + libre_texto.leer_texto());
                        ret = false;
                    }
                }
                texto.poner(libre_texto);
                return new bools(ret);
            }
        };    
        return ret;
    }

    public boolean crear_texto_libre_hasta_fin_comentario(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "texto_libre_hasta_fin_comentario";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                textos libre_texto = new textos();
                textos fin_comentario_multilinea_texto = new textos();
                ret = texto_gramatical.leer_texto_con_limite("*/", libre_texto, (textos) error);
//                if (ret) {
//                    ret = texto_gramatical.leer_esperado("*/", fin_comentario_multilinea_texto, (textos) error);
//                }
                if (ret) {
                    libre_texto.concat(fin_comentario_multilinea_texto);
                }
                texto.poner(libre_texto);
                return new bools(ret);
            }
        };    
        return ret;
    }

    public boolean crear_declaracion_accion(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "declaracion_accion";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                textos accion_texto = new textos();
                textos local_texto = new textos();
                ret = texto_gramatical.leer_esperado("accion", accion_texto, (textos) error);
                if (ret) {
                    ret = texto_gramatical.leer_texto_entre_espacios(local_texto, (textos) error);
                    if (local_texto.leer_texto().trim().equals("local") == false) {
                        ret = texto_gramatical.devolver_texto(
                                 local_texto.leer_texto()
                                 , (textos) error);
                    } else {
                        accion_texto.concat(" ");
                        accion_texto.concat(local_texto);
                    }
                }
                texto.poner(accion_texto);
                return new bools(ret);
            }
        };    
        return ret;
    }

    public boolean crear_nombre_accion(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "nombre_accion";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                textos verbo_texto = new textos();
                textos nombre_texto = new textos();
                ret = texto_gramatical.leer_verbo(verbo_texto, (textos) error);
                if (ret) {
                    ret = texto_gramatical.leer_nombres_m_singular(nombre_texto, (textos) error);
                }
                if (ret) {
                    verbo_texto.concat(" " + nombre_texto.leer_texto());
                }
                texto.poner(verbo_texto);
                return new bools(ret);
            }
        };    
        return ret;
    }

    public boolean crear_parametros(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "parametros";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("nombre_m_s", nombre_m_s, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("coma_parametro", coma_parametro, 1, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("...", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("...", regla_texto, 1, false, error);
        }
        return ret;
    }

    public boolean crear_parametros_subaccion(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "parametros_subaccion";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("nombre_m_s", nombre_m_s, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("coma_parametro", coma_parametro, 1, true, error);
        }
        return ret;
    }

    public boolean crear_coma_parametro(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "coma_parametro";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto(",", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla(",", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nombre_m_s", nombre_m_s, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("coma_parametro", coma_parametro, 1, true, error);
        }
        return ret;
    }

    public boolean crear_nombre_m_s(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "nombre_m_s";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                ret = texto_gramatical.leer_nombres_m_singular((textos) texto, (textos) error);
                return new bools(ret);
            }
        };    
        return ret;
    }

    public boolean crear_codigo_accion(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "codigo_accion";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("espacios_bien", espacios_bien, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("variable", variables, 1, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_excepcion", bloque_excepcion, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        return ret;
    }

    public boolean crear_semiconstante_variable_o_parametro(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "semiconstante_variable_o_parametro";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("constante_numero", constante_numero, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("constante_logica", constante_logica, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nombre_variable_o_parametro", nombre_variable_o_parametro, 1, false, error);
        }
        return ret;
    }

    public boolean crear_constante_logica(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "constante_logica";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto("verdad", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("verdad", regla_texto, 1, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("falso", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("falso", regla_texto, 1, false, error);
        }
        return ret;
    }

    public boolean crear_constante_numero(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "constante_numero";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                ret = texto_gramatical.leer_numero((textos) texto, (textos) error);
                return new bools(ret);
            }
        };    
        return ret;
    }

    public boolean crear_nombre_variable_o_parametro(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "nombre_variable_o_parametro";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("nombre_m_s", nombre_m_s, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("variable_o_parametro", variable_o_parametro, 1, true, error);
        }
        return ret;
    }

    public boolean crear_pasa_parametros(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "pasa_parametros";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("pasa_parametro", pasa_parametro, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("coma_pasa_parametro", coma_pasa_parametro, 1, true, error);
        }
        return ret;
    }

    public boolean crear_llamada_accion(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "llamada_accion";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("nombre_accion", nombre_accion, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("variable_o_parametro_final", variable_o_parametro_final, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("llamada_accion_fin", llamada_accion_fin, 1, true, error);
        }
        return ret;
    }

    public boolean crear_llamada_accion_fin(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "llamada_accion_fin";
        reglas_gramaticales regla_texto = null;
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto("[", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("[", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("ruta_de_la_accion", ruta_de_la_accion, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("]", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("]", regla_texto, 0, false, error);
        }
        return ret;
    }

    public boolean crear_ruta_de_la_accion(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "ruta_de_la_accion";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                File file;
                ret = texto_gramatical.leer_texto_entre_espacios((textos) texto, (textos) error);
                if (ret) {
                    file = new File(texto.leer_texto().trim());
                    if (file.getParent()== null) {
                        error.poner("(" + texto_gramatical.linea_num + ") " + "No se puede localizar la ruta padre (ruta incorrecta): " + texto.leer_texto());
                        ret = false;
                    }
                }
                return new bools(ret);
            }
        };    
        return ret;
    }

    public boolean crear_suma_4_espacios(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "suma_4_espacios";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                espacios_num = espacios_num + 4;
                return new bools(ret);
            }
        };
        return ret;
    }

    public boolean crear_resta_4_espacios(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "resta_4_espacios";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                espacios_num = espacios_num - 4;
                return new bools(ret);
            }
        };
        return ret;
    }

    public boolean crear_nulo(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "nulo";
        return ret;
    }

    public boolean crear_bloque_excepcion(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "bloque_excepcion";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto("tratable", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("tratable", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_codigo", bloque_codigo, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("captura", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("captura", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea*", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_codigo*", bloque_codigo, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("finalmente", finalmente, 1, true, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("/tratable", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("/tratable", regla_texto, 0, false, error);
        }
        return ret;
    }

    public boolean crear_finalmente(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "finalmente";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto("finalmente", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("finalmente", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_codigo", bloque_codigo, 0, false, error);
        }
        return ret;
    }

    public boolean crear_bloque_codigo(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "bloque_codigo";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("suma_4_espacios", suma_4_espacios, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("codigo", codigo, 2, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("resta_4_espacios", resta_4_espacios, 0, false, error);
        }
        return ret;
    }

    public boolean crear_codigo(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "codigo";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("espacios_bien", espacios_bien, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_si", bloque_si, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_repetir", bloque_repetir, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_excepcion", bloque_excepcion, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("salir", salir, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_no_lala", bloque_no_lala, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("llamada_acciones_linea", llamada_acciones_linea, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("subaccion_o_comentario", subaccion_o_comentario, 4, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("comentarios", comentarios, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("codigo", codigo, 1, true, error);
        }
        return ret;
    }

    public boolean crear_variables(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "variables";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto("variable", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("variable", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("variable_nombre", variable_nombre, 1, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("fin_opciones", fin_opciones, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("coma_variable", coma_variable, 1, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        return ret;
    }

    public boolean crear_coma_variable(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "coma_variable";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto(",", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla(",", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("variable_nombre", variable_nombre, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("coma_variable", coma_variable, 1, true, error);
        }
        return ret;
    }

    public boolean crear_variable_nombre(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "variable_nombre";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("nombre_m_s", nombre_m_s, 0, false, error);
        }
        return ret;
    }

    public boolean crear_variable_o_parametro(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "variable_o_parametro";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto(".", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla(".", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nombre_m_s", nombre_m_s, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("variable_o_parametro_final", variable_o_parametro_final, 1, true, error);
        }
        return ret;
    }

    public boolean crear_variable_o_parametro_final(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "variable_o_parametro_final";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto("(", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("(", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("pasa_parametros", pasa_parametros, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto(")", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla(")", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("variable_o_parametro", variable_o_parametro, 1, true, error);
        }
        return ret;
    }

    public boolean crear_pasa_parametro(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "pasa_parametro";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("llamada_acciones", llamada_acciones, 2, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("semiconstante_variable_o_parametro", semiconstante_variable_o_parametro, 1, true, error);
        }
        return ret;
    }

    public boolean crear_coma_pasa_parametro(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "coma_pasa_parametro";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto(",", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla(",", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("pasa_parametro", pasa_parametro, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("coma_pasa_parametro", coma_parametro, 1, true, error);
        }
        return ret;
    }

    public boolean crear_bloque_si(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "bloque_si";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("si_inicio", si_inicio, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_contra", bloque_contra, 2, true, error);
        }
        if (ret) {
            ret = regla.poner_regla("espacios_bien", espacios_bien, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("/si", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("/si", regla_texto, 0, false, error);
        }
        return ret;
    }

    public boolean crear_si_inicio(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "si_inicio";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto("si", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("si", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("condicion", condicion, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_codigo", bloque_codigo, 0, false, error);
        }
        return ret;
    }

    public boolean crear_bloque_contra(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "bloque_contra";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("espacios_bien", espacios_bien, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("contra", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("contra", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("si_inicio", si_inicio, 1, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_contra_fin", bloque_contra_fin, 1, false, error);
        }
        return ret;
    }

    public boolean crear_bloque_contra_fin(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "bloque_contra";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_codigo", bloque_codigo, 0, false, error);
        }
        return ret;
    }

    public boolean crear_espacios_bien(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "espacios_bien";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                ret = texto_gramatical.leer_espacios(espacios_num, (textos) texto, (textos) error);
                return new bools(ret);
            }
        };    
        return ret;
    }    
    
    public boolean crear_bloque_repetir(reglas_gramaticales regla, textos error) {
        boolean ret = true;
        reglas_gramaticales regla_texto = null;
        regla.id = "bloque_repetir";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                repetir_num = repetir_num + 1;
                return new bools(ret);
            }
        };    
        if (ret) {
            regla_texto = crear_regla_texto("repetir", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("repetir", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_codigo", bloque_codigo, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("espacios_bien", espacios_bien, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("bloque_repetir_fin", bloque_repetir_fin, 0, false, error);
        }
        return ret;
    }

    public boolean crear_bloque_repetir_fin(reglas_gramaticales regla, textos error) {
        boolean ret = true;
        reglas_gramaticales regla_texto = null;
        regla.id = "bloque_repetir_fin";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                repetir_num = repetir_num - 1;
                return new bools(ret);
            }
        };    
        if (ret) {
            regla_texto = crear_regla_texto("/repetir", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("/repetir", regla_texto, 0, false, error);
        }
        return ret;
    }
    
    public boolean crear_subaccion_o_comentario(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "subaccion_o_comentario";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("comentario_doc", comentario_doc, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("subacciones", subacciones, 2, true, error);
        }
        return ret;
    }
    
    public boolean crear_subacciones(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        reglas_gramaticales regla_texto = null;
        regla.id = "subacciones";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("subaccion", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("subaccion", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nombre_accion", nombre_accion, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("(", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("(", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("parametros_subaccion", parametros_subaccion, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto(")", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla(")", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("acciones_fin", acciones_fin, 0, false, error);
        }
        return ret;
    }

    public boolean crear_bloque_no_lala(reglas_gramaticales regla, textos error) {
        boolean ret = true;
        reglas_gramaticales regla_texto = null;
        regla.id = "bloque_no_lala";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            regla_texto = crear_regla_texto("no_lala", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("no_lala", regla_texto, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("texto_libre_no_lala", texto_libre_no_lala, 0, false, error);
        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea*", nueva_linea, 0, false, error);
        }
        if (ret) {
            regla_texto = crear_regla_texto("/no_lala", error);
            ret = (regla_texto != null);
        }
        if (ret) {
            ret = regla.poner_regla("/no_lala", regla_texto, 0, false, error);
        }
        return ret;
    }

//    public boolean crear_llamada_acciones_simple(reglas_gramaticales regla, textos error) {
//        boolean ret = true; 
//        regla.id = "llamada_acciones_simple";
//        ret = crear_elementos_comunes(regla, error);
//        if (ret) {
//            ret = regla.poner_regla("llamada_accion", llamada_accion, 2, false, error);
//        }
//        if (ret) {
//            ret = regla.poner_regla("llamada_subaccion", llamada_subaccion, 2, false, error);
//        }
//        return ret;
//    }

    public boolean crear_llamada_acciones(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "llamada_acciones";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("llamada_accion", llamada_accion, 0, false, error);
        }
//        if (ret) {
//            ret = regla.poner_regla("llamada_acciones_simple", llamada_acciones_simple, 0, false, error);
//        }
        if (ret) {
            ret = regla.poner_regla("nueva_linea", nueva_linea, 0, false, error);
        }
        return ret;
    }

    public boolean crear_llamada_acciones_linea(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "llamada_acciones_linea";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("llamada_accion", llamada_accion, 0, false, error);
        }
//        if (ret) {
//            ret = regla.poner_regla("llamada_acciones_simple", llamada_acciones_simple, 0, false, error);
//        }
        return ret;
    }

//    public boolean crear_llamada_subaccion(reglas_gramaticales regla, textos error) {
//        boolean ret = true; 
//        regla.id = "llamada_subaccion";
//        ret = crear_elementos_comunes(regla, error);
//        if (ret) {
//            ret = regla.poner_regla("nombre_m_s", nombre_m_s, 0, false, error);
//        }
//        if (ret) {
//            ret = regla.poner_regla("variable_o_parametro_final", variable_o_parametro_final, 0, false, error);
//        }
//        return ret;
//    }

    public boolean crear_condicion(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "condicion";
        ret = crear_elementos_comunes(regla, error);
        if (ret) {
            ret = regla.poner_regla("llamada_accion", llamada_accion, 0, false, error);
        }
//        if (ret) {
//            ret = regla.poner_regla("llamada_acciones_simple", llamada_acciones_simple, 0, false, error);
//        }
        return ret;
    }

    public boolean crear_salir(reglas_gramaticales regla, textos error) {
        boolean ret = true; 
        regla.id = "salir";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                ret = (repetir_num <= 0);
                if (ret) {
                    error.poner("(" + texto_gramatical.linea_num + ") " + "No situado dentro de un bucle. ");
                } else {
                    ret = texto_gramatical.leer_esperado("salir", (textos) texto, (textos) error);
                }
                return new bools(ret);
            }
        };    
        return ret;
    }

    public boolean crear_texto_libre_no_lala(reglas_gramaticales regla, textos error) {
        boolean ret = true;
        regla.id = "texto_libre_no_lala";
        ret = crear_elementos_comunes(regla, error);
        regla.leer_texto = new acciones.de_3 () {
            @Override
            protected bools ir(i_eles contexto, i_eles texto, i_eles error) {
                boolean ret = true;
                ret = texto_gramatical.leer_texto_no_lala((textos) texto, (textos) error);
                return new bools(ret);
            }
        };    
        return ret;
    }
    
}
