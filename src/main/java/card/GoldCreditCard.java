package card;

public class GoldCreditCard extends CreditCard{

    private double cashbackAmount;

    public double getCashbackAmount() {
        return cashbackAmount;
    }

    public GoldCreditCard(double balance, double creditLimit) {
        super(balance, creditLimit);
    }

    @Override
    public void topUp(double amount) {
        if (getCreditMoney() < getCreditLimit()) {
            double remainingCredit = getCreditLimit() - getCreditMoney();
            if (amount <= remainingCredit) {
             setCreditMoney(getCreditMoney()-amount);
            }
            if (amount >= remainingCredit){
                double remainingMoney=(getCreditMoney()+amount)-getCreditLimit();
               setBalance(getBalance() + remainingMoney);
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
            cashbackAmount += (amount * 0.3);
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
                +"\nБаланс: "+getBalance()
                +"\nНакопленно кешбэка: "+getCashbackAmount();
    }
}
