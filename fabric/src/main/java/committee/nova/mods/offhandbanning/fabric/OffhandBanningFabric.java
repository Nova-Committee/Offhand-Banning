package committee.nova.mods.offhandbanning.fabric;

import committee.nova.mods.offhandbanning.cmd.ModCmd;
import net.fabricmc.api.ModInitializer;

import committee.nova.mods.offhandbanning.OffhandBanning;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public final class OffhandBanningFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        OffhandBanning.init();
        CommandRegistrationCallback.EVENT.register((commandDispatcher, commandBuildContext, commandSelection) -> ModCmd.register(commandDispatcher, commandBuildContext));
    }
}
