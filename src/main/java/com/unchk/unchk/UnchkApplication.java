package com.unchk.unchk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.unchk.unchk.services.UserService;

@SpringBootApplication
@EnableJpaAuditing
public class UnchkApplication implements CommandLineRunner {

	// @Autowired
	// GroupeService groupeService;
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UnchkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// for (int i = 0; i < 4; i++) {
		// userService
		// .addEntity(
		// UserApp.builder().nom("user" +
		// i).adresse("adresse").email("ecm@gmail" + i).password("password"
		// + i)
		// .prenom("prenom").profil(Profil.Admin).telephone("telephone").status(Status.Actif)
		// .sexe(Sexe.M)
		// .build());
		// }

		System.out.println("Server at started on :: 2323");
	}

}
