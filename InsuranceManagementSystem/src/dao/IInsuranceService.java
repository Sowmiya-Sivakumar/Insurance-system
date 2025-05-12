package dao;

import entity.Insurance;
import java.util.Collection;

public interface IInsuranceService {
    boolean createInsurance(Insurance insurance);
    Insurance getInsurance(int insuranceId);
    Collection<Insurance> getAllInsurances();
    boolean updateInsurance(Insurance insurance);
    boolean deleteInsurance(int insuranceId);
}
