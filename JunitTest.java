/**
 * 
 */
package test;

import static org.junit.Assert.*;

//Importere klassen Dice. 
import terning.Dice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author janus
 *
 */
public class JunitTest {

	//Laver en ny variabel die, med klassen Dice. 
	Dice die; 

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		die = new Dice(); // Laver et nyt die objekt før hver test. 
	}


	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		die = null; //Fjerner gemt data fra die, til næste test.
	}

	/**
	 * Test method for {@link terning.Dice#roll()}.
	 */
	@Test
	public void testRoll() {
		// boolean expected = (1<=6 && 1>=6);
		// boolean actual = die.roll();

		int roll = die.roll();
		int high = 6;
		int low = 1;
		assertTrue(high >= roll); // Tester om det er korrekt at roll er mindre eller lig med 6.
		assertTrue(low <= roll);  // Tester om det er korrekt at roll er større eller lig med 1. 

	}

	/**
	 * Test method for {@link terning.Dice#rollMultiple(int)}.
	 */
	@Test
	public void testRollMultiple() {

		int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0;

		// Integeren i er lig 1, så længe i er under 60000 køres løkken igen, hver gang løkken køres bliver i 1 større.
		for(int i=1; i<60000; i++){
			int roll = die.roll();

			if (roll == 1){
				one ++;
			}
			else if (roll == 2){
				two ++;
			}
			else if (roll == 3){
				three ++;
			}
			else if (roll == 4){
				four ++;
			}
			else if (roll == 5){
				five ++;
			}
			else if (roll == 6){
				six ++;	
			}

		}
		// Vi definerer grænserne for fejlmarginer og tester for dem. Vi har sat vores fejlmargin til 400, da vi efter 60000 rolls forventer at der kan være et udfald på 4%.
		int upperlimit = 10400;
		int lowerlimit = 9600;
		assertTrue("Error " + one, upperlimit >= one); 
		assertTrue("Error " + one, lowerlimit <= one);

		assertTrue("Error " + two, upperlimit >= two); 
		assertTrue("Error " + two, lowerlimit <= two);

		assertTrue("Error " + three, upperlimit >= three); 
		assertTrue("Error " + three, lowerlimit <= three);

		assertTrue("Error " + four, upperlimit >= four); 
		assertTrue("Error " + four, lowerlimit <= four);

		assertTrue("Error " + five, upperlimit >= five); 
		assertTrue("Error " + five, lowerlimit <= five);

		assertTrue("Error " + six, upperlimit >= six); 
		assertTrue("Error " + six, lowerlimit <= six);


	}

}
