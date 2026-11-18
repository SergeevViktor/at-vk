package ru.sergeev.coreui.valueObjects;

import ru.sergeev.corecommon.exceptions.TestDefectException;

public record Credentials(String username, String password) {
    public Credentials {
        if (username == null || username.isBlank()) {
            throw new TestDefectException("Username cannot be blank");
        }
    }
}
