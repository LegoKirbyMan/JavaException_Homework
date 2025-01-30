import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ru.netology.AlreadyExistsException;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

public class ShopRepositoryTest {
    @Test
    public void ShopRepositoryTest1(){
        ShopRepository repository = new ShopRepository();
        repository.add(new Product(1, "Тест_Продукт_1", 10));
        repository.add(new Product(2, "Тест_Продукт_2", 50));
        repository.add(new Product(3, "Тест_Продукт_3", 20));

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(100);
        });
    }

    @Test
    public void ShopRepositoryTest2(){
        ShopRepository repository = new ShopRepository();
        repository.add(new Product(1, "Тест_Продукт_1", 10));
        repository.add(new Product(2, "Тест_Продукт_2", 50));
        repository.add(new Product(3, "Тест_Продукт_3", 20));
        
        repository.remove(3);
        
        Assertions.assertNull(repository.findById(3));
    }

    @Test
    public void ShopRepositoryTest3(){
        ShopRepository repository = new ShopRepository();
        repository.add(new Product(1, "Тест_Продукт_1", 10));
        repository.add(new Product(2, "Тест_Продукт_2", 50));
        repository.add(new Product(3, "Тест_Продукт_3", 20));

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.add(new Product(1, "Тест_Продукт_1", 10));
        });
    }

    @Test
    public void ShopRepositoryTest4(){
        ShopRepository repository = new ShopRepository();
        repository.add(new Product(1, "Тест_Продукт_1", 10));
        repository.add(new Product(2, "Тест_Продукт_2", 50));
        repository.add(new Product(3, "Тест_Продукт_3", 20));

        assertEquals(repository.findAll().length, new Product[3].length);
    }
}
