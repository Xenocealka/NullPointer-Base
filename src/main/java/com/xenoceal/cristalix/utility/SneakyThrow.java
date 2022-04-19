package com.xenoceal.cristalix.utility;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SneakyThrow {

    @SneakyThrows
    public RuntimeException sneaky(Throwable t) {
        throw t;
    }

}
