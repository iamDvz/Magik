package ru.iamdvz.magik.targeted

import com.nisovin.magicspells.MagicSpells
import com.nisovin.magicspells.spells.TargetedLocationSpell
import com.nisovin.magicspells.spells.TargetedSpell
import com.nisovin.magicspells.util.CastResult
import com.nisovin.magicspells.util.MagicConfig
import com.nisovin.magicspells.util.SpellData
import com.nisovin.magicspells.util.config.ConfigData
import org.bukkit.block.Block

class GetBlockTypeSpell(config: MagicConfig?, spellName: String?) : TargetedSpell(config, spellName), TargetedLocationSpell {
    private var block: Block? = null
    private val variableName: ConfigData<String> = getConfigDataString("variable", "")

    override fun cast(data: SpellData): CastResult {
        return castAtLocation(getTargetedBlockLocation(data).spellData())
    }

    override fun castAtLocation(data: SpellData): CastResult {
        block = data.location().block
        val variable = MagicSpells.getVariableManager().getVariable(variableName[data])
        MagicSpells.getVariableManager()[variable, if (data.caster() == null) null else data.caster().name] = block!!.type.toString()
        return CastResult(PostCastAction.HANDLE_NORMALLY, data)
    }
}
