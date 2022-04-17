package com.spring.sourcecode.springframework.context.supprot;

/**
 * @Author df
 * @Date 2022/1/8 21:47
 * @Version 1.0
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    // 获取配置文件的路径集合：如classpath:useContext.xml
    private String[] configLoctions;

    public ClassPathXmlApplicationContext() {
    }

    /*
     * @Author df
     * @Description 从xml中加载BeanDefinition并刷新上下文。
     * @Date 10:26 2021/11/30
     * @Param [configLocations]
     * @return
     **/
    public ClassPathXmlApplicationContext(String configLocations) {
        this(new String[]{configLocations});
    }

    /*
     * @Author df
     * @Description 从xml中加载BeanDefinition并刷新上下文。
     * @Date 10:26 2021/11/30
     * @Param [configLocations]
     * @return
     **/
    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLoctions = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLoctions;
    }
}