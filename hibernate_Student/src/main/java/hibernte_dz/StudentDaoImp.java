package hibernte_dz;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("productDaoImp")

public class StudentDaoImp implements StudentDao {

        private SessionFactoryUtil sessionFactoryUtil;
        public StudentDaoImp(SessionFactoryUtil sessionFactoryUtil){
            this.sessionFactoryUtil =sessionFactoryUtil;
        }
        @Override
        public void createStudent(Student student) {
            try (Session session =sessionFactoryUtil.getSession()){
                // при работе с бд открываем  транзакцию
                session.beginTransaction();
                // сохрнаем в бд обект
                session.save(student);
                //
                session.getTransaction().commit();
            }

        }

        @Override
        public Student findByID(int id) {
            try
                    (Session session = sessionFactoryUtil.getSession()) {

                session.beginTransaction();
                Student student1 = session.get(Student.class, id);
                session.getTransaction().commit();
                System.out.println(student1);
                return student1;
            }
        }

        @Override
        public List<Student> findAll() {
            try (Session session = sessionFactoryUtil.getSession()) {

                session.beginTransaction();
                List allproduct = session.createQuery("from Product").getResultList();
                System.out.println(allproduct);
                session.getTransaction().commit();
                return allproduct;
            }
        }

        @Override
        public void updateNameById(int id, String name) {
            try (Session session = sessionFactoryUtil.getSession()) {

                session.beginTransaction();
                Student student = session.get(Student.class, id);
                student.setName(name);
                session.getTransaction().commit();
                System.out.println(student);

            }

        }

        @Override
        public void updateByName(String name, String mark) {
            try (Session session = sessionFactoryUtil.getSession()) {

                session.beginTransaction();
// вытаскиваем из бд обект с именем student.name = :name пишем так если имя подставим потом .setParameter("name",name)
                Student student = session.createQuery("select student from Student student where student.name = :name",Student.class)
                        .setParameter("name",name)
                        .getSingleResult();
                // меняем
                student.setMark(mark);
                // после коммита применяются измпенения
                session.getTransaction().commit();
                System.out.println(student);

            }

        }



        @Override
        public void deleteById(int id) {
            try (Session session = sessionFactoryUtil.getSession()) {
                session.beginTransaction();
                Student student = session.get(Student.class, id);
                session.delete(student);
                session.getTransaction().commit();

            }
        }
    }
