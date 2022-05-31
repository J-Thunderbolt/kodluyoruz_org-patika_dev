import java.util.Arrays;
import java.util.stream.Collectors;

public class NeuralNetwork {
    Layer[] layers;
    TrainingData[] trainingData;

    public NeuralNetwork(Layer[] layers, TrainingData[] trainingData) {
        this.layers = layers;
        this.trainingData = trainingData;
    }

    public void forwardPropagation(float[] inputs) {
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

    public void backpropagation(float learningRate, TrainingData trainingDatum) {

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

    public float sumGradient(int neuronIndex, int layerIndex) {
        float gradientSum = 0;
        Layer currentLayer = layers[layerIndex];
        Neuron currentNeuron;
        for (int i = 0; i < currentLayer.neurons.length; i++) {
            currentNeuron = currentLayer.neurons[i];
            gradientSum += currentNeuron.weights[neuronIndex] * currentNeuron.gradient;
        }
        return gradientSum;
    }

    public void train(int epochs, float learningRate) {
        for (int i = 0; i < epochs; i++) {
            for (TrainingData trainingDatum : trainingData) {
                forwardPropagation(trainingDatum.data);
                backpropagation(learningRate, trainingDatum);
            }
        }
    }

    public void predict() {
        for (TrainingData trainingDatum : trainingData) {
            forwardPropagation(trainingDatum.data);
            System.out.println(Arrays.asList(layers[layers.length - 1].neurons).stream().map(Object::toString)
                    .collect(Collectors.joining("\n")));
        }
    }

    public void predictExactly() {
        for (TrainingData trainingDatum : trainingData) {
            forwardPropagation(trainingDatum.data);
            System.out.println(Arrays.asList(layers[layers.length - 1].neurons).stream()
                    .map(neuron -> neuron.value > 0.5 ? "1" : "0").collect(Collectors.joining("\n")));
        }
    }
}