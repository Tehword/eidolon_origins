package net.Tehword.eidolon_origins.registries;

import elucent.eidolon.codex.*;
import elucent.eidolon.registries.Signs;
import net.Tehword.eidolon_origins.Eidolon_origins;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class EOcodex {
    public static Chapter CHAOS_SIGN;
    @SubscribeEvent
    public static void OnCodexPreInitEvent (CodexEvents.PreInit init){
        Level level = Minecraft.getInstance().level;
        if (level == null) {
            return;
        }
        {
            CHAOS_SIGN = new CodexBuilder(level)
                    .title("eidolon_origins.codex.page.chaos_sign.title")
                    .titlePage("eidolon_origins.codex.page.chaos_sign")
                    .signPage(EOsigns.CHAOS_SIGN)
                    .build();
        }
    }
    @SubscribeEvent
    public static void OnCodexPostInitEvent (CodexEvents.PostInit init){
        CodexChapters.SIGNS_INDEX.addPage(
                new SignIndexPage(
                        new SignIndexPage.SignEntry(EOcodex.CHAOS_SIGN, EOsigns.CHAOS_SIGN))
        );
    }
}