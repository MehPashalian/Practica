public class task4 {
    class Computer {
        private Specifications specifications;

        public Computer(String operatingSystem, String processor, int ram) {
            this.specifications = new Specifications(operatingSystem, processor, ram);
        }

        public void displaySpecifications() {
            System.out.println("Информация о компьютере:");
            System.out.println("Операционная система: " + specifications.getOperatingSystem());
            System.out.println("Процессор: " + specifications.getProcessor());
            System.out.println("Оперативная память: " + specifications.getRam() + " ГБ");
        }

        // Внутренний класс Specifications
        private class Specifications {
            private String operatingSystem;
            private String processor;
            private int ram;

            public Specifications(String operatingSystem, String processor, int ram) {
                this.operatingSystem = operatingSystem;
                this.processor = processor;
                this.ram = ram;
            }

            public String getOperatingSystem() {
                return operatingSystem;
            }

            public String getProcessor() {
                return processor;
            }

            public int getRam() {
                return ram;
            }
        }
    }

    public class Main {
        public void main(String[] args) {
            Computer myComputer = new Computer("Windows 11", "Intel Core i7", 16);
            myComputer.displaySpecifications(); // Выводим информацию о компьютере
        }
    }

}
