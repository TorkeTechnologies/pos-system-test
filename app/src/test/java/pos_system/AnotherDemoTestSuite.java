package pos_system;

import org.junit.jupiter.api.Test;

import pos_system.database.Product;
import pos_system.database.ProductDatabase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

class AnotherDemoTestSuite {

    @BeforeAll
    static void setupDatabase() {
        ProductDatabase.init();
    }

    @Test
    void succeedingExampleTest2() {
        Product product = ProductDatabase.getProductById(0);
        assert product.getId() == 0;
    }

    @Test
    void failingExampleTest2() {
        Product product = ProductDatabase.getProductById(1);
        assert product.getName().equals("Reis");
    }
}
