package jp.github.shibadog.samplesleuth.front;

import java.util.concurrent.TimeUnit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SampleSleuthFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSleuthFrontApplication.class, args);
	}

	@Bean
	public RestOperations restTemplate() {
		return new RestTemplate();
	}

	@RestController
	public static class DemoController {
		private final RestOperations restOperations;
		private final DemoService service;

		public DemoController(RestOperations restOperations, DemoService service) {
			this.restOperations = restOperations;
			this.service = service;
		}

		@RequestMapping("/test")
		public String test() {
			service.something();
			return restOperations.getForObject("http://app-back:8080/backend", String.class);
		}
	}

	@Service
	public static class DemoService {
		@NewSpan("something")
		public void something() {
			log.info("something");
			try {
				TimeUnit.SECONDS.sleep(1L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
