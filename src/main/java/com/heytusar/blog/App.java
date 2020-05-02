package com.heytusar.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
public class App /*implements CommandLineRunner*/ {
	
	/*
	@Autowired
    private DatabaseConfig databaseConfig;
	*/
	
	/*
    public static void main(String[] args) {
        System.out.println( "Hello World!123" );
        SpringApplication.run(App.class, args);
    }
    */
	
    public static void main(String[] args) {
    	System.out.println( "Hello World!123" );
        SpringApplicationBuilder parentBuilder = new SpringApplicationBuilder(App.class);
        parentBuilder.run(args);
    }
    
    /**
	 * This method will be executed after the application context is loaded and
	 * right before the Spring Application main method is completed.
	 */
    /*
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("databaseConfig ---> " + databaseConfig.getDriverClassName());
    	System.out.println("databaseConfig ---> " + databaseConfig.getUrl());
    	System.out.println("databaseConfig ---> " + databaseConfig.getUsername());
    	System.out.println("databaseConfig ---> " + databaseConfig.getPassword());
	}
	
	
    public void onApplicationEvent(ApplicationReadyEvent e) {
        if (e.getApplicationContext().getParent() == null) {
            System.out.println("******************************");
            System.out.println("Post-process begins.");
            System.out.println("******************************");      
        }
    }
    
    public void run(String... args) {
    	System.out.println("databaseConfig ---> " + databaseConfig.getDriverClassName());
    	System.out.println("databaseConfig ---> " + databaseConfig.getUrl());
    	System.out.println("databaseConfig ---> " + databaseConfig.getUsername());
    	System.out.println("databaseConfig ---> " + databaseConfig.getPassword());
    }
    */
}
