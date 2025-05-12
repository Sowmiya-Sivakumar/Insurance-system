package dao;

import entity.Policy;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class PolicyServiceImpl implements IPolicyService {
    private Connection connection;

    public PolicyServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean createPolicy(Policy policy) {
        String query = "INSERT INTO Policies (policyName, policyDetails, premiumAmount) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, policy.getPolicyName());
            stmt.setString(2, policy.getPolicyDetails());
            stmt.setDouble(3, policy.getPremiumAmount());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Policy getPolicy(int policyId) {
        String query = "SELECT * FROM Policies WHERE policyId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, policyId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Policy(rs.getInt("policyId"), rs.getString("policyName"), rs.getString("policyDetails"), rs.getDouble("premiumAmount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Policy> getAllPolicies() {
        Collection<Policy> policies = new ArrayList<>();
        String query = "SELECT * FROM Policies";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                policies.add(new Policy(rs.getInt("policyId"), rs.getString("policyName"), rs.getString("policyDetails"), rs.getDouble("premiumAmount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policies;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
        String query = "UPDATE Policies SET policyName = ?, policyDetails = ?, premiumAmount = ? WHERE policyId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, policy.getPolicyName());
            stmt.setString(2, policy.getPolicyDetails());
            stmt.setDouble(3, policy.getPremiumAmount());
            stmt.setInt(4, policy.getPolicyId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePolicy(int policyId) {
        String query = "DELETE FROM Policies WHERE policyId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, policyId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public Collection<Policy> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Policy getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

