package com.etoak.bbs.web.springboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 主程序入口
 * 
 * @author lsc
 *
 */
@SpringBootApplication
@Component
@ServletComponentScan
@Configuration  
@ComponentScan("com.etoak.bbs.web")
@EnableAutoConfiguration  
public class Application extends SpringBootServletInitializer {
//WebMvcConfigurerAdapter{

	public static Log logger = LogFactory.getLog(Application.class);

	/**
	 * 保存Context ，便于使用。
	 */
	private static ApplicationContext ctx;

	public static ApplicationContext getCtx() {
		return ctx;
	}
//
//	public static void ShowBeans() {
//		String[] beanNames = getCtx().getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
//	}
//	/**
//	 * 启动springboot
//	 * */
//	public static void main(String[] args) throws SQLException {
//		ctx = SpringApplication.run(Application.class, args);
//		System.out.println("启动完毕!!");
//
//	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}