package praktikum;

import helpers.RandomFunctionsLib;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;

import java.util.List;

import static org.junit.Assert.*;

public class BurgerTest {

    Bun bun;
    Burger burger;
    Ingredient ingredient;

    @Before
    public void setUp(){
        bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(150F);
        Mockito.when(bun.getName()).thenReturn("Mocked bun 1");

        ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(50F);
        Mockito.when(ingredient.getName()).thenReturn("Mocked ingredient 1");

        burger = new Burger();
    }

    @Test
    public void setBuns() {
        assertNull("По умолчанию, булочки нет.", burger.bun);
        burger.setBuns(bun);
        assertEquals("Подставилась тестовая булочка, совпадает название", bun.getName(), burger.bun.getName());
        assertEquals("Подставилась тестовая булочка, совпадает цена", bun.getPrice(), burger.bun.getPrice(), 0.005);
    }

    @Test
    public void addIngredient() {
        int ingredientsCount = burger.ingredients.size();
        burger.addIngredient(ingredient);
        assertEquals("Количество ингридиентов увеличилось на 1", ingredientsCount+1, burger.ingredients.size());
        assertEquals("Последний добавленный ингридиент - с тем же именем, что мы добавили", ingredient.getName(), burger.ingredients.get(burger.ingredients.size()-1).getName());
        assertEquals("Последний добавленный ингридиент - с той же ценой, что мы добавили", ingredient.getPrice(), burger.ingredients.get(burger.ingredients.size()-1).getPrice(), 0.005);
    }

    @Test
    public void removeIngredient() {
        Ingredient ingredientToDelete = Mockito.mock(Ingredient.class);
        Mockito.when(ingredientToDelete.getName()).thenReturn("Mocked ingredient to be deleted");

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientToDelete);
        burger.addIngredient(ingredient);

        assertTrue("В списке ингридиентов есть тот, который мы хотим удалить",ingredientToBeDeletedIsPresent(ingredientToDelete, burger.ingredients));

        int ingredientsCount = burger.ingredients.size();
        burger.removeIngredient(2);
        assertEquals("Количество ингридиентов уменшилось на 1", ingredientsCount-1, burger.ingredients.size());

        assertFalse("В списке ингридиентов отсутствует тот, который мы хотели удалить", ingredientToBeDeletedIsPresent(ingredientToDelete, burger.ingredients));
    }

    @Test
    public void moveIngredient() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void getReceipt() {
    }

    public boolean ingredientToBeDeletedIsPresent(Ingredient ingredientToDelete, List<Ingredient> ingredientList){
        boolean ingredientToBeDeletedIsPresent = false;
        for(Ingredient ing: ingredientList){
            if (ing==ingredientToDelete) {
                ingredientToBeDeletedIsPresent = true;
                break;
            }
        }
        return ingredientToBeDeletedIsPresent;
    }
}