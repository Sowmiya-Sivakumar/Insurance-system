package dao;

import entity.Insurance;
import java.util.Collection;

public interface IInsuranceService {
    boolean createInsurance(Insurance insurance);           // Method to create a new insurance record
    Insurance getInsurance(int insuranceId);                // Method to retrieve an insurance by ID
    Collection<Insurance> getAllInsurances();               // Method to retrieve all insurance records
    boolean updateInsurance(Insurance insurance);           // Method to update an existing insurance record
    boolean deleteInsurance(int insuranceId);               // Method to delete an insurance by ID
}
