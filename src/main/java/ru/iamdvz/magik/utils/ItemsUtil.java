package ru.iamdvz.magik.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemsUtil {

    public static ItemStack setCMD(ItemStack item, int CMD) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setCustomModelData(CMD);
        item.setItemMeta((itemMeta));
        return item;
    }
}
