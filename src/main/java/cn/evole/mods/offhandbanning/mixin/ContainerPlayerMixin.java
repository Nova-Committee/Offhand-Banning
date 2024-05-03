package cn.evole.mods.offhandbanning.mixin;

import cn.evole.mods.offhandbanning.core.ModSlot;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;

/**
 * ContainerSlotMixin
 *
 * @author cnlimiter
 * @version 1.0
 * @description
 * @date 2024/5/3 下午10:15
 */
@Mixin(ContainerPlayer.class)
public class ContainerPlayerMixin {
    @Unique
    private IInventory offhandBanning$playerInventory;

    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/inventory/Slot;<init>(Lnet/minecraft/inventory/IInventory;III)V",
                    ordinal = 2
            )
    )
    private IInventory offhandbanning$init1(IInventory inventoryIn) {
        this.offhandBanning$playerInventory = inventoryIn;
        return inventoryIn;
    }


    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/inventory/ContainerPlayer;addSlotToContainer(Lnet/minecraft/inventory/Slot;)Lnet/minecraft/inventory/Slot;",
                    ordinal = 5

            )
    )
    public Slot offhandbanning$init2(Slot par1){
        return new ModSlot(offhandBanning$playerInventory, 40, 77, 62);
    }
}