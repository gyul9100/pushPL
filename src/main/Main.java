package main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("PushPL is Activated");
    }

    @Override
    public void onDisable() {
        System.out.println("PushPL is DisActivated");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof  Player) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("p")) {

                if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + "Type the command to execute.");
                } else if (args[0].equalsIgnoreCase("info")) {
                    sender.sendMessage(ChatColor.YELLOW + "Push for CmdBlock.Made by Gyul");
                } else if (isDouble(args[0])) {
                    if(args.length == 1) {
                        Vector unitVector = new Vector(player.getLocation().getDirection().getX(), player.getLocation().getDirection().getY(), player.getLocation().getDirection().getZ());
                        unitVector = unitVector.normalize();
                        player.setVelocity(unitVector.multiply(2));
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Invalid Command.");
                }


            }
        }
        return true;
    }

    boolean isDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException ex)
        {
            return false;
        }
    }
}