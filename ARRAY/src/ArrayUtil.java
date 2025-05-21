import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ArrayUtil {

//  Method to print an array
    public void printArray(int[] arr){
//        Printing array using for loop Method
        System.out.print("Printing array using for Loop: ");
        int n=arr.length;
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+"  ");
        }

//        Using stream API
        System.out.print("\nPrinting array using stream API: ");
        Arrays.stream(arr).forEach(e-> System.out.print(e+" "));

//        Using toString() method
        System.out.println("\nPrinting array using toString() method : "+Arrays.toString(arr));
    }


//  Finding the minimum element in the array
    public void findMinimum(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

//        Finding the minimum element using for loop
        int min=arr[0];
        for (int i=1;i<arr.length;i++){
            if(arr[i]<min) {
                min=arr[i];
            }
        }
        System.out.println("Finding the minimum element using for loop: "+min);

//        Finding the minimum element using stream API
        System.out.println("Finding the minimum element using stream API: "+Arrays.stream(arr).min().getAsInt());
    }

//    Reversing an Array
    public void reverse(int[] arr){
        int i=0,j=arr.length-1;
        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        System.out.print("Reversing an Array using while loop: ");
        Arrays.stream(arr).forEach(e-> System.out.print(e+" "));
        System.out.println();

        int[] reversed= IntStream.rangeClosed(1,arr.length)
                .map(e ->arr[arr.length- e]).toArray();
        System.out.print("Reversing an Array using IntStream: ");
        Arrays.stream(reversed).forEach(e->System.out.print(e+" "));

    }

//    LeetCode Question.1 Two Sums based on Arrays
    public static int[] twoSum(int[] numbers,int target){
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            if(!map.containsKey(target-numbers[i])){
                map.put(numbers[i],i);
            }else{

                return new int[]{i,map.get(target-numbers[i])};
            }
        }

        return new int[]{0,0};
    }

//
    public static int[] twoSumII(int[] arr, int target) {
        // Sorting and Two Pointer
//        If the input array is unsorted
        Arrays.sort(arr); // 0 2 6 7 10 11
        int left = 0;
        int right = arr.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                result[0] = arr[left];
                result[1] = arr[right];
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }


    public static int[] sortedSquares(int[] arr) {
        // Two pointer technique
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        int[] result = new int[n];

        // {-4, -1, 0, 3} -> {0, 1, 9, 16}

        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[k] = arr[i] * arr[i];
                i++;
            } else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }


//    Created a Array demo
    public void arrayDemo(){
        int[] arr={1, 3, 6, 8, 2, 4, 7 };
        printArray(arr);
        findMinimum(arr);
        reverse(arr);

    }
    public static void main(String[] args) {
        ArrayUtil arrayUtil=new ArrayUtil();
        arrayUtil.arrayDemo();
    }
}
