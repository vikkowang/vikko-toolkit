package com.vikko.demo.algorithm.year2021.month8;

import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/8/13 16:42
 * @Description: leetcode 300
 */
public class LengthOfLIS {

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int res = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(dp[i], res);
		}
		String s = "jtiaoj";
		char[] chars = s.toCharArray();
		int length = chars.length;
		return res;
	}

}
