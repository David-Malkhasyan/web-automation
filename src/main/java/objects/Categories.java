package objects;

public enum Categories {
    ELEMENTS("Elements"),
    FORMS("Forms"),
    ALERTS("Alerts, Frame & Windows"),
    WIDGETS("Widgets"),
    INTERACTIONS("Interactions"),
    BOOK_STORE_APPLICATIONS("Book Store Application");

    private final String categoryName;

    Categories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getValue() {
        return categoryName;
    }
}
