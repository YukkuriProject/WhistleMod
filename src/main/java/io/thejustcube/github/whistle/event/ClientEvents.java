package io.thejustcube.github.whistle.event;

import io.thejustcube.github.whistle.client.KeyBinds;
import io.thejustcube.github.whistle.main.WhistleMod;
import io.thejustcube.github.whistle.network.WhistlingPacket;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public class ClientEvents {
    @EventBusSubscriber(modid = WhistleMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinds.WHISTLING_KEY.consumeClick()) {
                if (Minecraft.getInstance().player != null) {
                    PacketDistributor.sendToServer(new WhistlingPacket());
                }
            }
        }
    }

    @EventBusSubscriber(modid = WhistleMod.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinds.WHISTLING_KEY);
        }
    }
}
