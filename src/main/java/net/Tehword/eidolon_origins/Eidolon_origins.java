package net.Tehword.eidolon_origins;

import net.Tehword.eidolon_origins.registries.EOcodex;
import net.Tehword.eidolon_origins.registries.EOsigns;
import net.Tehword.eidolon_origins.registries.EOspells;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Eidolon_origins.MODID)
public class Eidolon_origins {

    public static final String MODID = "eidolon_origins";

    public Eidolon_origins() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EOspells.init();
        EOsigns.init();;
        MinecraftForge.EVENT_BUS.register(this);
    }
}
