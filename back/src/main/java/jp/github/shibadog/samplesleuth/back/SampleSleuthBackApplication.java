package jp.github.shibadog.samplesleuth.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SampleSleuthBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSleuthBackApplication.class, args);
	}

	@RestController
	public static class DemoController {
		@RequestMapping("/backend")
		public String back() {
			return "back";
		}
	}
}
