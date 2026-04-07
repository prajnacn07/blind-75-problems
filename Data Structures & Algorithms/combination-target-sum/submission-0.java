class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), 0, nums, target);
        return res;
    }

    public void dfs(int i, List<Integer> curr, int total, int[] nums, int target){
        if (total == target){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j=i; j<nums.length; j++){
            if(total + nums[j] > target){
                return;
            }
            curr.add(nums[j]);
            dfs(j, curr, total+nums[j], nums, target);
            curr.remove(curr.size() - 1);
        }
    }
}
