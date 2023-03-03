package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import helpers.RandomFunctionsLib;

public class BunTest{

    Bun bun;
    String bunName;
    float bunPrice;

    @Before
    public void setUp(){
        bunName = RandomFunctionsLib.getRandomLetterString(10);
        bunPrice = RandomFunctionsLib.getRandomFloat();
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Название булочки такое же, как при создании.", bunName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals("Цена булочки совпадает до полутысячных.", bunPrice, bun.getPrice(), 0.005);
    }

    @Test
    public void directFieldsTest(){
        Assert.assertEquals("Цена булочки совпадает до полутысячных.", bunPrice, bun.price, 0.005);
        Assert.assertEquals("Название булочки такое же, как при создании.", bunName, bun.name);
    }
}