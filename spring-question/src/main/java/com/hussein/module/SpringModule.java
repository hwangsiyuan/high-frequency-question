package com.hussein.module;

/**
 * <p>Title: SpringModule</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/22 3:13 PM
 */
public class SpringModule {

    public static void main(String[] args) {
        /**
         * Jdbc                 ORM             WebSocket              Servlet
         * OXM                  JMS             Web                    Portlet
         *        Transaction
         *
         * Aop                  Aspects         Instrumentation        Messaging
         *
         * Core                 Bean            Context                SpEL
         *                              Test
         *
         * 1、Spring的Core模块 是Spring的核心类库，Spring的所有功能都依赖于该类库，Core主要实现IOC功能，Spring的所有功能都是借助IOC实现的。
         * 2、Spring的AOP模块  是Spring的AOP库，提供了AOP（拦截器）机制，并提供常用的拦截器，供用户自定义和配置。
         * 3、Spring的ORM模块  提供对常用的ORM框架的管理和辅助支持，Spring支持常用的Hibernate，ibtas，jdao等框架的支持，Spring本身并不对ORM进行实现，仅对常见的ORM框架进行封装，并对其进行管理
         * 4、Spring的DAO模块  提供对JDBC的支持，对JDBC进行封装，允许JDBC使用Spring资源，并能统一管理JDBC事物，并不对JDBC进行实现。（执行sql语句）
         * 5、Spring的Web模块  WEB模块提供对常见框架如Struts1，WEBWORK（Struts 2），JSF的支持，Spring能够管理这些框架，将Spring的资源注入给框架，也能在这些框架的前后插入拦截器。
         * 6、Spring的Context模块 提供框架式的Bean访问方式，其他程序可以通过Context访问Spring的Bean资源，相当于资源注入。
         * 7、Spring的MVC模块  为Spring提供了一套轻量级的MVC实现，在Spring的开发中，我们既可以用Struts也可以用Spring自己的MVC框架，相对于Struts，Spring自己的MVC框架更加简洁和方便。
         */
        System.out.println("Spring module.");
    }
}
