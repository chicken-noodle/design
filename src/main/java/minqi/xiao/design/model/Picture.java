package minqi.xiao.design.model;

public class Picture {
    private int id;
    private String uuid;
    private String picture_name;
    private String picture_location;

    public Picture() {
    }

    public Picture(int id, String uuid, String picture_name, String picture_location) {
        this.id = id;
        this.uuid = uuid;
        this.picture_name = picture_name;
        this.picture_location = picture_location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPicture_name() {
        return picture_name;
    }

    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
    }

    public String getPicture_location() {
        return picture_location;
    }

    public void setPicture_location(String picture_location) {
        this.picture_location = picture_location;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"uuid\":\"")
                .append(uuid).append('\"');
        sb.append(",\"picture_name\":\"")
                .append(picture_name).append('\"');
        sb.append(",\"picture_location\":\"")
                .append(picture_location).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
