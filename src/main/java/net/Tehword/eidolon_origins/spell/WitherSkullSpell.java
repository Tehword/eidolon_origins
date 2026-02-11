package net.Tehword.eidolon_origins.spell;

import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.capability.ISoul;
import elucent.eidolon.common.spell.StaticSpell;
import elucent.eidolon.registries.Researches;
import elucent.eidolon.util.KnowledgeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.level.Level;

import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.LazyOptional;


public class WitherSkullSpell extends StaticSpell {
    public WitherSkullSpell(ResourceLocation name, Sign... signs) {
        super(name, 10, signs);
    }
    @Override
    public boolean canCast(Level world, BlockPos pos, Player player) {
        if (!player.isCreative()) {
            LazyOptional<ISoul> capability = player.getCapability(ISoul.INSTANCE);
            if (capability.isPresent() && capability.resolve().isPresent()) {
                ISoul soul = (ISoul)capability.resolve().get();
                if (soul.getMagic() < (float)10) {
                    if (player instanceof ServerPlayer) {
                        ServerPlayer serverPlayer = (ServerPlayer)player;
                        serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("eidolon.title.no_mana")));
                        return false;
                    }
                }
            }
        }
        return true;
    }
    @Override
    public void cast(Level world, BlockPos blockPos, Player player) {
        if (!world.isClientSide) {
            float speed = 8  * 0.01f;
            float damage = 10;
            WitherSkull skull = new ExtendedWitherSkull(player, world, speed, damage);
            Vec3 spawn = player.getEyePosition().add(player.getForward());
            skull.moveTo(spawn.x, spawn.y - skull.getBoundingBox().getYsize() / 2, spawn.z, player.getYRot() + 180, player.getXRot());
            world.addFreshEntity(skull);
            ISoul.expendMana(player, 10);
        }
    }
}
