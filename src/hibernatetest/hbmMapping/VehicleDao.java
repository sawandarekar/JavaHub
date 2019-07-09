package hibernatetest.hbmMapping;

import hibernatetest.POJO.Vehicle;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VehicleDao {

    public static void main(final String[] args) {
        final VehicleDao vDao = new VehicleDao();
        final Vehicle vehicle = new Vehicle();
        // vehicle.setVehicle_ID(2);
        vehicle.setRegistrationNumber("Re0002");
        vehicle.setOwnerName("sawan");
        vehicle.setVehicleLaunchDate(new Date(new java.util.Date().getTime()));

        // vDao.addVehicle(vehicle);
        vDao.getAllVehicles();
    }

    private void addVehicle(final Vehicle vehicle) {
        System.out.println("add vehicle");
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(vehicle);
            tx.commit();
            System.out.println("vehicle added");
        } catch (final Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.disconnect();
                session.close();
            }
            System.out.println("session closed");
        }
    }

    private List<Vehicle> getAllVehicles() {
        System.out.println("vehicle list");
        List<Vehicle> ls = null;
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            final Criteria criteria = session.createCriteria(Vehicle.class);
            ls = criteria.list();
            // final Query query = session.createQuery("from vehicle");
            // ls = query.list();
            for (final Vehicle vehicle : ls) {
                System.out.println(vehicle.toString());
            }
            System.out.println("vehicle added");
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.disconnect();
                session.close();
            }
            System.out.println("session closed");
        }
        return ls;
    }
}
