package com.hendisantika.studentlist.repository;

import com.hendisantika.studentlist.domain.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long>  {
    
	List<Course> findByName(String name);
}

