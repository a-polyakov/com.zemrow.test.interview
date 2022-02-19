package interview.dellin.exercise06;

import java.math.BigDecimal;

/**
 * @author E.Bolgar on 15.05.2017.
 */
public class Task06Plus {

    public static class Account {
        private String name;
        private BigDecimal amount;

        protected boolean assignable(BigDecimal value) {
            return this.amount.add(value).compareTo(BigDecimal.ZERO) >= 0;
        }

        public synchronized void add(BigDecimal value) {
            if (!assignable(value)) throw new RuntimeException();
            this.amount = this.amount.add(value);
        }

        public void transfer(Account target, BigDecimal value) {
            //TODO
        }
    }

    public static void main(String[] args) {
        Account a1 = new Account();
        a1.name = "a1";
        a1.amount = BigDecimal.valueOf(100);
        Account a2 = new Account();
        a2.name = "a2";
        a2.amount = BigDecimal.valueOf(100);

        for (int i = 0; i < 10; i++) {
            final int iConst=i;
            new Thread() {
                @Override
                public void run() {
                    a1.transfer(a2, BigDecimal.valueOf(50));
                    System.out.println(1+" "+iConst);
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    a1.transfer(a2, BigDecimal.valueOf(50));
                    System.out.println(2+" "+iConst);
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    a2.transfer(a1, BigDecimal.valueOf(200));
                    System.out.println(3+" "+iConst);
                }
            }.start();
            System.out.println(a1.amount + " " + a2.amount);
        }

        System.out.println(a1.amount + " " + a2.amount);
    }
}
