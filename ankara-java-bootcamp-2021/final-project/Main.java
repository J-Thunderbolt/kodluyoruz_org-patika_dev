public class Main {
    public static void main(String[] args) {
        final float LEARNING_RATE = 0.05f;
        final int EPOCH_SIZE = 100000;
        Layer[] layers = new Layer[3];
        TrainingData[] trainingData;

        layers = initLayers();

        trainingData = createXORTrainingData();

        NeuralNetwork neuralNetwork = new NeuralNetwork(layers, trainingData);

        System.out.println("\nOutputs before training (after first iteration)");
        System.out.println("**************************");
        neuralNetwork.predict();

        neuralNetwork.train(EPOCH_SIZE, LEARNING_RATE);

        System.out.println("\nOutputs after training");
        System.out.println("**************************");
        neuralNetwork.predict();
    }

    // TODO edit this to generalize
    private static Layer[] initLayers() {
        Layer[] layers = new Layer[3];
        layers[1] = new Layer(2, 16);
        layers[2] = new Layer(16, 1);
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
