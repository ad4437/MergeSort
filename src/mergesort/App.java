package mergesort;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a list of up to 10 Integers (comma and space seperated): ");
            String input = in.nextLine() + ", ";

            int count = 0;
            for (char c : input.toCharArray()) {
                if (c == ',')
                    count++;
            }

            if (count > 10) {
                System.out.println("Cannot Exceed 10 Numbers");
            } else {

                int[] arr = new int[count];
                for (int i = 0; i < count; i++) {
                    arr[i] = Integer.parseInt(input.substring(0, input.indexOf(",")));
                    input = input.substring(input.indexOf(" ") + 1);
                }

                MergeSort ms = new MergeSort(arr);
                ms.mergeSort(arr, 0, arr.length - 1);
                System.out.println(Arrays.toString(ms.getArray()));

                System.out.print("Search for a number: ");
                int num = in.nextInt();
                int index = ms.binarysearch(0, arr.length - 1, num, arr);
                if (index == -1) {
                    System.out.println(num + " is not in the list");
                } else {
                    System.out.println(num + " is at index " + index);
                }
            }
            in.close();
        } catch (Exception e) {
            System.out.println("An Error Occured");
        }

    }
}
