package objects;

public enum CategoriesEnum {
    ELEMENTS("Elements"),
    FORMS("Forms"),
    ALERTS("Alerts, Frame & Windows"),
    WIDGETS("Widgets"),
    INTERACTIONS("Interactions"),
    BOOK_STORE_APPLICATIONS("Book Store Application");

    private final String categoryName;

    CategoriesEnum(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getValue() {
        return categoryName;
    }
}
