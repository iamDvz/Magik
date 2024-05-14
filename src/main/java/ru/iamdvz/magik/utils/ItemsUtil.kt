package ru.iamdvz.magik.utils

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

object ItemsUtil {
    @JvmStatic
    fun setCmd(item: ItemStack, CMD: Int?): ItemStack {
        val itemMeta: ItemMeta = item.itemMeta
        itemMeta.setCustomModelData(CMD)
        item.setItemMeta(itemMeta)
        return item
    }
}