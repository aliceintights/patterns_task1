import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryDateChange {
    @Test
    void changeDateForCardDelivery() {
        open("http://localhost:9999");
        var cardReceiverInfo = CardReceiverDataGenerator.CardReceiver.getCardReceiverInfo();

        $("[placeholder='Город']").setValue(cardReceiverInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        $("[name='name']").setValue(cardReceiverInfo.getName());
        $("[name='phone']").setValue(cardReceiverInfo.getPhoneNumber());
        $(".checkbox__box").click();
        $(".button").click();
        $("[data-test-id='success-notification']").shouldBe(visible).shouldHave(text("Успешно!"));

        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        $(".button").click();
        $("[data-test-id='replan-notification'] button").click();
        $("[data-test-id='success-notification']").shouldBe(visible).shouldHave(text("Успешно!"));
    }
}
