package com.unchk.unchk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.unchk.unchk.services.GroupeService;

@SpringBootApplication
@EnableJpaAuditing
public class UnchkApplication implements CommandLineRunner {

	@Autowired
	GroupeService groupeService;

	public static void main(String[] args) {
		SpringApplication.run(UnchkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// for (int i = 0; i < 10; i++) {
		// groupeService
		// .addEntity(
		// Groupe.builder().nom("UAB" +
		// i).heureTotalEffectue(0).heureTotalNonEffectue(0).build());
		// }
		System.out.println("Server at started on :: 2323");
	}

}
