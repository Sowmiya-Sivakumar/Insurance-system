package entity;

import java.time.LocalDate;
import java.util.Date;

public class Insurance {
    private int insuranceId;
    private int policyId;
    private int clientId;
    private double coverageAmount;
    private LocalDate startDate;
    private Date endDate;

    public Insurance(int insuranceId, int policyId, int clientId, double coverageAmount, LocalDate localDate, LocalDate localDate2) {
        this.insuranceId = insuranceId;
        this.policyId = policyId;
        this.clientId = clientId;
        this.coverageAmount = coverageAmount;
        this.startDate = localDate;
        this.endDate = localDate2;
    }

    public Insurance(int id, String name, String details) {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getInsuranceId() {
        return insuranceId;
    }

    public int getPolicyId() {
        return policyId;
    }

    public int getClientId() {
        return clientId;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceId=" + insuranceId +
                ", policyId=" + policyId +
                ", clientId=" + clientId +
                ", coverageAmount=" + coverageAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

