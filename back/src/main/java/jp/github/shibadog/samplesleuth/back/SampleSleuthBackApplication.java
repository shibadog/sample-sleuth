package jp.github.shibadog.samplesleuth.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SampleSleuthBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSleuthBackApplication.class, args);
	}

	@RestController
	public static class DemoController {
		@RequestMapping("/backend")
		public String back() {
			log.info("loglog");
			return "back";
		}
	}
}
