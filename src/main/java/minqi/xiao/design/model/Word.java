package minqi.xiao.design.model;

public class Word {
    private String word;
    private String word_mean;
    private String analysis;
    private String memory;

    public Word() {
    }

    public Word(String word, String word_mean, String analysis, String memory) {
        this.word = word;
        this.word_mean = word_mean;
        this.analysis = analysis;
        this.memory = memory;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord_mean() {
        return word_mean;
    }

    public void setWord_mean(String word_mean) {
        this.word_mean = word_mean;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"word\":\"")
                .append(word).append('\"');
        sb.append(",\"word_mean\":\"")
                .append(word_mean).append('\"');
        sb.append(",\"analysis\":\"")
                .append(analysis).append('\"');
        sb.append(",\"memory\":\"")
                .append(memory).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
