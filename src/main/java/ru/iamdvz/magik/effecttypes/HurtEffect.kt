package ru.iamdvz.magik.effecttypes

import com.nisovin.magicspells.spelleffects.SpellEffect
import com.nisovin.magicspells.util.Name
import com.nisovin.magicspells.util.SpellData
import com.nisovin.magicspells.util.config.ConfigData
import com.nisovin.magicspells.util.config.ConfigDataUtil
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity

@Name("hurt")
class HurtEffect : SpellEffect() {
    private var yaw: ConfigData<Float>? = null

    override fun loadFromConfig(config: ConfigurationSection) {
        yaw = ConfigDataUtil.getFloat(config, "yaw", 0f)
    }

    public override fun playEffectEntity(entity: Entity, data: SpellData): Runnable? {
        if (entity !is LivingEntity) return null
        entity.playHurtAnimation(yaw!![data])
        return null
    }
}
