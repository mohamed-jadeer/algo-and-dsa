package hashMap;

import java.util.HashMap;

public class ZeroSumSubArray {
	
	public static void main(String[] args){
		int arr[] = {-3, 2, 3, 1, 6};
        if (subArrayExists(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");
	}

	private static boolean subArrayExists(int[] arr) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hm = new HashMap<>();
		int sum = 0;
		for(int i = 0 ; i < arr.length ; i++){
			sum = sum + arr[i];
			if(arr[i] == 0 || sum == 0 || hm.get(sum) != null){
				return true;
			}
			hm.put(sum,i);
		}
		return false;
	}

}
