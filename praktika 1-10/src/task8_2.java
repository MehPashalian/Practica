public class task8_2 {
    public class Main {
        public static void main(String[] args) {
            // Создание двух массивов строк
            task8.StringArray array1 = new task8.StringArray(3);
            array1.set(0, "apple");
            array1.set(1, "banana");
            array1.set(2, "cherry");

            task8.StringArray array2 = new task8.StringArray(3);
            array2.set(0, "banana");
            array2.set(1, "date");
            array2.set(2, "fig");

            // Печать обоих массивов
            System.out.println("Array 1: " + array1);
            System.out.println("Array 2: " + array2);

            // Сцепление массивов
            task8.StringArray concatenatedArray = task8.StringArray.concatenate(array1, array2);
            System.out.println("Concatenated Array: " + concatenatedArray);

            // Слияние массивов
            task8.StringArray mergedArray = task8.StringArray.mergeUnique(array1, array2);
            System.out.println("Merged Unique Array: " + mergedArray);

            // Печать элементов массивов
            System.out.println("Elements of Array 1:");
            array1.print();
            System.out.println("Elements of Array 2:");
            array2.print();
        }
    }

}
