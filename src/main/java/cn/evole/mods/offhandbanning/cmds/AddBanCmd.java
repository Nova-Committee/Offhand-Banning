package cn.evole.mods.offhandbanning.cmds;

import cn.evole.mods.offhandbanning.Const;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nonnull;

/**
 * AddBanCmd
 *
 * @author cnlimiter
 * @version 1.0
 * @description
 * @date 2024/5/3 下午11:00
 */
public class AddBanCmd extends CommandBase {

    @Override
    @Nonnull
    public String getName() {
        return "addOffBan";
    }

    @Override
    @Nonnull
    public String getUsage(@Nonnull ICommandSender sender) {
        return "/addOffBan";
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args) throws CommandException {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender;
            ResourceLocation resourcelocation = new ResourceLocation(args[0]);
            Item item = ForgeRegistries.ITEMS.getValue(resourcelocation);

            if (item == null) {
                throw new NumberInvalidException("commands.give.item.notFound", resourcelocation);
            } else {
                Const.configHandler.config.addBanItems(args[0]);
                Const.configHandler.save();
                player.connection.sendPacket(new SPacketChat(new TextComponentString("成功添加！"), ChatType.SYSTEM));
            }
        }
    }
}
