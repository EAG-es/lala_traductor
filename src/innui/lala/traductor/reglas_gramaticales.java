/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.lala.traductor;

import innui.contextos.acciones;
import innui.contextos.contextos;
import innui.contextos.textos;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author emilio
 */
public class reglas_gramaticales {
    public String id = "";
    public LinkedHashMap<String, reglas_gramaticales_extendidas> reglas_gramaticales_mapa = null;
    public Map<String,acciones.de_2> acciones_tras_regla_mapa = null;
    public Map<String,acciones.de_4> lecturas_y_comprobaciones_tras_regla_mapa = null;
    public acciones.de_3 devolver_texto = null;
    reglas_gramaticales_extendidas regla_gramatical_extendida = null;
    
    public reglas_gramaticales() {
        reglas_gramaticales_mapa = new LinkedHashMap();
        acciones_tras_regla_mapa = new HashMap();
        lecturas_y_comprobaciones_tras_regla_mapa = new HashMap();
    }

    public boolean poner_regla_opcional(String nombre, reglas_gramaticales regla_gramatical, int opcional_hasta_num, textos error) {
        boolean ret = true;
        reglas_gramaticales_extendidas nueva_regla_gramatical_extendida;
        if (reglas_gramaticales_mapa.containsKey(nombre)) {
            ret = false;
            error.poner("No se pueden poner dos nombres iguales en la misma regla. ");
        } else {
            nueva_regla_gramatical_extendida = new reglas_gramaticales_extendidas();
            ret = nueva_regla_gramatical_extendida.configurar_opcional(regla_gramatical, opcional_hasta_num, false, error);
            reglas_gramaticales_mapa.put(nombre, nueva_regla_gramatical_extendida);
        }
        return ret;
    }
    
    public boolean poner_regla_opcional_con_opcion_vacia(String nombre, reglas_gramaticales regla_gramatical, int opcional_hasta_num, textos error) {
        boolean ret = true;
        reglas_gramaticales_extendidas nueva_regla_gramatical_extendida;
        if (reglas_gramaticales_mapa.containsKey(nombre)) {
            ret = false;
            error.poner("No se pueden poner dos nombres iguales en la misma regla. ");
        } else {
            nueva_regla_gramatical_extendida = new reglas_gramaticales_extendidas();
            ret = nueva_regla_gramatical_extendida.configurar_opcional(regla_gramatical, opcional_hasta_num, true, error);
            reglas_gramaticales_mapa.put(nombre, nueva_regla_gramatical_extendida);
        }
        return ret;
    }
    
    public boolean poner_regla_obligatoria(String nombre, reglas_gramaticales regla_gramatical, textos error) {
        boolean ret = true;
        reglas_gramaticales_extendidas nueva_regla_gramatical_extendida;
        if (reglas_gramaticales_mapa.containsKey(nombre)) {
            ret = false;
            error.poner("No se pueden poner dos nombres iguales en la misma regla. ");
        } else {
            nueva_regla_gramatical_extendida = new reglas_gramaticales_extendidas();
            ret = nueva_regla_gramatical_extendida.configurar_obligatoria(regla_gramatical, nueva_regla_gramatical_extendida.error_continuable_desde_num, error);
            reglas_gramaticales_mapa.put(nombre, nueva_regla_gramatical_extendida);
        }
        return ret;
    }
    
    public boolean poner_regla_obligatoria_continuable_desde_num(String nombre, reglas_gramaticales regla_gramatical, int error_continuable_desde_num, textos error) {
        boolean ret = true;
        reglas_gramaticales_extendidas nueva_regla_gramatical_extendida;
        if (reglas_gramaticales_mapa.containsKey(nombre)) {
            ret = false;
            error.poner("No se pueden poner dos nombres iguales en la misma regla. ");
        } else {
            nueva_regla_gramatical_extendida = new reglas_gramaticales_extendidas();
            ret = nueva_regla_gramatical_extendida.configurar_obligatoria(regla_gramatical, error_continuable_desde_num, error);
            reglas_gramaticales_mapa.put(nombre, nueva_regla_gramatical_extendida);
        }
        return ret;
    }
    
    public String procesar_regla_gramatical_extendida(contextos contexto, textos error) {
        regla_gramatical_extendida = new reglas_gramaticales_extendidas();
        regla_gramatical_extendida.regla_gramatical = this;
        return regla_gramatical_extendida.procesar_regla(contexto, error);
    }
}
