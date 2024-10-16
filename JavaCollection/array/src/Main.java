import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void array(){
        // khởi tạo mảng với từ khoá new
        int[] arrayInteger =  new  int[5] ; // nếu xác định kích thước khi khởi tao sẽ báo lỗi
        // Gán giá trị cho các phần tử trong mảng
        arrayInteger[0] = 10;
        arrayInteger[1] = 20;
        arrayInteger[2] = 30;
        arrayInteger[3] = 40;
        arrayInteger[4] = 50;
        for (int i = 0; i < arrayInteger.length; i++) {
            System.out.println("Index of " + i + ": " + arrayInteger[i]);
        }
        // khởi tạo và gán giá trị trực tiếp cho mảng
        int[] arr = new int[]{1,2,3,4};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index of" + i + ": " + arr[i]);
        }
    }
    public static void methodArrays(){
        System.out.println("Arrays.toString()");
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Arrays.sort()");
        int[] arr2 = {5, 3, 1, 4, 2};
        Arrays.sort(arr1);
        System.out.println("Array after sort: " + Arrays.toString(arr2));
        System.out.println("Arrays.fill()");
        int[] arr3 = new int[5];
        Arrays.fill(arr3, 7);
        System.out.println("Array after fill: " + Arrays.toString(arr3));
        System.out.println("Arrays.equals()");
        System.out.println("arr1 is equal arr2  :" + Arrays.equals(arr1, arr2));
        System.out.println("arr1 is equal arr3 : " + Arrays.equals(arr1, arr3));
        System.out.println("Arrays.copyOf():");
        int[] newArr = Arrays.copyOf(arr1, 7);
        System.out.println("New array: " + Arrays.toString(newArr));
        System.out.println("Arrays.binarySearch()");
        int index = Arrays.binarySearch(arr1, 3);
        System.out.println("Index of 3 in arr1: " + index);
        System.out.println("Arrays.asList()");
        String[] arr4 = {"Apple", "Banana", "Orange"};
        List<String> list = Arrays.asList(arr4);
        System.out.println("List juices: " + list);
        System.out.println("Arrays.setAll()");
        Arrays.setAll(arr1, i -> i * 2); // Gán giá trị cho từng phần tử
        System.out.println("Array arr1 after setAll: " + Arrays.toString(arr1));
    }
    public static void multidimensionalArray(){
        // khởi tạo mảng 2 chiều bằng từ khoá new
        int[][] matrix = new int[3][3];
        // Gán giá trị cho mảng
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        // In ra mảng 2 chiều
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // khởi tạo và gán trực tiếp giá trị cho mảng 2 chiều
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // Sử dụng deepToString để in mảng đa chiều
        System.out.println(Arrays.deepToString(matrix));


        // tạo mảng 2 chiều không đối xứng
        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[2];  // Hàng 0 có 2 phần tử
        jaggedArray[1] = new int[3];  // Hàng 1 có 3 phần tử
        jaggedArray[2] = new int[1];  // Hàng 2 có 1 phần tử

        // Gán giá trị cho từng hàng
        jaggedArray[0][0] = 1;
        jaggedArray[0][1] = 2;

        jaggedArray[1][0] = 3;
        jaggedArray[1][1] = 4;
        jaggedArray[1][2] = 5;

        jaggedArray[2][0] = 6;

        System.out.println(Arrays.deepToString(jaggedArray));

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Array");
            System.out.println("2. Method Array");
            System.out.println("3. Multidimensional Array");
            System.out.println("0. Exit");
            System.out.print("Choose an option (0-3): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Array");
                    array();
                    break;
                case 2:
                    System.out.println("Method Array");
                    methodArrays();
                    break;
                case 3:
                    System.out.println("Multidimensional Array");
                    multidimensionalArray();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }
}