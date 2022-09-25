package de.hyper.mobs.domain.commands;

import de.hyper.mobs.common.obj.CustomZombie;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (player.hasPermission("admin.admin.test")) {
                CustomZombie customZombie = new CustomZombie("Mutierter Zombie", player.getLocation());
                ServerLevel serverLevel = ((CraftWorld) player.getWorld()).getHandle();
                serverLevel.addFreshEntity(customZombie, CreatureSpawnEvent.SpawnReason.CUSTOM);
                player.sendMessage("sneeens test bestanden");

            }
        }
        return false;
    }
}
