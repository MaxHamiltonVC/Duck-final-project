import static org.junit.Assert.*;
import org.junit.Test;

public class duckTest{
	// Testing a redhead duck
	RedheadDuck redDuck = new RedheadDuck("Testy");
	
	@Test
	public void redheadTest(){
	assertEquals(redDuck.quack(),
		"Quack! Quack! Says Testy of the RedheadDuck class of ducks");
	}
}