package net.slipp.domain.movie;
   
import static org.junit.Assert.assertSame; 
    


import java.math.BigDecimal;
import java.util.Currency;

import org.junit.Before;
import org.junit.Test;
import java.util.Locale;
public class MovieTest {
 
	private Duration runningTime; 
	private Money fee; 
	
	@Before
	public void setup() { 
		runningTime = new Duration(); 
		fee = new Money(); 
	}
 
	@Test
	public void 식별자_일관성_보장() throws Exception {
		
		runningTime.setQuantity(95);
		 
		BigDecimal amount = new BigDecimal(8000);
		Locale locale = Locale.getDefault();
		Currency currency = Currency.getInstance(locale);
		
		fee.setFeeAmout(amount);
		fee.setFeeCurrency(currency);
		
		Movie movie1 = new MovieBuilder().title("test").runningTime(runningTime).fee(fee).build();
		Movie movie2 = new MovieBuilder().title("test").runningTime(runningTime).fee(fee).build();
		
		assertSame(movie1,movie2);
		
		
	}
	
}
