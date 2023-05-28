package com.example.Splitwise;

import com.example.Splitwise.commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	CommandRegistry commandRegistry;

	@Autowired
	public SplitwiseApplication(CommandRegistry commandRegistry){
		this.commandRegistry = commandRegistry;
	}

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}


	//SettleGroup 10
	//RegisterUser "A" "9999993193" "xyz"

	@Override
	public void run(String... args) throws Exception{
		Scanner sc = new Scanner(System.in);
		while (true){
			String input = sc.nextLine();
			commandRegistry.execute(input);
		}

	}

}
