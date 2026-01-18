package net.Tehword.eidolon_origins.spell;

import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.capability.ISoul;
import elucent.eidolon.common.spell.StaticSpell;
import elucent.eidolon.common.tile.IBurner;
import elucent.eidolon.network.IgniteEffectPacket;
import elucent.eidolon.network.Networking;
import elucent.eidolon.registries.Researches;
import elucent.eidolon.util.KnowledgeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import static net.minecraft.world.item.enchantment.ThornsEnchantment.getDamage;

public class WitherSkullSpell extends StaticSpell {
    public WitherSkullSpell(ResourceLocation name, Sign... signs) {
        super(name, signs);
    }

    @Override
    public boolean canCast(Level world, BlockPos blockPos, Player player) {
        return KnowledgeUtil.knowsResearch(player, Researches.FIRE_SPELL.getRegistryName());
    }


    @Override
    public void cast(Level level, BlockPos blockPos, Player player) {
        float speed = 8  * .01f;
        float damage = 10;
        WitherSkull skull = new ExtendedWitherSkull(player, level, speed, damage);
        Vec3 spawn = player.getEyePosition().add(player.getForward());
        skull.moveTo(spawn.x, spawn.y - skull.getBoundingBox().getYsize() / 2, spawn.z, player.getYRot() + 180, player.getXRot());
        level.addFreshEntity(skull);
        ISoul.expendMana(player, this.getCost());
        }

}
