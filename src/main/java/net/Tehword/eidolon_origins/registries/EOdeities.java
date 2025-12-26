package net.Tehword.eidolon_origins.registries;

import elucent.eidolon.api.deity.Deity;
import elucent.eidolon.common.deity.DarkDeity;
import elucent.eidolon.common.deity.LightDeity;
import net.Tehword.eidolon_origins.Eidolon_origins;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class EOdeities {
static final Map<ResourceLocation, Deity> deities = new HashMap();
    public static final ResourceLocation DARK_LIGHT_ID = new ResourceLocation(Eidolon_origins.MODID, "dark_light");
    public static final Deity DARK_LIGHT;

    public EOdeities() {
    }

    public static Deity register(Deity deity) {
        deities.put(deity.getId(), deity);
        return deity;
    }


    static {
        DARK_LIGHT = register(new LightDeity(DARK_LIGHT_ID, 199, 0, 40));
    }
}
