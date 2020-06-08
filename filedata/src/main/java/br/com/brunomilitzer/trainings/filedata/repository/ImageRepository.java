package br.com.brunomilitzer.trainings.filedata.repository;

import br.com.brunomilitzer.trainings.filedata.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
