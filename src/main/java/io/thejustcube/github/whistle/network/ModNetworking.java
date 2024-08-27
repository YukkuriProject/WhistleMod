package io.thejustcube.github.whistle.network;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModNetworking {
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");

        registrar.playBidirectional(WhistlingPacket.TYPE, WhistlingPacket.STREAM_CODEC, WhistlingPacket::handle);
    }
}
