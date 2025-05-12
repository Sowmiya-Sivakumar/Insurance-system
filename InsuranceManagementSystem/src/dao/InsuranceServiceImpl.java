package dao;

import entity.Insurance;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class InsuranceServiceImpl implements IInsuranceService {
    private Connection connection;

    public InsuranceServiceImpl(Connection connection) {
        this.connection = connection;
    }

    public boolean createInsurance(Insurance insurance) {
        String query = "INSERT INTO Insurance (policyId, clientId, coverageAmount, startDate, endDate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, insurance.getPolicyId());
            stmt.setInt(2, insurance.getClientId());
            stmt.setDouble(3, insurance.getCoverageAmount());
            stmt.setDate(4, Date.valueOf(insurance.getStartDate()));
            stmt.setDate(5, Date.valueOf(insurance.getEndDate()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Insurance getInsurance(int insuranceId) {
        String query = "SELECT * FROM Insurance WHERE insuranceId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, insuranceId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Insurance(rs.getInt("insuranceId"), rs.getInt("policyId"), rs.getInt("clientId"), rs.getDouble("coverageAmount"), rs.getDate("startDate").toLocalDate(), rs.getDate("endDate").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Collection<Insurance> getAllInsurances() {
        Collection<Insurance> insurances = new ArrayList<>();
        String query = "SELECT * FROM Insurance";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                insurances.add(new Insurance(rs.getInt("insuranceId"), rs.getInt("policyId"), rs.getInt("clientId"), rs.getDouble("coverageAmount"), rs.getDate("startDate").toLocalDate(), rs.getDate("endDate").toLocalDate()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insurances;
    }

    public boolean updateInsurance(Insurance insurance) {
        String query = "UPDATE Insurance SET policyId = ?, clientId = ?, coverageAmount = ?, startDate = ?, endDate = ? WHERE insuranceId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, insurance.getPolicyId());
            stmt.setInt(2, insurance.getClientId());
            stmt.setDouble(3, insurance.getCoverageAmount());
            stmt.setDate(4, Date.valueOf(insurance.getStartDate()));
            stmt.setDate(5, Date.valueOf(insurance.getEndDate()));
            stmt.setInt(6, insurance.getInsuranceId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteInsurance(int insuranceId) {
        String query = "DELETE FROM Insurance WHERE insuranceId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, insuranceId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public boolean create(Insurance insurance) {
		// TODO Auto-generated method stub
		return false;
	}

	public Insurance getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Insurance> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deletePolicy(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Insurance updatedInsurance) {
		// TODO Auto-generated method stub
		return false;
	}
}

