import card.*;

public class Main {
    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard(1000);
        CreditCard creditCard = new CreditCard(0, 500);
        PlatinumDebitCard platinumDebitCard = new PlatinumDebitCard(2000);
        CashbackDebitCard cashbackDebitCard = new CashbackDebitCard(1500, "Groceries");
        GoldCreditCard goldCreditCard = new GoldCreditCard(500, 2000);


        System.out.println("\nДоступные средства и кэшбек на золотой кредитной карте после платежа:");
        System.out.println(goldCreditCard.getAvailableFunds());

        // Пополним карты
        goldCreditCard.topUp(1000);
        debitCard.topUp(500);
        creditCard.topUp(300);
        platinumDebitCard.topUp(1000);
        cashbackDebitCard.topUp(500);

        // Проверим доступные средства
        System.out.println("Доступные средства на дебетовой карте:");
        System.out.println(debitCard.getAvailableFunds());

        System.out.println("\nДоступные средства на кредитной карте:");
        System.out.println(creditCard.getAvailableFunds());
        System.out.println("Доступные средства на платиновой дебетовой карте:");
        System.out.println(platinumDebitCard.getAvailableFunds());

        System.out.println("\nДоступные средства на кешбек дебетовой карте:");
        System.out.println(cashbackDebitCard.getAvailableFunds());

        System.out.println("Доступные средства и кэшбек на золотой кредитной карте:");
        System.out.println(goldCreditCard.getAvailableFunds());
        // Проверим результаты платежей

        System.out.println("\nДоступные средства на дебетовой карте после платежа:");
        System.out.println(debitCard.getAvailableFunds());

        System.out.println("\nДоступные средства на кредитной карте после платежа:");
        System.out.println(creditCard.getAvailableFunds());

        System.out.println("\nДоступные средства на платиновой дебетовой карте после платежа:");
        System.out.println(platinumDebitCard.getAvailableFunds());

        System.out.println("\nДоступные средства на кешбек дебетовой карте после платежа:");
        System.out.println(cashbackDebitCard.getAvailableFunds());

        System.out.println("\nДоступные средства и кэшбек на золотой кредитной карте после платежа:");
        System.out.println(goldCreditCard.getAvailableFunds());

    }
}