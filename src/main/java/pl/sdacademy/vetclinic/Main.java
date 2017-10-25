package pl.sdacademy.vetclinic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.sdacademy.vetclinic.service.PetService;

public class Main {

	public Main() {
	}
	
	public static void main(String[] args) {
		runApplication();
	}

	private static void runApplication() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Application service = context.getBean("application", Application.class);
		service.printGeneralSummary();
	}
	
	private static void generateData() {
		InputDataGenerator dataGenerator = new InputDataGenerator();
		dataGenerator.generateSampleData();
	}
}
