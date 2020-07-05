package com.victorpereira.mymarketplace.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.victorpereira.mymarketplace.models.Event;
import com.victorpereira.mymarketplace.models.User;
import com.victorpereira.mymarketplace.repositories.EventRepository;
import com.victorpereira.mymarketplace.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EventRepository eventRepo;

	@Bean
	public boolean instatiateDatabase() throws ParseException {
		User u1 = new User(null, "Ronaldo", "ronaldo@gmail.com", "ronaldin", "123");
		User u2 = new User(null, "Pelé", "pele@gmail.com", "reidofut", "123");
		User u3 = new User(null, "Cris Ronaldo", "cr7@gmail.com", "cr7", "123");
		User u4 = new User(null, "Marta", "marta@gmail.com", "marta001", "123");
		userRepo.saveAll(Arrays.asList(u1, u2, u3, u4));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Event e1 = new Event(null, "Rock in Rio", "RJ", "Rio de Janeiro", "Rua X", sdf.parse("21/01/2021 12:00"),
				sdf.parse("26/01/2021 18:00"));
		Event e2 = new Event(null, "Corona End", "SP", "São Paulo", "Centro", sdf.parse("21/12/2020 00:00"),
				sdf.parse("01/01/2021 00:00"));
		Event e3 = new Event(null, "Bike Racing", "SP", "São Paulo", "Interlagos", sdf.parse("10/05/2021 10:00"),
				sdf.parse("10/05/2021 18:00"));
		Event e4 = new Event(null, "Book Fair", "ES", "Vitória", "Rua X, 1243", sdf.parse("18/11/2020 08:40"),
				sdf.parse("19/11/2020 22:00"));
		e1.setOwner(u3);
		e2.setOwner(u4);
		e3.setOwner(u1);
		e4.setOwner(u3);
		eventRepo.saveAll(Arrays.asList(e1, e2, e3, e4));

		return true;
	}
}
