package ogmatech.com.techstile.controller;

import ogmatech.com.techstile.model.UserCartItem;

public class CartController {

    private static CartController cardController;

    private UserCartItem userCartItem;

    public static CartController getInstance() {
        if (cardController == null) {
            cardController = new CartController();
        }
        return cardController;
    }

    public static CartController getCardController() {
        return cardController;
    }

    public static void setCardController(CartController cardController) {
        CartController.cardController = cardController;
    }

    public UserCartItem getUserCartItem() {
        return userCartItem;
    }

    public void setUserCartItem(UserCartItem userCartItem) {
        this.userCartItem = userCartItem;
    }
}
