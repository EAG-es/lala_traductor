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
import static innui.lala.traductor.lala_resultados.lala_resultados_salida_archivo;
import static innui.lala.traductor.reglas_gramaticales_extendidas.estado_final_bien;
import static innui.lala.traductor.reglas_gramaticales_extendidas.lala_traductor_regla_en_curso;
import java.io.File;
import static innui.lala.traductor.reglas_gramaticales_extendidas.accion_tras_regla_0;
import static innui.lala.traductor.reglas_gramaticales_extendidas.accion_tras_fin_opcion;

/**
 *
 * @author emilio
 */
public class lalas_a_javas {
    public lala_resultados lala_resultado = new lala_resultados();
    public lala_reglas_gramaticales lala_regla_gramatical;
    public int espacios_num = 0;
    public int parametros_num = 0;
    
    public boolean abrir(contextos contexto, File salida, textos error) {
        boolean ret = true;
        contexto.fondear_con_datos(lala_resultados_salida_archivo, salida);
        ret = lala_resultado.abrir(salida, error);
        return ret;
    }
    
    public boolean cerrar(contextos contexto, textos error) {
        boolean ret = true;
        contexto.modificar(lala_resultados_salida_archivo, null);
        ret = lala_resultado.cerrar(error);
        return ret;
    }

    public boolean configurar(contextos contexto, lala_reglas_gramaticales local_lala_regla_gramatical, textos error) {
        boolean ret = true;
        lala_regla_gramatical = local_lala_regla_gramatical;
        if (ret) {
            ret = configurar_inicio_lala(contexto, lala_regla_gramatical.inicio_lala, error);
        }
        if (ret) {
            ret = configurar_programa_lala(contexto, lala_regla_gramatical.programa_lala, error);
        }
        if (ret) {
            ret = configurar_comentario_linea(contexto, lala_regla_gramatical.comentario_linea, error);
        }
        if (ret) {
            ret = configurar_comentario_multilinea(contexto, lala_regla_gramatical.comentario_multilinea, error);
        }
        if (ret) {
            ret = configurar_acciones(contexto, lala_regla_gramatical.acciones, error);
        }
        if (ret) {
            ret = configurar_acciones_fin(contexto, lala_regla_gramatical.acciones_fin, error);
        }
        if (ret) {
            ret = configurar_subacciones(contexto, lala_regla_gramatical.subacciones, error);
        }
        if (ret) {
            ret = configurar_comentario_doc(contexto, lala_regla_gramatical.comentario_doc, error);
        }
        if (ret) {
            ret = configurar_texto_libre_hasta_param(contexto, lala_regla_gramatical.texto_libre_hasta_param, error);
        }
        if (ret) {
            ret = configurar_texto_libre_hasta_return(contexto, lala_regla_gramatical.texto_libre_hasta_return, error);
        }
        if (ret) {
            ret = configurar_texto_libre_hasta_fin_comentario(contexto, lala_regla_gramatical.texto_libre_hasta_fin_comentario, error);
        }
        if (ret) {
            ret = configurar_parametros(contexto, lala_regla_gramatical.parametros, error);
        }
        if (ret) {
            ret = configurar_parametros_subaccion(contexto, lala_regla_gramatical.parametros_subaccion, error);
        }
        if (ret) {
            ret = configurar_nombre_m_s(contexto, lala_regla_gramatical.nombre_m_s, error);
        }
        if (ret) {
            ret = configurar_coma_parametro(contexto, lala_regla_gramatical.coma_parametro, error);
        }
        if (ret) {
            ret = configurar_coma_pasa_parametro(contexto, lala_regla_gramatical.coma_pasa_parametro, error);
        }
//        if (ret) {
//            ret = configurar_variables(contexto, lala_regla_gramatical.variables, error);
//        }
        if (ret) {
            ret = configurar_codigo_accion(contexto, lala_regla_gramatical.codigo_accion, error);
        }
        if (ret) {
            ret = configurar_variable_nombre(contexto, lala_regla_gramatical.variable_nombre, error);
        }
        if (ret) {
            ret = configurar_bloque_excepcion(contexto, lala_regla_gramatical.bloque_excepcion, error);
        }
        if (ret) {
            ret = configurar_finalmente(contexto, lala_regla_gramatical.finalmente, error);
        }
        if (ret) {
            ret = configurar_suma_4_espacios(contexto, lala_regla_gramatical.suma_4_espacios, error);
        }
        if (ret) {
            ret = configurar_resta_4_espacios(contexto, lala_regla_gramatical.resta_4_espacios, error);
        }
        if (ret) {
            ret = configurar_bloque_repetir(contexto, lala_regla_gramatical.bloque_repetir, error);
        }
        if (ret) {
            ret = configurar_salir(contexto, lala_regla_gramatical.salir, error);
        }
        if (ret) {
            ret = configurar_constante_numero(contexto, lala_regla_gramatical.constante_numero, error);
        }
        if (ret) {
            ret = configurar_constante_logica(contexto, lala_regla_gramatical.constante_logica, error);
        }
        if (ret) {
            ret = configurar_variable_o_parametro(contexto, lala_regla_gramatical.variable_o_parametro, error);
        }
        if (ret) {
            ret = configurar_variable_o_parametro_final(contexto, lala_regla_gramatical.variable_o_parametro_final, error);
        }
        if (ret) {
            ret = configurar_variable_o_parametro_final(contexto, lala_regla_gramatical.variable_o_parametro_final, error);
        }
        if (ret) {
            ret = configurar_llamada_acciones(contexto, lala_regla_gramatical.llamada_acciones, error);
        }
        if (ret) {
            ret = configurar_llamada_acciones_linea(contexto, lala_regla_gramatical.llamada_acciones_linea, error);
        }
        if (ret) {
            ret = configurar_llamada_accion(contexto, lala_regla_gramatical.llamada_accion, error);
        }
        if (ret) {
            ret = configurar_llamada_accion_fin(contexto, lala_regla_gramatical.llamada_accion_fin, error);
        }
        if (ret) {
            ret = configurar_codigo(contexto, lala_regla_gramatical.codigo, error);
        }
        if (ret) {
            ret = configurar_bloque_no_lala(contexto, lala_regla_gramatical.bloque_no_lala, error);
        }
        if (ret) {
            ret = configurar_texto_libre_no_lala(contexto, lala_regla_gramatical.texto_libre_no_lala, error);
        }
        if (ret) {
            ret = configurar_si_inicio(contexto, lala_regla_gramatical.si_inicio, error);
        }
        if (ret) {
            ret = configurar_bloque_contra(contexto, lala_regla_gramatical.bloque_contra, error);
        }
        if (ret) {
            ret = configurar_bloque_contra_fin(contexto, lala_regla_gramatical.bloque_contra_fin, error);
        }
        return ret;
    }
    
    public String obtener_texto_completo(contextos contexto, textos error) {
        String retorno = "";
        reglas_gramaticales_extendidas regla_en_curso = null;
        regla_en_curso = contexto.leer(lala_traductor_regla_en_curso).dar();
        retorno = regla_en_curso.lectura_temporal_texto.leer_texto();
        regla_en_curso.lectura_temporal_texto.poner("");
        return retorno;
    }                    
    
    public String obtener_resultado_texto(contextos contexto, textos error) {
        String retorno = "";
        reglas_gramaticales_extendidas regla_en_curso = null;
        regla_en_curso = contexto.leer(lala_traductor_regla_en_curso).dar();
        retorno = regla_en_curso.resultado_temporal_texto.leer_texto();
        return retorno;
    }                    
    
    public String obtener_texto(contextos contexto, textos error) {
        String retorno = "";
        retorno = obtener_texto_completo(contexto, error);
        retorno = retorno.trim();
        if (retorno.isEmpty()) {
            retorno = null;
        }
        return retorno;
    }                    
    
    public boolean poner_texto(contextos contexto, textos error) {
        boolean ret = true;
        String texto = "";
        texto = obtener_texto_completo(contexto, error);
        ret = (texto != null);
        if (ret) {
            ret = lala_resultado.escribir(contexto, texto, error);
        }
        return ret;
    }                    

    public boolean poner_accion(contextos contexto, textos error) {
        boolean ret = true;
        String texto_leido = "";
        String texto_java = "";
        texto_leido = obtener_texto(contexto, error);
        ret = (texto_leido != null);
        if (ret) {
            if (texto_leido.equals("accion local")) {
                texto_java = "\nprivate static i_eles ";
            } else if (texto_leido.equals("accion")) {
                texto_java = "\npublic static i_eles ";
            } else {
                ret = false;
            }
        }
        if (ret) {
            ret = lala_resultado.escribir(contexto, texto_java, error);
        }
        return ret;
    }                    

    public boolean poner_nombre_java(contextos contexto, textos error) {
        boolean ret = true;
        String texto = "";
        String texto_java = "";
        texto = obtener_texto(contexto, error);
        ret = (texto != null);
        if (ret) {
            texto_java = texto.replace(" ", "_");
            ret = lala_resultado.escribir(contexto, texto_java, error);
        }
        return ret;
    }                    

    public boolean poner_iniciar_clase(contextos contexto, textos error) {
        boolean ret = true;
        File salida = null;
        String nombre_clase = null;
        String texto_java = "";
        String ruta_salida = "";
        int pos = 0;
        reglas_gramaticales_extendidas regla_gramatical_extendida;
        regla_gramatical_extendida = contexto.leer(lala_traductor_regla_en_curso).dar();
        if (regla_gramatical_extendida.estado.equals(estado_final_bien)) {
            salida = contexto.leer(lala_resultados_salida_archivo).dar();
            ret = (salida != null);
            if (ret) {
                ruta_salida = salida.getAbsolutePath();
                pos = ruta_salida.lastIndexOf(".java");
                if (pos < 0) {
                    ret = false;
                    error.poner("El archivo de salida no tiene la extensión: java ");
                }
            }
            if (ret) {
                ruta_salida = ruta_salida.substring(0, pos);
                nombre_clase = salida.getName();
                pos = nombre_clase.lastIndexOf(".java");
                if (pos < 0) {
                    ret = false;
                    error.poner("El archivo de salida no tiene la extensión: java ");
                }
            }
            if (ret) {
                nombre_clase = nombre_clase.substring(0, pos);
                ret = nombre_clase.matches("[a-zñçáéíóú][a-zñçáéíóú0-9 ]*");
            }
            if (ret) {
                ret = validar_nombre_plural(nombre_clase, error);
            }
            if (ret) {
                pos = ruta_salida.lastIndexOf("/java/");
                if (pos < 0) {
                    ret = false;
                    error.poner("El archivo de salida está dentro de la carpeta: /java ");
                }
            }
            if (ret) {
                pos = pos + "/java/".length();
                ruta_salida = ruta_salida.substring(pos);
                if (ruta_salida.startsWith(File.separator)) {
                    ruta_salida = ruta_salida.substring(File.separator.length());
                }
                ruta_salida = ruta_salida.replace(File.separator, ".");
                texto_java = "package <carpeta_archivo>;\n"
                + "/* import */\n"
                + "import innui.contextos.bools;\n"
                + "import innui.contextos.i_eles;\n"
                + "import static java.lang.System.out;\n"
                + "import innui.contextos.acciones;\n"
                + "\n"
                + "public class <nombre_archivo_clase_java> {\n";
                texto_java = texto_java.replace("<nombre_archivo_clase_java>", nombre_clase);
                texto_java = texto_java.replace("<carpeta_archivo>", ruta_salida);
            }
        }
        if (ret) {
            ret = lala_resultado.escribir(contexto, texto_java, error);
        }
        return ret;
    }

    public static boolean validar_nombre_plural(String texto_plural, textos error) {
        boolean ret = true;
        if (texto_plural == null || texto_plural.trim().isEmpty()) {
            ret = false;
            error.poner("texto no indicado. ");
        } else {
            texto_plural = texto_plural.trim();
            if (texto_plural.endsWith("s") == false) {
                ret = false;
                error.poner( texto_plural + ": debe estar en plural. ");
            }
        }
        return ret;
    }                    
    
    public boolean configurar_elementos_comunes(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_fin_opcion, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               ret = lala_resultado.hacer_temporal_definitivo((contextos) contexto, (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });  
        return ret;
    }

    public boolean configurar_inicio_lala(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               ret = poner_iniciar_clase((contextos) contexto, (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });  
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.programa_lala.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               obtener_texto((contextos) contexto, (textos) error);
               ret = lala_resultado.escribir((contextos) contexto, "}\n", (textos) error);
               return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_programa_lala(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               ret = lala_resultado.escribir((contextos) contexto, "\n", (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_comentario_multilinea(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               ret = poner_texto((contextos) contexto, (textos) error);
               return new bools(ret);
            }
        });  
        return ret;
    }

    public boolean configurar_acciones(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.declaracion_accion.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               ret = poner_accion((contextos) contexto, (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });  
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nombre_accion.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                ret = poner_nombre_java((contextos) contexto, (textos) error);
                return new bools(ret);
            }
        });          
        regla_gramatical.acciones_tras_regla_mapa.put("(", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " (", (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });          
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.acciones_fin.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                espacios_num = espacios_num - 4;
                obtener_texto((contextos) contexto, (textos) error);
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "}", (textos) error);
                }
                return new bools(ret);
            }
        });          
        return ret;
    }
    
    public boolean configurar_acciones_fin(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("nueva_linea", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " ) {", (textos) error);
                return new bools(ret);
            }
        });          
        regla_gramatical.acciones_tras_regla_mapa.put("retornar", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "return", (textos) error);
                }
                return new bools(ret);
            }
        });          
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nulo.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, " ret;", (textos) error);
                }
                return new bools(ret);
            }
        });          
        return ret;
    }

    public boolean configurar_subacciones(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("subaccion", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "acciones ", (textos) error);
                }
                return new bools(ret);
            }
        });  
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nombre_accion.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                if (ret) {
                    ret = poner_nombre_java((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, " = new acciones ( ) {", (textos) error);
                }
                if (ret) {
                    espacios_num = espacios_num + 4;
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "@Override", (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "public i_eles ir ", (textos) error);
                }
                return new bools(ret);
            }
        });  
        regla_gramatical.acciones_tras_regla_mapa.put("(", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " (", (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });          
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.acciones_fin.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                espacios_num = espacios_num - 4;
                obtener_texto((contextos) contexto, (textos) error);
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "    }", (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "    @Override", (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "    public int dar_num () {", (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "        return " + parametros_num + ";", (textos) error);
                    parametros_num = 0;
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "    }", (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "};", (textos) error);
                }
                return new bools(ret);
            }
        });          
        return ret;
    }

    public boolean configurar_comentario_doc(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                ret = poner_texto((contextos) contexto, (textos) error);
                error.poner(error);
                return new bools(ret);
            }
        });  
        return ret;
    }

    public boolean configurar_comentario_linea(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               ret = poner_texto((contextos) contexto, (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });  
        return ret;
    }

    public boolean configurar_texto_libre_hasta_param(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               ret = poner_texto((contextos) contexto, (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_texto_libre_hasta_return(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               ret = poner_texto((contextos) contexto, (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_texto_libre_hasta_fin_comentario(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
               boolean ret = true;
               ret = poner_texto((contextos) contexto, (textos) error);
               error.poner(error);
               return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_parametros(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " i_eles ", (textos) error);
                parametros_num = 1;
                return new bools(ret);
            }
        });  
        regla_gramatical.acciones_tras_regla_mapa.put("...", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, ", i_eles ... i_eles_array", (textos) error);
                return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_parametros_subaccion(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " i_eles ", (textos) error);
                parametros_num = 1;
                return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_nombre_m_s(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                String texto;
                texto = obtener_texto((contextos) contexto, (textos) error);
                ret = (texto != null);
                if (ret) {
                    texto = texto.replace(" ", "_");
                    ret = lala_resultado.escribir((contextos) contexto, texto, (textos) error);
                }
                return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_coma_parametro(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(",", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, ",", (textos) error);
                parametros_num = parametros_num + 1;
                return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_coma_pasa_parametro(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(",", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, ",", (textos) error);
                return new bools(ret);
            }
        });  
        return ret;
    }
    
//    public boolean configurar_variables(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
//        boolean ret = true;
//        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
//        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nombre_m_s.id, new acciones.de_2 () {
//            @Override
//            protected bools ir(i_eles contexto, i_eles error) {
//                boolean ret = true;
//                obtener_texto((contextos) contexto, (textos) error);
//                ret = lala_resultado.escribir((contextos) contexto, ";", (textos) error);
//                return new bools(ret);
//            }
//        });  
//        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nueva_linea.id, new acciones.de_2 () {
//            @Override
//            protected bools ir(i_eles contexto, i_eles error) {
//                boolean ret = true;
//                obtener_texto((contextos) contexto, (textos) error);
//                ret = poner_linea_espacios((contextos) contexto, (textos) error);
//                return new bools(ret);
//            }
//        });  
//        return ret;
//    }
    
    public boolean configurar_codigo_accion(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.espacios_bien.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, 
                              "/* variable */"
                            , (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, 
                            "i_eles ret = new bools ( true );"
                            , (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_variable_nombre(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, 
                        "i_eles "
                        , (textos) error);
                return new bools(ret);
            }
        });  
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nombre_m_s.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, ";", (textos) error);
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                return new bools(ret);
            }
        });  
        return ret;
    }

    public boolean poner_linea_espacios(contextos contexto, textos error) {
        boolean ret = true;
        String espacio = "\n";
        int i = 0;
        while (true) {
            if (i >= espacios_num) {
                break;
            }
            espacio = espacio + " ";
            i = i + 1;
        }
        ret = lala_resultado.escribir((contextos) contexto, espacio, (textos) error);
        return ret;
    }
    
    public boolean configurar_bloque_excepcion(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("tratable", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "try {", (textos) error);
                }
                return new bools(ret);
            }
        });  
        regla_gramatical.acciones_tras_regla_mapa.put("captura", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "} catch ( Exception e ) {", (textos) error);
                }
                return new bools(ret);
            }
        });  
        regla_gramatical.acciones_tras_regla_mapa.put("bloque_codigo*", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                String resultado;
                resultado = obtener_resultado_texto((contextos) contexto, (textos) error);
                if (resultado.endsWith("{")) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                    if (ret) {
                        ret = lala_resultado.escribir((contextos) contexto, "    throw new RuntimeException ( e );", (textos) error);
                    }
                }
                return new bools(ret);
            }
        });  
        regla_gramatical.acciones_tras_regla_mapa.put("/tratable", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "}", (textos) error);
                }
                return new bools(ret);
            }
        });  
        return ret;
    }
    
    public boolean configurar_suma_4_espacios(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                espacios_num = espacios_num + 4;
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_resta_4_espacios(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                espacios_num = espacios_num - 4;
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_finalmente(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "} finally {", (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_bloque_repetir(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("repetir", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "while ( true ) {", (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "    if ( ret.no_es ( ) ) {", (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "        break;", (textos) error);
                }
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "    }", (textos) error);
                }
                return new bools(ret);
            }
        });
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.bloque_repetir_fin.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "}", (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_salir(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "break;", (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_constante_numero(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                String constante;
                constante = obtener_texto((contextos) contexto, (textos) error);
                ret = (constante != null);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, " " + constante, (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_constante_logica(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("verdad", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " true", (textos) error);
                return new bools(ret);
            }
        });
        regla_gramatical.acciones_tras_regla_mapa.put("falso", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " false", (textos) error);
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_variable_o_parametro(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(".", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, ".", (textos) error);
                }
                return new bools(ret);
            }
        });
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nombre_m_s.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                String nombre_m_s;
                nombre_m_s = obtener_texto((contextos) contexto, (textos) error);
                ret = (nombre_m_s != null);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, " " + nombre_m_s, (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_variable_o_parametro_final(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("(", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " (", (textos) error);
                return new bools(ret);
            }
        });
        regla_gramatical.acciones_tras_regla_mapa.put(")", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " )", (textos) error);
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_llamada_acciones(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nueva_linea.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, ";\n", (textos) error);
                return new bools(ret);
            }
        });
        return ret;
    }
        
    public boolean configurar_llamada_acciones_linea(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, "if ( ret.es ( ) ) {", (textos) error);
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "    ret = ", (textos) error);
                }
                return new bools(ret);
            }
        });
//        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.llamada_acciones_simple.id, new acciones.de_2 () {
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.llamada_accion.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, ";", (textos) error);
                if (ret) {
                    ret = poner_linea_espacios((contextos) contexto, (textos) error);
                }
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "}", (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }
    
    public boolean configurar_llamada_accion(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nombre_accion.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                ret = poner_nombre_java((contextos) contexto, (textos) error);
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_llamada_accion_fin(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("]", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                String ruta;
                ruta = obtener_texto((contextos) contexto, (textos) error);
                ret = (ruta != null);
                if (ret) {
                    ruta = ruta.replace("[", " /*");
                    ruta = ruta.replace("]", "*/");
                    ret = lala_resultado.escribir((contextos) contexto, ruta, (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_codigo(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.espacios_bien.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_bloque_no_lala(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("no_lala", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, "out.print ( ", (textos) error);
                return new bools(ret);
            }
        });
        regla_gramatical.acciones_tras_regla_mapa.put("/no_lala", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " );", (textos) error);
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_texto_libre_no_lala(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(accion_tras_regla_0, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                String texto;
                texto = obtener_texto((contextos) contexto, (textos) error);
                ret = (texto != null);
                if (ret) {
                    texto = texto.replace("\\", "\\\\");
                    texto = texto.replace("\"", "\\\"");
                    texto = texto.replace("\n", "\\n");
                    texto = texto.replace("\t", "\\t");
                    texto = texto.replace("\r", "\\r");
                    texto = texto.replace("\f", "\\f");
                    texto = "\"" + texto + "\"";
                    ret = lala_resultado.escribir((contextos) contexto, texto, (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_si_inicio(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("si", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, "if ( ", (textos) error);
                return new bools(ret);
            }
        });
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.condicion.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " ) {", (textos) error);
                return new bools(ret);
            }
        });
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.bloque_codigo.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "}", (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_bloque_contra(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put("contra", new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, " else ", (textos) error);
                return new bools(ret);
            }
        });
        return ret;
    }

    public boolean configurar_bloque_contra_fin(contextos contexto, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        ret = configurar_elementos_comunes(contexto, regla_gramatical, error);
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.nueva_linea.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = lala_resultado.escribir((contextos) contexto, "{", (textos) error);
                return new bools(ret);
            }
        });
        regla_gramatical.acciones_tras_regla_mapa.put(lala_regla_gramatical.bloque_codigo.id, new acciones.de_2 () {
            @Override
            protected bools ir(i_eles contexto, i_eles error) {
                boolean ret = true;
                obtener_texto((contextos) contexto, (textos) error);
                ret = poner_linea_espacios((contextos) contexto, (textos) error);
                if (ret) {
                    ret = lala_resultado.escribir((contextos) contexto, "}", (textos) error);
                }
                return new bools(ret);
            }
        });
        return ret;
    }

}
