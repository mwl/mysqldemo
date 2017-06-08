package com.containersolutions.mysqldemo;

import com.containersolutions.mysqldemo.domain.Planet;
import com.containersolutions.mysqldemo.domain.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@SpringBootApplication
@RestController
public class MysqldemoApplication {
    @Autowired
    PlanetRepository planetRepository;

    @GetMapping("/")
    public List<String> planetNames() {
        return StreamSupport.stream(planetRepository.findAll().spliterator(), false).map(Planet::getName).collect(toList());
    }

	public static void main(String[] args) {
		SpringApplication.run(MysqldemoApplication.class, args);
	}
}
