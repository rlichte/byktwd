package com.walmart.minecraft.mod.item.items;

import com.walmart.minecraft.mod.item.util.Strings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SparkItems
{
    public static Item spark;
    
    public static void init()
    {
        spark = new Item();
        spark.setUnlocalizedName("spark");
        spark.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    public static void register()
    {
        GameRegistry.registerItem(spark, spark.getUnlocalizedName().substring(5));
    }
    
    public static void registerRenders()
    {
        registerRender(spark);
    }
    
    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
                                 register(item, 0, new ModelResourceLocation(Strings.MOD_ID + 
                                                                             ":" + 
                                                                             item.getUnlocalizedName().substring(5),
                                                                             "inventory"));
    }

}
