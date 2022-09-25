package de.hyper.mobs.common.obj;

import net.minecraft.network.chat.Component;

public interface CustomEntity {

    String getMaxHealthAsString();
    String getHealthAsString();
    void update();
    Component buildCustomName();

}