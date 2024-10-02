-- Gym Management System Database Schema
-- This schema defines the tables for managing gym members, coaches, payments, and user accounts

-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS gym_management;
USE gym_management;

-- Users table for login credentials
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'staff') NOT NULL DEFAULT 'staff',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Members table for storing gym member information
CREATE TABLE members (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    age INT,
    gender ENUM('male', 'female', 'other'),
    address VARCHAR(255),
    membership_status ENUM('active', 'inactive', 'suspended') DEFAULT 'active',
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    assigned_coach_id INT,
    FOREIGN KEY (assigned_coach_id) REFERENCES coaches(coach_id) ON DELETE SET NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Coaches table for storing information about gym coaches
CREATE TABLE coaches (
    coach_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    specialization VARCHAR(100),
    status ENUM('active', 'inactive') DEFAULT 'active',
    hire_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Payments table for storing payment information
CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT NOT NULL,
    payment_date DATE NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method ENUM('cash', 'credit_card', 'bank_transfer') DEFAULT 'cash',
    payment_status ENUM('completed', 'pending', 'failed') DEFAULT 'completed',
    FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Membership plans table to define various membership options
CREATE TABLE membership_plans (
    plan_id INT AUTO_INCREMENT PRIMARY KEY,
    plan_name VARCHAR(50) NOT NULL,
    duration_days INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Assign membership plans to members
ALTER TABLE members
ADD COLUMN membership_plan_id INT,
ADD FOREIGN KEY (membership_plan_id) REFERENCES membership_plans(plan_id) ON DELETE SET NULL;

-- Audit logs table to track actions performed by users
CREATE TABLE audit_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    action VARCHAR(255) NOT NULL,
    action_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Inserting default admin user (please hash the password using a secure method)
INSERT INTO users (username, password, role)
VALUES ('admin', 'your_hashed_password', 'admin');

-- Sample membership plans
INSERT INTO membership_plans (plan_name, duration_days, price)
VALUES ('Monthly', 30, 50.00), ('Quarterly', 90, 120.00), ('Annual', 365, 300.00);

-- Sample coaches
INSERT INTO coaches (first_name, last_name, email, phone_number, specialization, hire_date)
VALUES ('John', 'Doe', 'john.doe@gym.com', '123-456-7890', 'Personal Trainer', '2023-01-15'),
       ('Jane', 'Smith', 'jane.smith@gym.com', '098-765-4321', 'Yoga Instructor', '2022-10-05');

-- Sample members
INSERT INTO members (first_name, last_name, email, phone_number, start_date, end_date, membership_plan_id, membership_status, assigned_coach_id)
VALUES ('Alice', 'Johnson', 'alice.johnson@example.com', '123-123-1234', '2023-01-01', '2023-12-31', 3, 'active', 1),
       ('Bob', 'Brown', 'bob.brown@example.com', '321-321-4321', '2023-02-01', '2023-05-01', 1, 'active', 2);

-- Sample payments
INSERT INTO payments (member_id, payment_date, amount, payment_method, payment_status)
VALUES (1, '2023-01-01', 300.00, 'credit_card', 'completed'),
       (2, '2023-02-01', 50.00, 'cash', 'completed');
