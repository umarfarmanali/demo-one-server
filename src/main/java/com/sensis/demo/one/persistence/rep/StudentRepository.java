package com.sensis.demo.one.persistence.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sensis.demo.one.persistence.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
