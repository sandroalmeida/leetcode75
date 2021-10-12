package info.sandroalmeida.graph;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * Constraints:
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 * */
public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graphCourses = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int course = 0; course < numCourses; course++)
            graphCourses.put(course, new ArrayList<>());

        for(int[] prereq: prerequisites){
            graphCourses.get(prereq[0]).add(prereq[1]);
        }

        for(int course = 0; course < numCourses; course++){
            if(hasCycle(course, graphCourses, visited))
                return false;
        }

        return true;
    }

    public static boolean hasCycle(int course, Map<Integer, List<Integer>> graphCourses, Set<Integer> visited){
        if(visited.contains(course)){
            return true;
        }else {
            if(graphCourses.containsKey(course)){
                visited.add(course);
                List<Integer> prereqs = graphCourses.get(course);
                for(int prereq: prereqs){
                    if(hasCycle(prereq, graphCourses, visited))
                        return true;
                }
                visited.remove(course);
                graphCourses.put(course, new ArrayList<>());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{0,1},{0,2},{1,3},{1,4},{3,4},{4,1}};
        System.out.println(canFinish(5, prerequisites));
    }
}
