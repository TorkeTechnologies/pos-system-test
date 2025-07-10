package pos_system;

import org.junit.jupiter.api.Test;

import pos_system.database.Product;
import pos_system.database.ProductDatabase;
import pos_system.models.Taxation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

// Sortieren Sie Ihre Tests sinnvoll in Klassen ein, die sich mit ähnlichen Tests beschäftigen. Denken Sie an
// Kohäsion aus SWT. Gradle erkennt alle Klassen automatisch. Wenn Sie eine neue Klasse mit Tests erstellen,
// müssen Sie nichts weiter machen, außer die Tests laufen zu lassen.
class DemoTestSuite {

    @BeforeAll
    static void setupDatabase() {
        // Die Produkt-Datenbank ist für einige Tests wichtig. Setzen Sie entweder diese über init() oder, wenn
        // gefordert, mocken Sie die Datenbank.
        ProductDatabase.init();
    }

    // Dies ist ein Test. Erinnern Sie sich daran, wie wir Tests in der Vorlesung und Übung definiert haben.
    // Auch hier gilt das Single-Responsibility-Principle. Ein JUnit @Test sollte genau einen Tests
    // "auf Papier" abdecken und nicht mehr.

/* 
    @Test
    void succeedingExampleTest2() {
        // Machen Sie sich mit der API der Software in der JavaDoc vertraut.
        Product product = ProductDatabase.getProductById(0);

        // Sie können assert oder die JUnit assert-Familie (assertEquals, ...) verwenden.
        assert product.getId() != 0;
    }

*/

/* 
    @Test
    void failingExampleTest2() {
        Product product = ProductDatabase.getProductById(1);
        assertEquals(product.getName(), "Reis");
    }
*/

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
