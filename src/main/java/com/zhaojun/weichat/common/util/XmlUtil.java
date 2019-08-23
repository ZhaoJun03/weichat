package com.zhaojun.weichat.common.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDomDriver;
import com.zhaojun.weichat.common.annotaion.XStreamCDATA;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhaoJun
 * @date 2019/8/22 15:08
 */
@Slf4j
public class XmlUtil {
    private static final XStream xStream = XStreamFactory.getXStream();
    public static Map<String, String> parseXml(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(16);
        try (InputStream is = request.getInputStream()) {
            SAXReader reader = new SAXReader();
            Document document = reader.read(is);
            Element root = document.getRootElement();
            List<Element> elementList = root.elements();
            for (Element e : elementList) {
                map.put(e.getName(), e.getText());
            }
        } catch (IOException | DocumentException e) {
            log.error(e.getMessage(), e);
        }
        return map;
    }

    public static<T> T toBean(Class<T> clazz, String xml) {
        Object xmlObject;
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        xstream.autodetectAnnotations(true);
        xmlObject= xstream.fromXML(xml);
        return (T) xmlObject;
    }
    /**
     * 对象转xml
     * @param obj 对象
     * @return
     */
    public static String toXml(Object obj) {
        xStream.processAnnotations(obj.getClass());
        return xStream.toXML(obj);
    }

    static class XStreamFactory {
        public static final String CDATA_PREFIX = "<![CDATA[";
        public static final String CDATA_SUFFIX = "]]>";
        public static XStream getXStream() {
            final NameCoder nameCoder = new NoNameCoder();
            XStream xStream = new XStream(new XppDomDriver(nameCoder) {
                @Override
                public HierarchicalStreamWriter createWriter(Writer out) {
                    return new PrettyPrintWriter(out, nameCoder) {
                        boolean cdataFlag = false;
                        Class<?> targetClass = null;
                        @Override
                        public void startNode(String name, Class clazz) {
                            super.startNode(name, clazz);
                            if (targetClass == null) {
                                targetClass = clazz;
                            }
                            cdataFlag = isCDATA(targetClass, name);
                        }
                        @Override
                        public void writeText(QuickWriter writer, String text) {
                            if (cdataFlag) {
                                writer.write(CDATA_PREFIX);
                                writer.write(text);
                                writer.write(CDATA_SUFFIX);
                            } else {
                                writer.write(text);
                            }
                        }
                    };
                }
            });
            return xStream;
        }
        private static boolean isCDATA(Class<?> clazz, String fieldAlias) {
            //检查类本身
            boolean cdataFlag = isExistCDATA(clazz, fieldAlias);
            if (cdataFlag) {
                return cdataFlag;
            }
            //继续检查父类
            Class<?> superClazz = clazz.getSuperclass();
            while (!superClazz.equals(Object.class)) {
                cdataFlag = isExistCDATA(superClazz, fieldAlias);
                if (cdataFlag) {
                    return cdataFlag;
                }
                superClazz = superClazz.getClass().getSuperclass();
            }
            return false;
        }
        /**
         * 检查是否有 @XStreamCDATA 注解
         * @param clazz clazz
         * @param fieldAlias fieldAlias
         * @return
         */
        private static boolean isExistCDATA(Class<?> clazz, String fieldAlias) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.getAnnotation(XStreamCDATA.class) != null) {
                    XStreamAlias xStreamAlias = field.getAnnotation(XStreamAlias.class);
                    if (xStreamAlias != null && fieldAlias.equals(xStreamAlias.value())) {
                        return true;
                    } else {
                        if (fieldAlias.equals(field.getName())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
