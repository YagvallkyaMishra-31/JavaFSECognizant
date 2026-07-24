#!/bin/bash
# =======================================================
# Week 6 Git Hands-on Automated Verification Script
# Simulates and verifies Q1 to Q5 Git workflows
# =======================================================

echo "--- Starting Git Hands-on Exercises Simulation ---"

# Step 1: Initialize GitDemo directory
mkdir -p GitDemo_Lab
cd GitDemo_Lab
git init

# Step 2: Configure & Add welcome.txt (Q1)
echo "Welcome to Git Hands-on Lab Exercise!" > welcome.txt
git add welcome.txt
git commit -m "Q1: Initial commit with welcome.txt"

# Step 3: Setup .gitignore (Q2)
echo "*.log" > .gitignore
echo "logs/" >> .gitignore
mkdir -p logs
echo "Test log" > logs/app.log
echo "Debug log" > debug.log
git add .gitignore
git commit -m "Q2: Add .gitignore for log files"

# Step 4: Branching & Merging (Q3)
git branch GitNewBranch
git checkout GitNewBranch
echo "New feature content" > feature.txt
git add feature.txt
git commit -m "Q3: Feature addition in GitNewBranch"
git checkout master
git merge GitNewBranch -m "Q3: Merge GitNewBranch into master"
git branch -d GitNewBranch

# Step 5: Merge Conflict Resolution (Q4)
git checkout -b GitWork
echo "<note>GitWork Branch</note>" > hello.xml
git add hello.xml
git commit -m "Q4: Add hello.xml in GitWork"

git checkout master
echo "<note>Master Branch</note>" > hello.xml
git add hello.xml
git commit -m "Q4: Add hello.xml in master"

# Trigger merge conflict
git merge GitWork || echo "Expected Merge Conflict Encountered!"

# Resolve conflict
echo "<note>Resolved Master and GitWork</note>" > hello.xml
echo "*.orig" >> .gitignore
git add hello.xml .gitignore
git commit -m "Q4: Resolved merge conflict in hello.xml"
git branch -d GitWork

# Step 6: Verify Commit Graph (Q5)
echo "--- Final Commit History ---"
git log --oneline --graph --decorate

echo "--- Git Hands-on Simulation Completed Successfully ---"
