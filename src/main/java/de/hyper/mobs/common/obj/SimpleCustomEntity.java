package de.hyper.mobs.common.obj;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftLivingEntity;

public abstract class SimpleCustomEntity<T extends Mob> extends Mob implements CustomEntity {

    private String callName;

    protected SimpleCustomEntity(EntityType<? extends T> entitytypes, String callName, Location location) {
        super(entitytypes, ((CraftWorld) location.getWorld()).getHandle().getLevel());
        this.callName = callName;
        this.setPos(location.getX(), location.getY(), location.getZ());
    }

    @Override
    public String getCallName() {
        return this.callName;
    }

    @Override
    public String getMaxHealthAsString() {
        return ((Math.round(getMaxHealth() * 100)) / 100D) + "";
    }

    @Override
    public String getHealthAsString() {
        return ((Math.round(getHealth() * 100)) / 100D) + "";
    }

    @Override
    public void updateName() {
        this.setCustomName(buildCustomName());
        this.setCustomNameVisible(true);
    }

    @Override
    public Component buildCustomName() {
        TextComponent textComponent = new TextComponent("");

        TextComponent nameComponent = new TextComponent(getCallName());
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
    public boolean setMaxHealth(double maxHealth) {
        CraftEntity bukkitEntity = getBukkitEntity();
        if (bukkitEntity instanceof CraftLivingEntity bukkitLivingEntity) {
            bukkitLivingEntity.setMaxHealth(maxHealth);
            return true;
        }
        return false;
    }

    @Override
    public boolean alwaysAccepts() {
        return super.alwaysAccepts();
    }
}