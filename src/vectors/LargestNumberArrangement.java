/**
 * Form the largest possible number from the array of numbers
 */

package vectors;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class LargestNumberArrangement {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Vector<String> vc = new Vector<>();
		int arrayLength = 0;
		System.out.print("Enter Array Length : ");
		arrayLength = sc.nextInt();
		int[] arr = new int[arrayLength];
		System.out.println("Enter Array Elements : ");
		for(int i = 0 ; i < arrayLength ; i++){
			arr[i] = sc.nextInt();
		}
		for(int i = 0 ; i < arrayLength ; i++){
			vc.add(String.valueOf(arr[i]));
		}
		printLargest(vc);
		sc.close();
		
	}

	private static void printLargest(Vector<String> vc) {
		// TODO Auto-generated method stub
		Collections.sort(vc, new Comparator<String>() {
			public int compare(String x, String y){
				String XY = x+y;
				String YX = y+x;
				return XY.compareTo(YX) > 0 ? -1:1;
			}
		});
		Iterator it = vc.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
	}

}
