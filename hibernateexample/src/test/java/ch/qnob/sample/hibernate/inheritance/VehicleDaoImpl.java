package ch.qnob.sample.hibernate.inheritance;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class VehicleDaoImpl {

	private SessionFactory sessionFactory;

	private synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(builder.build());
		}
		return sessionFactory;
	}

	public Long create(Vehicle v) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(v);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + v.toString());
		return v.getVehicleId();

	}

	public List<Vehicle> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Vehicle> vehicles = session.createQuery("FROM Vehicle").list();
		session.close();
		System.out.println("Found " + vehicles.size() + " Vehicle");
		return vehicles;

	}

	public void delete(Long id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Vehicle v = findByID(id);
		session.delete(v);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + v.toString());

	}

	public Vehicle findByID(Long id) {
		Session session = getSessionFactory().openSession();
		Vehicle v = (Vehicle) session.load(Vehicle.class, id);
		session.close();
		return v;
	}
	
	public void update(Vehicle v) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.update(v);
		session.getTransaction().commit();
		session.close();		
		
	}

	public void deleteAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Vehicle ");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted all Vehicles.");

	}
}
