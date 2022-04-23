/**
 * From Karumanchi
 */

package linkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RecursiveReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ll = new ArrayList<>();
		System.out.println("Enter the length of the Linked List");
		Scanner sc = new Scanner(System.in);
		int sizeList = sc.nextInt();
		int i = 0;
		System.out.println("Enter the values to be inserted");
		while(i < sizeList){
			ll.add(sc.nextInt());
			i++;
		}
		System.out.println("Create Linked List : ");
		i = 0;
		Iterator it = ll.iterator();
		while(it.hasNext()){
			System.out.println(it.next() + "->");
		}
		reverse(ll);
	}

	private static void reverse(List<Integer> ll) {
		// TODO Auto-generated method stub
		while(ll.isEmpty()){
			return;
		}
		
	}

}
