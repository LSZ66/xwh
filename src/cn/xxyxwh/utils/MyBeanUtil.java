package cn.xxyxwh.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MyBeanUtil {

    public static <BeanObject> BeanObject createBeanByRequest(Class clazz, HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        Map<String, String[]> map = request.getParameterMap();
        Map<String, String> beanMap = new HashMap<>();
        for (String key : map.keySet())
            beanMap.put(key, StringUtils.join(map.get(key), ","));
        Object bean;
        try {
            bean = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.populate(bean, beanMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (BeanObject) bean;
    }
}
