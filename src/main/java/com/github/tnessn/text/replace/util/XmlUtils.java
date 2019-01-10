package com.github.tnessn.text.replace.util;
import java.io.File;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlUtils {

    /**
     * XML转对象
     * @param clazz 对象类
     * @param str xml字符串
     * @param <T> T
     * @return
     */
    public static <T> T parseFromXml(Class<T> clazz, String xml) {
        //创建解析XML对象
        XStream xStream = new XStream(new DomDriver());
        //处理注解
        xStream.processAnnotations(clazz);
        @SuppressWarnings("unchecked")
        //将XML字符串转为bean对象
        T t = (T)xStream.fromXML(xml);
        return t;
    }
    
    /**
     * XML转对象
     * @param clazz 对象类
     * @param str xml字符串
     * @param <T> T
     * @return
     */
    public static <T> T parseFromXml(Class<T> clazz, File xmlFile) {
        //创建解析XML对象
        XStream xStream = new XStream(new DomDriver());
        //处理注解
        xStream.processAnnotations(clazz);
        @SuppressWarnings("unchecked")
        //将XML字符串转为bean对象
        T t = (T)xStream.fromXML(xmlFile);
        return t;
    }

    /**
     * 对象转xml
     * @param obj 对象
     * @return
     */
    public static String toXml(Object obj) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(obj.getClass());
        return xStream.toXML(obj);
    }

}