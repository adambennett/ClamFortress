package com.zipcode.justcode.clamfortress.ClamFortress;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClamFortress {

	public static void main(String[] args) {
		SpringApplication.run(ClamFortress.class, args);
		MainApp mainApp = new MainApp();
		mainApp.initialize();
	}

}
