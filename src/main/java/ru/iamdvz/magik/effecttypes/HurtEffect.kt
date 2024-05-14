package ru.iamdvz.magik.effecttypes;

import com.nisovin.magicspells.spelleffects.SpellEffect;
import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;
import com.nisovin.magicspells.util.config.ConfigData;
import com.nisovin.magicspells.util.config.ConfigDataUtil;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

@Name("hurt")
public class HurtEffect extends SpellEffect {
    private ConfigData<Float> yaw;
    @Override
    protected void loadFromConfig(ConfigurationSection config) {
        yaw = ConfigDataUtil.getFloat(config, "yaw", 0f);
    }

    public Runnable playEffectEntity(Entity entity, SpellData data) {
        if (!(entity instanceof LivingEntity le)) return null;
        le.playHurtAnimation(yaw.get(data));
        return null;
    }
}
