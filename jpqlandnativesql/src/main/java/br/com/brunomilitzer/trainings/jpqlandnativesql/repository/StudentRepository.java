package br.com.brunomilitzer.trainings.jpqlandnativesql.repository;

import br.com.brunomilitzer.trainings.jpqlandnativesql.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("from Student ")
    List<Student> findAllStudents(Pageable pageable);

    @Query("select st.firstName, st.lastName from Student st")
    List<Object[]> findAllStudentsPartialData();

    @Query("from Student where firstName = :firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score > :min and score < :max")
    List<Student> findStudentsByScores(@Param("min") Long min, @Param("max") Long max);

    @Modifying
    @Query("delete from Student where firstName = :firstName")
    void deleteStudentsByFirstName(@Param("firstName") String firstName);

    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findAllStudentsNQ();

    @Query(value = "select * from student where fname = :firstName", nativeQuery = true)
    List<Student> findByFirstNameNQ(@Param("firstName") String firstName);
}
