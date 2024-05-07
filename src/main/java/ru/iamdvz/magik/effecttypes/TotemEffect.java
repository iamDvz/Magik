package ru.iamdvz.magik.effecttypes;

import com.nisovin.magicspells.spelleffects.SpellEffect;
import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_20_R3.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.iamdvz.magik.utils.ItemsUtil;

@Name("totem")
public class TotemEffect extends SpellEffect {
    private int customModelData;

    @Override
    protected void loadFromConfig(ConfigurationSection config) {
        customModelData = config.getInt("custom-model-data", 0);
    }

    @Override
    public Runnable playEffectEntity(Entity entity, SpellData data) {
        if (!(entity instanceof Player p)) return null;
        ItemStack offHandItem = p.getInventory().getItemInOffHand();
        ItemStack item = ItemsUtil.setCMD(new ItemStack(Material.TOTEM_OF_UNDYING), customModelData);
        ((CraftPlayer) p).getHandle().connection.send(new ClientboundContainerSetSlotPacket(0, 0, 45, CraftItemStack.asNMSCopy(item)));
        p.playEffect(EntityEffect.TOTEM_RESURRECT);
        ((CraftPlayer) p).getHandle().connection.send(new ClientboundContainerSetSlotPacket(0, 0, 45, CraftItemStack.asNMSCopy(offHandItem)));
        return null;
    }

}
