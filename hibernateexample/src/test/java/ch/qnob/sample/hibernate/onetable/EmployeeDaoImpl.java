package ch.qnob.sample.hibernate.onetable;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class EmployeeDaoImpl {

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

	public Integer create(Employee e) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + e.toString());
		return e.getId();

	}

	public List<Employee> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Employee> employees = session.createQuery("FROM Employee").list();
		session.close();
		System.out.println("Found " + employees.size() + " Employees");
		return employees;

	}

	public void update(Employee e) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Employee em = (Employee) session.load(Employee.class, e.getId());
		em.setName(e.getName());
		em.setAge(e.getAge());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + e.toString());

	}

	public void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Employee e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + e.toString());

	}

	public Employee findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Employee e = (Employee) session.load(Employee.class, id);
		session.close();
		return e;
	}

	public void deleteAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Employee ");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted all employees.");

	}

}
