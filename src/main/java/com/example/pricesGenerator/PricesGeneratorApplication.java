package com.example.pricesGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;
import java.util.stream.DoubleStream;


@RestController
@EnableBinding(PriceProducerChannel.class) //inject bean
@SpringBootApplication
public class PricesGeneratorApplication {

	public static Logger logger = LoggerFactory.getLogger(PricesGeneratorApplication.class);
	private final MessageChannel producer;
	public PricesGeneratorApplication(PriceProducerChannel channel) {
		this.producer = channel.producer();
	}

	public static int scen = 10;
	public static double lower = -100;
	public static double upper = 100;

	@PostMapping("/new/{ctp}/{trade}")
	public void pubblishPrice(@PathVariable String ctp, @PathVariable String trade) {
		long seed = UUID.nameUUIDFromBytes((ctp+trade).getBytes()).getMostSignificantBits();
		double[] prices = DoubleStream.generate( () -> new Random().nextDouble() * (upper - lower) + lower )
				.limit(scen).toArray();
		PriceData data = new PriceData(ctp, trade, prices);
		Message<PriceData> message = MessageBuilder.withPayload(data).build();
		logger.info("sending: " + data);
		this.producer.send(message);

	}


	public static void main(String[] args) {
		SpringApplication.run(PricesGeneratorApplication.class, args);
	}

}

class PriceData {
	final String ctp;
	final String trade;
	final double[] prices;

	public PriceData(String ctp, String trade, double[] prices) {
		this.ctp = ctp;
		this.trade = trade;
		this.prices = prices;
	}

	public String getCtp() {
		return ctp;
	}

	public String getTrade() {
		return trade;
	}

	public double[] getPrices() {
		return prices;
	}

	@Override
	public String toString() {
		return ctp + " " + trade;
	}
}

interface PriceProducerChannel {

	@Output
	MessageChannel producer();
}

