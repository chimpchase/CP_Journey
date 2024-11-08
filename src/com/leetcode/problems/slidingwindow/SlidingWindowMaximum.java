package com.leetcode.problems.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int x [] = {7,2,4};
		 for(int r:maxSlidingWindow(x, 2)) {
			 System.out.println(r);
		 }
	}
	
	static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
		int res[] = new int[n-k+1];
		int l=0;
		Deque<Integer> dq = new ArrayDeque<>();
		int windowSize = 0;
		int item ;
		for(int i=0;i<n;i++) {
			item = nums[i];
			windowSize++;
			int size = dq.size();
			if(windowSize<k) {				
				for(int c=0;c<size;c++) {
					int alpha = dq.peekFirst();
					if(alpha<item) {
						dq.removeFirst();
					}
				}
				
				dq.addLast(item);			
			}
			else {
				for(int c=0;c<size;c++) {
					int alpha = dq.peekFirst();
					if(alpha<item) {
						dq.removeFirst();
					}
				}
				dq.addLast(item);
				
				if(dq.size()>k) {
					int extra = dq.size()-k;
					for(int c =1;c<=extra;c++) {
						dq.removeFirst();
					}
					for(int c=0;c<size;c++) {
						int alpha = dq.peekFirst();
						if(alpha<item) {
							dq.removeFirst();
						}
					}
				}	
				res[l++]=dq.getFirst();
			}
			
		}
		return res;
    }

}
