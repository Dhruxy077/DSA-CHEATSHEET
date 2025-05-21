# ArrayUtil - A Complete Guide to Array Operations in Java

Arrays are one of the most fundamental data structures in computer science. This comprehensive guide examines the `ArrayUtil` class, which demonstrates various common array operations, both using traditional approaches and modern Java features like the Stream API.

## Understanding the ArrayUtil Class Structure

The `ArrayUtil` class serves as a collection of methods that perform different operations on arrays. Let's break down each component:

## 1. Array Printing Techniques

### Method: `printArray(int[] arr)`

This method demonstrates three different ways to print the contents of an array:

#### 1.1 Using a Traditional For Loop:
```java
System.out.print("Printing array using for Loop: ");
int n = arr.length;
for (int i = 0; i < n; i++) {
    System.out.print(arr[i] + "  ");
}
```

This is the classic approach to array traversal. We iterate from index 0 to `length-1`, accessing each element by its index. This approach has been used since the earliest days of programming and provides complete control over how elements are accessed and processed.

**Time Complexity**: O(n) - We process each element exactly once
**Space Complexity**: O(1) - We use constant extra space

#### 1.2 Using Java's Stream API:
```java
System.out.print("\nPrinting array using stream API: ");
Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
```

This modern approach converts the array into a stream of elements and then applies operations to each element in the stream. The `forEach` method takes a lambda expression that defines what to do with each element. This functional programming approach is more concise and can be more readable for complex operations.

**Time Complexity**: O(n) - Still processing each element once
**Space Complexity**: O(1) - Though the stream is created, it doesn't store elements separately

#### 1.3 Using Arrays.toString() Method:
```java
System.out.println("\nPrinting array using toString() method : " + Arrays.toString(arr));
```

This is the simplest and most convenient method for debugging or quick printing. The `Arrays.toString()` method automatically formats the array elements inside square brackets with commas separating each element.

**Time Complexity**: O(n) - Internally iterates through all elements
**Space Complexity**: O(n) - Creates a new String containing all elements

## 2. Finding the Minimum Element

### Method: `findMinimum(int[] arr)`

This method shows two ways to find the minimum value in an array:

#### 2.1 Using a For Loop:
```java
int min = arr[0];
for (int i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
        min = arr[i];
    }
}
```

This approach initializes `min` with the first element and then compares each subsequent element with the current minimum. If a smaller element is found, it becomes the new minimum.

**Time Complexity**: O(n) - We process each element once
**Space Complexity**: O(1) - We only need one variable to track the minimum

#### 2.2 Using Stream API:
```java
Arrays.stream(arr).min().getAsInt()
```

This functional approach converts the array to a stream, calls the `min()` method to find the smallest element (which returns an `OptionalInt`), and then extracts the value using `getAsInt()`.

**Time Complexity**: O(n) - Still requires checking each element
**Space Complexity**: O(1) - Doesn't require additional data structures

#### 2.3 Error Handling:
```java
if (arr == null || arr.length == 0) {
    throw new IllegalArgumentException("Invalid input");
}
```

This defensive programming approach ensures the method doesn't crash when given an empty or null array. Instead, it throws a meaningful exception with a clear error message.

## 3. Array Reversal Techniques

### Method: `reverse(int[] arr)`

This method demonstrates two ways to reverse an array:

#### 3.1 In-place Reversal Using Two Pointers:
```java
int i = 0, j = arr.length - 1;
while (i <= j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    i++;
    j--;
}
```

This classic algorithm uses two pointers - one starting from the beginning and one from the end. As the pointers move toward each other, the elements at those positions are swapped. This continues until the pointers meet or cross.

**Time Complexity**: O(n/2) which simplifies to O(n) - We process half the array
**Space Complexity**: O(1) - We modify the array in-place with only a few variables

#### 3.2 Using IntStream for Functional Reversal:
```java
int[] reversed = IntStream.rangeClosed(1, arr.length)
        .map(e -> arr[arr.length - e]).toArray();
```

This approach uses Java's functional programming features to create a new reversed array. It:
1. Creates a stream of integers from 1 to the array length
2. Maps each number `e` to the value at index `(length - e)` in the original array
3. Collects the results into a new array

**Time Complexity**: O(n) - Still processing each element once
**Space Complexity**: O(n) - Creates a new array of the same size

## 4. Two Sum Problem Solutions

### Method 1: `twoSum(int[] numbers, int target)`

This method finds the indices of two numbers in an array that add up to a target value.

```java
public static int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < numbers.length; i++) {
        if (!map.containsKey(target - numbers[i])) {
            map.put(numbers[i], i);
        } else {
            return new int[]{i, map.get(target - numbers[i])};
        }
    }

    return new int[]{};
}
```

This elegant solution uses a HashMap to achieve O(n) time complexity:

1. For each element, we check if its complement (target - current number) exists in our map
2. If not, we add the current number and its index to the map
3. If we find a complement, we've found our pair and return both indices

**Time Complexity**: O(n) - Single pass through the array with O(1) lookups in HashMap
**Space Complexity**: O(n) - In worst case, we might store nearly all elements in the HashMap

### Method 2: `twoSumII(int[] arr, int target)`

An alternative implementation for the Two Sum problem using sorting and a two-pointer technique:

```java
public static int[] twoSumII(int[] arr, int target) {
    Arrays.sort(arr);
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
```

This approach:
1. First sorts the array (which changes the original order)
2. Uses two pointers - one at the beginning and one at the end
3. If the sum is too small, we move the left pointer right to get a larger number
4. If the sum is too large, we move the right pointer left to get a smaller number
5. We continue until we find the target sum or the pointers cross

**Note**: Unlike the first method, this one returns the actual values, not their indices, and requires sorting the array first.

**Time Complexity**: O(n log n) due to the sorting step
**Space Complexity**: O(1) excluding the result array

## 5. Sorted Squares Problem

### Method: `sortedSquares(int[] arr)`

This method takes a sorted array (which may contain negative numbers) and returns an array of the squares of each number, also sorted in ascending order.

```java
public static int[] sortedSquares(int[] arr) {
    int n = arr.length;
    int i = 0;
    int j = n - 1;
    int[] result = new int[n];

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

This clever solution uses a two-pointer approach:

1. We start with pointers at both ends of the input array
2. We compare the absolute values at these positions (since squaring makes negative numbers positive)
3. Whichever value has the larger absolute value will have the larger square
4. We place this square at the end of our result array and move the corresponding pointer
5. We continue this process, filling the result array from the end to the beginning

**Time Complexity**: O(n) - We process each element exactly once
**Space Complexity**: O(n) - We create a new array to store the result

## 6. Demo and Main Method

### Demo Method: `arrayDemo()`

```java
public void arrayDemo() {
    int[] arr = {1, 3, 6, 8, 2, 4, 7};
    printArray(arr);
    findMinimum(arr);
    reverse(arr);
}
```

This method creates a sample array and demonstrates the use of several utilities:
1. Printing the array using multiple methods
2. Finding the minimum value
3. Reversing the array

### Main Method: `main(String[] args)`

```java
public static void main(String[] args) {
    ArrayUtil arrayUtil = new ArrayUtil();
    arrayUtil.arrayDemo();
}
```

The main method creates an instance of the ArrayUtil class and calls the demo method to showcase the functionality.

## Key Takeaways from ArrayUtil

1. **Multiple Approaches**: The class demonstrates both traditional imperative methods and modern functional programming approaches to solve the same problems.

2. **Error Handling**: The methods include checks for edge cases such as null or empty arrays.

3. **Algorithmic Efficiency**: Many methods use efficient algorithms like the two-pointer technique to optimize time and space complexity.

4. **Common Patterns**: The code showcases common array manipulation patterns:
    - Iteration through all elements
    - Finding minimum/maximum values
    - Reversal operations
    - Two-pointer techniques (from both ends)
    - Hash-based lookups for O(1) search

5. **Problem-Solving Strategies**: The class implements solutions to common algorithmic problems that frequently appear in coding interviews.

## How to Use This in Your DSA Journey

The techniques demonstrated in ArrayUtil form the foundation for more advanced array manipulations and algorithmic problems. Understanding these patterns will help you:

1. Recognize when to apply specific techniques to new problems
2. Choose the most efficient approach based on the constraints
3. Implement clean, readable, and efficient code
4. Handle edge cases and write robust solutions

Arrays are fundamental to almost all data structures and algorithms, making the patterns learned here widely applicable in your DSA practice and real-world programming.