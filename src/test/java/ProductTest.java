import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.netology.Product;
import ru.netology.ShopRepository;

public class ProductTest {
    // Чтобы покрытие было идеальным
    @Test
    public void ProductTest1() {
        ShopRepository repository = new ShopRepository();
        repository.add(new Product(1, "Тест_Продукт_1", 10));
        repository.add(new Product(2, "Тест_Продукт_2", 50));
        repository.add(new Product(3, "Тест_Продукт_3", 20));

        Product TestProduct = repository.findById(2);
        TestProduct.setTitle("Макароны");
        Assertions.assertTrue(repository.findById(2).getTitle().equals("Макароны"));
        TestProduct.setPrice(25);
        Assertions.assertTrue(repository.findById(2).getPrice() == 25);
    }
}
