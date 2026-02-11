package net.Tehword.eidolon_origins.spell;

import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.capability.ISoul;
import elucent.eidolon.common.spell.StaticSpell;
import elucent.eidolon.util.KnowledgeUtil;
import net.Tehword.eidolon_origins.registries.EOresearches;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.DamageCommand;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;

public class FirePrayerSpell extends StaticSpell {
    public FirePrayerSpell(ResourceLocation name, Sign... signs) {
        super(name, signs);
    }

    @Override
    public boolean canCast(Level world, BlockPos blockPos, Player player) {
        return KnowledgeUtil.knowsResearch(player, EOresearches.LYCH_RESEARCH_ONE.getRegistryName());
    }


    @Override
    public void cast(Level world, BlockPos blockPos, Player player) {
        float damage = 999999999;
        if (!world.isClientSide) {
        DamageSources.applyDamage(player, damage, new DamageSource((Holder<DamageType>) DamageTypes.ON_FIRE));
    }
}
    }