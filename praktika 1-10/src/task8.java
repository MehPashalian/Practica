import java.util.HashSet;

public class task8 {import java.util.HashSet;

    public class StringArray {
        private String[] array; // Массив строк
        private int size; // Размер массива

        // Конструктор класса
        public StringArray(int length) {
            this.size = length;
            this.array = new String[length];
        }

        // Метод для получения размера массива
        public int getSize() {
            return size;
        }

        // Метод для установки значения по индексу
        public void set(int index, String value) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Индекс вне пределов массива");
            }
            array[index] = value;
        }

        // Метод для получения значения по индексу
        public String get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Индекс вне пределов массива");
            }
            return array[index];
        }

        // Метод для сцепления двух массивов
        public static StringArray concatenate(StringArray array1, StringArray array2) {
            int newLength = array1.size + array2.size;
            StringArray newArray = new StringArray(newLength);

            for (int i = 0; i < array1.size; i++) {
                newArray.set(i, array1.get(i));
            }
            for (int i = 0; i < array2.size; i++) {
                newArray.set(array1.size + i, array2.get(i));
            }
            return newArray;
        }

        // Метод для слияния двух массивов с исключением повторяющихся элементов
        public StringArray mergeUnique(StringArray array1, StringArray array2) {
            HashSet<String> uniqueElements = new HashSet<>();

            for (int i = 0; i < array1.size; i++) {
                uniqueElements.add(array1.get(i));
            }
            for (int i = 0; i < array2.size; i++) {
                uniqueElements.add(array2.get(i));
            }

            StringArray result = new StringArray(uniqueElements.size());
            int index = 0;
            for (String str : uniqueElements) {
                result.set(index++, str);
            }
            return result;
        }

        // Метод для печати элементов массива
        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.println(array[i]);
            }
        }

        // Метод для печати всего массива (в виде строки)
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(array[i]);
                if (i < size - 1) {
                    sb.append(", "); // Разделитель
                }
            }
            return sb.toString();
        }
    }

}
