package dao;

import entity.Policy;
import java.util.Collection;

public interface IPolicyService {
    boolean createPolicy(Policy policy); // Method to create a new policy
    Policy getPolicy(int policyId); // Method to retrieve a policy by ID
    Collection<Policy> getAllPolicies(); // Method to retrieve all policies
    boolean updatePolicy(Policy policy); // Method to update an existing policy
    boolean deletePolicy(int policyId); // Method to delete a policy by ID
}
