package io.rensatopc.github.rensato_whistle.register;

import io.rensatopc.github.rensato_whistle.block.item.BlockItemWhistle;
import io.rensatopc.github.rensato_whistle.item.ItemWhistle;
import io.rensatopc.github.rensato_whistle.main.WhistleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WhistleModItems {

    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(Registries.ITEM, WhistleMod.MOD_ID);
    public static final DeferredHolder<Item, ItemWhistle> WHISTLE = MOD_ITEMS.register("whistle", ItemWhistle::new);
    public static final DeferredHolder<Item, BlockItemWhistle> WHISTLE_BLOCK = MOD_ITEMS.register("whistle_block", () -> new BlockItemWhistle(WhistleModBlocks.WHISTLE_BLOCK.get()));
}