import java.util.Arrays;
import java.util.List;

public class task6 {

    public class Airplane {
        private List<Wing> wings;
        private Chassis chassis;
        private List<Engine> engines;
        private String route;

        public Airplane(List<Wing> wings, Chassis chassis, List<Engine> engines) throws InsufficientEnginesException {
            if (engines == null || engines.isEmpty()) {
                throw new InsufficientEnginesException("Самолет должен иметь как минимум один двигатель.");
            }
            this.wings = wings;
            this.chassis = chassis;
            this.engines = engines;
        }

        // Methods
        public void fly() throws InsufficientEnginesException {
            if (engines == null || engines.isEmpty()) {
                throw new InsufficientEnginesException("Не могу летать без двигателей.");
            } else {
                System.out.println("Самолет летит.");
            }
        }

        public void setRoute(String route) throws RouteNotSetException {
            if (route == null || route.isEmpty()) {
                throw new RouteNotSetException("Маршрут не может быть пустым.");
            }
            this.route = route;
        }

        public void printRoute() throws RouteNotSetException {
            if (route == null || route.isEmpty()) {
                throw new RouteNotSetException("Маршрут не задан.");
            } else {
                System.out.println("Текущий маршрут: " + route);
            }
        }

        // Getters and setters for components
        public List<Wing> getWings() { return wings; }
        public void setWings(List<Wing> wings) { this.wings = wings; }

        public Chassis getChassis() { return chassis; }
        public void setChassis(Chassis chassis) { this.chassis = chassis; }

        public List<Engine> getEngines() { return engines; }
        public void setEngines(List<Engine> engines) throws InsufficientEnginesException {
            if (engines == null || engines.isEmpty()) {
                throw new InsufficientEnginesException("Самолет должен иметь как минимум один двигатель.");
            }
            this.engines = engines;
        }
    }
    public class Wing {
        private double length;
        private double area;

        public Wing(double length, double area) throws InvalidWingLengthException {
            if (length <= 0 || area <= 0) {
                throw new InvalidWingLengthException("Длина или площадь крыла недопустимы.");
            }
            this.length = length;
            this.area = area;
        }

        // Getters and setters
        public double getLength() { return length; }
        public void setLength(double length) throws InvalidWingLengthException {
            if (length <= 0) {
                throw new InvalidWingLengthException("Длина крыла не может быть отрицательной или равной нулю.");
            }
            this.length = length;
        }

        public double getArea() { return area; }
        public void setArea(double area) throws InvalidWingLengthException {
            if (area <= 0) {
                throw new InvalidWingLengthException("Площадь крыла не может быть отрицательной или равной нулю.");
            }
            this.area = area;
        }
    }

    public class Engine {
        private String type;
        private int power; // in horsepower

        public Engine(String type, int power) throws InvalidEnginePowerException {
            if (power <= 0) {
                throw new InvalidEnginePowerException("Мощность двигателя не может быть отрицательной или равной нулю.");
            }
            this.type = type;
            this.power = power;
        }

        // Getters and setters
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public int getPower() { return power; }
        public void setPower(int power) throws InvalidEnginePowerException {
            if (power <= 0) {
                throw new InvalidEnginePowerException("Мощность двигателя не может быть отрицательной или равной нулю.");
            }
            this.power = power;
        }
    }
    public class Chassis {
        private int wheels;

        public Chassis(int wheels) {
            this.wheels = wheels;
        }

        // Getters and setters
        public int getWheels() { return wheels; }
        public void setWheels(int wheels) { this.wheels = wheels; }
    }

    public class TASK3 {
        public void main(String[] args) {
            try {
                Wing leftWing = new Wing(10, 500);
                Wing rightWing = new Wing(-10, 500);
                Chassis chassis = new Chassis(3);
                Engine engine1 = new Engine("Джет", 100000);
                Engine engine2 = new Engine("Джет", 100000);

                Airplane airplane = new Airplane(
                        Arrays.asList(leftWing, rightWing),
                        chassis,
                        Arrays.asList(engine1, engine2)
                );

                airplane.setRoute("Из Нью-Йорка в Лондон");
                airplane.printRoute();
                airplane.fly();
            } catch (InvalidWingLengthException | InvalidEnginePowerException | InsufficientEnginesException | RouteNotSetException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (OutOfMemoryError e) {
                System.out.println("Недостаточно памяти для выполнения программы.");
            } catch (Exception e) {
                System.out.println("Неожиданная ошибка: " + e.getMessage());
            }
        }
    }

    class InvalidWingLengthException extends Exception {
        public InvalidWingLengthException(String message) {
            super(message);
        }
    }

    class InvalidEnginePowerException extends Exception {
        public InvalidEnginePowerException(String message) {
            super(message);
        }
    }

    class InsufficientEnginesException extends Exception {
        public InsufficientEnginesException(String message) {
            super(message);
        }
    }

    class RouteNotSetException extends Exception {
        public RouteNotSetException(String message) {
            super(message);
        }
    }

}
