import java.util.HashMap;

public class twoSum_01 {
public static int[] sum(int [] nums, int target){
    for (int i = 0; i < nums.length; i++) {
        for (int j = i+1; j < nums.length; j++) {
            if (nums[i]+nums[j]==target) {
                return new int[]{i,j};
            }
        }
    }
    return new int[]{-1,-1};
}
public static int[] OptimalSum(int [] nums, int target){
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int compliment=target-nums[i];
        if (map.containsKey(compliment)) {
            return new int[]{map.get(compliment), i};
        }
        map.put(nums[i], i);
    }
    return new int[]{-1,-1};
}
public static void main(String[] args) {
    int nums[]={5,6,9,7,1};
    int target=10;
    int [] result=sum(nums, target);
    System.out.println(result[0]+" "+result[1]);
    System.out.println(nums[result[0]]+" "+ nums[result[1]]);
}
    
}