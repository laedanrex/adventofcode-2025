package net.laedanrex.santa.day01;

public class Counter {


    public Counter() {
        this(50);
    }

    public Counter(int initial) {
        this.numberInInterval = initial;
    }

    int numberOfZerosHit = 0;
    int numberOfZerosLanded = 0;

    int numberInInterval = 50;
    final int MAX = 99;
    final int MIN = 0;
    final int RANGE = MAX - MIN + 1;
    int hit = 0;
    String line;

    public void readLine(String line) {
        // no use number
        this.line = line;
        int number = getNumber(line);
        if (number < 0) {
            goLeft(number);
        } else if (number > 0) {
            goRight(number);
        }
    }

    void hitMIN() {
        hit += 1;
        numberOfZerosHit += 1;
    }

    //negatif number
    void goLeft(int negativ) {
        hit = 0;
        if (negativ > 0) throw new IllegalArgumentException();
        while (negativ < 0) {
            if (negativ < -RANGE) {
                //tour complet avec hit (100 clic)
                negativ = negativ + RANGE;
                hitMIN();
            } else if (numberInInterval + negativ >= MIN) {
                // on reste dans l'interval
                numberInInterval = numberInInterval + negativ;
                negativ = 0;
                if (numberInInterval == MIN) hitMIN();
            } else {
                negativ = negativ + numberInInterval + 1;
                if (numberInInterval != 0) hitMIN(); //pas hit quand on démarre de 0
                numberInInterval = MAX;
            }
        }
        if (numberInInterval == 0) numberOfZerosLanded += 1;
    }

    void goRight(int positiv) {
        hit = 0;
        if (positiv < 0) throw new IllegalArgumentException();
        while (positiv > 0) {
            if (positiv > RANGE) {
                //tour complet avec hit (100 clic)
                positiv = positiv - RANGE;
                hitMIN();
            } else if (numberInInterval + positiv <= MAX) {
                // on reste dans l'interval
                numberInInterval = numberInInterval + positiv;
                positiv = 0;

            } else {
                positiv = positiv - (MAX - (numberInInterval - 1));
                numberInInterval = MIN;
                hitMIN();
            }
        }
        if (numberInInterval == 0) numberOfZerosLanded += 1;
    }

    void add(int increment) {
        numberInInterval += increment;
        while (numberInInterval < MIN) {
            numberInInterval += MAX;
            hit += 1;
            numberOfZerosHit += 1;
        }
        while (numberInInterval > MAX) {
            numberInInterval -= MAX;
            hit += 1;
            numberOfZerosHit += 1;
        }
    }

    int getNumber(String line) {
        if (line.startsWith("R")) {
            int i = Integer.parseInt(line.substring(1));
            if (i < 0) throw new IllegalArgumentException();
            return i;
        } else if (line.startsWith("L")) {
            int i = Integer.parseInt(line.substring(1));
            if (i < 0) throw new IllegalArgumentException();
            return -i;
        }
        throw new IllegalArgumentException();
    }

    public void printHeader() {
        System.out.printf("\n");
        System.out.printf("         |    N°   |  0 HIT  | 0 LAND  \n");
        System.out.printf("---------|---------|---------|---------\n");
    }

    public void print() {
        System.out.printf(" %-7s | %7d | %7d | %7d \n", line, numberInInterval, numberOfZerosHit, numberOfZerosLanded);

    }
}