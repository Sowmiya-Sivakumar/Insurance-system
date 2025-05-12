package entity;

import java.time.LocalDate;

public class Insurance {
    private int insuranceId;
    private int policyId;
    private int clientId;
    private double coverageAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    // Constructor
    public Insurance(int insuranceId, int policyId, int clientId, double coverageAmount, LocalDate startDate, LocalDate endDate) {
        this.insuranceId = insuranceId;
        this.policyId = policyId;
        this.clientId = clientId;
        this.coverageAmount = coverageAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters
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

    // toString
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
}
