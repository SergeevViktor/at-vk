package ru.sergeev.hw47.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductsPageEnum {
    TITLE("//span[@class='title']"),
    SIDEBAR_BUTTON("react-burger-menu-btn"),
    SIDEBAR_ELEMENTS("//*[@class='bm-item-list']/a"),
    ITEM_DESCRIPTIONS("//div[@class='inventory_item_description']"),
    CHILD_ITEM_TITLE(".//div[@class='inventory_item_name ']"),
    CHILD_ITEM_BUTTON("./div[@class='pricebar']/button"),
    SHOPPING_CART_BUTTON("//div[@class='shopping_cart_container']/a");

    private final String val;
}
