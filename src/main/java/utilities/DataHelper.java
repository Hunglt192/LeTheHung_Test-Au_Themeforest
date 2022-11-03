package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getUserName() {
		return faker.address().firstName();
	}

	public String getPassword() {
		return faker.internet().password(8, 12, true, true);
	}
}
