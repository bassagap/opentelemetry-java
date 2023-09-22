package bi.opentelemetry.SampleEndpoint;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/rolldice")
    public String index(@RequestParam("player") Optional<String> player) {
        int result = this.getRandomNumber(1, 6);
        if (player.isPresent()) {
            logger.info("{} is rolling the dice: {}", player.get(), result);
        } else {
            logger.info("Anonymous player is rolling the dice: {}", result);
        }
        return Integer.toString(result);
    }

    public int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
