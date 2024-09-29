package committee.nova.mods.offhandbanning.core;


import committee.nova.mods.offhandbanning.OffhandBanning;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * ModSlot
 *
 * @author cnlimiter
 * @version 1.0
 * @description
 * @date 2024/5/3 下午10:13
 */
public class ModSlot extends Slot {
    public ModSlot(Container inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        for (String item : OffhandBanning.configHandler.config.getItems()){
            if (itemStack.getItem().equals(BuiltInRegistries.ITEM.get(new ResourceLocation(item)))){
                return false;
            }
        }
        return super.mayPlace(itemStack);
    }

}
