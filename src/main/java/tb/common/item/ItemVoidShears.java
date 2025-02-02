package tb.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import thaumcraft.api.IRepairable;
import thaumcraft.api.IWarpingGear;

public class ItemVoidShears extends ItemShears implements IRepairable, IWarpingGear {

    public EnumRarity getRarity(ItemStack itemstack) {
        return EnumRarity.uncommon;
    }

    public void onUpdate(ItemStack stk, World w, Entity entity, int slot, boolean held) {
        super.onUpdate(stk, w, entity, slot, held);
        if ((stk.isItemDamaged()) && (entity != null)
                && (entity.ticksExisted % 20 == 0)
                && ((entity instanceof EntityLivingBase)))
            stk.damageItem(-1, (EntityLivingBase) entity);
    }

    public int getWarp(ItemStack itemstack, EntityPlayer player) {
        return 1;
    }
}
