package com.walmart.minecraft.mod.item.items;

import com.walmart.minecraft.mod.examples.EnderBlock;
import com.walmart.minecraft.mod.examples.EnderIngot;
import com.walmart.minecraft.mod.item.util.Strings;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SparkItems
{
    public static Item spark;
    public static Block enderBlock;
    public static Item enderIngot;
    
    public static void init()
    {
        spark = new Item();
        spark.setUnlocalizedName("spark");
        spark.setCreativeTab(CreativeTabs.tabMaterials);
        enderBlock = new EnderBlock();
        
    }
    
    public static void register()
    {
        GameRegistry.registerItem(spark, spark.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(enderBlock, "enderBlock");
        
        
    }
    
    public static void registerRenders()
    {
        registerRender(spark);
    }
    
    public static void registerRender(Item item)
    {
        Item enderBlockItem = GameRegistry.findItem("wmt", "enderBlock");
        ModelResourceLocation enderBlockModel = new ModelResourceLocation(
                "wmt:enderBlock", "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(enderBlockItem, 0, enderBlockModel);
        
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(enderBlockItem, 0, enderBlockModel);

        enderIngot = new EnderIngot();
        GameRegistry.registerItem(enderIngot, "enderIngot");
        Item enderIngotItem = GameRegistry.findItem("wmt", "enderIngot");
        
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
                                 register(item, 0, new ModelResourceLocation(Strings.MOD_ID + 
                                                                             ":" + 
                                                                             item.getUnlocalizedName().substring(5),
                                                                             "inventory"));
        
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(enderBlockItem, 0, enderBlockModel);
        ModelResourceLocation enderIngotModel = new ModelResourceLocation(
                "wmt:enderIngot", "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(enderIngot, 0, enderIngotModel);
        
        GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone), "dd", "dd",
                'd', Blocks.dirt);

        GameRegistry.addRecipe(new ItemStack(enderBlock), "iii", "iii", "iii",
                'i', enderIngot);

        GameRegistry.addRecipe(new ItemStack(enderBlock), "e e", " o ", "e e",
                'o', Blocks.obsidian, 'e', Items.ender_eye);

        GameRegistry.addShapelessRecipe(new ItemStack(enderIngot, 9),
                new ItemStack(enderBlock));

        GameRegistry.addShapelessRecipe(new ItemStack(enderIngot, 12),
                new ItemStack(enderBlock, 1), new ItemStack(Items.iron_ingot),
                new ItemStack(Items.gold_ingot));

        GameRegistry.addSmelting(Items.ender_pearl,
                new ItemStack(enderIngot, 1), 1.0F);

        Items.cake.setPotionEffect(PotionHelper.blazePowderEffect);
    }

}
