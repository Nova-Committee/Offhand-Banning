package committee.nova.mods.offhandbanning.forge;

import committee.nova.mods.offhandbanning.cmd.ModCmd;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import committee.nova.mods.offhandbanning.OffhandBanning;

@Mod(OffhandBanning.MOD_ID)
public final class OffhandBanningForge {
    public OffhandBanningForge() {
        // Run our common setup.
        OffhandBanning.init();
        MinecraftForge.EVENT_BUS.addListener(OffhandBanningForge::cmdRegister);
    }

    public static void cmdRegister(RegisterCommandsEvent event) {
        ModCmd.register(event.getDispatcher(), event.getBuildContext());
    }
}
