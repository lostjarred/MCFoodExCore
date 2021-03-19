package com.lo93.foodexpansion.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lo93.foodexpansion.core.init.items.ModItems;
import com.lo93.locore.init.registry.ItemRegistry;
import com.lo93.locore.proxy.CommonProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(modid = FoodExpansionCore.MODID, name = FoodExpansionCore.NAME, version = FoodExpansionCore.VERSION)
public class FoodExpansionCore {
	
	@SidedProxy(serverSide = "com.lo93.locore.proxy.CommonProxy", clientSide = "com.lo93.locore.proxy.ClientProxy")
	public static CommonProxy Proxy;
	
	public static final String MODID = "foodexpansioncore";
    public static final String NAME = "Food Expansion Core";
    public static final String VERSION = "1.0";
    
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
    public static final ItemRegistry itemregistry = new ItemRegistry(LOGGER);
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	LOGGER.info(NAME + " Is loading");
    }
    
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> event){
    		IForgeRegistry<Item> registry = event.getRegistry();
    		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.TOOL_KNIFE);
    		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.TOOL_MORTARPESTAL);
    		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.ITEM_WHOLEFLOUR);
    		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.TOOL_BAKINGTRAY);
    	}
    	
    	@SubscribeEvent
    	public static void registerModels(ModelRegistryEvent event){
    		ModItems.TOOL_KNIFE.RegisterItemModel(new ModelResourceLocation(FoodExpansionCore.MODID + ":" +"tool_knife" ,"inventory"));
    		ModItems.TOOL_MORTARPESTAL.RegisterItemModel(new ModelResourceLocation(FoodExpansionCore.MODID + ":" +"tool_mortar_pestal" ,"inventory"));
    		ModItems.ITEM_WHOLEFLOUR.RegisterItemModel(new ModelResourceLocation(FoodExpansionCore.MODID + ":" +"tool_whole_flour" ,"inventory"));
    		ModItems.TOOL_BAKINGTRAY.RegisterItemModel(new ModelResourceLocation(FoodExpansionCore.MODID + ":" +"tool_bakingtray" ,"inventory"));
    	}
    }
    
}


