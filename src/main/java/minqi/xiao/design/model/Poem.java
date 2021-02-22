package minqi.xiao.design.model;

public class Poem {
    private String title;
    private String writer;
    private String poem;

    public Poem() {
    }

    public Poem(String title, String writer, String poem) {
        this.title = title;
        this.writer = writer;
        this.poem = poem;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"writer\":\"")
                .append(writer).append('\"');
        sb.append(",\"poem\":\"")
                .append(poem).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
