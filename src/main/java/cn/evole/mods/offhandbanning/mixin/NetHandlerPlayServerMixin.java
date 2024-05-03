package cn.evole.mods.offhandbanning.mixin;

import cn.evole.mods.offhandbanning.Const;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * NetHandlerPlayServerMixin
 *
 * @author cnlimiter
 * @version 1.0
 * @description
 * @date 2024/5/3 下午8:21
 */
@Mixin(NetHandlerPlayServer.class)
public class NetHandlerPlayServerMixin {

    @Shadow public EntityPlayerMP player;

    @Inject(
            method = "processPlayerDigging",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/EntityPlayerMP;getHeldItem(Lnet/minecraft/util/EnumHand;)Lnet/minecraft/item/ItemStack;",
                    opcode = 0,
                    shift = At.Shift.BEFORE
            ),
            cancellable = true
    )
    public void offhandbanning$processPlayerDigging(CPacketPlayerDigging packetIn, CallbackInfo ci) {
        for (String item : Const.configHandler.config.getItems()){
            if (this.player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(ForgeRegistries.ITEMS.getValue(new ResourceLocation(item)))){
                ci.cancel();
            }
        }
    }
}
