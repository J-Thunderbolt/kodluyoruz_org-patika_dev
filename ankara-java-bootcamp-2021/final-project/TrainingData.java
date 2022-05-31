public class TrainingData {
    float[] data;
    float[] targets;

    public TrainingData(float[] data, float target) {
        this.data = data;
        this.targets = new float[] { target };
    }

    public TrainingData(float[] data, float[] targets) {
        this.data = data;
        this.targets = targets;
    }
}
