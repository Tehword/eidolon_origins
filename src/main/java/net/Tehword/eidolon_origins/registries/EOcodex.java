package net.Tehword.eidolon_origins.registries;

import elucent.eidolon.client.particle.Particles;
import elucent.eidolon.codex.*;
import elucent.eidolon.registries.Registry;
import elucent.eidolon.registries.Researches;
import elucent.eidolon.util.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static elucent.eidolon.codex.CodexChapters.*;

@Mod.EventBusSubscriber()
public class EOcodex {
    public static Category MAGE_HOLDERS;
    public static Index MAGE_HOLDERS_INDEX;
    public static Chapter ORIGINS;
    public static Chapter TIER_ONE;
    public static Chapter TIER_TWO;
    public static Chapter TIER_THREE;
    public static Chapter TIER_FOUR;
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
        };
        {
            ORIGINS = new CodexBuilder(level)
                    .title("eidolon_origins.codex.page.origins.title")
                    .titlePage("eidolon_origins.codex.page.origins")
                    .build();
        };
        {
            TIER_ONE = new CodexBuilder(level)
                    .title("eidolon_origins.codex.page.tier_one.title")
                    .titlePage("eidolon_origins.codex.page.tier_one")
                    .build();
        };
        {
        TIER_TWO = new CodexBuilder(level)
                .title("eidolon_origins.codex.page.tier_two.title")
                .titlePage("eidolon_origins.codex.page.tier_two")
                .build();
        };
        {
            TIER_THREE = new CodexBuilder(level)
                    .title("eidolon_origins.codex.page.tier_three.title")
                    .titlePage("eidolon_origins.codex.page.tier_three")
                    .build();
        };
        {
            TIER_FOUR = new CodexBuilder(level)
                    .title("eidolon_origins.codex.page.tier_four.title")
                    .titlePage("eidolon_origins.codex.page.tier_four")
                    .build();
        };

        MAGE_HOLDERS_INDEX = new Index(
                "eidolon.codex.category.mage_holders"
        );

        categories.add(MAGE_HOLDERS = new Category(
                "mage_holders",
                new ItemStack(Registry.IMBUED_BONES.get()),
                ColorUtil.packColor(255, 80, 200, 120),
                MAGE_HOLDERS_INDEX
        ));

    }
    @SubscribeEvent
    public static void OnCodexPostInitEvent (CodexEvents.PostInit init){
        CodexChapters.SIGNS_INDEX.addPage(
                new SignIndexPage(
                        new SignIndexPage.SignEntry(EOcodex.CHAOS_SIGN, EOsigns.CHAOS_SIGN))
        );
        EOcodex.MAGE_HOLDERS_INDEX.addPage(
                new TitledIndexPage("eidolon.codex.page.mage_holders",
                        new IndexPage.IndexEntry(ORIGINS, new ItemStack(Items.ENDER_EYE)),
                        new IndexPage.ResearchLockedEntry(TIER_ONE, new ItemStack(Registry.RESEARCH_NOTES.get()), EOresearches.LYCH_RESEARCH_ONE),
                        new IndexPage.ResearchLockedEntry(TIER_TWO, new ItemStack(Registry.RESEARCH_NOTES.get()), EOresearches.LYCH_RESEARCH_TWO),
                        new IndexPage.ResearchLockedEntry(TIER_THREE, new ItemStack(Registry.RESEARCH_NOTES.get()), EOresearches.LYCH_RESEARCH_THREE),
                        new IndexPage.ResearchLockedEntry(TIER_FOUR, new ItemStack(Registry.RESEARCH_NOTES.get()), EOresearches.LYCH_RESEARCH_FOUR)
                )
        );
    }
}