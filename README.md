# Expense Tracker (Java Console App)

## What is this?
A simple Java console application to record personal expenses.  
Features:
- Add expense (date, category, amount)
- View all expenses
- View total expenses by category
- Persistent storage in a local `expenses.txt` file

This is deliberately small and easy to run so you can finish it quickly and upload for job applications.

---

## Files in this package
- `ExpenseTracker.java` — Java source code
- `expenses.txt` — Sample data (can be empty or prefilled)
- `run_examples.txt` — Example interaction (sample terminal session)
- `README.md` — This file

---

## How the data is stored
Each expense is stored as a comma-separated line:
```
YYYY-MM-DD,category,amount
```
Example:
```
2025-01-04,Food,150.00
2025-01-05,Transport,60.00
```

---

## Run instructions (Command-line)

### Requirements
- JDK installed (javac & java available)
- Current directory set to the folder containing `ExpenseTracker.java`

### Compile
```bash
javac ExpenseTracker.java
```

This produces `ExpenseTracker.class`.

### Run
```bash
java ExpenseTracker
```

You will see a menu. Enter choices as numbers (1,2,3,4) and follow prompts.

---

## Create runnable JAR (optional)
1. Compile:
```bash
javac ExpenseTracker.java
```
2. Create a manifest file `manifest.txt` containing:
```
Main-Class: ExpenseTracker
```
(make sure there is a newline at the end of the file)
3. Create JAR:
```bash
jar cfm ExpenseTracker.jar manifest.txt ExpenseTracker.class
```
4. Run:
```bash
java -jar ExpenseTracker.jar
```

---

## Notes & Tips
- `expenses.txt` is created in the same folder when you add the first expense.
- If you prefer, edit `expenses.txt` manually (follow CSV format).
- To take a screenshot of your working output, run the program, show the menu and some sample data, then take a screenshot and include it in your project upload.

---

## Possible improvements (if you have more time)
- Add validation for date format (YYYY-MM-DD)
- Save data in JSON or a small SQLite DB
- Add 'delete expense' or 'edit expense' feature
- Create a simple Swing or JavaFX GUI
- Add monthly or date-range reports
