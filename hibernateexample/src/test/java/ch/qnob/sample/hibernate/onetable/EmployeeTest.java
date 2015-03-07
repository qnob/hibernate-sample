/**
 * 
 */
package ch.qnob.sample.hibernate.onetable;

import java.util.List;

import org.junit.Test;

/**
 * @author kanoodle
 *
 */
public class EmployeeTest {

	@Test
	public void test() {
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		
		Employee em1 = new Employee("Mary Smith", 25);
		Employee em2 = new Employee("John Aces", 32);
		Employee em3 = new Employee("Ian Young", 29);
		
		System.out.println(" =======CREATE =======");
		dao.create(em1);
		dao.create(em2);
		dao.create(em3);
		System.out.println(" =======READ =======");
		List<Employee> ems1 = dao.read();
		for(Employee e: ems1) {
			System.out.println(e.toString());
		}
		System.out.println(" =======UPDATE =======");
		em1.setAge(44);
		em1.setName("Mary Rose");
		dao.update(em1);
		System.out.println(" =======READ =======");
		List<Employee> ems2 = dao.read();
		for(Employee e: ems2) {
			System.out.println(e.toString());
		}
		System.out.println(" =======DELETE ======= ");
		dao.delete(em2.getId());
		System.out.println(" =======READ =======");
		List<Employee> ems3 = dao.read();
		for(Employee e: ems3) {
			System.out.println(e.toString());
		}
		System.out.println(" =======DELETE ALL ======= ");
		dao.deleteAll();
		System.out.println(" =======READ =======");
		List<Employee> ems4 = dao.read();
		for(Employee e: ems4) {
			System.out.println(e.toString());
		}
	}

	
	/**
CREATE TABLE `company`.`employee` (
	id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(20) default NULL,
   age INT  default NULL,
   PRIMARY KEY (id)
);
	 */


}
