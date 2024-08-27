package io.thejustcube.github.whistle.network;

import io.thejustcube.github.whistle.item.ItemWhistle;
import io.thejustcube.github.whistle.main.WhistleMod;
import io.thejustcube.github.whistle.register.WhistleModItems;
import io.thejustcube.github.whistle.util.Whistle;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.Set;

public record WhistlingPacket() implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<WhistlingPacket> TYPE = new Type<>(new ResourceLocation(WhistleMod.MOD_ID, "whistling"));

    public static final StreamCodec<FriendlyByteBuf, WhistlingPacket> STREAM_CODEC = StreamCodec.ofMember(WhistlingPacket::encode, WhistlingPacket::new);

    public WhistlingPacket(FriendlyByteBuf buf) {
        this();
    }

    public void encode(FriendlyByteBuf buf) {}

    public static void handle(final WhistlingPacket packet, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            Level level = context.player().level();

            ItemWhistle whistle =WhistleModItems.WHISTLE.get();

            Inventory inventory = player.getInventory();
            if (inventory.hasAnyOf(Set.of(WhistleModItems.WHISTLE.get()))) {
                if (!player.getCooldowns().isOnCooldown(whistle)) {
                    Whistle.use(level, player, whistle);
                }
            }
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
