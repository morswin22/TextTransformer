package pl.put.poznan.transformer.rest.model;

public class ResponseModel {
    private final String result;

    public ResponseModel(String text) {
        this.result = text;
    }

    public String getResult() {
        return result;
    }
}
