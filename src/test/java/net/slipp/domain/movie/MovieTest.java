package net.slipp.domain.movie;
   
import static org.junit.Assert.assertSame; 
    
import org.junit.Before;
import org.junit.Test;

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
		fee.setFeeAmout("8000");
		fee.setFeeCurrency("KRW");
		
		Movie movie1 = new MovieBuilder().title("test").runningTime(runningTime).fee(fee).build();
		Movie movie2 = new MovieBuilder().title("test").runningTime(runningTime).fee(fee).build();
		
		assertSame(movie1,movie2);
		
		
	}
	
}
