import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NeuralNetwork {
    static Layer[] layers;
    static TrainingData[] trainingData;

    public static void main(String[] args) {
        layers = new Layer[3];
        layers[0] = null;
        layers[1] = new Layer(2, 6);
        layers[2] = new Layer(6, 1);

        createTrainingData();

        System.out.println("\nOutputs before training");
        System.out.println("**************************");
        for (TrainingData trainingDatum : trainingData) {
            forwardPropagation(trainingDatum.data);
            System.out.println(Arrays.asList(layers[layers.length - 1].neurons).stream().map(Object::toString)
                    .collect(Collectors.joining("\n")));
        }

        train(99999, 0.05f);

        System.out.println("\nOutputs after training");
        System.out.println("**************************");
        for (TrainingData trainingDatum : trainingData) {
            forwardPropagation(trainingDatum.data);
            System.out.println(Arrays.asList(layers[layers.length - 1].neurons).stream().map(Object::toString)
                    .collect(Collectors.joining("\n")));
        }
    }

    // TODO edit this
    public static void createTrainingData() {
        // XOR Dataset
        float[][] inputs = new float[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        float[] expectedOutputs = new float[] { 0, 1, 1, 0 };
        trainingData = new TrainingData[4];

        for (int i = 0; i < expectedOutputs.length; i++) {
            trainingData[i] = new TrainingData(inputs[i], expectedOutputs[i]);
        }
    }

    public static void forwardPropagation(float[] inputs) {
        layers[0] = new Layer(inputs);

        for (int i = 1; i < layers.length; i++) {
            for (int j = 0; j < layers[i].neurons.length; j++) {
                float sum = 0;
                for (int k = 0; k < layers[i - 1].neurons.length; k++) {
                    sum += layers[i - 1].neurons[k].value * layers[i].neurons[j].weights[k];
                }
                sum += layers[i].neurons[j].bias;
                layers[i].neurons[j].value = StatisticsUtils.sigmoid(sum);
            }
        }
    }

    public static void backpropagation(float learningRate, TrainingData trainingDatum) {

        int outputLayerIndex = layers.length - 1;

        for (int i = 0; i < layers[outputLayerIndex].neurons.length; i++) {
            float output = layers[outputLayerIndex].neurons[i].value;
            float target = trainingDatum.targets[i];
            float dz = output - target;
            float dw = dz * StatisticsUtils.sigmoidDerivative(output);
            layers[outputLayerIndex].neurons[i].gradient = dw;
            for (int j = 0; j < layers[outputLayerIndex].neurons[i].weights.length; j++) {
                float previousOutput = layers[outputLayerIndex - 1].neurons[j].value;
                float error = dw * previousOutput;
                layers[outputLayerIndex].neurons[i].cacheWeights[j] = layers[outputLayerIndex].neurons[i].weights[j]
                        - learningRate * error;
            }
        }

        for (int i = outputLayerIndex - 1; i > 0; i--) {
            for (int j = 0; j < layers[i].neurons.length; j++) {
                float output = layers[i].neurons[j].value;
                float gradientSum = sumGradient(j, i + 1);
                float delta = gradientSum * StatisticsUtils.sigmoidDerivative(output);
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