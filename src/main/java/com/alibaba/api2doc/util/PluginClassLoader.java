package com.alibaba.api2doc.util;


import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {
    public PluginClassLoader(URL[] urls) {
        super(urls, PluginClassLoader.class.getClassLoader());
    }

    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        /** try to use parent ClassLoader */
        ClassLoader parent = PluginClassLoader.class.getClassLoader();
        Class<?> c = null;
        try {
            c = parent.loadClass(name);
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            // DO Nothing
        }
        /** if parent load failed,load by self */
        if (c == null) {
            /** check if the class has already been loaded */
            c = findLoadedClass(name);
            if (c == null) {
                /** find and load from urls */
                c = findClass(name);
            }
        }
        if (resolve) {
            resolveClass(c);
        }
        return c;
    }
}
