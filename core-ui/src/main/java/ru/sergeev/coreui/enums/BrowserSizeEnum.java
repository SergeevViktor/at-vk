package ru.sergeev.coreui.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BrowserSizeEnum {
    LOOPTOP("1366,768"),
    PC("1920,1080");

    private final String val;
}
