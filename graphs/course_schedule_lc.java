/*
 * 
 * 
 * q. 210 Course Schedule II
 * 
 * 
 * There are a total of numCourses courses you have to take, 
 * labeled from 0 to numCourses - 1.
 *  You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adj[prerequisiteCourse].add(course);
            indegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            result[index++] = currentCourse;
            
            for (int neighbor : adj[currentCourse]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // Check if all courses are taken
        if (index == numCourses) {
            return result;
        } else {
            return new int[0]; // It is impossible to finish all courses
        }
    }
}
