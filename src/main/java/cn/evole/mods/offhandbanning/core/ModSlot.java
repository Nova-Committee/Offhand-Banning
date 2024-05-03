package cn.evole.mods.offhandbanning.core;

import cn.evole.mods.offhandbanning.Const;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * ModSlot
 *
 * @author cnlimiter
 * @version 1.0
 * @description
 * @date 2024/5/3 下午10:13
 */
public class ModSlot extends Slot {
    public ModSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        for (String item : Const.configHandler.config.getItems()){
            if (stack.getItem().equals(ForgeRegistries.ITEMS.getValue(new ResourceLocation(item)))){
                return false;
            }
        }
        return super.isItemValid(stack);
    }

    @Nullable
    @SideOnly(Side.CLIENT)
    public String getSlotTexture()
    {
        return "minecraft:items/empty_armor_slot_shield";
    }
}
