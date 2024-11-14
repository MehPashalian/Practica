public class task3 {
    class Okno {
        private boolean isClosed;

        public Okno() {
            this.isClosed = false;
        }

        public void close() {
            this.isClosed = true;
            System.out.println("Окно закрыто.");
        }

        public boolean isClosed() {
            return isClosed;
        }
    }

    class Dver {
        private boolean isLocked;

        public Dver() {
            this.isLocked = false;
        }

        public void lock() {
            this.isLocked = true;
            System.out.println("Дверь закрыта на ключ.");
        }

        public boolean isLocked() {
            return isLocked;
        }
    }

    class Dom {
        private Okno[] okna;
        private Dver[] dveri;

        public Dom(int numberOfWindows, int numberOfDoors) {
            okna = new Okno[numberOfWindows];
            dveri = new Dver[numberOfDoors];

            for (int i = 0; i < numberOfWindows; i++) {
                okna[i] = new Okno();
            }

            for (int i = 0; i < numberOfDoors; i++) {
                dveri[i] = new Dver();
            }
        }

        public void closeDoors() {
            for (Dver dver : dveri) {
                dver.lock();
            }
        }

        public void printCount() {
            System.out.println("Количество окон: " + okna.length);
            System.out.println("Количество дверей: " + dveri.length);
        }
    }

    public class Main {
        public void main(String[] args) {
            Dom myHouse = new Dom(5, 3); // Создаем дом с 5 окнами и 3 дверями
            myHouse.closeDoors(); // Закрываем двери на ключ
            myHouse.printCount(); // Выводим количество окон и дверей
        }
    }

}
