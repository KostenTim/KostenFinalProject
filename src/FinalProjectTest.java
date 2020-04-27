import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;

import ua.nure.kosten.FinalTask.DateTime;
import ua.nure.kosten.FinalTask.Password;

class FinalProjectTest {

	@Test
	void PasswordMD5CoddingTest() {
		String result = Password.md5Coding("adminadmin");
		assertEquals(result, "f6fdffe48c908deb0f4c3bd36c032e72");
	}
	
	@Test
	void PasswordHaveCyrillicTest() {
		boolean result = Password.haveCyrillic("admin");
		assertEquals(result, false);
	}
	
	@Test
	void PasswordHaveCyrillicTest2() {
		boolean result = Password.haveCyrillic("adminы");
		assertEquals(result, true);
	}
	
	@Test
	void PasswordIsValidPasswordTest() {
		boolean result = Password.isValidPassword("123");
		assertEquals(result, false);
	}
	
	@Test
	void PasswordIsValidPasswordTest2() {
		boolean result = Password.isValidPassword("1234567");
		assertEquals(result, true);
	}
	
	@Test
	void PasswordIsValidPasswordTest3() {
		boolean result = Password.isValidPassword("sssfwSййцуеып");
		assertEquals(result, false);
	}
	
	@Test
	void PasswordIsValidPasswordTest4() {
		boolean result = Password.isValidPassword("sdasdasddsadasdasdasdadasdsadasdadasdasdasdasdasda");
		assertEquals(result, false);
	}
	@Test
	void PasswordIsValidLoginTest() {
		boolean result = Password.isValidLogin("admin");
		assertEquals(result, true);
	}
	
	@Test
	void PasswordIsValidLoginTest2() {
		boolean result = Password.isValidLogin("a");
		assertEquals(result, false);
	}
	
	@Test
	void DateTimePlusText() {
		DateTime dt1 = new DateTime(new Date(1000, 10, 10) , new Time(0,0,0));
		Time time = new Time(11,11,00);
		dt1.plus(time);
		assertEquals(dt1, new DateTime(new Date(1000, 10, 10) , new Time(11,11,0)));
	}
	
	@Test
	void DateTimeMinusText() {
		DateTime dt1 = new DateTime(new Date(1000, 10, 9) , new Time(0,0,0));
		DateTime dt2 = new DateTime(new Date(1000, 10, 10) , new Time(0,0,0));
		int result = DateTime.minus(dt2, dt1);
		assertEquals(result, 1440);
	}

	
}
