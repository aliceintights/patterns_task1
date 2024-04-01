import com.github.javafaker.Faker;

public class CardReceiverUserInfo {
    private Faker faker;

    String name = faker.name().fullName();
    String city = faker.address().city();
    String phoneNumber = faker.phoneNumber().phoneNumber();
}
