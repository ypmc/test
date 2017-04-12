package net.cq.test;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();

		System.out.println(millis);
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);
		
		System.out.println(legacyDate);
	}

}
