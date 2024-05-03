package cn.evole.mods.offhandbanning.event;

import cn.evole.mods.offhandbanning.Const;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.items.CapabilityItemHandler;

/**
 * ForgeBusEventHandler
 *
 * @author cnlimiter
 * @version 1.0
 * @description
 * @date 2024/5/3 下午11:13
 */
@Mod.EventBusSubscriber(modid = Const.MOD_ID)
public class ForgeBusEventHandler {
    @SubscribeEvent
    public static void onPlayerLoginIn(PlayerEvent.PlayerLoggedInEvent event){
        if (event.player instanceof EntityPlayerMP){
            EntityPlayerMP serverPlayer = (EntityPlayerMP) event.player;
        }
    }

}
