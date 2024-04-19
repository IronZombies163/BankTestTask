package card;

public class CashbackDebitCard extends DebitCard {

    private String purchaseCategory;
    private double cashbackRate;

    public CashbackDebitCard(double balance, String purchaseCategory) {
        super(balance);
        this.purchaseCategory = purchaseCategory;
        this.cashbackRate = determineCashbackRate(purchaseCategory);
    }

    protected double determineCashbackRate(String purchaseCategory) {
        switch (purchaseCategory) {
            case "Groceries":
                return 0.03;
            case "Gas":
                return 0.02;
            case "Dining":
                return 0.05;
            case "Travel":
                return 0.04;
            default:
                return 0.01;
        }
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= getBalance()) {
            double cashback = amount * cashbackRate;
           setBalance(getBalance()-amount);
            setBalance(getBalance()+cashback);
            return true;
        } else {
            return false;
        }


    }

    @Override
    public String getAvailableFunds() {
        return "Баланс: " + getBalance() +
                "\nКатегория покупки: " + purchaseCategory + "\nКешбек: " + (cashbackRate * 100) + "%";
    }
}

