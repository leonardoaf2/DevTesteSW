package com.testeItauDev.StarWarsItau;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.testeItauDev.StarWarsItau.controller.PeopleController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PeopleController.class)
class StarWarsItauApplicationTests {

	@Test
	void contextLoads() {
	}

}
