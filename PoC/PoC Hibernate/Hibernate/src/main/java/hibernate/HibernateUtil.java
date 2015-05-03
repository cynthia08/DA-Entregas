package hibernate;

import entidades.Jugador1;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Cyn
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static SessionFactory sessionAnnotationFactory;
    private static SessionFactory sessionJavaConfigFactory;

    private static SessionFactory buildSessionFactory() {
        try {

            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Throwable ex) {

            System.err.println("Fallo en conexion" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionAnnotationFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate-annotation.cfg.xml");
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("SessionFactory fallo" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionJavaConfigFactory() {
        try {
            Configuration configuration = new Configuration();

            Properties props = new Properties();
            props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            props.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/hibernate");
            props.put("hibernate.connection.username", "root");
            props.put("hibernate.connection.password", "1234");
            props.put("hibernate.current_session_context_class", "thread");

            configuration.setProperties(props);
            configuration.addAnnotatedClass(Jugador1.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Fallo de conexion" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionAnnotationFactory() {
        if (sessionAnnotationFactory == null) {
            sessionAnnotationFactory = buildSessionAnnotationFactory();
        }
        return sessionAnnotationFactory;
    }

    public static SessionFactory getSessionJavaConfigFactory() {
        if (sessionJavaConfigFactory == null) {
            sessionJavaConfigFactory = buildSessionJavaConfigFactory();
        }
        return sessionJavaConfigFactory;
    }

}
