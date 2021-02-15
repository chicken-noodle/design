package minqi.xiao.design.model;

public class Character {
    private Integer id;
    private String character;

    public Character() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"character\":\"")
                .append(character).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
