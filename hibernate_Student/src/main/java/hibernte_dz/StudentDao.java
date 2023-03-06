package hibernte_dz;

import java.util.List;

public interface StudentDao {


    void createStudent(Student student);
    Student findByID(int id);
    List<Student> findAll();


    void updateNameById(int id, String name);
    void updateByName(String name, String mark);

    void deleteById(int id);




}
