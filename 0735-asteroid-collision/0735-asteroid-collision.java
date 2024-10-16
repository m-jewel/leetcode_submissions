import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a : asteroids) {
            // Handle collisions only if the asteroid is moving left (a < 0) and the stack has asteroids moving right (stack.peek() > 0)
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int top = stack.peek();
                // If the absolute value of the current asteroid is larger, pop the stack and continue checking for more collisions
                if (Math.abs(a) > top) {
                    stack.pop();
                    continue;
                } 
                // If the asteroids are of equal size, both explode
                else if (Math.abs(a) == top) {
                    stack.pop();
                }
                // In both cases (equal or smaller), the current asteroid will explode, so break out of the loop
                a = 0;
                break;
            }
            
            // If the current asteroid didn't explode, push it to the stack
            if (a != 0) {
                stack.push(a);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
