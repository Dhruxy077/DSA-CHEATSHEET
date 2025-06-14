import java.util.Arrays;

public class Insertion_Sort {

    /*
    PSUEDO-CODE

    Insertion-sort(Arr,n)
    1   for i = 2 to n :
    2       key = Arr[j]
    3       j = i - 1
    4       while j > 0 and Arr[j] > key :
    5           Arr[j+1] = Arr[j]
    6           j = j - 1
    7
    8       Arr[j+1] = key
     */

    public static void insertionSort(int[] arr){
        if(arr==null) return;
        int len=arr.length;
        for(int i=1;i<len;i++){
            int key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
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
        System.out.println("Unsorted Array: "+Arrays.toString(arr));
        long startTime =System.nanoTime();
        insertionSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Sorted Array: "+Arrays.toString(arr));
        System.out.println("Execution time: " + duration / 1000000 + " milliseconds");
    }
}
