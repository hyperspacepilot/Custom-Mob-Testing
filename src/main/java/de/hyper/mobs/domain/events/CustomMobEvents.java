package de.hyper.mobs.domain.events;

import de.hyper.mobs.common.obj.CustomEntity;
import de.hyper.mobs.domain.CustomMobs;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.ArrayList;
import java.util.List;

public class CustomMobEvents implements Listener {

    private List<Player> doubleClick = new ArrayList<>();

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (((CraftEntity) event.getEntity()).getHandle() instanceof CustomEntity customEntity) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(CustomMobs.get(), () -> customEntity.updateName(), 10L);
        }
    }

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (((CraftEntity) event.getRightClicked()).getHandle() instanceof CustomEntity customEntity) {
            if (doubleClick.contains(player)) {
                doubleClick.remove(player);
            } else {
                doubleClick.add(player);
                customEntity.onRightClickedByPlayer(player);
            }
        }
    }
}