package com.github.remainingtoast;

import com.github.remainingtoast.armor.BreadArmourMaterial;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BreadMod implements ModInitializer {

	private static final ItemGroup BREAD_GROUP = new ItemGroup(4, "bread") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Items.BREAD);
		}
	};

	public static final Item BREAD_HELMET = new ArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.HEAD, new Item.Settings().group(BREAD_GROUP));
	public static final Item BREAD_CHEST = new ArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.CHEST, new Item.Settings().group(BREAD_GROUP));
	public static final Item BREAD_LEGS = new ArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.LEGS, new Item.Settings().group(BREAD_GROUP));
	public static final Item BREAD_BOOTS = new ArmorItem(BreadArmourMaterial.BREAD, EquipmentSlot.FEET, new Item.Settings().group(BREAD_GROUP));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_helmet"), BREAD_HELMET);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_chest"), BREAD_CHEST);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_legs"), BREAD_LEGS);
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_boots"), BREAD_BOOTS);

		System.out.println("Hello Bread World!");
	}
}
