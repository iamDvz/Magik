package ru.iamdvz.magik.listeners;

import com.nisovin.magicspells.MagicSpells;
import com.nisovin.magicspells.events.SpellEffectsLoadingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.iamdvz.magik.effecttypes.TotemEffect;
public class MagicSpellsListener implements Listener {

    @EventHandler
    public void onSpellEffectLoad(SpellEffectsLoadingEvent event) {
        MagicSpells.getSpellEffectManager().addSpellEffect(TotemEffect.class);
    }
}
