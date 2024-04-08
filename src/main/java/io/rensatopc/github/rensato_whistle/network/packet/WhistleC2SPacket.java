package io.rensatopc.github.rensato_whistle.network.packet;

import io.rensatopc.github.rensato_whistle.item.ItemWhistle;
import io.rensatopc.github.rensato_whistle.main.WhistleMod;
import io.rensatopc.github.rensato_whistle.register.WhistleModItems;
import io.rensatopc.github.rensato_whistle.util.Whistle;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

import java.util.Set;

public record WhistleC2SPacket() implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(WhistleMod.MOD_ID, "whistle");

    public WhistleC2SPacket(FriendlyByteBuf buf) {
        this();
    }

    @Override
    public void write(FriendlyByteBuf buf) {

    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    public static void handle(final WhistleC2SPacket packet, final PlayPayloadContext context) {
        context.workHandler().submitAsync(() -> {
            Player player = context.player().get();
            Level level = context.level().get();

            ItemWhistle whistle =WhistleModItems.WHISTLE.get();

            Inventory inventory = player.getInventory();
            if (inventory.hasAnyOf(Set.of(WhistleModItems.WHISTLE.get()))) {
                if (!player.getCooldowns().isOnCooldown(whistle)) {
                    Whistle.use(level, player, whistle);
                }
            }
        });
    }
}
