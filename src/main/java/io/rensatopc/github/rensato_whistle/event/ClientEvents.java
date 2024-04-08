package io.rensatopc.github.rensato_whistle.event;

import io.netty.buffer.ByteBuf;
import io.rensatopc.github.rensato_whistle.client.KeyBinds;
import io.rensatopc.github.rensato_whistle.main.WhistleMod;
import io.rensatopc.github.rensato_whistle.network.packet.WhistleC2SPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = WhistleMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinds.WHISTLING_KEY.consumeClick()) {
                if (Minecraft.getInstance().player != null) {
                    PacketDistributor.SERVER.noArg().send(new WhistleC2SPacket());
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = WhistleMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinds.WHISTLING_KEY);
        }
    }
}
