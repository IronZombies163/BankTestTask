package card;

    public abstract class BankCard {
        private double balance;
        public void setBalance(double balance) {
            this.balance = balance;
        }



        public BankCard(double balance) {
            this.balance = balance;
        }

        public void topUp(double amount) {
            balance += amount;
        }

        public boolean pay(double amount) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }

        public double getBalance() {
            return balance;
        }

        public abstract String getAvailableFunds();

    }

