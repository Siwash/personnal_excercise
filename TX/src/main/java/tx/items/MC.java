package tx.items;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MC {

	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Inser inser=context.getBean(Inser.class);
		inser.insert();
		

	}

}
