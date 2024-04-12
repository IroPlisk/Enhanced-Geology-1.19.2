package com.example.enhancedgeology.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnhancedGeologySoundEvents{
    private static final DeferredRegister<SoundEvent> SOUND_EVENTS;
    public static final RegistryObject<SoundEvent> TRAPANO_BENZA_START;
    public static final RegistryObject<SoundEvent> TRAPANO_BENZA_SCARICO;

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> {
            return new SoundEvent(new ResourceLocation("enhancedgeology", name));
        });
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

    static {
        SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "enhancedgeology");
        TRAPANO_BENZA_START = registerSoundEvent("trapano_benza_start");
        TRAPANO_BENZA_SCARICO = registerSoundEvent("trapano_benza_scarico");
    }
}
