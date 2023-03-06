package hibernte_dz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
            SessionFactoryUtil sessionFactoryUtil = new SessionFactoryUtil();
            sessionFactoryUtil.init();
            try {
                StudentDao studentDao = new StudentDaoImp(sessionFactoryUtil);
                for (int i = 0; i < 1000; i++) {

                    studentDao.createStudent(new Student(i,"Student " +i,"1"+i));
                }
                 //studentDao.createStudent(new Student(3,"Tom","1"));
               // studentDao.findByID(3);
               // studentDao.findAll();
                //studentDao.updateNameById(2, "Mila");
               //  studentDao.deleteById(2);
                //studentDao.updateByName("Bob","1");

            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                sessionFactoryUtil.shutdown();
            }
        }
}
