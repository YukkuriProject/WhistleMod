package io.rensatopc.github.rensato_whistle.network;

import io.rensatopc.github.rensato_whistle.main.WhistleMod;
import io.rensatopc.github.rensato_whistle.network.packet.WhistleC2SPacket;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

public class ModNetworking {
    public static void register(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar(WhistleMod.MOD_ID);

        registrar.play(WhistleC2SPacket.ID,
                WhistleC2SPacket::new,
                handler -> handler.server(WhistleC2SPacket::handle));
    }
}
