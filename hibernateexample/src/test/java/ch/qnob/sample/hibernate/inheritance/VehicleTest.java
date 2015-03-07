/**
 * 
 */
package ch.qnob.sample.hibernate.inheritance;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ch.qnob.sample.hibernate.onetable.Employee;
import ch.qnob.sample.hibernate.onetable.EmployeeDaoImpl;

/**
 * @author kanoodle
 *
 */
public class VehicleTest {

	@Test
	public final void test() {
		VehicleDaoImpl dao = new VehicleDaoImpl();
		dao.deleteAll();
		
		Car car1 = new Car();
		car1.setColor("Red");
		car1.setManufacturer("Porsche");
		car1.setModel("XZ2");
		
		Truck truck1 = new Truck();
		truck1.setManufacturer("BMW");
		truck1.setModel("XYC");
		truck1.setMaxLoad(2000);
				
		System.out.println(" =======CREATE =======");
		dao.create(car1);
		dao.create(truck1);
		System.out.println(" =======READ =======");
		List<Vehicle> vms1 = dao.read();
		assertEquals("Anz.", 2, vms1.size());
		for(Vehicle v: vms1) {
			System.out.println(v.toString());
		}
		System.out.println(" =======UPDATE =======");
		car1.setManufacturer("Ferrari");
		dao.update(car1);
		System.out.println(" =======READ =======");
		List<Vehicle> vms2 = dao.read();
		assertEquals("Anz.", 2, vms2.size());
		assertTrue("Instance of Car", vms2.get(0) instanceof Car);
		assertEquals("New Value","Ferrari", vms2.get(0).getManufacturer());
		for(Vehicle v: vms2) {
			System.out.println(v.toString());
		}
		System.out.println(" =======DELETE ======= ");
		dao.delete(truck1.getVehicleId());
		System.out.println(" =======READ =======");
		List<Vehicle> vms3 = dao.read();
		assertEquals("Anz.", 1, vms3.size());
		for(Vehicle v: vms3) {
			System.out.println(v.toString());
		}
		System.out.println(" =======DELETE ALL ======= ");
		dao.deleteAll();
		System.out.println(" =======READ =======");
		List<Vehicle> vms4 = dao.read();
		assertEquals("Anz.", 0, vms4.size());
		for(Vehicle v: vms4) {
			System.out.println(v.toString());
		}

	}

}
