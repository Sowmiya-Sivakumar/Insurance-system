package entity;

public class Policy {
    private int policyId;
    private String policyName;
    private String policyDetails;
    private double premiumAmount;

    public Policy(int policyId, String policyName, String policyDetails, double premiumAmount) {
        this.policyId = policyId;
        this.policyName = policyName;
        this.policyDetails = policyDetails;
        this.premiumAmount = premiumAmount;
    }

    // Getters and Setters
    public int getPolicyId() {
        return policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public String getPolicyDetails() {
        return policyDetails;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", policyName='" + policyName + '\'' +
                ", policyDetails='" + policyDetails + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
