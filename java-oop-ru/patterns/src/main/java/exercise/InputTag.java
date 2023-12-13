package exercise;

// BEGIN
public class  InputTag implements TagInterface {
    private String type;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    private String value;



    public String render() {
        return "<input type=\"" + type +"\"" +" value=\"" + value + "\">";
    }
}
