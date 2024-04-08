package io.rensatopc.github.rensato_whistle.register;

import io.rensatopc.github.rensato_whistle.main.WhistleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WhistleModSounds {
    public static final DeferredRegister<SoundEvent> MOD_SOUNDEVENTS = DeferredRegister.create(Registries.SOUND_EVENT, WhistleMod.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> WHISTLE_CLICK = registerSoundEvent("whistle_click");

    public static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
        return MOD_SOUNDEVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(WhistleMod.MOD_ID, name)));
    }
}
