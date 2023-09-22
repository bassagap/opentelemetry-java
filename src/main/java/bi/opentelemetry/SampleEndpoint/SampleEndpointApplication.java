package bi.opentelemetry.SampleEndpoint;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SampleEndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleEndpointApplication.class, args);
	}
	@Bean
	public OpenTelemetry openTelemetry() {
		return AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();
	}
}
