package com.qihoo.study;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by luoyong on 16-10-20.
 */
public class TestJson  implements InitializingBean, BeanFactoryAware{
    private String jobService;

    public String getJobService() {
        return jobService;
    }

    public void setJobService(String jobService) {
        this.jobService = jobService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
