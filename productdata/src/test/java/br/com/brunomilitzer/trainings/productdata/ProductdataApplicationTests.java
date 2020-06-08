package br.com.brunomilitzer.trainings.productdata;

import br.com.brunomilitzer.trainings.productdata.model.Product;
import br.com.brunomilitzer.trainings.productdata.repository.ProductRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductdataApplicationTests {

    private static final Long PRODUCT_ID = 2l;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testCreate() {
        final Product product = this.getProduct(PRODUCT_ID);

        this.productRepository.save(product);
    }

    @Test
    public void testRead() {

        final Product product = this.productIsPresent(1l);

        assertNotNull(product);
        assertEquals("Galaxy S20", product.getName());
    }

    @Test
    public void testUpdate() {

        final Product product = this.productIsPresent(1l);

        product.setName("Galaxy S20+");
        product.setPrice(1200D);

        this.productRepository.save(product);

        assertNotNull(product);
        assertEquals("Galaxy S20+", product.getName());
        assertEquals(1200d, product.getPrice());
    }

    @Test
    public void testDelete() {

        final Product product = this.productIsPresent(1l);

        this.productRepository.delete(product);

        this.productRepository.findById(1L).isPresent();

        assertFalse(this.productRepository.findById(1L).isPresent());
    }

    @Test
    public void testCount() {

        System.out.println("=================================");
        System.out.println("Total Records: " + this.productRepository.count());
        System.out.println("=================================");
    }

    @Test
    public void testFindByName() {
        final List<Product> products = this.productRepository.findByName("Galaxy S20+");

        products.forEach(System.out::println);
    }

    @Test
    public void testFindByNameAndDescription() {
        final List<Product> products = this.productRepository.findByNameAndDescription("Galaxy S20", "Samsung Galaxy S20");

        products.forEach(System.out::println);
    }

    @Test
    public void testFindByPriceGreaterThan() {
        final List<Product> products = this.productRepository.findByPriceGreaterThan(1000D);

        products.forEach(System.out::println);
    }

    @Test
    public void testFindByDescriptionContains() {
        final List<Product> products = this.productRepository.findByDescriptionContains("Samsung");

        products.forEach(System.out::println);
    }

    @Test
    public void testFindByPriceBetween() {
        final List<Product> products = this.productRepository.findByPriceBetween(900D, 1000D);

        products.forEach(System.out::println);
    }

    @Test
    public void testFindByDescriptionLike() {
        final List<Product> products = this.productRepository.findByDescriptionLike("%%Galaxy%%");

        products.forEach(System.out::println);
    }

    @Test
    public void testFindByIdIn() {
        final List<Product> products = this.productRepository.findByIdIn(Arrays.asList(1L, 4L, 5L), PageRequest.of(0, 1));

        products.forEach(System.out::println);
    }

    @Test
    public void testFindAllPaging() {

        final Pageable pageable = PageRequest.of(2, 2);

        final Page<Product> products = this.productRepository.findAll(pageable);

        products.forEach(System.out::println);
    }

    @Test
    public void testFindAllSorting() {

        this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "name")).forEach(System.out::println);
    }

    @Test
    public void testFindAllSortingMultipleProperties() {

        this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "price", "name")).forEach(System.out::println);
    }

    @Test
    public void testFindAllSortingMultipleDirections() {

        this.productRepository.findAll(Sort.by(Sort.Order.desc("name"), Sort.Order.asc("price"))).forEach(System.out::println);
    }

    @Test
    public void testFindAllPagingAndSorting() {
        final Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Order.desc("name"), Sort.Order.asc("price")));

        this.productRepository.findAll(pageable).forEach(System.out::println);
    }

    @Test
    public void testNoCaching() {
        this.productIsPresent(1L);

        this.productRepository.findById(1L);
        this.productRepository.findById(1L);
        this.productRepository.findById(1L);
        this.productRepository.findById(1L);
    }

    @Test
    @Transactional
    public void testL1Caching() {
        final Session session = this.entityManager.unwrap(Session.class);

        final Product product = this.productIsPresent(1L);

        this.productRepository.findById(1L);

        session.evict(product);

        this.productRepository.findById(1L);
        /*this.productRepository.findById(1L);
        this.productRepository.findById(1L);*/
    }

    @Test
    @Transactional
    public void testL2Caching() {
        final Session session = this.entityManager.unwrap(Session.class);

        final Product product = this.productIsPresent(1L);

        this.productRepository.findById(1L);
        
        session.evict(product);

        this.productRepository.findById(1L);
        this.productRepository.findById(1L);
    }

    private Product productIsPresent(final Long id) {

        assertTrue(this.productRepository.findById(id).isPresent());

        return this.productRepository.findById(id).get();
    }

    private Product getProduct(final Long id) {
        final Product product = new Product();
        product.setId(id);
        product.setName("Galaxy S20");
        product.setDescription("Samsung Galaxy S20");
        product.setPrice(1129D);
        return product;
    }
}
