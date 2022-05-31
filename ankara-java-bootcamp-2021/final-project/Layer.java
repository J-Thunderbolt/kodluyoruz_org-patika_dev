public class Layer {
    public Neuron[] neurons;

    // Hidden layer
    public Layer(int previousNeuronsCount, int neuronsCount) {
        this.neurons = new Neuron[neuronsCount];

        for (int i = 0; i < neuronsCount; i++) {
            float[] weights = new float[previousNeuronsCount];
            StatisticsUtils.initWeights(weights);
            neurons[i] = new Neuron(weights, (float) Math.random());
        }
    }

    // Input layer
    public Layer(float input[]) {
        this.neurons = new Neuron[input.length];
        for (int i = 0; i < input.length; i++) {
            this.neurons[i] = new Neuron(input[i]);
        }
    }
}
