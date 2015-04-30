package com.sneakingshadow.bvks.item.tool.hammer;

import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;
import net.minecraft.init.Items;

public class ItemStoneHammer extends ItemBVKSHammer
{
    public ItemStoneHammer()
    {
        super(ItemToolMaterial.StoneHammer, 2,2,2, Items.stone_shovel);
        this.setUnlocalizedName(Names.Items.StoneHammer);
    }
}