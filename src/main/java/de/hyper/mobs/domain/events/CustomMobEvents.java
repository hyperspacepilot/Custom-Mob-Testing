package de.hyper.mobs.domain.events;

import de.hyper.mobs.common.obj.CustomEntity;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class CustomMobEvents implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (((CraftEntity) event.getEntity()).getHandle() instanceof CustomEntity customEntity) {
            customEntity.update();
            Bukkit.broadcastMessage("Custom-Entity " + event.getEntity().getType().name() + " got damage (" + event.getDamage() + ") and is now updated");
        }
    }
}