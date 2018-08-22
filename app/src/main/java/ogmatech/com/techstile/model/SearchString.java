package ogmatech.com.techstile.model;

public class SearchString {
   private static String searchOrder;

    public static String getSearchOrder() {
        return searchOrder;
    }

    public static void setSearchOrder(String searchOrder) {
        SearchString.searchOrder = searchOrder;
    }
}
