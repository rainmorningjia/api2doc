package com.alibaba.api2doc;

import com.alibaba.api2doc.entity.MailPerson;
import com.alibaba.api2doc.entity.Province;
import com.alibaba.api2doc.service.MailPersonService;
import com.alibaba.api2doc.service.ProvinceService;
import com.alibaba.api2doc.util.PluginClassLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Api2docApplicationTests {

    @Resource
    MailPersonService mailPersonService;
    @Resource
    ProvinceService provinceService;
    @Autowired
    DataSource datasource;

    @Test
    public void contextLoads() {
        List<MailPerson> mailPeople = mailPersonService.queryAllMailPerson();
        for (MailPerson mailPerson : mailPeople) {
            System.out.println(mailPeople);
        }

    }

    @Test
    public void province() {
        List<Province> list = provinceService.queryAllProvince();
        for (Province province : list) {
            System.out.println(list);
        }
    }

    @Test
    public void testClassLoader() throws Exception {
        String url = "file:D:\\jiachenyu\\classloader-1.0.0-SNAPSHOT.jar";
        PluginClassLoader pluginClassLoader = new PluginClassLoader(new URL[]{new URL(url)});
        JarFile jarFile = new JarFile(new File("D:\\jiachenyu\\classloader-1.0.0-SNAPSHOT.jar"));
        Enumeration<JarEntry> es = jarFile.entries();
        while (es.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) es.nextElement();
            String name = jarEntry.getName();
            if (name != null && name.endsWith(".class")) {
                Class<?> test = pluginClassLoader.loadClass(name.replace("/", ".").substring(0, name.length() - 6));
                System.out.println(name.replace("/", ".").substring(0, name.length() - 6));
            }
        }


    }

}
