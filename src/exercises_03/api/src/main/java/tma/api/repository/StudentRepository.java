package tma.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tma.api.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("FROM Student S WHERE S.gpa = (SELECT max(S.gpa) FROM Student S)")
    List<Student> findMaxGPAList();

    @Query("FROM Student S WHERE S.gpa = (SELECT min(S.gpa) FROM Student S)")
    List<Student> findMinGPAList();
}
