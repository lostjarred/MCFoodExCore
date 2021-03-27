package com.lo93.foodexpansion.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lo93.foodexpansion.core.init.items.ModItems;
import com.lo93.locore.init.registry.ItemRegistry;
import com.lo93.locore.proxy.CommonProxy;
import com.lo93.locore.utils.logger.HelperLoggerMessages;
import com.lo93.locore.utils.resourcelocation.HelperResourceLocation;

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
    public static final HelperResourceLocation RESOURCEHELPER = new HelperResourceLocation(MODID);
    public static final HelperLoggerMessages LOGGERHELPER = new HelperLoggerMessages(LOGGER, MODID);
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	LOGGER.info(NAME + " Is loading");
    }
    
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> event){
    		LOGGERHELPER.logMsgRegItemstart();
    		IForgeRegistry<Item> registry = event.getRegistry();
    		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.TOOL_KNIFE);
    		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.TOOL_MORTARPESTAL);
    		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.ITEM_WHOLEFLOUR);
    		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.TOOL_BAKINGTRAY);
    		FoodExpansionCore.itemregistry.RegisterItem(registry, ModItems.ITEM_DOUGHBALLBASIC);
    		LOGGERHELPER.logMsgRegItemend();
    	}
    	
    	@SubscribeEvent
    	public static void registerModels(ModelRegistryEvent event){
    		LOGGERHELPER.logMsgRegModelstart();
    		ModItems.TOOL_KNIFE.RegisterItemModel(RESOURCEHELPER.genModelResourcelocation("tool_knife"));
    		ModItems.TOOL_MORTARPESTAL.RegisterItemModel(RESOURCEHELPER.genModelResourcelocation("tool_mortar_pestal"));
    		ModItems.ITEM_WHOLEFLOUR.RegisterItemModel(RESOURCEHELPER.genModelResourcelocation("tool_whole_flour"));
    		ModItems.TOOL_BAKINGTRAY.RegisterItemModel(RESOURCEHELPER.genModelResourcelocation("tool_bakingtray"));
    		ModItems.ITEM_DOUGHBALLBASIC.RegisterItemModel(RESOURCEHELPER.genModelResourcelocation("item_doughballbasic"));
    		LOGGERHELPER.logMsgRegModelend();
    	}
    }
    
}


