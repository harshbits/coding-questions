package google.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.

Example 1:
Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
Explanation:

Example 2:
Input: [[1,2],[2,2],[4,2]]
Output: [[1,2],[2,2],[4,2]]
Explanation:

Even you only have trees in a line, you need to use rope to enclose them. 
Note:

All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
All input integers will range from 0 to 100.
The garden has at least one tree.
All coordinates are distinct.
Input points have NO order. No order required for output.
 * 
 * @author hbhavsar
 * 
 * @see https://www.geeksforgeeks.org/convex-hull-set-2-graham-scan/
 *
 */
public class ErecttheFence587 {

	public static void main(String[] args) {
		Point[] points = {};
		ErecttheFence587 e = new ErecttheFence587();
		List<Point> ans = e.outerTrees(points);
		System.out.println(ans);
		
	}
	
	// Total time complexity O (n log n)
	public List<Point> outerTrees(Point[] points) {

		// 1.
		// Find the bottom-most point by comparing y coordinate of all points. 
		// If there are two points with same y value, then the point with smaller x coordinate value is considered. 
		// Let the bottom-most point be P0. Put P0 at first position in output hull.
		// find the first point to start rolling
		Point bottomLeft = getMostBottomLeft(points);

		// 2.
		// sort by polor angle in counterclockwise order around points[0]
		// if polor angle of two points is same, then put the nearest point first.
		sortByPolar(points, bottomLeft);

		// 3. 
		// Create an empty stack ‘S’ and push points[0], points[1] and points[2] to S.
		// Space complexity O(n)
		Stack<Point> stack = new Stack<>(); 
        stack.push(points[0]);                      
        stack.push(points[1]);  
        
		// 4.
        // Time complexity O(n)
		for (int i = 2; i < points.length; i++) {
			Point top = stack.pop();
			
			//  Keep removing points from stack while orientation of following
			// 3 points is not counterclockwise (or they don’t make a left turn).
			// if angle is more than 180 degree/ clock wise direction 
			while (getSegmentIntersectType(stack.peek(), top, points[i]) < 0) {
				// keep updating the top
				top = stack.pop();
			}
			stack.push(top);
			stack.push(points[i]);
		}
		
		// 5. Print contents of S
		// return anseer
		return new ArrayList<>(stack);
	}
	
	// Time complexity = O(n)
	private Point getMostBottomLeft(Point[] points) {
		Point bottomLeft = points[0];
		for (Point p : points) {
			if (p.y < bottomLeft.y || p.y == bottomLeft.y && p.x < bottomLeft.x) {
				bottomLeft = p;
			}
		}
		return bottomLeft;
	}
	
	/**
	 * For collinear points in the begin positions, 
	 * 		make sure they are sorted by distance to reference point in ascending order.
	 * For collinear points in the end positions, 
	 * 		make sure they are sorted by distance to reference point in descending order.
	 * @param points
	 */
	// Time complexity = O(n logn)
	private void sortByPolar(Point[] points, Point start) {
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p, Point q) {
				int compPolar = getSegmentIntersectType(p, start, q);
				int compDist = getDistance(p, start) - getDistance(q, start);
				return compPolar == 0 ? compDist : compPolar;
			}
		});
			
		// find collinear points in the end positions
		Point p = points[0];
		Point q = points[points.length - 1];
		int i = points.length - 2;

		while (i >= 0 && getSegmentIntersectType(p, q, points[i]) == 0) {
			i--;
		}
		
		// reverse sort order of collinear points in the end positions
		for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
			Point tmp = points[l];
			points[l] = points[h];
			points[h] = tmp;
		}
	}
	
	/**
	 * Get distance between 2 points
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	private int getDistance(Point p, Point q) {
		// Distance =√(x2−x1)2+(y2−y1)2
		// return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y));
		return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
	}

	/**
	 * Orientation of an ordered triplet of points in the plane can be
	 * –counterclockwise 
	 * –clockwise 
	 * –colinear
	 * 
	 * @return
	 */
	private int getSegmentIntersectType(Point a, Point b, Point c) {
		return a.x * b.y - b.x * a.y + b.x * c.y - c.x * b.y + c.x * a.y - c.y * a.x;
	}
	
	public class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
}
