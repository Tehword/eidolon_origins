package net.Tehword.eidolon_origins.registries;

import elucent.eidolon.api.research.Research;
import net.Tehword.eidolon_origins.Eidolon_origins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;

import static elucent.eidolon.registries.Researches.register;

public class EOresearches  {

    public static final Research
            LYCH_RESEARCH_ONE = register(new Research(new ResourceLocation(Eidolon_origins.MODID, "lych_research_one"), 3), EntityType.PIG),
            LYCH_RESEARCH_TWO = register(new Research(new ResourceLocation(Eidolon_origins.MODID, "lych_research_two"), 3), EntityType.PIG),
            LYCH_RESEARCH_THREE = register(new Research(new ResourceLocation(Eidolon_origins.MODID, "lych_research_three"), 3), EntityType.PIG),
            LYCH_RESEARCH_FOUR = register(new Research(new ResourceLocation(Eidolon_origins.MODID, "lych_research_four"), 3), EntityType.PIG);


    public static void init() {}
}
