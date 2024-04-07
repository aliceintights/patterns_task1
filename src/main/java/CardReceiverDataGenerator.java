import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.util.Locale;

public class CardReceiverDataGenerator {
    private CardReceiverDataGenerator() {
    }

    public static final Faker faker = new Faker(new Locale("ru"));

    public static String getName() {
        return faker.name().fullName();
    }

    public static String getCity() {
        return faker.address().city();
    }

    public static String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static class CardReceiver {
        private CardReceiver() {
        }

        public static CardReceiverInfo getCardReceiverInfo() {
            return new CardReceiverInfo(getName(), getCity(), getPhoneNumber());
        }
    }

    @Value
    public static class CardReceiverInfo {
        String name;
        String city;
        String phoneNumber;
    }
}