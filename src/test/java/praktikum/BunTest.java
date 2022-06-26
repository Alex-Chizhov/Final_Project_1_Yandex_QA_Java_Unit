package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp(){
        bun = new Bun("Булочка", 100F);
    }

    @Test
    public void getNameTest() {
        assertEquals("Булочка", bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(100F, bun.getPrice(), 0);
    }
}