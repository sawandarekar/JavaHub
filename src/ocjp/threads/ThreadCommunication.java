package ocjp.threads;

import java.util.Date;

public class ThreadCommunication {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ":Start. Time = " + new Date());
        Account account = new Account(20);
        Thread debitWorker = new DebitWorker(account);
        debitWorker.start();
        Thread debitWorker1 = new DebitWorker(account);
        debitWorker1.start();
        // TimeUnit.SECONDS.sleep(2);
        Thread creditWorker = new CreditWorker(account);
        creditWorker.start();
    }
}

class DebitWorker extends Thread {

    Account account;

    DebitWorker(Account a) {
        account = a;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":Debit run Time = " + new Date());
        super.run();
        try {
            account.debit(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CreditWorker extends Thread {

    Account account;

    CreditWorker(Account a) {
        account = a;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":credit run Time = " + new Date());
        super.run();
        synchronized (account) {
            account.credit(20);
            account.credit(20);
            account.credit(20);
            account.credit(20);
        }
    }

}

class Account {

    long amount;
    long minBalance;

    Account(long a) {
        amount = a;
    }

    public boolean debit(long amt) throws InterruptedException {
        Thread.sleep(1000);
        Thread.yield();
        if (amount < minBalance) {
            System.out.println(Thread.currentThread().getName() + ":" + amount + ":amount is less");
            synchronized (this) {
                System.out.println("wait started Time = " + new Date());
                this.wait(100);
            }
        }
        amount = amount - amt;
        System.out.println(Thread.currentThread().getName() +" "+ amt+ ":amount is debited balance:"+this.amount);
        return true;
    }

    public boolean credit(long amt) {
        amount = amount + amt;
        System.out.println(Thread.currentThread().getName() + ": " + amt + ": amount credited total amt:"+this.amount+" - notify Time = " + new Date());
        synchronized (this) {
            this.notifyAll();
        }
        return true;
    }
}
