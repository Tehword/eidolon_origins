package net.Tehword.eidolon_origins.spell;

import elucent.eidolon.api.research.Research;
import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.capability.ISoul;
import elucent.eidolon.common.spell.StaticSpell;
import elucent.eidolon.util.KnowledgeUtil;
import mod.maxbogomol.fluffy_fur.common.network.FluffyFurPacketHandler;
import mod.maxbogomol.fluffy_fur.common.network.playerskin.PlayerSkinChangePacket;
import mod.maxbogomol.fluffy_fur.common.playerskin.PlayerSkinHandler;
import mod.maxbogomol.fluffy_fur.registry.common.FluffyFurPlayerSkins;
import net.Tehword.eidolon_origins.registries.EOresearches;
import net.Tehword.eidolon_origins.registries.EOsigns;
import net.Tehword.eidolon_origins.registries.LychPlayerSkins;
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

public class FurrySpell extends StaticSpell {
    public FurrySpell(ResourceLocation name, Sign... signs) {
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
//    EOresearches.LYCH_RESEARCH_ONE
    @Override
    public void cast(Level world, BlockPos blockPos, Player player) {
                if (PlayerSkinHandler.getSkin(player) != LychPlayerSkins.KOSTI && KnowledgeUtil.knowsSign(player, EOsigns.CHAOS_SIGN)) {
                    PlayerSkinHandler.setSkinPacket(LychPlayerSkins.KOSTI);
                } else {
                    PlayerSkinHandler.setSkinPacket(FluffyFurPlayerSkins.EMPTY_SKIN);
                }
                FluffyFurPacketHandler.sendToServer(new PlayerSkinChangePacket(player.position().add(0, player.getBbHeight(), 0)));
    }
}