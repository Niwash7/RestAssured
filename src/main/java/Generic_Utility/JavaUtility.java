package Generic_Utility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Niwash
 *
 */
public class JavaUtility {

	// it generates a random number within 5000 range

	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt();
		return randomNumber;
	}
	
	// it will return system date and time
	
	public String getSystemDateAndTime() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}
}
