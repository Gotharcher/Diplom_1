package praktikum;

import helpers.RandomFunctionsLib;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    Ingredient ingredient;
    IngredientType ingredientType;
    float ingredientPrice;
    String ingredientName;

    @Before
    public void setUp(){
        ingredientPrice = RandomFunctionsLib.getRandomFloat();
        ingredientName = RandomFunctionsLib.getRandomLetterString(10);
        ingredientType = IngredientType.values()[RandomFunctionsLib.getRandomInt(1)];
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals("Цена ингридиента совпадает до полутысячных.", ingredientPrice, ingredient.getPrice(), 0.005);
}

    @Test
    public void getName() {
        Assert.assertEquals("Название ингридиента такое же, как при создании.", ingredientName, ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals("Тип ингридиента совпадает", ingredientType, ingredient.getType());
    }

    @Test
    public void directFieldsTest(){
        Assert.assertEquals("Цена булочки совпадает до полутысячных.", ingredientPrice, ingredient.price, 0.005);
        Assert.assertEquals("Название булочки такое же, как при создании.", ingredientName, ingredient.name);
        Assert.assertEquals("Тип ингридиента совпадает", ingredientType, ingredient.getType());
    }
}