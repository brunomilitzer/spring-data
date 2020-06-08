package br.com.brunomilitzer.trainings.mongodemo;

import br.com.brunomilitzer.trainings.mongodemo.model.Product;
import br.com.brunomilitzer.trainings.mongodemo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MongodemoApplicationTests {

    @Autowired
    private ProductRepository repository;

    @Test
    void testCreateProduct() {
        final Product product = new Product();
        product.setName("Dell XPS");
        product.setPrice(2000F);

        final Product p1 = this.repository.save(product);
        assertNotNull(p1);
    }

    @Test
    public void testFindAll() {
        final List<Product> products = this.repository.findAll();

        assertEquals(1, products.size());
    }

    @Test
    public void testDelete() {
        this.repository.deleteById("5edd43a8fa790d10bd4dfa71");
        final Optional<Product> product = this.repository.findById("5edd43a8fa790d10bd4dfa71");

        assertEquals(Optional.empty(), product);
    }
}
