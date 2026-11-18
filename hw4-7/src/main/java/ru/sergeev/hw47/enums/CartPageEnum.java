package ru.sergeev.hw47.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CartPageEnum {
    TITLE("//span[@class='title']"),
    CART_ITEMS("//div[@class='cart_item']");

    private final String val;
}
