package committee.nova.mods.offhandbanning.cmd;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import committee.nova.mods.offhandbanning.OffhandBanning;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * @Project: offhandbanning
 * @Author: cnlimiter
 * @CreateTime: 2024/9/30 00:15
 * @Description:
 */
public class ModCmd {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext commandBuildContext) {
        dispatcher.register(
                Commands.literal("offban")
                        .then(
                                Commands.literal("del")
                                        .then(Commands.argument("item", ItemArgument.item(commandBuildContext))
                                                .executes(ModCmd::del)
                                        )
                        )
                        .then(
                                Commands.literal("add")
                                        .then(Commands.argument("item", ItemArgument.item(commandBuildContext))
                                                .executes(ModCmd::add)
                                        )
                        )
                        .requires(context -> context.hasPermission(2))

        );

    }

    private static int del(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        var player = context.getSource().getPlayerOrException();
        var item = ItemArgument.getItem(context, "item");
        OffhandBanning.configHandler.config.removeBanItems(BuiltInRegistries.ITEM.getKey(item.getItem()).toString());
        OffhandBanning.configHandler.save();
        player.sendSystemMessage(Component.literal("成功移除！"));
        return 1;
    }

    private static int add(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        var player = context.getSource().getPlayerOrException();
        var item = ItemArgument.getItem(context, "item");
        OffhandBanning.configHandler.config.addBanItems(BuiltInRegistries.ITEM.getKey(item.getItem()).toString());
        OffhandBanning.configHandler.save();
        player.sendSystemMessage(Component.literal("成功添加！"));
        return 1;
    }

}
