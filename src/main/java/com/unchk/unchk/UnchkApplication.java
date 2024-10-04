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
		// Set<Module> modules = new HashSet<Module>();

		// modules.add(
		// Module.builder()
		// .id("a42367a0-628c-4899-b885-32064a818588")
		// .build());

		// for (int i = 0; i < 3; i++) {
		// userService
		// .addEntity(
		// UserApp.builder().nom("admin " +
		// i).adresse("adresse " + i).email("admin" + i +
		// "@gmail.com")
		// .password("password"
		// + i)
		// .prenom("prenom" + i).profil(UserApp.Profil.Admin).telephone("77 567 77 66")
		// // .modules(modules)
		// .status(UserApp.Status.Actif)
		// .sexe(UserApp.Sexe.M)
		// .build());
		// }

		System.out.println("Server at started on :: 2323");
	}

}
