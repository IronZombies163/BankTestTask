package card;

public class PlatinumDebitCard extends DebitCard {

    private double cashbackAmount;

    public PlatinumDebitCard(double balance) {
        super(balance);
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= getBalance()) {
            if (amount >= 5000) {
                setCashbackAmount(getCashbackAmount() + (amount * 0.25));
            } else {
                setCashbackAmount(getCashbackAmount() + (amount * 0.05));
            }
            setBalance(getBalance() - amount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void topUp(double amount) {
        setCashbackAmount(getCashbackAmount() + (amount * 0.00005));
        setBalance(getBalance() + amount);
    }

    @Override
    public String getAvailableFunds() {
        return "Баланс: " + getBalance() +
                "\nСколько накопили кэшбека: " + getCashbackAmount();
    }

    public double getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(double cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }


}
