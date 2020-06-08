package br.com.brunomilitzer.trainings.productdata.repository;

import br.com.brunomilitzer.trainings.productdata.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByNameAndDescription(String name, String description);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByDescriptionContains(String description);

    List<Product> findByPriceBetween(Double price1, Double price2);

    List<Product> findByDescriptionLike(String description);

    List<Product> findByIdIn(List<Long> ids, Pageable pageable);
}
