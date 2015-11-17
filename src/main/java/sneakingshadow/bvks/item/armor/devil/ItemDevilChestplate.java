package sneakingshadow.bvks.item.armor.devil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.util.LogHelper;

import java.util.List;

public class ItemDevilChestplate extends ItemBVKSArmor
{
    public ItemDevilChestplate()
    {
        super(Names.ArmorTextures.DEVIL, Armor.Material.DEVIL, Armor.Type.CHESTPLATE);
        this.setUnlocalizedName(Names.Items.DEVIL_CHESTPLATE);
        this.setInvisible();
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.fallDistance = 0F;
        player.capabilities.allowFlying = true;
    }

    @SideOnly(Side.CLIENT)
    public static void addInformation(List list){
        list.add("Also called the opposite-hello-kitty armor");
    }
}