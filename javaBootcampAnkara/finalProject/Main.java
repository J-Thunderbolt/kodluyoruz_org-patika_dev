import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final float LEARNING_RATE = 0.05f;
        final int EPOCH_SIZE = 99999;
        Layer[] layers = new Layer[3];
        TrainingData[] trainingData;

        layers = initLayers();

        trainingData = createXORTrainingData();

        NeuralNetwork neuralNetwork = new NeuralNetwork(layers, trainingData);

        System.out.println("\nOutputs before training");
        System.out.println("**************************");
        for (TrainingData trainingDatum : trainingData) {
            neuralNetwork.forwardPropagation(trainingDatum.data);
            System.out.println(Arrays.asList(layers[layers.length - 1].neurons).stream().map(Object::toString)
                    .collect(Collectors.joining("\n")));
        }

        neuralNetwork.train(EPOCH_SIZE, LEARNING_RATE);

        System.out.println("\nOutputs after training");
        System.out.println("**************************");
        for (TrainingData trainingDatum : trainingData) {
            neuralNetwork.forwardPropagation(trainingDatum.data);
            System.out.println(Arrays.asList(layers[layers.length - 1].neurons).stream().map(Object::toString)
                    .collect(Collectors.joining("\n")));
        }
    }

    // TODO edit this
    private static Layer[] initLayers() {
        Layer[] layers = new Layer[3];
        layers[0] = null;
        layers[1] = new Layer(2, 6);
        layers[2] = new Layer(6, 1);
        return layers;
    }

    public static TrainingData[] createXORTrainingData() {
        TrainingData[] trainingData = new TrainingData[4];
        float[][] inputs = new float[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        float[] expectedOutputs = new float[] { 0, 1, 1, 0 };
        for (int i = 0; i < expectedOutputs.length; i++) {
            trainingData[i] = new TrainingData(inputs[i], expectedOutputs[i]);
        }
        return trainingData;
    }
}
