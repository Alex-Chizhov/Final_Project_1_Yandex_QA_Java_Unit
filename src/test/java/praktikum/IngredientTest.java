package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name="{index}. Type: {0} | name: {1} | price: {2}")
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100F},
                {SAUCE, "sour cream", 300F},
                {SAUCE, "chili sauce", 300F},
                {FILLING, "cutlet", 100F},
                {FILLING, "dinosaur", 200F},
                {FILLING, "sausage", 300F},
        };
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getTypeTest(){
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getNameTest(){
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest(){
        assertEquals(price, ingredient.getPrice(), 0);
    }
}
