package hibernte_dz;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryUtil {

    private SessionFactory factory;
    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                // прописываем сущьность с которой будем работать
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }
    public Session getSession(){
        return factory.getCurrentSession();
    }

    public void shutdown(){
        if (factory!=null){
            factory.close();
        }
    }
}
