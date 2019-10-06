package com.udacity.springmongodb;

import com.udacity.springmongodb.model.Member;
import com.udacity.springmongodb.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@SpringBootApplication
@EnableMongoRepositories
public class SpringMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(MemberRepository memberRepository) {
		return args -> {
			// create a member record
			Member member = new Member();
			member.setFirstName("Jenny");
			member.setLastName("Shin");
			member.setAge(23);
			member.setGender("female");

			// save the member record
			memberRepository.save(member);

			// read the member using member last name
			Optional<Member> optional = memberRepository.findByLastName("Shin");

			if(optional.isPresent()) {
				System.out.println(optional.get().getFirstName() + " " + optional.get().getLastName());
				System.err.println("Member: " + member);
			}

			// read the member using member id
			optional = memberRepository.findById(optional.get().getId());
			if(optional.isPresent()) {
				System.out.println(optional.get().getFirstName() + " " + optional.get().getLastName());
			}
		};
	}
}
