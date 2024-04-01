import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class CardReceiverDataGenerator {
    private CardReceiverDataGenerator() {}

    public static class CardReceiver {
        private CardReceiver() {}

        public static CardReceiverUserInfo generateByName(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new CardReceiverUserInfo();
        }
    }
}
