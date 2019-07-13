/**
 *
 */
package hibernatetest.POJO;

import java.sql.Date;

/**
 * @author darekar
 */
public class Vehicle {

    private int Vehicle_ID;
    private String OwnerName;
    private String RegistrationNumber;
    private Date vehicleLaunchDate;

    public int getVehicle_ID() {
        return Vehicle_ID;
    }

    public void setVehicle_ID(final int vehicle_ID) {
        Vehicle_ID = vehicle_ID;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(final String ownerName) {
        OwnerName = ownerName;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(final String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public Date getVehicleLaunchDate() {
        return vehicleLaunchDate;
    }

    public void setVehicleLaunchDate(final Date vehicleLaunchDate) {
        this.vehicleLaunchDate = vehicleLaunchDate;
    }

    @Override
    public String toString() {
        final StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(getVehicle_ID());
        sBuilder.append("|" + getRegistrationNumber());
        sBuilder.append("|" + getOwnerName());
        sBuilder.append("|" + getVehicleLaunchDate());
        return sBuilder.toString();
    }
}
