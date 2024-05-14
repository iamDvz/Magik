package ru.iamdvz.magik.effecttypes

import com.nisovin.magicspells.spelleffects.SpellEffect
import com.nisovin.magicspells.util.Name
import com.nisovin.magicspells.util.SpellData
import com.nisovin.magicspells.util.config.ConfigData
import com.nisovin.magicspells.util.config.ConfigDataUtil
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket
import org.bukkit.EntityEffect
import org.bukkit.Material
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer
import org.bukkit.craftbukkit.v1_20_R3.inventory.CraftItemStack
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import ru.iamdvz.magik.utils.ItemsUtil

@Name("totem")
class TotemEffect : SpellEffect() {
    private var customModelData: ConfigData<Int>? = null

    override fun loadFromConfig(config: ConfigurationSection) {
        customModelData = ConfigDataUtil.getInteger(config, "custom-model-data", 1)
    }
    public override fun playEffectEntity(entity: Entity, data: SpellData): Runnable? {
        if (entity !is Player) return null
        val offhandItem: ItemStack = entity.inventory.itemInOffHand
        val item: ItemStack = ItemsUtil.setCmd(ItemStack(Material.TOTEM_OF_UNDYING), customModelData!![data])

        (entity as CraftPlayer).handle.connection.send(ClientboundContainerSetSlotPacket(0, 0, 45, CraftItemStack.asNMSCopy(item)))
        entity.playEffect(EntityEffect.TOTEM_RESURRECT)
        entity.handle.connection.send(ClientboundContainerSetSlotPacket(0, 0, 45, CraftItemStack.asNMSCopy(offhandItem)))
        return null
    }
}