import java.util.Arrays;

public class quickSort {

    public static void quick_sort(int[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quick_sort(arr,low,pi-1);
            quick_sort(arr,pi,high);
        }
    }

    public static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int x=low-1;
        for(int i=low;i<=high-1;i++){
            if(arr[i]<pivot){
                x++;
                arr[x]=arr[x]+arr[i]-(arr[i]=arr[x]);
            }
        }
        arr[++x]=arr[x]+arr[high]-(arr[high]=arr[x]);
        return x;
    }

    public static void main(String[] args) {
        long startTime =System.nanoTime();

        int[] arr={10,30,20,80,15,5,12,35,90,45};
        quick_sort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(e-> System.out.printf("%3d",e));
        System.out.println();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

//        System.out.println("Execution time: " + duration + " nanoseconds");
        System.out.println("Execution time: " + duration / 1000000 + " milliseconds");
    }
}
