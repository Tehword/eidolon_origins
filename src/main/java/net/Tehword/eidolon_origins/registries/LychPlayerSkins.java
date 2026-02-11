package net.Tehword.eidolon_origins.registries;

import com.google.common.base.Ticker;
import elucent.eidolon.util.KnowledgeUtil;
import mod.maxbogomol.fluffy_fur.common.network.FluffyFurPacketHandler;
import mod.maxbogomol.fluffy_fur.common.network.playerskin.PlayerSkinChangePacket;
import mod.maxbogomol.fluffy_fur.common.playerskin.FoxPlayerSkin;
import mod.maxbogomol.fluffy_fur.common.playerskin.PlayerSkin;
import mod.maxbogomol.fluffy_fur.common.playerskin.PlayerSkinHandler;
import mod.maxbogomol.fluffy_fur.registry.common.FluffyFurPlayerSkins;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;

public class LychPlayerSkins {
    public static PlayerSkin KOSTI = (
            new LychKosti("fluffy_fur:lych"))
            .setKostiTexture(PlayerSkin.getSkinLocation("fluffy_fur", "maxbogomol/tail"))
            .setSlim(true);

    public LychPlayerSkins(){}


    public static void init(){
        PlayerSkinHandler.register(KOSTI);


    }
}
