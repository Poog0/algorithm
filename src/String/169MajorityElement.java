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
