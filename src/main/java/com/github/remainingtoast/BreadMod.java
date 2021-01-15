package com.github.remainingtoast;

import com.github.remainingtoast.armor.BreadArmorItem;
import com.github.remainingtoast.armor.BreadArmourMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BreadMod implements ModInitializer {

	public static String modVersion = FabricLoader.getInstance().getModContainer("breadmod").get().getMetadata().getVersion().toString();

	private static final ItemGroup BREAD_GROUP = new ItemGroup(4, "bread") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Items.BREAD);
		}
	};

	public static final Item BREAD_HELMET = new BreadArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.HEAD, new Item.Settings().group(BREAD_GROUP));
	public static final Item BREAD_CHEST = new BreadArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.CHEST, new Item.Settings().group(BREAD_GROUP));
	public static final Item BREAD_LEGS = new BreadArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.LEGS, new Item.Settings().group(BREAD_GROUP));
	public static final Item BREAD_BOOTS = new BreadArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.FEET, new Item.Settings().group(BREAD_GROUP));

	public static final Item TOAST = new Item(new Item.Settings().group(BREAD_GROUP).maxCount(64).food(new FoodComponent.Builder().hunger(5).saturationModifier(1.3F).build()));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_helmet"), BREAD_HELMET);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_chestplate"), BREAD_CHEST);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_leggings"), BREAD_LEGS);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_boots"), BREAD_BOOTS);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "toast"), TOAST);

		System.out.println("Hello Bread World! Using version " + modVersion);
	}
}
