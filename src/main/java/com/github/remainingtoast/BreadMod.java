package com.github.remainingtoast;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BreadMod implements ModInitializer {

	public static final Item BREAD_HELMET = new Item(new Item.Settings().group(ItemGroup.COMBAT).maxCount(1));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("breadmod", "bread_helmet"), BREAD_HELMET);

		System.out.println("Hello Bread World!");
	}
}
