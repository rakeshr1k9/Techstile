package ogmatech.com.techstile.controller;

import java.util.ArrayList;
import java.util.List;

import ogmatech.com.techstile.model.Item;
import ogmatech.com.techstile.model.Order;

public class NewOrderController {
    private static NewOrderController newOrderController;
    private Order order;

    public static NewOrderController getInstance() {
        if (newOrderController == null) {
            newOrderController = new NewOrderController();
        }
        return newOrderController;
    }

    public static NewOrderController getNewOrderController() {
        return newOrderController;
    }

    public static void setNewOrderController(NewOrderController newOrderController) {
        NewOrderController.newOrderController = newOrderController;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void clearInstance() {
        newOrderController = null;
    }
}
