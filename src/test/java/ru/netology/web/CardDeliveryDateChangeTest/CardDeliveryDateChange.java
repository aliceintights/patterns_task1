package ru.netology.web.CardDeliveryDateChangeTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.DataGenerator.CardReceiverDataGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryDateChange {
    @Test
    void changeDateForCardDelivery() {
        open("http://localhost:9999");
        var cardReceiverInfo = CardReceiverDataGenerator.CardReceiver.getCardReceiverInfo();
        var originalDeliveryDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        var replanDeliveryDate = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        $("[placeholder='Город']").setValue(cardReceiverInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(originalDeliveryDate);
        $("[name='name']").setValue(cardReceiverInfo.getName());
        $("[name='phone']").setValue(cardReceiverInfo.getPhoneNumber());
        $(".checkbox__box").click();
        $(".button").click();
        $("[data-test-id='success-notification']").shouldBe(visible).shouldHave(text("Успешно! Встреча успешно запланирована на " + originalDeliveryDate));

        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(replanDeliveryDate);
        $(".button").click();
        $("[data-test-id='replan-notification'] button").click();
        $("[data-test-id='success-notification']").shouldBe(visible).shouldHave(text("Успешно! Встреча успешно запланирована на " + replanDeliveryDate));
    }
}
