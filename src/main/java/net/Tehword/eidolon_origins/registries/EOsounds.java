package net.Tehword.eidolon_origins.registries;

import net.Tehword.eidolon_origins.Eidolon_origins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EOsounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Eidolon_origins.MODID);

    public static final RegistryObject<SoundEvent> LYCH_ONE = registerSoundEvents("lych_sound_one");
    public static final RegistryObject<SoundEvent> LYCH_TWO = registerSoundEvents("lych_sound_two");
    public static final RegistryObject<SoundEvent> LYCH_THREE = registerSoundEvents("lych_sound_three");
    public static final RegistryObject<SoundEvent> LYCH_FOUR = registerSoundEvents("lych_sound_four");
    public static final RegistryObject<SoundEvent> LYCH_FIVE = registerSoundEvents("lych_sound_five");
    public static final RegistryObject<SoundEvent> LYCH_SIX = registerSoundEvents("lych_sound_six");
    public static final RegistryObject<SoundEvent> LYCH_HURT = registerSoundEvents("lych_sound_hurt");
    public static final RegistryObject<SoundEvent> LYCH_DEATH = registerSoundEvents("lych_sound_death");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Eidolon_origins.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}