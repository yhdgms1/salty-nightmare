package org.saltynightmare.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import org.saltynightmare.blocks.*;
import org.saltynightmare.SaltyNightmare;

public class BlockRegister {
    public static final Block SALT_BLOCK = new SaltBlock(new ColorCode(13356278), AbstractBlock.Settings.create().instrument(NoteBlockInstrument.SNARE).sounds(BlockSoundGroup.SAND).mapColor(MapColor.WHITE_GRAY).strength(0.5F));

    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, SaltyNightmare.id("salt_block"), SALT_BLOCK);
    }
}
