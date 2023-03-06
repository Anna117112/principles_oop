package hibernte_dz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
// хотим хранить сущьность в таблице products
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private String mark;







// обязательно должен быть пустой конструктор
    public Student() {
    }

    public Student(int id, String name,  String mark){
        this.id = id;
        this.name = name;
        this.mark = mark;
    }



    @Override
    public String toString() {
        return "Student [ id - " + id + " name  " + name + " mark " + mark + "]";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }
}
