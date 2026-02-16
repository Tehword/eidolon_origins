package net.Tehword.eidolon_origins;

import java.awt.Color;
import java.util.List;

import mod.maxbogomol.fluffy_fur.FluffyFurClient;
import mod.maxbogomol.fluffy_fur.client.gui.screen.FluffyFurMod;
import mod.maxbogomol.fluffy_fur.client.gui.screen.FluffyFurPanorama;
import mod.maxbogomol.fluffy_fur.client.language.LanguageHandler;
import mod.maxbogomol.fluffy_fur.client.splash.SplashHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static elucent.eidolon.registries.Registry.IMBUED_BONES;
import static elucent.eidolon.registries.Registry.UNHOLY_SYMBOL;

public class Eidolon_origins_client {
    public static FluffyFurMod MOD_INSTANCE;
    public static FluffyFurPanorama EIDOLON_ORIGINS;

    public static void ClientSetup(final FMLClientSetupEvent event) {
        setupMenu();
        setupSplashes();
    }

    public static void setupMenu() {
        MOD_INSTANCE = new FluffyFurMod("eidolon_origins", "Eidolon Origins", "0.1").setDev("Artmax, Tehword, MrDeToxin").setItem(new ItemStack(UNHOLY_SYMBOL.get()))
                .setEdition(16).setNameColor(new Color(0,47,85)).setVersionColor(new Color(1,50,32))
                .setDescription(Component.translatable("eidolon_origins.mod_description"));

        EIDOLON_ORIGINS = new FluffyFurPanorama(Eidolon_origins.MODID + ":eidolon_origins", Component.translatable("eidolon_origins.eidor_crypt.panorama"))
                .setMod(MOD_INSTANCE).setItem(new ItemStack(IMBUED_BONES.get())).setSort(0)
                .setTexture(new ResourceLocation(Eidolon_origins.MODID, "textures/gui/menu/panorama/eidolon_origins/panorama"))
                .setLogo(new ResourceLocation(Eidolon_origins.MODID, "textures/gui/menu/title/eidolon_origins.png"));


        FluffyFurClient.registerMod(MOD_INSTANCE);
        FluffyFurClient.registerPanorama(EIDOLON_ORIGINS);
    }

    public static void setupSplashes() {
        List<String> strings = LanguageHandler.getStringsFromFile(new ResourceLocation(Eidolon_origins.MODID, "texts/splashes.txt"));
        for (String string : strings) {
            SplashHandler.addSplash(string);
        }
    }
}
