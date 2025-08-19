package io.github.itzispyder.clickcrystals.gui.elements.common;

import io.github.itzispyder.clickcrystals.gui.GuiElement;

@FunctionalInterface
public interface PressAction<T extends GuiElement> {

    void onPress(T button);
}
