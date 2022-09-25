package de.hyper.mobs.common.obj;

import net.minecraft.network.chat.Component;
import org.bukkit.entity.Player;

public interface CustomEntity {

    String getCallName();

    String getMaxHealthAsString();

    String getHealthAsString();

    void updateName();

    Component buildCustomName();

    void onRightClickedByPlayer(Player player);

    boolean setMaxHealth(double maxHealth);
}