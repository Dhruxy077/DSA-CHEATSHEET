# 🧰 Java Array Utilities Toolkit 🛠️

Welcome to the `ArrayUtil` toolkit! This Java class is packed with handy methods for performing common operations on integer arrays. Whether you need to print arrays in style, find the smallest element, reverse an array, or even tackle some popular LeetCode problems, this toolkit has got your back! 😉

---

## 🌟 Features & Methods

Let's take a tour of the awesome functionalities provided by `ArrayUtil.java`:

### 1. `printArray(int[] arr)` 📜
This method showcases three different ways to print the elements of an integer array. Variety is the spice of life, right? ✨

* **Traditional `for` loop**: The good old reliable way.
* **Stream API**: For a more modern, functional approach (`Arrays.stream().forEach()`).
* **`Arrays.toString()`**: The simplest way to get a string representation of an array.

**How it looks:**
```java
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
```
**Example Output:**
```
Printing array using for Loop: 1  3  6  8  2  4  7
Printing array using stream API: 1 3 6 8 2 4 7
Printing array using toString() method : [1, 3, 6, 8, 2, 4, 7]
```

---

### 2. `findMinimum(int[] arr)` 📉
Need to find the smallest treasure 💎 in your array? This method does just that!

* **Input**: An integer array `arr`.
* **Action**:
   * Throws an `IllegalArgumentException` if the array is `null` or empty (safety first! 👷).
   * Demonstrates finding the minimum using:
      1.  A classic `for` loop.
      2.  The sleek Stream API (`Arrays.stream(arr).min().getAsInt()`).
* **Output**: Prints the minimum element found by both methods.

```java
public void findMinimum(int[] arr){
    if (arr == null || arr.length == 0) {
        throw new IllegalArgumentException("Invalid input 🚫: Array cannot be null or empty!");
    }

    // Finding the minimum element using for loop
    int min=arr[0];
    for (int i=1;i<arr.length;i++){
        if(arr[i]<min) {
            min=arr[i];
        }
    }
    System.out.println("Finding the minimum element using for loop: "+min);

    // Finding the minimum element using stream API
    System.out.println("Finding the minimum element using stream API: "+Arrays.stream(arr).min().getAsInt());
}
```
**Example Output (for `arr = {1, 3, 6, 8, 2, 4, 7}`):**
```
Finding the minimum element using for loop: 1
Finding the minimum element using stream API: 1
```

---

### 3. `reverse(int[] arr)` 🔄
Time to flip things around! This method reverses an array and shows two ways to do it.

* **Input**: An integer array `arr`.
* **Action**:
   1.  **In-place reversal**: Reverses the array `arr` directly using a `while` loop and a two-pointer technique (swapping elements from start and end). Prints the reversed array.
   2.  **`IntStream` reversal**: Creates a *new* array by reversing the *already modified `arr`* from step 1 using `IntStream.rangeClosed().map()`. Prints this second reversed array.
      * 🎨 **Fun Fact**: If you call this on `[1,2,3]`:
         * First part changes `arr` to `[3,2,1]` and prints it.
         * Second part takes `[3,2,1]` and prints `[1,2,3]`. It's like a double reverse!

```java
public void reverse(int[] arr){
    int i=0,j=arr.length-1;
    while(i<=j){ // In-place reversal
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j--;
    }
    System.out.print("Reversing an Array using while loop (in-place): ");
    Arrays.stream(arr).forEach(e-> System.out.print(e+" "));
    System.out.println();

    // Note: 'arr' is already reversed here. This IntStream reverses it again.
    int[] reversedAgain = IntStream.rangeClosed(1,arr.length)
            .map(e ->arr[arr.length- e]).toArray(); // arr.length-e because rangeClosed is 1-based
    System.out.print("Reversing an Array using IntStream (on already reversed array): ");
    Arrays.stream(reversedAgain).forEach(e->System.out.print(e+" "));
    System.out.println();
}
```
**Example Output (for `arr = {1, 3, 6, 8, 2, 4, 7}` initially):**
```
Reversing an Array using while loop (in-place): 7 4 2 8 6 3 1
Reversing an Array using IntStream (on already reversed array): 1 3 6 8 2 4 7
```

---

### 4. `twoSum(int[] numbers, int target)` (LeetCode Q1) 🎯
This static method tackles the classic LeetCode problem "Two Sum".

* **Problem**: Given an array of integers `numbers` and an integer `target`, return *indices* of the two numbers such that they add up to `target`.
* **Approach**: Uses a `HashMap` for an efficient O(n) time complexity solution. It iterates through the array, and for each element, it checks if `target - currentElement` is already in the map.
   * If yes, it means we found the pair! Returns `[currentIndex, map.get(target - currentElement)]`.
   * If no, it stores `currentElement` and its index in the map.
* **Return**: An `int[]` containing the two indices. If no such pair is found, it returns `[0,0]` (as per the current implementation - you might want to change this to `null` or an empty array for clarity).

```java
public static int[] twoSum(int[] numbers, int target){
    Map<Integer,Integer> map = new HashMap<>(); // To store <number, index>

    for(int i=0; i < numbers.length; i++){
        int complement = target - numbers[i];
        if(map.containsKey(complement)){
            // Found the pair!
            return new int[]{i, map.get(complement)}; // Returns current index and stored index
        }
        map.put(numbers[i], i); // Store current number and its index
    }
    // No solution found
    return new int[]{0,0}; // Or throw new IllegalArgumentException("No two sum solution");
}
```
**Example Usage:**
```java
int[] nums = {2, 7, 11, 15};
int target = 9;
int[] result = ArrayUtil.twoSum(nums, target);
// result would be [1, 0] (indices of 7 and 2) or [0,1] depending on iteration order.
// The current code returns [currentIndex, map.get(complement)], so if 7 is processed, complement is 2, which is in map.
System.out.println("Two Sum Indices: " + Arrays.toString(result));
```

---

### 5. `twoSumII(int[] arr, int target)` (LeetCode Q167 variant) 🪜
Another static method for a "Two Sum" variation, often seen when the input array is (or can be) sorted.

* **Problem**: Find two numbers in `arr` that sum up to `target`.
* **Approach**:
   1.  **Sorts the array `arr` in place** (`Arrays.sort(arr)`). This is crucial if the input isn't guaranteed to be sorted.
   2.  Uses the **Two-Pointer Technique**:
      * `left` pointer starts at the beginning of the sorted array.
      * `right` pointer starts at the end.
   3.  Calculates `sum = arr[left] + arr[right]`:
      * If `sum == target`, we found the pair! Returns `[arr[left], arr[right]]` (note: returns the **values**, not indices).
      * If `sum < target`, we need a larger sum, so `left++`.
      * If `sum > target`, we need a smaller sum, so `right--`.
* **Return**: An `int[]` containing the two *values* that sum to target. If no such pair, returns an empty `int[]`.

```java
public static int[] twoSumII(int[] arr, int target) {
    // Sorting is key for the two-pointer approach
    Arrays.sort(arr); // Example: {0, 2, 6, 7, 10, 11} if target is, say, 9
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) {
            return new int[]{arr[left], arr[right]}; // Returns the values
        } else if (sum < target) {
            left++; // Need a bigger sum
        } else {
            right--; // Need a smaller sum
        }
    }
    return new int[0]; // No solution found, return empty array
}
```
**Example Usage:**
```java
int[] numbers = {10, 2, 7, 11, 0, 6}; // Unsorted
int targetSum = 9;
int[] resultValues = ArrayUtil.twoSumII(numbers, targetSum);
// After sorting 'numbers': {0, 2, 6, 7, 10, 11}
// resultValues would be {2, 7}
System.out.println("Two Sum II Values: " + Arrays.toString(resultValues));
```

---

### 6. `sortedSquares(int[] arr)` (LeetCode Q977) 🔢⏹️
This static method solves "Squares of a Sorted Array" from LeetCode.

* **Problem**: Given an array `arr` sorted in non-decreasing order (can contain negatives), return an array of the squares of each number, also sorted in non-decreasing order.
* **Approach**: Efficient Two-Pointer Technique.
   * Since the input array `arr` is sorted, the numbers with the largest absolute values are at the ends. Their squares will be the largest.
   * `i` pointer starts at `0` (left end).
   * `j` pointer starts at `arr.length - 1` (right end).
   * A `result` array is filled from its end (`k = n-1` down to `0`).
   * In each step, compare `abs(arr[i])` and `abs(arr[j])`.
      * If `abs(arr[i]) > abs(arr[j])`, then `arr[i]*arr[i]` is larger. Place it at `result[k]` and `i++`.
      * Else, `arr[j]*arr[j]` is larger or equal. Place it at `result[k]` and `j--`.
* **Return**: A new `int[]` containing the sorted squares.

```java
public static int[] sortedSquares(int[] arr) {
    int n = arr.length;
    int i = 0;       // Pointer for the start of arr
    int j = n - 1;   // Pointer for the end of arr
    int[] result = new int[n]; // To store sorted squares

    // Fill the result array from the end (largest squares first)
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
```
**Example Usage:**
```java
int[] sortedArr = {-4, -1, 0, 3, 10};
int[] squaredResult = ArrayUtil.sortedSquares(sortedArr);
// squaredResult would be {0, 1, 9, 16, 100}
System.out.println("Sorted Squares: " + Arrays.toString(squaredResult));
```

---

### 7. `arrayDemo()` 🎬
This instance method is a quick demonstration of some of the utilities. It:
1.  Creates a sample array: `{1, 3, 6, 8, 2, 4, 7}`.
2.  Calls `printArray()` to display it.
3.  Calls `findMinimum()` to find and show its minimum element.
4.  Calls `reverse()` to reverse it and show the reversal steps.

```java
public void arrayDemo(){
    int[] arr={1, 3, 6, 8, 2, 4, 7 };
    System.out.println("🎉--- Original Array Demo ---🎉");
    printArray(arr);
    System.out.println("\n\n💎--- Finding Minimum ---💎");
    findMinimum(arr); // arr is {1, 3, 6, 8, 2, 4, 7}
    System.out.println("\n\n🔄--- Reversing Array ---🔄");
    // Note: reverse() modifies 'arr' in its first step.
    reverse(arr); // arr becomes {7, 4, 2, 8, 6, 3, 1} after the first reversal part
}
```

---

## 🚀 How to Run

1.  **Save**: Save the code as `ArrayUtil.java`.
2.  **Compile**: Open your terminal or command prompt, navigate to the directory where you saved the file, and compile:
    ```bash
    javac ArrayUtil.java
    ```
3.  **Run**: Execute the `main` method to see the `arrayDemo()` in action:
    ```bash
    java ArrayUtil
    ```
    The `main` method currently does this:
    ```java
    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.arrayDemo();

        // You can also test static methods directly:
        System.out.println("\n\n🎯--- Testing twoSum ---🎯");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] indices = ArrayUtil.twoSum(nums, target);
        System.out.println("Indices for target " + target + ": " + Arrays.toString(indices)); // Expected: [1,0] or [0,1]

        System.out.println("\n\n🪜--- Testing twoSumII ---🪜");
        int[] unsortedNums = {10, 2, 7, 11, 0, 6};
        int target2 = 9;
        int[] values = ArrayUtil.twoSumII(unsortedNums, target2);
        System.out.println("Values for target " + target2 + ": " + Arrays.toString(values)); // Expected: [2,7] (after sorting)

        System.out.println("\n\n🔢⏹️--- Testing sortedSquares ---🔢⏹️");
        int[] mixedSorted = {-7, -3, 2, 3, 11};
        int[] squares = ArrayUtil.sortedSquares(mixedSorted);
        System.out.println("Sorted squares: " + Arrays.toString(squares)); // Expected: [4, 9, 9, 49, 121]
    }
    ```

---

## 💡 Ideas for Improvement & Fun

* Add more array utility functions (e.g., find maximum, calculate sum/average, check if sorted, remove duplicates).
* Implement generic versions of these methods to work with other data types.
* Add more LeetCode array problems! 🤓
* Write unit tests for each method to ensure they are robust. 🧪

Happy Array Manipulating! 🎉📊✨
