public class StatisticsUtils {

    public static void initWeights(float[] weights) {
        for (int i = 0; i < weights.length; i++) {
            float u1 = (float) Math.random();
            float u2 = (float) Math.random();
            float r = (float) Math.sqrt(-2 * (float) Math.log(u1));
            weights[i] = r * (float) Math.cos(2 * (float) Math.PI * u2);
        }
    }

    public static float sigmoid(float x) {
        return (float) (1 / (1 + Math.pow(Math.E, -x)));
    }

    public static float sigmoidDerivative(float x) {
        float sigmoidX = sigmoid(x);
        return sigmoidX * (1 - sigmoidX);
    }

    public static float logisticLoss(float output, float target) {
        // return (float) (0.5 * Math.pow(2, (target - output))); // non-convex
        return -(target * (float) Math.log(output) + (1 - target) * (float) Math.log(1 - output));
    }

    // TODO: code and use this xD
    public static float calculateCost(float[] outputs, float[] targets) {
        int samplesCount = 1;
        float sum = 0;
        float cost;

        for (int i = 0; i < samplesCount; i++) {
            sum += logisticLoss(outputs[i], targets[i]);
        }

        cost = sum / samplesCount;
        return cost;
    }
}
