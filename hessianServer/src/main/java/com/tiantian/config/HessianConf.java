package com.tiantian.config;

import com.tiantian.hessianserver.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;


/**
 * Created by 951087952@qq.com on 2017/8/21.
 *
 * 由于Hessian是基于HTTP的，所以HessianServiceExporter实现为一个SpringMvc控制器。这意味着为了使用导出的Hessian服务
 * ，我们需要执行两个额外的配置步骤：
 *
 *          1.在web.xml中配置spring的DispatcherServlet，并把我们的应用部署为web应用，
 *          2.在spring的配置文件中配置一个URL处理器，把Hessian服务的URL分发给对应的Hessian服务Bean
 */
@Configuration
@ComponentScan("com.tiantian.hessianserver.service")
public class HessianConf {

//    @Bean(name = "/userService.service")
    @Bean
    public HessianServiceExporter hessianServiceExporter(UserService userService){
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(userService);
        exporter.setServiceInterface(UserService.class);
        return exporter;
    }

    /**
     * 将springmvc请求转发给Hessian服务，所以要配置一个URL映射来确保DispatcherServlet把请求转发给myService
     * @return
     */
    @Bean
    public HandlerMapping handlerMapping(){
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.setProperty("/userService.service","hessianServiceExporter");
        mapping.setMappings(mappings);
        return mapping;
    }

}
