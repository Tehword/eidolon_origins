package net.Tehword.eidolon_origins.spell;

import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.common.spell.StaticSpell;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class RevengeSpell extends StaticSpell {
    public RevengeSpell(ResourceLocation name, Sign... signs) {
        super(name, signs);
    }

    @Override
    public boolean canCast(Level level, BlockPos blockPos, Player player) {
        return false;
    }

    @Override
    public void cast(Level level, BlockPos blockPos, Player player) {

    }
}
