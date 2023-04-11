package com.wkr.fifty;
/*11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical 
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together 
 * with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * 
 * */
public class C11ContainerWithMostWater {
	public static void main(String[] args) {
		C11ContainerWithMostWater s = new C11ContainerWithMostWater();
		int []height = {1, 5, 3, 7};
		System.out.println(s.maxArea(height));
	}
    public int maxArea(int[] height) {
    	int max = 0;
    	int left = 0, right = height.length-1;
    	int area = 0;
    	// 第一次使用双重循环的方式，超时了^:^
    	while (left < right) {
			area = (Math.min(height[left], height[right]))*(right-left);
			if (max < area) {
				max = area;
			}
			if (height[left] > height[right]) {
				do {
					--right;
				} while (left < right && height[right+1] >= height[right]);
			} else {
				do {
					++left;
				} while (left < right && height[left-1] >= height[left]);
			}
		}
        return max;
    }
}
