package com.hendisantika.studentlist;

import com.hendisantika.studentlist.domain.Student;
import com.hendisantika.studentlist.domain.User;
import com.hendisantika.studentlist.repository.StudentRepository;
import com.hendisantika.studentlist.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {CrudbootApplication.class, WebSecurityConfig.class })
public class CrudbootApplicationTests {


	private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }    
    
    @Test
    public void addUser() {
    	User user = new User("testuser", "testuser", "USER");

    	assertNull(user.getId());
    	userRepository.save(user);
    	assertNotNull(user.getId());
    }
    
	@Test
    public void addStudent() {
        Student student = new Student("Test", "Student", "IT", "test@test.com");

        studentRepository.save(student);
        Optional<Student> findStudent = studentRepository.findById(student.getId());
        assertNotNull(findStudent);
    }
    
}
