package framework.engine.utils;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class LoadProperties {

    public static Properties loadProperties(){
        String file = "config";
        //Obtengo un objeto enumeracion con las llaves del archivo
        Properties propiedades = new Properties();
        ResourceBundle bundle = ResourceBundle.getBundle(file);
        Enumeration<String> e = bundle.getKeys();

        //guardo las propiedades del archivo en el objeto propiedades
        String key;
        while (e.hasMoreElements()){
            key = (String) e.nextElement();
            propiedades.put(key,bundle.getObject(key));
        }
        return propiedades;
    }
}
