package br.com.brunomilitzer.trainings.mongodemo.repository;

import br.com.brunomilitzer.trainings.mongodemo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
