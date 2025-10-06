package org.fpinscala;

import java.util.Collection;

public class EarlyReturnsJava {
    private Bar complexConversion(Foo foo) {
        return new Bar();
    }

    private boolean complexValidation(Bar bar) {
        return true;
    }

    public Bar findFirstValidBar(Collection<Foo> foos) {
        for(Foo foo : foos) {
            Bar bar = complexConversion(foo);
            if (complexValidation(bar)) return bar;
        }
        return null;
    }
}
