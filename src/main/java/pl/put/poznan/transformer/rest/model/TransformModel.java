package pl.put.poznan.transformer.rest.model;

public class TransformModel {
    private String text;
    private String[] transforms;

    public TransformModel() {
    }

    public TransformModel(String text, String[] transforms) {
        this.text = text;
        this.transforms = transforms;
    }

    public String getText() {
        return text;
    }

    public String[] getTransforms() {
        return transforms;
    }
}
