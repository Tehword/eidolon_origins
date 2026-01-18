package net.Tehword.eidolon_origins.datagen;


import elucent.eidolon.datagen.*;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = "eidolon_origins",
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class Datagen {
    
    public Datagen() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(event.includeServer(), new EOChantProvider(gen));
    }
}
