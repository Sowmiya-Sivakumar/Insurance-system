package main;

import dao.InsuranceServiceImpl;
import dao.PolicyServiceImpl;
import entity.Insurance;
import entity.Policy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainModule {
    private static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/InsuranceManagementSystem"; 
        String user = "root"; 
        String password = "S3cur3P@ssw0rd!"; 

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Database connection failed:");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = getConnection();

        if (connection == null) {
            System.out.println("Failed to establish a database connection. Exiting.");
            scanner.close();
            return;
        }

        PolicyServiceImpl policyService = new PolicyServiceImpl(connection);
        InsuranceServiceImpl insuranceService = new InsuranceServiceImpl(connection);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println();
            System.out.println("Insurance Management System");
            System.out.println("1. Create Policy");
            System.out.println("2. Get Policy");
            System.out.println("3. Get All Policies");
            System.out.println("4. Update Policy");
            System.out.println("5. Delete Policy");
            System.out.println("6. Create Insurance");
            System.out.println("7. Get Insurance");
            System.out.println("8. Get All Insurances");
            System.out.println("9. Update Insurance");
            System.out.println("10. Delete Insurance");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Create Policy
                    System.out.print("Enter Policy Name: ");
                    String policyName = scanner.nextLine();
                    System.out.print("Enter Policy Details: ");
                    String policyDetails = scanner.nextLine();
                    System.out.print("Enter Premium Amount: ");
                    double premiumAmount = scanner.nextDouble();
                    scanner.nextLine();
                    Policy newPolicy = new Policy(0, policyName, policyDetails, premiumAmount);
                    if (policyService.createPolicy(newPolicy)) {
                        System.out.println("Policy created successfully.");
                    } else {
                        System.out.println("Failed to create policy.");
                    }
                    break;

                case 2: // Get Policy
                    System.out.print("Enter Policy ID: ");
                    int policyId = scanner.nextInt();
                    scanner.nextLine();
                    Policy policy = policyService.getPolicy(policyId);
                    if (policy != null) {
                        System.out.println("Policy Details: " + policy);
                    } else {
                        System.out.println("Policy not found.");
                    }
                    break;

                case 3: // Get All Policies
                    Collection<Policy> policies = policyService.getAllPolicies();
                    if (policies != null && !policies.isEmpty()) {
                        for (Policy p : policies) {
                            System.out.println(p);
                        }
                    } else {
                        System.out.println("No policies found.");
                    }
                    break;

                case 4: // Update Policy
                    System.out.print("Enter Policy ID to update: ");
                    int updatePolicyId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Policy Name: ");
                    String newPolicyName = scanner.nextLine();
                    System.out.print("Enter New Policy Details: ");
                    String newPolicyDetails = scanner.nextLine();
                    System.out.print("Enter New Premium Amount: ");
                    double newPremiumAmount = scanner.nextDouble();
                    scanner.nextLine();
                    Policy updatedPolicy = new Policy(updatePolicyId, newPolicyName, newPolicyDetails, newPremiumAmount);
                    if (policyService.updatePolicy(updatedPolicy)) {
                        System.out.println("Policy updated successfully.");
                    } else {
                        System.out.println("Failed to update policy.");
                    }
                    break;

                case 5: // Delete Policy
                    System.out.print("Enter Policy ID to delete: ");
                    int deletePolicyId = scanner.nextInt();
                    scanner.nextLine();
                    if (policyService.deletePolicy(deletePolicyId)) {
                        System.out.println("Policy deleted successfully.");
                    } else {
                        System.out.println("Failed to delete policy.");
                    }
                    break;

                case 6: // Create Insurance
                    try {
                        System.out.print("Enter Policy ID: ");
                        int insurancePolicyId = scanner.nextInt();
                        System.out.print("Enter Client ID: ");
                        int clientId = scanner.nextInt();
                        System.out.print("Enter Coverage Amount: ");
                        double coverageAmount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter Start Date (yyyy-MM-dd): ");
                        String startDateStr = scanner.nextLine();
                        System.out.print("Enter End Date (yyyy-MM-dd): ");
                        String endDateStr = scanner.nextLine();

                        Date startDate = dateFormat.parse(startDateStr);
                        Date endDate = dateFormat.parse(endDateStr);

                        Insurance newInsurance = new Insurance(0, insurancePolicyId, clientId, coverageAmount, startDate, endDate);
                        if (insuranceService.createInsurance(newInsurance)) {
                            System.out.println("Insurance created successfully.");
                        } else {
                            System.out.println("Failed to create insurance.");
                        }
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                    }
                    break;

                case 7: // Get Insurance
                    System.out.print("Enter Insurance ID: ");
                    int insuranceId = scanner.nextInt();
                    scanner.nextLine();
                    Insurance insurance = insuranceService.getInsurance(insuranceId);
                    if (insurance != null) {
                        System.out.println("Insurance Details: " + insurance);
                    } else {
                        System.out.println("Insurance not found.");
                    }
                    break;

                case 8: // Get All Insurances
                    Collection<Insurance> insurances = insuranceService.getAllInsurances();
                    if (insurances != null && !insurances.isEmpty()) {
                        for (Insurance ins : insurances) {
                            System.out.println(ins);
                        }
                    } else {
                        System.out.println("No insurances found.");
                    }
                    break;

                case 9: // Update Insurance
                    try {
                        System.out.print("Enter Insurance ID to update: ");
                        int updateInsuranceId = scanner.nextInt();
                        System.out.print("Enter New Policy ID: ");
                        int newInsurancePolicyId = scanner.nextInt();
                        System.out.print("Enter New Client ID: ");
                        int newClientId = scanner.nextInt();
                        System.out.print("Enter New Coverage Amount: ");
                        double newCoverageAmount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter New Start Date (yyyy-MM-dd): ");
                        String newStartDateStr = scanner.nextLine();
                        System.out.print("Enter New End Date (yyyy-MM-dd): ");
                        String newEndDateStr = scanner.nextLine();

                        Date newStartDate = dateFormat.parse(newStartDateStr);
                        Date newEndDate = dateFormat.parse(newEndDateStr);

                        Insurance updatedInsurance = new Insurance(updateInsuranceId, newInsurancePolicyId, newClientId, newCoverageAmount, newStartDate, newEndDate);
                        if (insuranceService.updateInsurance(updatedInsurance)) {
                            System.out.println("Insurance updated successfully.");
                        } else {
                            System.out.println("Failed to update insurance.");
                        }
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                    }
                    break;

                case 10: // Delete Insurance
                    System.out.print("Enter Insurance ID to delete: ");
                    int deleteInsuranceId = scanner.nextInt();
                    scanner.nextLine();
                    if (insuranceService.deleteInsurance(deleteInsuranceId)) {
                        System.out.println("Insurance deleted successfully.");
                    } else {
                        System.out.println("Failed to delete insurance.");
                    }
                    break;

                case 0: // Exit
                    System.out.println("Exiting the system.");
                    scanner.close();
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

