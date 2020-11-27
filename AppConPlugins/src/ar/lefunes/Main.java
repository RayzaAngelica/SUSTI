package ar.lefunes;
 
import plugins.plugins;
import ar.lefunes.plugins.IPluginMensaje;
 
public class Main {
 
    public static void main(String[] args) {
        System.out.println("-------------------------------");
 
        //se cargan los jars del directorio "plugins" al classpath
        boolean cargados = plugins.cargarPlugins();
 
        if (cargados) {
            try {
                //obtiene una instancia de cada plugin IPluginMensaje encontrado
                IPluginMensaje[] avisadores = plugins.getPlugins();
 
                if (avisadores.length > 0) {
                    for (IPluginMensaje a : avisadores) {
                        //por cada plugin muestra la clase y el mensaje que devuelve
                        System.out.println("Plugin: \t" + a.getClass().getCanonicalName());
                        System.out.println("Mensaje:\t" + a.getMensaje());
                        System.out.println();
                    }
                } else {
                    System.out.println("No se Encontraron Plugins");
                }
            } catch (Exception ex) {
                System.err.println("Excepcion: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            System.out.println("Plugins No Cargados");
        }
 
        System.out.println("-------------------------------");
    }
}