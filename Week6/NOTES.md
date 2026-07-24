# Git Hands-on Lab Notes & Step-by-Step Commands

Author: Student (Cognizant FSE Training)  
Date: July 2026  

---

## Q1: Setup Git Configuration, Editor & Initial Repository (`GitDemo`)

### Commands Executed:
```bash
# 1. Verify Git Installation
git --version
# Output: git version 2.39.2.windows.1

# 2. Configure user details globally
git config --global user.name "Yash Mishra"
git config --global user.email "yash.mishra@example.com"

# 3. Check configuration settings
git config --list

# 4. Integrate Notepad++ as default editor
git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -notabbar -nosession -noPlugin"
alias npp="'C:/Program Files/Notepad++/notepad++.exe'"

# Verify editor config
git config --global -e

# 5. Create local repository
mkdir GitDemo
cd GitDemo
git init

# Verify hidden .git folder
ls -la

# 6. Create welcome.txt file
echo "Welcome to Git Hands-on Lab Exercise!" > welcome.txt
cat welcome.txt
git status

# 7. Stage & Commit file
git add welcome.txt
git commit -m "Initial commit: Add welcome.txt"

# 8. Link to remote repository and push
git remote add origin https://github.com/YagvallkyaMishra-31/GitDemo.git
git pull origin master --allow-unrelated-histories
git push -u origin master
```

---

## Q2: Implementing `.gitignore`

### Steps & Verification:
```bash
# Create log files and log directory
echo "App started log line 1" > app.log
mkdir -p logs
echo "Debug trace log" > logs/debug.log

# Check git status - app.log and logs/ appear untracked
git status

# Create .gitignore file
echo "*.log" > .gitignore
echo "logs/" >> .gitignore

# Check git status again - app.log and logs/ are now ignored!
git status

# Stage and commit .gitignore
git add .gitignore
git commit -m "Add .gitignore to exclude .log files and logs directory"
```

---

## Q3: Branching & Merging (`GitNewBranch`)

### Steps & Verification:
```bash
# 1. Create and list branches
git branch GitNewBranch
git branch -a
# * master
#   GitNewBranch

# 2. Switch to new branch
git checkout GitNewBranch

# 3. Add feature file in branch
echo "Feature updates in new branch" > feature.txt
git add feature.txt
git commit -m "Add feature.txt in GitNewBranch"

# 4. Switch back to master & compare diff
git checkout master
git diff master..GitNewBranch

# 5. Fast-forward merge GitNewBranch into master
git merge GitNewBranch

# 6. Check log history graph
git log --oneline --graph --decorate

# 7. Delete merged branch
git branch -d GitNewBranch
git status
```

---

## Q4: Resolving Merge Conflicts (`GitWork`)

### Scenario Setup & Conflict Resolution:
```bash
# 1. Ensure master clean state
git status

# 2. Create & switch to GitWork branch
git checkout -b GitWork

# 3. Create hello.xml in branch
cat << 'EOF' > hello.xml
<?xml version="1.0" encoding="UTF-8"?>
<greeting>
    <message>Hello from GitWork Branch!</message>
</greeting>
EOF

git add hello.xml
git commit -m "Add hello.xml in GitWork branch"

# 4. Switch to master and create conflicting hello.xml
git checkout master

cat << 'EOF' > hello.xml
<?xml version="1.0" encoding="UTF-8"?>
<greeting>
    <message>Hello from Master Branch!</message>
</greeting>
EOF

git add hello.xml
git commit -m "Add hello.xml in Master branch"

# 5. Attempt merge (Triggers Conflict!)
git merge GitWork
# Auto-merging hello.xml
# CONFLICT (add/add): Merge conflict in hello.xml
# Automatic merge failed; fix conflicts and then commit the result.

# 6. View diff and conflict markers
git diff

# 7. Resolve Conflict manually in hello.xml
cat << 'EOF' > hello.xml
<?xml version="1.0" encoding="UTF-8"?>
<greeting>
    <message>Hello from Master and GitWork (Merged & Resolved)!</message>
</greeting>
EOF

# 8. Stage, add backup files to .gitignore, and commit merge resolution
echo "*.orig" >> .gitignore
git add hello.xml .gitignore
git commit -m "Merge branch 'GitWork' and resolve conflict in hello.xml"

# 9. View graph log history & delete branch
git log --oneline --graph --decorate --all
git branch -d GitWork
```

---

## Q5: Remote Clean-up & Push Synchronization

### Commands Executed:
```bash
# 1. Check clean working directory
git status

# 2. List active branches
git branch

# 3. Pull latest remote changes
git pull origin master

# 4. Push local commits to remote repository
git push origin master

# 5. Verify git log graph
git log --oneline --graph --decorate -n 5
```
