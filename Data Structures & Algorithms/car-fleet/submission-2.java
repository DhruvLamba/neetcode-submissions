class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Pair each car's position with its speed
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position, closest to target FIRST
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (double[] car : cars) {
            double time = (target - car[0]) / car[1];

            // Only push if this car is slower than the fleet currently at the top
            // (i.e. it can't catch up -> it's a new fleet)
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // else: it merges into the fleet ahead -> push nothing
        }

        return stack.size();
    }
}