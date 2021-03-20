package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Lab_6 {
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {  //поменяеть местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int[] x = new int[10];
        System.out.println("Insert array elements (10):");
        for (int i = 0; i < 10; i++) {
            x[i] = num.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.println("Before:");
        int a = 0;
        int[] y = new int[4];
        for (int i = 0; i < 4; i++) {
            y[i] = x[a];
            a++;
        }
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = y.length - 1;
        int v = 0;
        for (int i = 0; i < 4; i++) {
            x[i] = y[v];
            v++;
        }
        quickSort(x, low, high);
        System.out.println("After:");
        System.out.println(Arrays.toString(x));
    }
}
