-- ============================================================
-- Exercise 1: Control Structures
-- This file covers cursors, IF-ELSE logic, and loops in PL/SQL
-- ============================================================

-- ==========================
-- TABLE CREATION
-- ==========================

-- Create Customers table
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER,
    balance NUMBER(15,2),
    IsVIP CHAR(5) DEFAULT 'FALSE'
);

-- Create Loans table
CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    loan_amount NUMBER(15,2),
    interest_rate NUMBER(5,2),
    end_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- ==========================
-- SAMPLE DATA
-- ==========================

-- Mix of ages (some > 60, some not) and balances (some > 10000, some not)
INSERT INTO customers VALUES (1, 'Rajesh Kumar',    65, 15000.00, 'FALSE');
INSERT INTO customers VALUES (2, 'Priya Sharma',    29, 8500.00,  'FALSE');
INSERT INTO customers VALUES (3, 'Mohan Verma',     72, 22000.00, 'FALSE');
INSERT INTO customers VALUES (4, 'Anita Desai',     45, 5000.00,  'FALSE');
INSERT INTO customers VALUES (5, 'Suresh Patil',    68, 12000.00, 'FALSE');
INSERT INTO customers VALUES (6, 'Neha Gupta',      34, 30000.00, 'FALSE');

-- Loans with varying end dates — some due soon, some far out
INSERT INTO loans VALUES (101, 1, 50000.00,  5.50, SYSDATE + 15);
INSERT INTO loans VALUES (102, 2, 30000.00,  7.00, SYSDATE + 90);
INSERT INTO loans VALUES (103, 3, 80000.00,  6.25, SYSDATE + 10);
INSERT INTO loans VALUES (104, 4, 20000.00,  8.00, SYSDATE + 25);
INSERT INTO loans VALUES (105, 5, 45000.00,  5.75, SYSDATE + 60);

COMMIT;


-- ============================================================
-- Scenario 1: Discount for Senior Citizens
-- If a customer is above 60, reduce their loan interest by 1%
-- ============================================================

SET SERVEROUTPUT ON;

DECLARE
    -- cursor joins customers and loans so we can check age for each loan
    CURSOR senior_cur IS
        SELECT c.customer_id, c.name, c.age, l.loan_id, l.interest_rate
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60;

    v_new_rate NUMBER(5,2);
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Senior Citizen Loan Discount ---');

    FOR rec IN senior_cur LOOP
        -- reduce the rate by 1 percent
        v_new_rate := rec.interest_rate - 1;

        UPDATE loans
        SET interest_rate = v_new_rate
        WHERE loan_id = rec.loan_id;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.name ||
            ' (Age ' || rec.age || ') - Loan ' || rec.loan_id ||
            ' rate reduced from ' || rec.interest_rate || '% to ' || v_new_rate || '%');
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Senior citizen discount applied successfully.');
END;
/


-- ============================================================
-- Scenario 2: VIP Status Based on Balance
-- Customers with balance > 10000 get promoted to VIP
-- ============================================================

DECLARE
    -- simple cursor FOR loop — no explicit OPEN/FETCH needed
    CURSOR cust_cur IS
        SELECT customer_id, name, balance
        FROM customers;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- VIP Status Update ---');

    FOR rec IN cust_cur LOOP
        IF rec.balance > 10000 THEN
            UPDATE customers
            SET IsVIP = 'TRUE'
            WHERE customer_id = rec.customer_id;

            DBMS_OUTPUT.PUT_LINE(rec.name || ' (Balance: ' || rec.balance ||
                ') promoted to VIP.');
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status update complete.');
END;
/


-- ============================================================
-- Scenario 3: Loan Due Reminders
-- Print a reminder for loans that are due within 30 days
-- ============================================================

DECLARE
    CURSOR due_cur IS
        SELECT c.name, l.loan_id, l.loan_amount, l.end_date
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.end_date <= SYSDATE + 30;

    v_name    customers.name%TYPE;
    v_id      loans.loan_id%TYPE;
    v_amount  loans.loan_amount%TYPE;
    v_date    loans.end_date%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Loan Due Reminders ---');

    OPEN due_cur;
    LOOP
        FETCH due_cur INTO v_name, v_id, v_amount, v_date;
        EXIT WHEN due_cur%NOTFOUND;

        -- print a friendly reminder message
        DBMS_OUTPUT.PUT_LINE('Dear ' || v_name ||
            ', your loan (ID: ' || v_id ||
            ') of amount ' || v_amount ||
            ' is due on ' || TO_CHAR(v_date, 'DD-MON-YYYY') ||
            '. Please ensure timely payment.');
    END LOOP;
    CLOSE due_cur;
END;
/
