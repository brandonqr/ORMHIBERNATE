
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class Main {


    public static void main(String[] args) {
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Cliente cliente = new Cliente(1,"Brandon", "Quiroz Rodriguez","95847856");
        
        Session session=sessionFactory.openSession();
        
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        
        
        Cliente profesor2=(Cliente)session.get(Cliente.class,101);
        System.out.println(profesor2.getId());
        System.out.println(profesor2.getNombre());
        System.out.println(profesor2.getApellidos());
       // System.out.println(profesor2.getApe2());        
        
        profesor2.setNombre("Emilio");
        
        session.beginTransaction();
        session.update(profesor2);
        session.getTransaction().commit();        

        session.beginTransaction();
       // session.delete(profesor2);
        session.getTransaction().commit(); 
        
        
        session.close();
        sessionFactory.close();
    }
}
