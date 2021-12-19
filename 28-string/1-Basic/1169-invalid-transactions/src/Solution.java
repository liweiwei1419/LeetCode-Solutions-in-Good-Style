import java.util.ArrayList;
import java.util.List;

public class Solution {

    class Transaction {
        private String name;
        private int time;
        private int amount;
        private String city;

        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "name='" + name + '\'' +
                    ", time=" + time +
                    ", amount=" + amount +
                    ", city='" + city + '\'' +
                    '}';
        }
    }


    public List<String> invalidTransactions(String[] transactions) {
        int len = transactions.length;

        List<Transaction> transactionList = new ArrayList<>();
        for (String transaction : transactions) {
            String[] transactionArray = transaction.split(",");
            transactionList.add(new Transaction(transactionArray[0],
                    Integer.parseInt(transactionArray[1]),
                    Integer.parseInt(transactionArray[2]),
                    transactionArray[3]));
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (transactionList.get(i).amount > 1000) {
                res.add(transactions[i]);
                continue;
            }

            boolean found = false;
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }

                boolean condition1 = transactionList.get(i).name.equals(transactionList.get(j).name);
                boolean condition2 = !transactionList.get(i).city.equals(transactionList.get(j).city);
                boolean condition3 = Math.abs(transactionList.get(i).time - transactionList.get(j).time) <= 60;

                if (condition1 && condition2 && condition3) {
                    found = true;
                    break;
                }
            }

            if (found) {
                res.add(transactions[i]);
            }
        }
        return res;
    }
}