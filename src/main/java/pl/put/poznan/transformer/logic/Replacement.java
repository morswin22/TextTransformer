package pl.put.poznan.transformer.logic;

class Replacement {
    final public String replacement;
    final public int start;
    final public int end;

    Replacement(String replacement, int start, int end) {
        this.replacement = replacement;
        this.start = start;
        this.end = end;
    }
}
