package pos_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pos_system.database.Product;
import pos_system.database.ProductDatabase;
import pos_system.models.Order;
import pos_system.models.OrderItem;

class OrderTests {
    @BeforeAll
    static void setupDatabase() {
        ProductDatabase.init();
    }
    
    @Test
    void priceAfterAddToOptionList() {
        Product product = new Product(2, "Cheeseburger", 6.49, 0.0, false, false);
        OrderItem.Option size = new OrderItem.Option("Klein", 1.0);
        List<OrderItem.Option> options = new ArrayList<>();
        options.add(new OrderItem.Option("Ohne Eis", 0));
        OrderItem item = new OrderItem(product, size, options);
        options.add(new OrderItem.Option("Extra Käse", 0.5));
        // assertEquals(options, item.getFoodOptions()); Added to find what the underlying issue is
        assertEquals( 6.49, item.calculatePrice());
    }

    @Test
    void orderTakeoutState() {
        Order order = new Order();
        assertFalse(order.isTakeOut());
    }
}
