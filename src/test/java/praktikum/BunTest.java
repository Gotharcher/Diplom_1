package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;
    Bun bun;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        bun = new Bun(bunName, bunPrice);
    }

    @Parameterized.Parameters
    public static Object[][] getBuns() {
        return new Object[][]{
                {"Вкусная", 150F},
                {"Съедобная", Float.MAX_VALUE},
                {"Негативная", -150F},
                {"Бесценная", 0F},
                {"", 150F},
                {"        ", 150F},
                {"№;!:/-+!@#", 150F},
        };
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Название булочки такое же, как при создании.", bunName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals("Цена булочки совпадает до полутысячных.", bunPrice, bun.getPrice(), 0.005);
    }

}