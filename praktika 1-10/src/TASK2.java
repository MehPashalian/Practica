class Patient {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phone;
    private int medicalCardNumber;
    private String diagnosis;

    // Конструкторы
    public Patient() {}

    public Patient(int id, String lastName, String firstName, String middleName, String address, String phone, int medicalCardNumber, String diagnosis) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    // Методы setТип() и getТип()
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setMedicalCardNumber(int medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Пациент(" +
                "id=" + id +
                ", Фамилия='" + lastName + '\'' +
                ", имя='" + firstName + '\'' +
                ", Очество='" + middleName + '\'' +
                ", Адрес='" + address + '\'' +
                ", Телефон='" + phone + '\'' +
                ", Номер Медецинкой карты =" + medicalCardNumber +
                ", Диагнос ='" + diagnosis + '\'' +
                ')';
    }
}

public class TASK2 {
    public static void main(String[] args) {
        // Создание массива объектов пациентов
        Patient[] patients = new Patient[]{
                new Patient(1, "Ivanov", "Ivan", "Ivanovich", "Moscow, Lenin str. 1", "111-111-111", 12345, "Flu"),
                new Patient(2, "Petrov", "Petr", "Petrovich", "Moscow, Red square 5", "222-222-222", 54321, "Headache"),
                new Patient(3, "Sidorov", "Sidor", "Sidorovich", "Saint-Petersburg, Nevsky str. 10", "333-333-333", 67890, "Diabetes"),
                new Patient(4, "Kuznetsov", "Vladimir", "Vladimirovich", "Novosibirsk, Central st. 20", "444-444-444", 13579, "Flu"),
                new Patient(5, "Smirnov", "Sergey", "Sergeevich", "Ekaterinburg, Victory st. 7", "555-555-555", 98765, "Headache")
        };

        String searchDiagnosis = "Flu";
        int cardNumberLower = 10000;
        int cardNumberUpper = 60000;

        // Вывод списка пациентов с заданным диагнозом
        System.out.println("Пациенты с диагнозом " + searchDiagnosis + ":");
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equals(searchDiagnosis)) {
                System.out.println(patient);
            }
        }

        // Вывод списка пациентов, у которых номер медицинской карты находится в заданном интервале
        System.out.println("\nПациенты с номером медицинской карты в интервале от " + cardNumberLower + " до " + cardNumberUpper + ":");
        for (Patient patient : patients) {
            if (patient.getMedicalCardNumber() >= cardNumberLower && patient.getMedicalCardNumber() <= cardNumberUpper) {
                System.out.println(patient);
            }
        }
    }
}
