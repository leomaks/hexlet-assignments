package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private TagInterface tag;

    public LabelTag(String value, TagInterface tag) {
        this.tag = tag;
        this.value = value;
    }

    private String value;


    public String render() {
        var str = "<label>" + value + tag.render() + "</label>";
        return str;
    }
}
