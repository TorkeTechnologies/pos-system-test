package pos_system;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pos_system.database.ProductDatabase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pos_system.util.Util.roundPrice;

class UtilTests {
    @BeforeAll
    static void setupDatabase() {
        ProductDatabase.init();
    }

    @Test
    void roundPriceDown() {
        assertEquals(1.22, roundPrice(1.222));
    }

    @Test
    void roundPriceUp() {
        assertEquals(1.23, roundPrice(1.227));
    }
}