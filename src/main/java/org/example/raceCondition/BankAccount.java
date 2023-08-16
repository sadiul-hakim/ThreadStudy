package org.example.raceCondition;

public class BankAccount {
    private volatile long currentBalance;

    public BankAccount(long initialBalance){
        currentBalance = initialBalance;
    }

    public synchronized void deposit(long amount){
        System.out.println("Inside deposit: lock acquired......");
        System.out.println("Depositing amount : "+amount);
        long newBalance  = currentBalance + amount;
        System.out.println("New Balance is : "+newBalance);
        currentBalance = newBalance;
        System.out.println("Done, release lock");
    }

    public synchronized void withdraw(long amount){
        System.out.println("Inside withdraw: lock acquired......");
        System.out.println("Withdrawing amount : "+amount);
        long newBalance  = currentBalance - amount;
        System.out.println("New Balance is : "+newBalance);
        currentBalance = newBalance;
        System.out.println("Done, release lock");
    }

    public long getCurrentBalance() {
        return currentBalance;
    }
}
