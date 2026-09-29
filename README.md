# SAM AI Technologies - Java Programming Internship

Java console programs I built for the SAM AI Technologies internship.
Each task is a single folder with one `.java` file (Task 3 has two small classes in one file).

## Tasks

| # | Task | What it does |
|---|------|--------------|
| 1 | Number Game | Computer picks 1-100, you guess, it says Too High / Too Low / Correct |
| 2 | Student Grade Calculator | Takes marks for N subjects, shows total, average and grade (A/B/C/Fail) using an ArrayList |
| 3 | ATM Interface | PIN login, withdraw, deposit, check balance, with input validation |
| 4 | Currency Converter | Converts between USD, INR, EUR, GBP, JPY using fixed exchange rates |
| 5 | Password Generator | Random password of chosen length with upper, lower, digits and symbols |

## How to run

You need JDK 8 or newer installed. Example for Task 1:

```
cd Task1_NumberGame
javac NumberGame.java
java NumberGame
```

Same steps for the other folders (the file names are `StudentGradeCalculator`, `ATM`, `CurrencyConverter`, `PasswordGenerator`).

## Notes

- ATM demo PIN is `1234` and the starting balance is Rs. 5000.
- Grade rules: A >= 80%, B >= 60%, C >= 40%, below 40% is Fail.
- Exchange rates in Task 4 are fixed sample values, not live rates.
