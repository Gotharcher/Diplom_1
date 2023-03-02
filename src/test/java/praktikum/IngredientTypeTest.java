package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String enumName;
    private final boolean shouldExist;

    public IngredientTypeTest(String enumName, boolean shouldExist) {
        this.enumName = enumName;
        this.shouldExist = shouldExist;
    }

    @Parameterized.Parameters
    public static Object[][] getFamilies() {
        return new Object[][]{{"FILLING", true}, {"SAUCE", true}, {"TOPPING", false},};
    }

    @Test
    public void checkEnumValueExists() {
        if (shouldExist) {
            Assert.assertNotNull("В перечислении ингридентов обязан присутствовать тип:", IngredientType.valueOf(enumName));
        } else {
            Assert.assertThrows("В перечислении ингридентов не должно быть типа:", IllegalArgumentException.class, () -> IngredientType.valueOf(enumName));
        }
    }

}