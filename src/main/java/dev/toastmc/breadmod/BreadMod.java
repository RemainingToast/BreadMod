package dev.toastmc.breadmod;

import dev.toastmc.breadmod.armor.BreadArmorItem;
import dev.toastmc.breadmod.armor.BreadArmourMaterial;
import dev.toastmc.breadmod.block.BreadBlock;
import dev.toastmc.breadmod.item.BreadPickaxeItem;
import dev.toastmc.breadmod.item.BreadToolMaterials;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BreadMod implements ModInitializer {

	public static String modVersion = FabricLoader.getInstance().getModContainer("breadmod").get().getMetadata().getVersion().toString();

	private static final ItemGroup BREAD_GROUP = new ItemGroup(8, "bread") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Items.BREAD);
		}
	};

	public static final Item BREAD_HELMET = new BreadArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.HEAD, new Item.Settings().group(BREAD_GROUP));
	public static final Item BREAD_CHEST = new BreadArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.CHEST, new Item.Settings().group(BREAD_GROUP));
	public static final Item BREAD_LEGS = new BreadArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.LEGS, new Item.Settings().group(BREAD_GROUP));
	public static final Item BREAD_BOOTS = new BreadArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.FEET, new Item.Settings().group(BREAD_GROUP));

	public static final Block BREAD_BLOCK = new BreadBlock(FabricBlockSettings.copyOf(Blocks.HAY_BLOCK));
	public static final Item BREAD_BLOCK_ITEM = new BlockItem(BREAD_BLOCK, new Item.Settings().group(BREAD_GROUP));

	public static final Item BREAD_PICKAXE = new BreadPickaxeItem(BreadToolMaterials.BREAD, 2, -2.8F, new Item.Settings().group(BREAD_GROUP));

	public static final Item TOAST = new Item(new Item.Settings().group(BREAD_GROUP).maxCount(64).food(new FoodComponent.Builder().hunger(5).saturationModifier(1.3F).build()));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_helmet"), BREAD_HELMET);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_chestplate"), BREAD_CHEST);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_leggings"), BREAD_LEGS);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_boots"), BREAD_BOOTS);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "toast"), TOAST);
		Registry.register(Registry.BLOCK, new Identifier("breadmod", "bread_block"), BREAD_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_block"), BREAD_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_pickaxe"), BREAD_PICKAXE);

		System.out.println("Hello Bread World! Using version " + modVersion);
	}
}
