package de.hyper.mobs.common.obj;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CustomZombie extends SimpleCustomEntity<Zombie> {

    public CustomZombie(String callName, Location location) {
        super(EntityType.ZOMBIE, callName, location);
        this.setMaxHealth(50.0);
        this.setHealth(50.0f);
        updateName();
    }

    @Override
    public void onRightClickedByPlayer(Player player) {
        player.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
    }
}
