package de.hyper.mobs.common.obj;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftLivingEntity;

public class CustomZombie extends Zombie implements CustomEntity {

    public CustomZombie(Location location) {
        super(EntityType.ZOMBIE, ((CraftWorld) location.getWorld()).getHandle().getLevel());
        this.setPos(location.getX(), location.getY(), location.getZ());
        this.setMaxHealth(50.001);
        this.setHealth(50.001f);
        update();
    }

    @Override
    public void update() {
        this.setCustomName(buildCustomName());
        this.setCustomNameVisible(true);
    }

    @Override
    public String getMaxHealthAsString() {
        return ((Math.round(getMaxHealth() * 100)) / 100D) + "";
    }

    public String getHealthAsString() {
        return ((Math.round(getHealth() * 100)) / 100D) + "";
    }

    public void setMaxHealth(double maxHealth) {
        CraftEntity bukkitEntity = getBukkitEntity();
        if (bukkitEntity instanceof CraftLivingEntity bukkitLivingEntity) {
            bukkitLivingEntity.setMaxHealth(maxHealth);
        }
    }

    @Override
    public Component buildCustomName() {
        TextComponent textComponent = new TextComponent("");

        TextComponent nameComponent = new TextComponent("Mutierter Zombie");
        nameComponent.setStyle(nameComponent.getStyle().withColor(ChatFormatting.GRAY));

        TextComponent splitNameAndHealthComponent = new TextComponent(" [");
        splitNameAndHealthComponent.setStyle(splitNameAndHealthComponent.getStyle().withColor(ChatFormatting.DARK_GRAY));

        TextComponent currentHealthComponent = new TextComponent(getHealthAsString());
        currentHealthComponent.setStyle(currentHealthComponent.getStyle().withColor(ChatFormatting.RED).withBold(true));

        TextComponent splitHealthComponent = new TextComponent("/");
        splitHealthComponent.setStyle(splitHealthComponent.getStyle().withColor(ChatFormatting.DARK_GRAY));

        TextComponent maxHealthComponent = new TextComponent(getMaxHealthAsString());
        maxHealthComponent.setStyle(maxHealthComponent.getStyle().withColor(ChatFormatting.GRAY).withBold(true));

        TextComponent healthIconComponent = new TextComponent("❤");
        healthIconComponent.setStyle(healthIconComponent.getStyle().withColor(ChatFormatting.RED).withBold(true));

        TextComponent endComponent = new TextComponent("]");
        endComponent.setStyle(endComponent.getStyle().withColor(ChatFormatting.DARK_GRAY));

        textComponent.append(nameComponent)
                .append(splitNameAndHealthComponent)
                .append(currentHealthComponent)
                .append(splitHealthComponent)
                .append(maxHealthComponent)
                .append(healthIconComponent)
                .append(endComponent);
        return textComponent;
    }

    @Override
    public boolean alwaysAccepts() {
        return super.alwaysAccepts();
    }
}
