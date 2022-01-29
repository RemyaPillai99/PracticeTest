package problemsolving.arrays;
/*Given an array of numbers where every number is represented as string. The numbers may be very large (may not fit in long long int), the task is to sort these numbers.
Examples:


Input : arr[] = {"5", "1237637463746732323", "12" };
Output : arr[] = {"5", "12", "1237637463746732323"};

Input : arr[] = {"50", "12", "12", "1"};
Output : arr[] = {"1", "12", "12", "50"};*/


import java.util.Arrays;

// Java program to sort large numbers represented
// as strings.
public class SortLargeNums {
    // Function for sort an array of large numbers
    // represented as strings
    static void sortLargeNumbers(String arr[])
    {
        // Refer below post for understanding below expression:
        // https://www.geeksforgeeks.org/lambda-expressions-java-8/
        Arrays.sort(arr, (left, right) ->
        {
            /* If length of left != right, then return
               the diff of the length else  use compareTo
               function to compare values.*/
            if (left.length() != right.length())
                return left.length() - right.length();
            return left.compareTo(right);
        });
    }

    // Driver code
    public static void main(String args[])
    {
        String arr[] = {"5", "67987",
                "97987", "12" };
        sortLargeNumbers(arr);
        for (String s : arr)
            System.out.print(s + " ");
    }

    /*Time complexity: O(k * n Log n) where k is length of the longest number.
    Here assumption is that the sort() function uses a O(n Log n) sorting algorithm.*/
}
