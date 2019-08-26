import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YandexSearch {

    @Test
    public void search_in_yandex() {
        String k,j,l;
        open("https://yandex.ru");
        $(By.xpath("//*[@id=\"text\"]")).val("Погода");
        sleep(1000);
        k = $(By.cssSelector(".suggest2-item__fact")).getText();
        System.out.println(k);
        $(By.xpath("//*[@id=\"text\"]")).val("Липецк");
        sleep(1000);
        j = $(By.cssSelector(".suggest2-item__fact")).getText();
        System.out.println(j);
        $(By.xpath("//*[@id=\"text\"]")).val("Лото");
        sleep(1000);
        SelenideElement test  = $(By.cssSelector(".suggest2-item__fact"));
        if (test.exists()) {
            System.out.println(test.getText());
        } else {
            System.out.println("Нет значения из подсказки");
        }

        open("https://yandex.ru/images/");
        $(byText("Картинки")).should(Condition.exist);
        $(byText("Моя лента")).should(Condition.exist);
        $(byText("Мои коллекции")).should(Condition.exist);
        $(byText("Темы")).should(Condition.exist);
        $(byText("Ещё")).should(Condition.exist);

        $(By.name("text")).val("авто").pressEnter();
        $(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[1]/div")).should(Condition.exist);
        $(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/label")).should(Condition.exist);

    }
}