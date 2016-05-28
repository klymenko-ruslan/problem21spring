package problem21spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import problem21spring.model.Message;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableScheduling
public class Problem21springApplication {

	public static final int SLEEP_TIME = 3_000;
	public static final int MIN_SEED = 1_000;
	public static final int MAX_SEED = 20_000;
	public static final String MESSAGES_URL = "http://localhost:9999/messages";
	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime.getRuntime().exec("mongod");
		SpringApplication.run(Problem21springApplication.class);
	}

	@Scheduled(fixedRate = SLEEP_TIME)
	private static void problem21job() throws JsonProcessingException {
		Message message = generateMessage();
		try {
			ResponseEntity<Integer> response =
					restTemplate.postForEntity(MESSAGES_URL, message, Integer.class);
			System.out.println("Amicable numbers sum for " + message.getSeed() + " is " + response.getBody());
		} catch(HttpClientErrorException e) {
			System.out.println(message.getMissionId() + " is not unique id!" + e);
		}
	}

	private static Message generateMessage() {
		return new Message(ThreadLocalRandom.current().nextInt(),
						   ThreadLocalRandom.current().nextInt(MIN_SEED, MAX_SEED + 1));
	}
}
