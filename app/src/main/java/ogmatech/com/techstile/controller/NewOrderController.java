package ogmatech.com.techstile.controller;

import java.util.ArrayList;
import java.util.List;

import ogmatech.com.techstile.model.Item;

public class NewOrderController {
    private static NewOrderController newOrderController;
    private List<Item> items = new ArrayList<>();

    public static NewOrderController getInstance() {
        if (newOrderController == null) {
            newOrderController = new NewOrderController();
        }
        return newOrderController;
    }

    public List<Item> getItems() {
        return items;
    }

    public void clearInstance() {
        newOrderController = null;
    }
}
