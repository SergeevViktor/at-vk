package ru.sergeev.hw47.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductsPageEnum {
    TITLE("//span[@class='title]"),
    SIDEBAR_BUTTON("react-burger-menu-btn"),
    SIDEBAR_ELEMENTS("//*[@class='bm-item-list']/a");

    private final String val;
}
