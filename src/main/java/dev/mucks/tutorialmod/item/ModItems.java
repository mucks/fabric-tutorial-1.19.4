package dev.mucks.tutorialmod.item;

import dev.mucks.tutorialmod.TutorialMod;
import dev.mucks.tutorialmod.block.ModBlocks;
import dev.mucks.tutorialmod.entity.ModEntities;
import dev.mucks.tutorialmod.entity.client.TigerRenderer;
import dev.mucks.tutorialmod.item.custom.AnimatedBlockItem;
import dev.mucks.tutorialmod.item.custom.AnimatedItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CITRINE = registerItem("citrine", new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registerItem("raw_citrine", new Item(new FabricItemSettings()));

    public static final Item TIGER_SPAWN_EGG = registerItem("tiger_spawn_egg",
            new SpawnEggItem(ModEntities.TIGER, 0xD57E36, 0x1D0D00, new FabricItemSettings()));

    public static final Item ANIMATED_ITEM = registerItem("animated_item", new AnimatedItem(new FabricItemSettings()));
    public static final Item ANIMATED_BLOCK_ITEM = registerItem("animated_block",
            new AnimatedBlockItem(ModBlocks.ANIMATED_BLOCK, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, CITRINE);
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_CITRINE);

        addToItemGroup(ModItemGroup.CITRINE, CITRINE);
        addToItemGroup(ModItemGroup.CITRINE, RAW_CITRINE);
        addToItemGroup(ModItemGroup.CITRINE, TIGER_SPAWN_EGG);
        addToItemGroup(ModItemGroup.CITRINE, ANIMATED_ITEM);
        addToItemGroup(ModItemGroup.CITRINE, ANIMATED_BLOCK_ITEM);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        addItemsToItemGroup();
    }

}
