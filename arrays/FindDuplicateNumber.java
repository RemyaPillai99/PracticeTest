package problemsolving.arrays;
/*Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least
 one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
https://leetcode.com/problems/find-the-duplicate-number/solution/

Note:

-You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
IMP : There is only one duplicate number in the array, but it could be "repeated more than once".

Q ask if range fixed

Given an array that contains numbers from 1 to n-1 and exactly 1 duplicate, find that duplicate.
* arr[] = {2,3,1,4,4}
* range = 1 to n-1
* sum of 0 to n-1 nos = (n*(n-1))/2
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {

    /*Complexity Analysis

Time complexity : (nlgn)O(nlgn)

The sort invocation costs O(nlgn) time in Python and Java, so it dominates the subsequent linear scan.

Space complexity : O(1) orO(n))

Here, we sort nums in place, so the memory footprint is constant. If we cannot modify the input array, then we must
 allocate linear space for a copy of nums and sort that instead*/
    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }

    /*Time complexity : \mathcal{O}(n)O(n)

Set in both Python and Java rely on underlying hash tables, so insertion and lookup have amortized constant time
complexities. The algorithm is therefore linear, as it consists of a for loop that performs constant work n times.

Space complexity : \mathcal{O}(n)O(n)

In the worst case, the duplicate element appears twice, with one of its appearances at array index n-1n−1.
 In this case, seen will contain n-1n−1 distinct values, and will therefore occupy \mathcal{O}(n)O(n) space.*/

        public static int findDuplicateSet(int[] nums) {
            Set<Integer> seen = new HashSet<Integer>();
            for (int num : nums) {
                if (seen.contains(num)) {
                    return num;
                }
                seen.add(num);
            }

            return -1;
        }
/*Good to know
*
* omplexity Analysis

Time complexity : O(n)

Space complexity : O(1)*/

    public static int findDuplicateFloydsCycle(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];  //2x
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
    public static void main(String args[]){
        int arr[] = {2,6,4,1,3,5,1};//{5,3,4,1,6,2,6};//{5,2,1,4,3,4};
        int duplicate = findDuplicateFloydsCycle(arr);
        System.out.println(duplicate);
    }
}
