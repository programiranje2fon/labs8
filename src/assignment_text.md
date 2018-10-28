# Lab exercise 8

## Task 1
*(to be done by the tutor together with students)*

Create public *abstract* class **Employee**, in package **task1**, with the following elements:

1. Protected attribute **hourlyRate** that represents the price for one hour of work.
2. Public **get and set** methods for the attribute **hourlyRate**.
3. Public *abstract* method **computeSalary** that receives, as its input parameter, the number of working hours within a month, and computes and returns the employee's salary.  

In package **task1**, create public class **FactoryWorker** that extends the **Employee** class, and implements method **computeSalary**. The method computes and returns the employee's salary using the formula: **salary = number of working hours * hourly rate**.

In package **task1**, create public class **Commercialist** that extends the **Employee** class, and implements method **computeSalary**. The method computes and returns the employee's salary using the formula: **salary = number of working hours * hourly rate + bonus**, where bonus has the fixed value of 50,000 RSD.

In package **task1**, create public class **TestEmployee**. In the main method of this class, create one object of the type **FactoryWorker** with hourly rate of 170 RSD and one object of the type **Commercialist** with hourly rate of 450 RSD.
Compute and print salaries for both employees for a month when each of them had 176 working hours. 
  
Create public interface **AccountingInterface** in package **task1.finances**. This interface declares public method **paySalaries** that receives, as its input parameters, an array of objects of the type **Employee** and the number of working hours within a month; the method has no return value.  

In package **task1.finances**, create public class **AccountingDepartment** that implements **AccountingInterface**, and has: 

1. Private attribute **balance** that represents the current amount of money at the company's account.
2. Public **get and set** methods for the **balance** attribute. 
3. Implementation of the public method **paySalaries**. The method computes the overall amount to be payed to all employees from the array of employees that is passed to the method as its input parameter. If there is a sufficient amount of money at the company's account, the amount for salaries is subtracted from the company's account balance. If the amount is insufficient, the method prints the message "NOT ENOUGH MONEY FOR SALARIES". 

In the existing class **TestEmployee**, in package **task1**, create one object of the type **AccountingDepartment** using variable of the type **AccountingInterface**. On thus created object, call the **paySalaries** method by passing to the method an array with the two previously created employees and 176 as the number of working hours. Then, create a variable of the type **AccountingDepartment** and assign to it the previously created **AccountingDepartment** object. Add 1,000,000 RSD to the company's balance, and call again the **paySalaries** method with the same input parameters, but now using the newly created variable. Finally, print the company's account balance.    


## Task 2
*(students work on their own)*

In package **task2**, create public interface **ATMInterface** with the following methods:

1. Public method **depositMoney** with no return value, and the money to be deposited as its input parameter (e.g., 123.45 RSD)
2. Public method **withdrawMoney** with no return value, and the money to be withdrawn as its input parameter (e.g., 123.45 RSD)

In the same package (**task2**), create public class **ATM** that implements the **ATMInterface** and has:

1. Private attribute **balance** that represents the current amount of money in the ATM machine; the initial balance is 5000.0 RSD
2. Implementation of the **depositMoney** method; this method deposits money in the ATM, that is, adds the input amount to the current balance; this is done only if the input amount is greater than zero; otherwise, the method prints an error message ("ERROR") to the screen.
3. Implementation of the **withdrawMoney** method; this method withdraws money from the ATM, that is, subtracts the given amount from the current balance; this is done only if the given amount is greater than zero and if there is enough money in the ATM machine; otherwise, the method prints an error message to the screen ("ERROR" and "NOT ENOUGH MONEY FOR WITHDRAWL", respectively).
4. Public method **printBalance** that prints the current amount of money in the ATM machine as follows: "Current ATM balance: ### RSD".

Create the **TestATM** class in the **task2** package. In the main method of this class, create an object of the **ATM** class, but represent it with a variable of the **ATMInterface** type; call the methods of this object. Next, create one variable of the **ATM** type and assign to it the previously created ATM object; call the same methods but through this new variable. 