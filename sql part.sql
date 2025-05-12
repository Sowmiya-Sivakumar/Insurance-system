create database InsuranceManagementSystem
use InsuranceManagementSystem

-- Create User Table
CREATE TABLE Users (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Create Client Table
CREATE TABLE Clients (
    clientId INT PRIMARY KEY AUTO_INCREMENT,
    clientName VARCHAR(255) NOT NULL,
    contactInfo VARCHAR(255) NOT NULL,
    policy VARCHAR(255) NOT NULL
);

-- Create Claim Table
CREATE TABLE Claims (
    claimId INT PRIMARY KEY AUTO_INCREMENT,
    claimNumber VARCHAR(255) NOT NULL,
    dateFiled DATE NOT NULL,
    claimAmount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    policy VARCHAR(255) NOT NULL,
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Clients(clientId)
);

-- Create Payment Table
CREATE TABLE Payments (
    paymentId INT PRIMARY KEY AUTO_INCREMENT,
    paymentDate DATE NOT NULL,
    paymentAmount DECIMAL(10, 2) NOT NULL,
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Clients(clientId)
);

-- Create Policy Table (Assuming you have a Policy entity)
CREATE TABLE Policies (
    policyId INT PRIMARY KEY AUTO_INCREMENT,
    policyName VARCHAR(255) NOT NULL,
    policyDetails TEXT NOT NULL,
    premiumAmount DECIMAL(10, 2) NOT NULL
);
-- Insert sample data into Users table
INSERT INTO Users (username, password, role) VALUES 
('john_doe', 'password123', 'admin'),
('jane_smith', 'securepass', 'user'),
('alice_jones', 'alicepass', 'user'),
('bob_brown', 'bobpass', 'user'),
('charlie_black', 'charliepass', 'user'),
('david_white', 'davidpass', 'admin');

-- Insert sample data into Clients table
INSERT INTO Clients (clientName, contactInfo, policy) VALUES 
('Acme Corp', '123-456-7890', 'Policy A'),
('Globex Inc', '987-654-3210', 'Policy B'),
('Initech', '555-123-4567', 'Policy C'),
('Umbrella Corp', '555-765-4321', 'Policy D'),
('Stark Industries', '555-111-2222', 'Policy E'),
('Wayne Enterprises', '555-333-4444', 'Policy F');

-- Insert sample data into Policies table
INSERT INTO Policies (policyName, policyDetails, premiumAmount) VALUES 
('Policy A', 'Comprehensive coverage for Acme Corp', 1500.00),
('Policy B', 'Basic coverage for Globex Inc', 800.00),
('Policy C', 'Liability coverage for Initech', 1200.00),
('Policy D', 'Property coverage for Umbrella Corp', 2000.00),
('Policy E', 'Health coverage for Stark Industries', 1800.00),
('Policy F', 'Auto coverage for Wayne Enterprises', 900.00);

-- Insert sample data into Claims table
INSERT INTO Claims (claimNumber, dateFiled, claimAmount, status, policy, clientId) VALUES 
('CLM001', '2023-01-15', 5000.00, 'Pending', 'Policy A', 1),
('CLM002', '2023-02-20', 3000.00, 'Approved', 'Policy B', 2),
('CLM003', '2023-03-10', 7000.00, 'Denied', 'Policy C', 3),
('CLM004', '2023-04-05', 2500.00, 'Pending', 'Policy D', 4),
('CLM005', '2023-05-15', 4000.00, 'Approved', 'Policy E', 5),
('CLM006', '2023-06-20', 1500.00, 'Pending', 'Policy F', 6);

-- Insert sample data into Payments table
INSERT INTO Payments (paymentDate, paymentAmount, clientId) VALUES 
('2023-01-20', 1500.00, 1),
('2023-02-25', 800.00, 2),
('2023-03-15', 1200.00, 3),
('2023-04-10', 2000.00, 4),
('2023-05-20', 1800.00, 5),
('2023-06-25', 900.00, 6);

-- Create Insurance Table
CREATE TABLE Insurance (
    insuranceId INT PRIMARY KEY AUTO_INCREMENT,
    policyId INT,
    clientId INT,
    coverageAmount DECIMAL(10, 2) NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    FOREIGN KEY (policyId) REFERENCES Policies(policyId),
    FOREIGN KEY (clientId) REFERENCES Clients(clientId)
);

-- Insert sample data into Insurance table
INSERT INTO Insurance (policyId, clientId, coverageAmount, startDate, endDate) VALUES 
(1, 1, 100000.00, '2023-01-01', '2024-01-01'),
(2, 2, 50000.00, '2023-02-01', '2024-02-01'),
(3, 3, 75000.00, '2023-03-01', '2024-03-01'),
(4, 4, 200000.00, '2023-04-01', '2024-04-01'),
(5, 5, 150000.00, '2023-05-01', '2024-05-01'),
(6, 6, 300000.00, '2023-06-01', '2024-06-01'),
(1, 2, 120000.00, '2023-07-01', '2024-07-01'),
(3, 1, 90000.00, '2023-08-01', '2024-08-01');


