package committee.nova.mods.offhandbanning.mixin;

import committee.nova.mods.offhandbanning.core.ModSlot;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
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
@Mixin(InventoryMenu.class)
public class InventoryMenuMixin {
    @Unique
    private Container offhandBanning$playerInventory;

    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/inventory/Slot;<init>(Lnet/minecraft/world/Container;III)V",
                    ordinal = 2
            )
    )
    private Container offhandbanning$init1(Container inventoryIn) {
        this.offhandBanning$playerInventory = inventoryIn;
        return inventoryIn;
    }


    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/inventory/InventoryMenu;addSlot(Lnet/minecraft/world/inventory/Slot;)Lnet/minecraft/world/inventory/Slot;",
                    ordinal = 5

            )
    )
    public Slot offhandbanning$init2(Slot par1){
        return new ModSlot(offhandBanning$playerInventory, 40, 77, 62);
    }
}