public class Neuron {
    float[] weights;
    float[] cacheWeights;
    float gradient;
    float bias;
    float value;

    public Neuron(float[] weights, float bias) {
        this.weights = weights;
        this.bias = bias;
        this.cacheWeights = weights;
        this.gradient = 0;
    }

    @Override
    public String toString() {
        return "Neuron [Output = " + value + "]";
    }

    public Neuron(float value) {
        this.value = value;
    }

    public void updateWeights() {
        this.weights = this.cacheWeights;
    }

}
