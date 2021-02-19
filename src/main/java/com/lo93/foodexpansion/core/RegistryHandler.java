package com.lo93.foodexpansion.core;

import com.lo93.foodexpansion.core.init.items.ModItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event){
		IForgeRegistry<Item> registry = event.getRegistry();
		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.TOOLKNIFE);
		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.TOOLMORTARPESTAL);
		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.WHOLEFLOUR);
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event){
		ModItems.TOOLKNIFE.RegisterItemModel(new ModelResourceLocation(FoodExpansionCore.MODID + ":" +"tool_knife" ,"inventory"));
		ModItems.TOOLMORTARPESTAL.RegisterItemModel(new ModelResourceLocation(FoodExpansionCore.MODID + ":" +"tool_mortar_pestal" ,"inventory"));
		ModItems.WHOLEFLOUR.RegisterItemModel(new ModelResourceLocation(FoodExpansionCore.MODID + ":" +"tool_whole_flour" ,"inventory"));
	}
}
