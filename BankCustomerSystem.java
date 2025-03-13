import java.util.ArrayList;
import java.util.List;

// Class representing a Bank
class Bank {
    private String bankName;
    private List<Customer> customers;

    // Constructor
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    // Method to open a new account for a customer
    public void openAccount(String customerName, String accountNumber, double initialBalance) {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            customer = new Customer(customerName);
            customers.add(customer);
        }
        customer.addAccount(new BankAccount(accountNumber, initialBalance, this));
        System.out.println("Account opened for " + customerName + " at " + bankName);
    }

    // Method to find an existing customer
    private Customer findCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        return null;
    }

    // Method to display bank details
    public void displayBankDetails() {
        System.out.println("Bank: " + bankName);
        for (Customer customer : customers) {
            customer.displayCustomerDetails();
        }
    }
}

// Class representing a Customer
class Customer {
    private String customerName;
    private List<BankAccount> accounts;

    // Constructor
    public Customer(String customerName) {
        this.customerName = customerName;
        this.accounts = new ArrayList<>();
    }

    // Method to add an account
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Method to view balance of all accounts
    public void viewBalance() {
        System.out.println("Customer: " + customerName);
        for (BankAccount account : accounts) {
            System.out.println("Account " + account.getAccountNumber() + " - Balance: " + account.getBalance());
        }
    }

    // Getter method for customer name
    public String getCustomerName() {
        return customerName;
    }

    // Method to display customer details
    public void displayCustomerDetails() {
        System.out.println("Customer: " + customerName);
        for (BankAccount account : accounts) {
            System.out.println("  Account: " + account.getAccountNumber() + " | Balance: " + account.getBalance());
        }
    }
}

// Class representing a Bank Account
class BankAccount {
    private String accountNumber;
    private double balance;
    private Bank bank;

    // Constructor
    public BankAccount(String accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// Main class to run the program
public class BankCustomerSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("City Bank");

        // Opening accounts for customers
        bank.openAccount("Arjun", "101", 500.0);
        bank.openAccount("Ram", "102", 1000.0);
        bank.openAccount("Sonam", "103", 1500.0);

        // Display bank details
        bank.displayBankDetails();

        // Customer views their balance
        Customer arjun = new Customer("Arjun");
        arjun.viewBalance();
    }
}


//SampleOutput
//        Account opened for Arjun at City Bank
//        Account opened for Ram at City Bank
//        Account opened for Sonam at City Bank
//        Bank: City Bank
//        Customer: Arjun
//        Account: 101 | Balance: 500.0
//        Customer: Ram
//        Account: 102 | Balance: 1000.0
//        Customer: Sonam
//        Account: 103 | Balance: 1500.0
//        Customer: Arjun