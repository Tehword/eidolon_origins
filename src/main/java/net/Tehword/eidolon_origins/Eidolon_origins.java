package net.Tehword.eidolon_origins;

import elucent.eidolon.util.KnowledgeUtil;
import mod.maxbogomol.fluffy_fur.common.network.FluffyFurPacketHandler;
import mod.maxbogomol.fluffy_fur.common.network.playerskin.PlayerSkinChangePacket;
import mod.maxbogomol.fluffy_fur.common.playerskin.PlayerSkinHandler;
import mod.maxbogomol.fluffy_fur.registry.common.FluffyFurPlayerSkins;
import net.Tehword.eidolon_origins.effect.EOEffects;
import net.Tehword.eidolon_origins.registries.*;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static mod.maxbogomol.fluffy_fur.FluffyFur.hi;

@Mod(Eidolon_origins.MODID)
public class Eidolon_origins {

    public static final String MODID = "eidolon_origins";

    public Eidolon_origins() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        LychPlayerSkins.init();
        EOspells.init();
        EOsigns.init();
        EOEffects.init(modEventBus);
        EOsounds.SOUND_EVENTS.register(modEventBus);
        EOresearches.init();

        EOModStructures.STRUCTURES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(Eidolon_origins_client::ClientSetup);
        modEventBus.addListener(this::setup);
    }

    @SubscribeEvent
    public void onPlayerJoin(TickEvent.PlayerTickEvent event) {
        lych(event.player);
    }
    public static void lych(Player player) {
        if (PlayerSkinHandler.getSkin(player) != LychPlayerSkins.KOSTI && KnowledgeUtil.knowsSign(player, EOsigns.CHAOS_SIGN)) {
            PlayerSkinHandler.setSkinPacket(LychPlayerSkins.KOSTI);
        }
    }
    private void setup(final FMLCommonSetupEvent event) {
        hi();
    }
}