package card;

import java.lang.*;

public class DebitCard extends BankCard {

    public DebitCard(double balance) {
        super(balance);
    }

    @Override
    public String getAvailableFunds() {
        return "Баланс: "+getBalance();
    }
}
