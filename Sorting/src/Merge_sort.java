import java.util.Arrays;

public class Merge_sort {

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Create temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j]; // Corrected index here as well
        }

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = low;
        while (i < n1 && j < n2) { // Loop while both arrays have elements
            if (left[i] <= right[j]) { // Use <= for stable sort (optional but good practice)
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[] if any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[] if any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] arr,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;

            sort(arr,left,mid);
            sort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    public static void main(String[] args) {

        int[] arr={543, 876, 123, 999, 456, 789, 234, 567, 890, 345, 678, 901, 432, 765, 198, 321,
                654, 987, 210, 543, 876, 109, 432, 765, 298, 531, 864, 197, 420, 753, 186, 419,
                752, 185, 418, 751, 184, 417, 750, 183, 416, 749, 182, 415, 748, 181, 414, 747,
                180, 413, 746, 179, 412, 745, 178, 411, 744, 177, 410, 743, 176, 409, 742, 175,
                408, 741, 174, 407, 740, 173, 406, 739, 172, 405, 738, 171, 404, 737, 170, 403,
                736, 169, 402, 735, 168, 401, 734, 167, 400, 733, 166, 399, 732, 165, 398, 731,
                164, 397, 730, 163, 396, 729, 162, 395, 728, 161, 394, 727, 160, 393, 726, 159,
                392, 725, 158, 391, 724, 157, 390, 723, 156, 389, 722, 155, 388, 721, 154, 387,
                720, 153, 386, 719, 152, 385, 718, 151, 384, 717, 150, 383, 716, 149, 382, 715,
                148, 381, 714, 147, 380, 713, 146, 379, 712, 145, 378, 711, 144, 377, 710, 143,
                376, 709, 142, 375, 708, 141, 374, 707, 140, 373, 706, 139, 372, 705, 138, 371,
                704, 137, 370, 703, 136, 369, 702, 135, 368, 701, 134, 367, 700, 133, 366, 699,
                132, 365, 698, 131, 364, 697, 130, 363, 696};

        System.out.println("Unsorted Array: "+ Arrays.toString(arr));
        long startTime =System.nanoTime();
        sort(arr,0,arr.length-1);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Sorted Array: "+Arrays.toString(arr));
        System.out.println("Execution time: " + duration / 1000000 + " milliseconds");
    }
}
