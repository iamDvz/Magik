package ru.iamdvz.magik.listeners

import com.nisovin.magicspells.MagicSpells
import com.nisovin.magicspells.events.SpellEffectsLoadingEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import ru.iamdvz.magik.effecttypes.HurtEffect
import ru.iamdvz.magik.effecttypes.TotemEffect

class MagicSpellsListener : Listener {
    @EventHandler
    fun onSpellEffectLoad(event: SpellEffectsLoadingEvent?) {
        MagicSpells.getSpellEffectManager().addSpellEffect(TotemEffect::class.java)
        MagicSpells.getSpellEffectManager().addSpellEffect(HurtEffect::class.java)
    }
}
