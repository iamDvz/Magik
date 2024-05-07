package ru.iamdvz.magik.effecttypes;

import com.nisovin.magicspells.spelleffects.SpellEffect;
import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;
import net.minecraft.network.protocol.game.ClientboundHurtAnimationPacket;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

@Name("hurt")
public class HurtEffect  extends SpellEffect {
    private float yaw;
    @Override
    protected void loadFromConfig(ConfigurationSection config) {
        yaw = Float.parseFloat(config.getString("yaw", "0"));
    }

    public Runnable playEffectEntity(Entity entity, SpellData data) {
        if (!(entity instanceof LivingEntity le)) return null;
        le.playHurtAnimation(yaw);
        return null;
    }
}
