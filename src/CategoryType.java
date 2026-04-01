public enum CategoryType {
    ELECTRO("전자제품"),
    CLOTH("의류"),
    FOOD("식품");

    private final String type;

    CategoryType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
