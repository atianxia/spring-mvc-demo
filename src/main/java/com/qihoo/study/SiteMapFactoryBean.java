package com.qihoo.study;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoyong on 16-10-20.
 */
public class SiteMapFactoryBean implements FactoryBean<Map<String, String>>, InitializingBean {
    private Map<String, String> siteMap;

    @Override
    public Map<String, String> getObject() throws Exception {
        return siteMap;
    }

    @Override
    public Class<?> getObjectType() {
        return HashMap.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        siteMap = objMapper.readValue(new File("/opt/mgsiteconf/site.json"),
                new TypeReference<HashMap<String, Object>>() {
                });
    }
}
