package ru.sergeev.hw47.pageElements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static ru.sergeev.hw47.enums.ProductsPageEnum.CHILD_ITEM_BUTTON;
import static ru.sergeev.hw47.enums.ProductsPageEnum.CHILD_ITEM_TITLE;

public class ItemDescription {
    private final SelenideElement root;
    @Getter
    private final SelenideElement title;
    @Getter
    private final Button addToCartBtn;

    public ItemDescription(SelenideElement root) {
        this.root = root;
        this.title = root.$x(CHILD_ITEM_TITLE.getVal());
        this.addToCartBtn = new Button(root.$x(CHILD_ITEM_BUTTON.getVal()));
    }
}
