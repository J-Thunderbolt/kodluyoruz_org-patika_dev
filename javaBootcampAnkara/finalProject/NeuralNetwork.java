public class NeuralNetwork {
    static Layer[] layers;
    static TrainingData[] trainingData;

    public static void main(String[] args) {
        layers = new Layer[3];
        layers[0] = null;
        layers[1] = new Layer(2, 6);
        layers[2] = new Layer(6, 1);

        createTrainingData();

        System.out.println("Outputs before training");
        for (TrainingData trainingDatum : trainingData) {
            forwardPropagation(trainingDatum.data);
            System.out.println(layers[2].neurons[0].value);
        }

        train(99999, 0.05f);

        System.out.println("Outputs after training");
        for (TrainingData trainingDatum : trainingData) {
            forwardPropagation(trainingDatum.data);
            System.out.println(layers[2].neurons[0].value);
        }
    }

    // TODO edit this
    public static void createTrainingData() {
        // XOR Dataset
        float[] input1 = new float[] { 0, 0 }; // Expect 0 here
        float[] input2 = new float[] { 0, 1 }; // Expect 1 here
        float[] input3 = new float[] { 1, 0 }; // Expect 1 here
        float[] input4 = new float[] { 1, 1 }; // Expect 0 here

        float[] expectedOutput1 = new float[] { 0 };
        float[] expectedOutput2 = new float[] { 1 };
        float[] expectedOutput3 = new float[] { 1 };
        float[] expectedOutput4 = new float[] { 0 };

        trainingData = new TrainingData[4];
        trainingData[0] = new TrainingData(input1, expectedOutput1);
        trainingData[1] = new TrainingData(input2, expectedOutput2);
        trainingData[2] = new TrainingData(input3, expectedOutput3);
        trainingData[3] = new TrainingData(input4, expectedOutput4);
    }

    public static void forwardPropagation(float[] inputs) {
        layers[0] = new Layer(inputs);

        for (int i = 1; i < layers.length; i++) {
            for (int j = 0; j < layers[i].neurons.length; j++) {
                float sum = 0;
                for (int k = 0; k < layers[i - 1].neurons.length; k++) {
                    sum += layers[i - 1].neurons[k].value * layers[i].neurons[j].weights[k];
                }
                // sum += layers[i].neurons[j].bias; // TODO add bias
                layers[i].neurons[j].value = StatisticsUtils.sigmoid(sum);
            }
        }
    }

    public static void backpropagation(float learningRate, TrainingData trainingDatum) {

        int layersCount = layers.length;
        int outputLayerIndex = layersCount - 1;

        for (int i = 0; i < layers[outputLayerIndex].neurons.length; i++) {
            float output = layers[outputLayerIndex].neurons[i].value;
            float target = trainingDatum.targets[i];
            float derivative = output - target;
            float delta = derivative * (output * (1 - output));
            layers[outputLayerIndex].neurons[i].gradient = delta;
            for (int j = 0; j < layers[outputLayerIndex].neurons[i].weights.length; j++) {
                float previousOutput = layers[outputLayerIndex - 1].neurons[j].value;
                float error = delta * previousOutput;
                layers[outputLayerIndex].neurons[i].cacheWeights[j] = layers[outputLayerIndex].neurons[i].weights[j]
                        - learningRate * error;
            }
        }

        for (int i = outputLayerIndex - 1; i > 0; i--) {
            for (int j = 0; j < layers[i].neurons.length; j++) {
                float output = layers[i].neurons[j].value;
                float gradientSum = sumGradient(j, i + 1);
                float delta = (gradientSum) * (output * (1 - output));
                layers[i].neurons[j].gradient = delta;
                for (int k = 0; k < layers[i].neurons[j].weights.length; k++) {
                    float previousOutput = layers[i - 1].neurons[k].value;
                    float error = delta * previousOutput;
                    layers[i].neurons[j].cacheWeights[k] = layers[i].neurons[j].weights[k] - learningRate * error;
                }
            }
        }

        for (Layer layer : layers) {
            for (int j = 0; j < layer.neurons.length; j++) {
                layer.neurons[j].updateWeights();
            }
        }

    }

    public static float sumGradient(int neuronIndex, int layerIndex) {
        float gradientSum = 0;
        Layer currentLayer = layers[layerIndex];
        for (int i = 0; i < currentLayer.neurons.length; i++) {
            Neuron currentNeuron = currentLayer.neurons[i];
            gradientSum += currentNeuron.weights[neuronIndex] * currentNeuron.gradient;
        }
        return gradientSum;
    }

    public static void train(int epochs, float learningRate) {
        for (int i = 0; i < epochs; i++) {
            for (TrainingData trainingDatum : trainingData) {
                forwardPropagation(trainingDatum.data);
                backpropagation(learningRate, trainingDatum);
            }
        }
    }
}