package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient secondIngredient;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);

        assertEquals(ingredient, burger.ingredients.get(0));
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);

        assertEquals(secondIngredient, burger.ingredients.get(0));
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        when(bun.getPrice()).thenReturn(100F);
        when(ingredient.getPrice()).thenReturn(300F);

        assertEquals(100F * 2 + 300F, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        when(bun.getName()).thenReturn("white bun");
        when(bun.getPrice()).thenReturn(200F);
        when(ingredient.getType()).thenReturn(FILLING);
        when(ingredient.getName()).thenReturn("cutlet");
        when(ingredient.getPrice()).thenReturn(100F);

        String expected =
                        "(==== white bun ====)\r\n" +
                        "= filling cutlet =\r\n" +
                        "(==== white bun ====)\r\n\r\n" +
                        "Price: 500,000000\r\n";

        assertEquals(expected, burger.getReceipt());
    }
}
