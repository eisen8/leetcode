
// 27. Remove Element --- https://leetcode.com/problems/remove-element/description
// See bottom for problem statement
public class P_0027 {

    /**
     * This solution uses 1 pointer and as we go through the array we swap over the numbers that don't match the value.
     */
    public int removeElement(int[] nums, int val) {
        int ind = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ind] = nums[i];
                ind++;
            }
        }

        return ind;
    }

    /**
     * This solution has two pointers (1 at the start and 1 at the end). We move the ints from the end to fill in any
     * val matches at the start.
     */
    public int removeElement2(int[] nums, int val) {
        int startInd = 0;
        int endInd = nums.length-1;

        while (startInd <= endInd) {
            if (nums[startInd] == val) { // need to swap one from the end
                while (endInd >= startInd && nums[endInd] == val) {
                    endInd--;
                }

                if (endInd > startInd) {
                    nums[startInd] = nums[endInd];
                    endInd--;
                    startInd++;
                }

            }
            else {
                startInd++;
            }
        }

        return startInd;
    }
}

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
// It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
        assert nums[i] == expectedNums[i];
        }

If all assertions pass, then your solution will be accepted.



        Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).



Constraints:

        0 <= nums.length <= 100
        0 <= nums[i] <= 50
        0 <= val <= 100
*/


