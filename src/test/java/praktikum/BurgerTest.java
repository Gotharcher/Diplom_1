package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class BurgerTest {

    Bun bun;
    Burger burger;
    Ingredient ingredient;

    @Before
    public void setUp() {
        bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(150F);
        Mockito.when(bun.getName()).thenReturn("Mocked bun 1");

        ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(50F);
        Mockito.when(ingredient.getName()).thenReturn("Mocked ingredient 1");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals("Подставилась тестовая булочка", bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        int ingredientsCount = burger.ingredients.size();
        burger.addIngredient(ingredient);
        assertEquals("Количество ингридиентов увеличилось на 1", ingredientsCount + 1, burger.ingredients.size());
        assertEquals("Последний добавленный ингридиент - добавленный тестовый ингридиент.", ingredient, burger.ingredients.get(burger.ingredients.size() - 1));
    }

    @Test
    public void removeIngredient() {
        Ingredient ingredientToDelete = Mockito.mock(Ingredient.class);
        Mockito.when(ingredientToDelete.getName()).thenReturn("Mocked ingredient to be deleted");

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientToDelete);
        burger.addIngredient(ingredient);

        assertTrue("В списке ингридиентов есть тот, который мы хотим удалить", ingredientToBeDeletedIsPresent(ingredientToDelete, burger.ingredients));

        int ingredientsCount = burger.ingredients.size();
        burger.removeIngredient(2);
        assertEquals("Количество ингридиентов уменшилось на 1", ingredientsCount - 1, burger.ingredients.size());

        assertFalse("В списке ингридиентов отсутствует тот, который мы хотели удалить", ingredientToBeDeletedIsPresent(ingredientToDelete, burger.ingredients));
    }

    @Test
    public void moveIngredient() {
        Ingredient ingredientMoving = Mockito.mock(Ingredient.class);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientMoving);

        burger.moveIngredient(1, 0);
        assertEquals("Ингридиент переместился на первое место в списке", ingredientMoving, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        float totalPrice = bun.getPrice() * 2 + ingredient.getPrice() * 3;

        assertEquals("Цена бургера совпадает с ценой ингридиентов", totalPrice, burger.getPrice(), 0.005);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        System.out.println();
        StringBuilder recieptLegalStringBuilder = new StringBuilder("(==== Mocked bun 1 ====)\r\n");
        recieptLegalStringBuilder.append("= filling Mocked ingredient 1 =\r\n");
        recieptLegalStringBuilder.append("= filling Mocked ingredient 1 =\r\n");
        recieptLegalStringBuilder.append("(==== Mocked bun 1 ====)\r\n");
        recieptLegalStringBuilder.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Рецепт из метода совпадает с ожидаемым рецептом", recieptLegalStringBuilder.toString(), burger.getReceipt());
    }

    public boolean ingredientToBeDeletedIsPresent(Ingredient ingredientToDelete, List<Ingredient> ingredientList) {
        boolean ingredientToBeDeletedIsPresent = false;
        for (Ingredient ing : ingredientList) {
            if (ing == ingredientToDelete) {
                ingredientToBeDeletedIsPresent = true;
                break;
            }
        }
        return ingredientToBeDeletedIsPresent;
    }
}