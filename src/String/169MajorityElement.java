//第一种写法
public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] nums2;
        for(int i = 0;i< nums.length;i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else{
                int value = map.get(nums[i]) + 1;
                map.put(nums[i],value);
            }
        }
        for (Integer integer : map.keySet()) {
            if(map.get(integer) > nums.length / 2)
                return integer;
        }
        return -1;
    }
//第二种写法(摩尔算法)
//时间复杂度O(n)
//空间复杂度O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                temp = nums[i];
                count = 1;
            }
        }

        // 验证是否满足要求
        int t = nums.length / 2 + 1;
        count = 0;
        for (int num : nums) {
            if (num == temp) count++;
            if (count == t) return temp;
        }
        return -1;
    }
}
