package card;

public class CreditCard extends BankCard {
    private double creditLimit;
    private double creditMoney;

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getCreditMoney() {
        return creditMoney;
    }

    public void setCreditMoney(double creditMoney) {
        this.creditMoney = creditMoney;
    }

    public CreditCard(double balance, double creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
        this.creditMoney = creditLimit;
    }

    @Override
    public void topUp(double amount) {
        if (getCreditMoney() < getCreditLimit()) {
            double remainingCredit = getCreditLimit() - getCreditMoney();
            if (amount <= remainingCredit) {
               setCreditMoney(getCreditMoney()+amount);
            }
            if (amount >= remainingCredit){
                    double remainingMoney=(getCreditMoney()+amount)-getCreditLimit();
                    setBalance(getBalance()-remainingMoney);
            }
        } else {
            setBalance(getBalance()+amount);
        }
    }


    @Override
    public boolean pay(double amount) {
        if (getBalance() + getCreditMoney() < amount) {
            return false;
        }
        else if (getBalance() >= amount) {
            setBalance(getBalance()-amount);
            return true;
        } else {
            double diff = amount - getBalance();
            setBalance(0);
            setCreditMoney(getCreditMoney()-diff);
            return true;
        }

    }

    @Override
    public String getAvailableFunds() {
    return "Кредитный лимит: " + getCreditLimit()
            +"\nКредитные средства: " + getCreditMoney()
            +"\nБаланс: "+getBalance();
    }


}
