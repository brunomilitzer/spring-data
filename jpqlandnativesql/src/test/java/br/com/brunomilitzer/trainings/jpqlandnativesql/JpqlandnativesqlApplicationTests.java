package br.com.brunomilitzer.trainings.jpqlandnativesql;

import br.com.brunomilitzer.trainings.jpqlandnativesql.model.Student;
import br.com.brunomilitzer.trainings.jpqlandnativesql.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

    @Autowired
    private StudentRepository repository;

    @Test
    void testStudentCreate() {

        final Student s1 = this.createStudent("John", "Ramirez", 88L);
        final Student s2 = this.createStudent("Alois", "Lobo Molnar", 77L);
        final Student s3 = this.createStudent("Vanessa", "de Garcez", 98L);
        final Student s4 = this.createStudent("Tales", "de Garcez Coelho", 57L);
        final Student s5 = this.createStudent("Bruno", "Militzer", 27L);
        final Student s6 = this.createStudent("Nicholas", "Militzer", 45L);
        final Student s7 = this.createStudent("José", "Garcez", 89L);
        final Student s8 = this.createStudent("Josué", "Trindade", 59L);
        final Student s9 = this.createStudent("André", "Trindade", 79L);
        final Student s10 = this.createStudent("Leandro", "Mudrai", 59L);

        this.repository.save(s1);
        this.repository.save(s2);
        this.repository.save(s3);
        this.repository.save(s4);
        this.repository.save(s5);
        this.repository.save(s6);
        this.repository.save(s7);
        this.repository.save(s8);
        this.repository.save(s9);
        this.repository.save(s10);
    }

    @Test
    public void testFindAllStudents() {
        this.repository.findAllStudents(PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "lastName"))).forEach(System.out::println);
    }

    @Test
    public void testFindAllStudentsPartialData() {
        final List<Object[]> partialData = this.repository.findAllStudentsPartialData();

        for (final Object[] data : partialData) {
            System.out.println(data[0] + " " + data[1]);
        }
    }

    @Test
    public void testFindAllStudentsByFirstName() {

        this.repository.findAllStudentsByFirstName("Alois").forEach(System.out::println);
    }

    @Test
    public void testFindAllStudentsByScores() {

        this.repository.findStudentsByScores(50L, 80L).forEach(System.out::println);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteStudentsByFirstName() {

        this.repository.deleteStudentsByFirstName("Alois");
    }

    @Test
    public void testFindAllStudentsNQ() {
        this.repository.findAllStudentsNQ().forEach(System.out::println);
    }

    @Test
    public void testFindByFirstNameNQ() {
        this.repository.findByFirstNameNQ("Tales").forEach(System.out::println);
    }

    private Student createStudent(final String firstName, final String lastName, final Long score) {
        final Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setScore(score);

        return student;
    }

}
