-- ============================================================
-- Exercise 3: Stored Procedures
-- Three procedures: monthly interest, employee bonus, fund transfer
-- ============================================================

-- ==========================
-- TABLE CREATION
-- ==========================

-- Note: customers table is assumed to already exist from Exercise 1.
-- If running standalone, create the customers table first.

-- Accounts table linked to customers
CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    account_type VARCHAR2(20),
    balance NUMBER(15,2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Employees table (independent, no FK needed)
CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    department_id NUMBER,
    salary NUMBER(15,2)
);

-- ==========================
-- SAMPLE DATA
-- ==========================

-- Mix of Savings and Current accounts
INSERT INTO accounts VALUES (201, 1, 'Savings', 15000.00);
INSERT INTO accounts VALUES (202, 2, 'Current', 8500.00);
INSERT INTO accounts VALUES (203, 3, 'Savings', 22000.00);
INSERT INTO accounts VALUES (204, 4, 'Savings', 5000.00);
INSERT INTO accounts VALUES (205, 5, 'Current', 12000.00);

-- Employees spread across two departments (10 and 20)
INSERT INTO employees VALUES (301, 'Amit Joshi',    10, 55000.00);
INSERT INTO employees VALUES (302, 'Sneha Rao',     10, 62000.00);
INSERT INTO employees VALUES (303, 'Vikram Singh',   20, 48000.00);
INSERT INTO employees VALUES (304, 'Kavita Nair',    20, 53000.00);
INSERT INTO employees VALUES (305, 'Rohan Mehta',    10, 70000.00);

COMMIT;

SET SERVEROUTPUT ON;


-- ============================================================
-- Procedure 1: ProcessMonthlyInterest
-- Adds 1% interest to all Savings accounts
-- ============================================================

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_count NUMBER := 0;
BEGIN
    -- update all savings accounts with 1% interest
    UPDATE accounts
    SET balance = balance * 1.01
    WHERE account_type = 'Savings';

    -- SQL%ROWCOUNT tells us how many rows the last DML affected
    v_count := SQL%ROWCOUNT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to ' || v_count || ' Savings account(s).');

    COMMIT;
END;
/

-- Demo: call the procedure
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Running ProcessMonthlyInterest ---');
    ProcessMonthlyInterest;
END;
/


-- ============================================================
-- Procedure 2: UpdateEmployeeBonus
-- Gives a percentage bonus to all employees in a department
-- ============================================================

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) IS
    v_count NUMBER := 0;
BEGIN
    -- increase salary by the given percentage
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percentage / 100)
    WHERE department_id = p_department_id;

    v_count := SQL%ROWCOUNT;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department ' || p_department_id || '.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(v_count || ' employee(s) in department ' ||
            p_department_id || ' received a ' || p_bonus_percentage || '% bonus.');
    END IF;

    COMMIT;
END;
/

-- Demo: give 10% bonus to department 10
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Running UpdateEmployeeBonus ---');
    UpdateEmployeeBonus(10, 10);
END;
/


-- ============================================================
-- Procedure 3: TransferFunds
-- Moves money from one account to another with balance check
-- ============================================================

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_source_account IN NUMBER,
    p_target_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_source_balance NUMBER(15,2);
BEGIN
    -- first check the source account balance
    SELECT balance INTO v_source_balance
    FROM accounts
    WHERE account_id = p_source_account;

    -- if not enough money, raise an error
    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001,
            'Insufficient funds. Source account ' || p_source_account ||
            ' has balance ' || v_source_balance ||
            ' but transfer amount is ' || p_amount);
    END IF;

    -- debit the source
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_source_account;

    -- credit the target
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_target_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_amount ||
        ' moved from Account ' || p_source_account ||
        ' to Account ' || p_target_account || '.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One of the account IDs does not exist.');
        ROLLBACK;
    WHEN OTHERS THEN
        -- catches the RAISE_APPLICATION_ERROR and any unexpected issues
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
        ROLLBACK;
END;
/

-- Demo: valid transfer
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Running TransferFunds (valid) ---');
    TransferFunds(201, 202, 2000);
END;
/

-- Demo: transfer that should fail (amount too large)
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Running TransferFunds (insufficient funds) ---');
    TransferFunds(204, 205, 999999);
END;
/
