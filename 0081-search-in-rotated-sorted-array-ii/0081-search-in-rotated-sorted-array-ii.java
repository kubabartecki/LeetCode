class Solution {
    public int detectPivot(int[] nums){
        if(nums.length == 1) return 0;
        else if(nums.length == 2){
            return nums[0] <= nums[1] ? 0 : 1;
        }
        int left_i = 0;
        int right_i = nums.length - 1;
        while(left_i < right_i - 1){
            int mid_i = (left_i + right_i) / 2;
            if(nums[left_i] > nums[mid_i]){
                right_i = mid_i;
            }
            else if (nums[left_i] < nums[mid_i]){
                // if all element would be equal -> iterates +1 n times
                left_i = mid_i; // not +1 coz when |1|1|0|1| -> left = 0 and alg broken(comes from smallest to the end)
            }
            else{
                if(nums[left_i + 1] >= nums[left_i]){
                    left_i++;
                }
                else return left_i + 1;
            }
        }
        if(nums[left_i] >= nums[left_i + 1]) return left_i + 1;
        else return 0; // already sorted array
    }

    public boolean binSearch(int[] arr, int num){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] == num){
                return true;
            } else if (arr[mid] > num) {
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return arr[left] == num;
    }
    public boolean search(int[] nums, int target) {
        int pivot = detectPivot(nums);

        // make array great again
        // could also use arrraycopy
        int [] new_arr = new int[nums.length];

        int j = 0;
        for(int i = pivot; i < nums.length; ++i){
            new_arr[j++] = nums[i];
        }
        int i = 0;
        for(;j < nums.length; ++j){
            new_arr[j] = nums[i++];
        }
        System.out.println(Arrays.toString(new_arr));

        // binary search but in normal array
        return binSearch(new_arr, target);
    }
}