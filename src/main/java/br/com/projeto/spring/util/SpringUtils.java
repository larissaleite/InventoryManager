
package br.com.projeto.spring.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class SpringUtils implements ApplicationContextAware {
	private static ApplicationContext context;
	
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
			context = applicationContext;
		
		
	}
	
	public static Object getBean(String beanName) throws BeansException {
		return context.getBean(beanName);
	}




	
}
