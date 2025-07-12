package pos_system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pos_system.database.Product;
import pos_system.database.ProductDatabase;
import pos_system.models.Taxation;

class TaxTest {
    @BeforeAll
    static void setupDatabase() {
        ProductDatabase.init();
    }

    //Fall A: Kein Getränk, kein Milchgetränk, kein Takeaway
    @Test
    void TestFallA() {
        Product p = new Product(2, "Cheeseburger", 6.49, 0.0, false, false);
        double tax = Taxation.getTax(p, false);
        assertEquals(0.19, tax, 0.01); 
    }

    //Fall B: Kein Getränk, kein Milchgetränk, Takeaway
    @Test
    void TestFallB() {
        Product p = new Product(2, "Cheeseburger", 6.49, 0.0, false, false);
        double tax = Taxation.getTax(p, true);
        assertEquals(0.07, tax, 0.01); 
    }

    //Fall C: Getränk, kein Milchgetränk, kein Takeaway
    @Test
    void TestFallC() {
        Product p = new Product(2, "Fanta", 2.49, 0.0, true, false);
        double tax = Taxation.getTax(p, false);
        assertEquals(0.19, tax, 0.01);
    }

    //Fall D: Getränk, kein Milchgetränk, Takeaway
    @Test
    void TestFallD() {
        Product p = new Product(2, "Fanta", 2.49, 0.0, true, false);
        double tax = Taxation.getTax(p, true);
        assertEquals(0.19, tax, 0.01);
    } 

    //Fall E: Getränk, Milchgetränk, kein Takeaway
    @Test
    void TestFallE() {
        Product p = new Product(2, "Cappuccino", 3.19, 0.0, true, true);
        double tax = Taxation.getTax(p, false);
        assertEquals(0.19, tax, 0.01);
    } 

    //Fall F: Getränk, Milchgetränk, Takeaway
    @Test
    void TestFallF() {
        Product p = new Product(2, "Cappuccino", 3.19, 0.0, true, true);
        double tax = Taxation.getTax(p, true);
        assertEquals(0.07, tax, 0.01);
    } 
}
