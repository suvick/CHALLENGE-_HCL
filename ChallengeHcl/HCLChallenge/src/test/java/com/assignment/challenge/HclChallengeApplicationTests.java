package com.assignment.challenge;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
		classes = { HclChallengeApplicationTests.class})
@SpringBootTest
class HclChallengeApplicationTests {

	@Test
	void contextLoads() {
	}

}
