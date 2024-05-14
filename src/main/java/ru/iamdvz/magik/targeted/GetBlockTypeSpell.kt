package ru.iamdvz.magik.targeted;

import com.nisovin.magicspells.MagicSpells;
import com.nisovin.magicspells.spells.TargetedLocationSpell;
import com.nisovin.magicspells.spells.TargetedSpell;
import com.nisovin.magicspells.util.CastResult;
import com.nisovin.magicspells.util.MagicConfig;
import com.nisovin.magicspells.util.SpellData;
import com.nisovin.magicspells.util.TargetInfo;
import com.nisovin.magicspells.util.config.ConfigData;
import com.nisovin.magicspells.variables.Variable;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class GetBlockTypeSpell extends TargetedSpell implements TargetedLocationSpell {
    private Block block;
    private final ConfigData<String> variableName;

    public GetBlockTypeSpell(MagicConfig config, String spellName) {
        super(config, spellName);
        variableName = getConfigDataString("variable", "");
    }
    @Override
    public CastResult cast(SpellData data) {
        return castAtLocation(getTargetedBlockLocation(data).spellData());
    }
    @Override
    public CastResult castAtLocation(SpellData data) {
        block = data.location().getBlock();
        Variable variable = MagicSpells.getVariableManager().getVariable(variableName.get(data));
        MagicSpells.getVariableManager().set(variable, data.caster() == null ? null : data.caster().getName(), String.valueOf(block.getType()));
        return new CastResult(PostCastAction.HANDLE_NORMALLY, data);
    }
}
