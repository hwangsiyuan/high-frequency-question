package com.hussein;

import com.hussein.lifecycle.StudentBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {

    /**
     * --------------【初始化容器】---------------
     * 【BeanFactoryPostProcessor接口】调用BeanFactoryPostProcessor实现类构造方法
     * 【BeanFactoryPostProcessor接口】调用BeanFactoryPostProcessor接口的postProcessBeanFactory方法
     * 【BeanPostProcessor接口】调用BeanPostProcessor的构造方法
     * 【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor构造方法
     * 【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessBeforeInstantiation方法
     * 【Bean构造方法】学生类的无参构造方法
     * 【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessPropertyValues方法
     * 【set注入】注入学生的name属性
     * 【set注入】注入学生的age属性
     * 【BeanNameAware接口】调用BeanNameAware的setBeanName方法得到Bean的名称
     * 【BeanFactoryAware接口】调用BeanFactoryAware的setBeanFactory方法得到beanFactory引用
     * 【BeanPostProcessor接口】调用postProcessBeforeInitialization方法，这里可对studentBean的属性进行更改。
     * 【InitializingBean接口】调用InitializingBean接口的afterPropertiesSet方法
     * 【init-method】调用init-method属性配置的初始化方法
     * 【BeanPostProcessor接口】调用postProcessAfterInitialization方法，这里可对studentBean的属性进行更改。
     * 【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessAfterInitialization方法
     * -------------------【容器初始化成功】------------------
     * StudentBean{name='zwj', age=21, beanName='studentBean'}
     * --------------------【销毁容器】----------------------
     * 【DisposableBean接口】调用DisposableBean接口的destroy方法
     * 【destroy-method】调用destroy-method属性配置的销毁方法
     */
    public static void main(String[] args) {
        System.out.println("--------------【初始化容器】---------------");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifecycle.xml");
        System.out.println("-------------------【容器初始化成功】------------------");
        //得到studentBean，并显示其信息
        StudentBean studentBean = context.getBean("studentBean", StudentBean.class);
        System.out.println(studentBean);
        System.out.println("--------------------【销毁容器】----------------------");
        context.registerShutdownHook();
    }
}
