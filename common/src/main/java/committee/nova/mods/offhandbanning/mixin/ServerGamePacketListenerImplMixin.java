package committee.nova.mods.offhandbanning.mixin;


import committee.nova.mods.offhandbanning.OffhandBanning;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.InteractionHand;
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
@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {

    @Shadow public ServerPlayer player;

    @Inject(
            method = "handlePlayerAction",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ServerPlayer;getItemInHand(Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/item/ItemStack;",
                    ordinal = 0,
                    shift = At.Shift.AFTER
            ),
            cancellable = true
    )
    public void offhandbanning$processPlayerDigging(ServerboundPlayerActionPacket serverboundPlayerActionPacket, CallbackInfo ci) {
        for (String item : OffhandBanning.configHandler.config.getItems()){
            if (this.player.getItemInHand(InteractionHand.MAIN_HAND).getItem().equals(BuiltInRegistries.ITEM.get(new ResourceLocation(item)))){
                ci.cancel();
            }
        }
    }
}
