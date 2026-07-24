# Week 6 - Git Hands-on Exercises

This directory contains documentation, shell scripts, and exercise walkthroughs for the Git version control hands-on labs (Q1 to Q5).

## Overview of Exercises

- **Q1: Git Configuration & First Repository (`GitDemo`)**
  - Git user name & email configuration
  - Configuring default editor (Notepad++)
  - Creating `GitDemo` repository, adding `welcome.txt`, committing, and pushing.

- **Q2: Git Ignore (`.gitignore`)**
  - Ignoring `.log` files and `log/` directories using `.gitignore`.
  - Verifying `git status` output to ensure ignored files are untracked.

- **Q3: Branching & Merging (`GitNewBranch`)**
  - Creating and switching to branch `GitNewBranch`.
  - Making changes, committing in branch, diffing with `master`, and merging back into `master`.
  - Visualizing log history with `git log --oneline --graph --decorate`.
  - Deleting merged branch.

- **Q4: Merge Conflict Resolution (`GitWork`)**
  - Creating `GitWork` branch with `hello.xml`.
  - Modifying `hello.xml` in branch and master differently to intentionally induce a merge conflict.
  - Resolving 3-way merge conflict manually and committing resolution.
  - Updating `.gitignore` for backup files (`*.orig`).

- **Q5: Remote Repository Synchronization & Clean-up**
  - Cleaning up local branch workspace (`git branch -d`).
  - Pulling remote changes (`git pull origin master`).
  - Pushing local master commits back to remote (`git push origin master`).
