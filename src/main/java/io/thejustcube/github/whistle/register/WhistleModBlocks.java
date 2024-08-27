package io.thejustcube.github.whistle.register;

import io.thejustcube.github.whistle.block.BlockWhistle;
import io.thejustcube.github.whistle.main.WhistleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WhistleModBlocks {
    public static final DeferredRegister<Block> MOD_BLOCKS = DeferredRegister.create(Registries.BLOCK, WhistleMod.MOD_ID);

    public static final DeferredHolder<Block, BlockWhistle> WHISTLE_BLOCK = MOD_BLOCKS.register("whistle_block", BlockWhistle::new);
}
