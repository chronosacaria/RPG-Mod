package net.LiorNadav.rpgmod.block;

import net.LiorNadav.rpgmod.RPGMod;
import net.LiorNadav.rpgmod.block.custom.KJPortalBlock;
import net.LiorNadav.rpgmod.item.ModCreativeModeTab;
import net.LiorNadav.rpgmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RPGMod.MOD_ID);

    public static final RegistryObject<Block> AZURITE_ORE = registerBlock("azurite_ore",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.RPG_MOD_ITEMS);

    public static final RegistryObject<Block> ADAMANTITE_ORE = registerBlock("adamantite_ore",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.RPG_MOD_ITEMS);

    public static final RegistryObject<Block> JADEITE_ORE = registerBlock("jadeite_ore",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.RPG_MOD_ITEMS);

    public static final RegistryObject<Block> KAUPEN_PORTAL = registerBlockWithoutBlockItem("kaupen_portal",
            KJPortalBlock::new);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
}
