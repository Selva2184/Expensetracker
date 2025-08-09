# Expense Tracker (Java Console App)

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




