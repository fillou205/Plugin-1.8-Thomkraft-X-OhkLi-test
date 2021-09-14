package fr.thomkraftXphilou.pluginmc.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player)sender;

            if(cmd.getName().equalsIgnoreCase("test")){
                player.sendMessage("§cbravo tu a réussi §9le test");
                return true;
            }

            if(cmd.getName().equalsIgnoreCase("alert")) {

                if(args.length == 0) {
                    player.sendMessage("la commande est : /alert <message>");
                }

                if(args.length >= 1) {

                    StringBuilder bc = new StringBuilder();
                    for(String part : args) {
                        bc.append(part + " ");
                    }

                    Bukkit.broadcastMessage("[" + player.getName() + "] " + bc.toString());

                }
                return true;
            }
            if(cmd.getName().equalsIgnoreCase("kit")) {

                ItemStack customsword = new ItemStack(Material.STONE_SWORD);
                ItemMeta customS = customsword.getItemMeta();
                customS.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                customsword.setItemMeta(customS);


                ItemStack customaxe = new ItemStack(Material.STONE_AXE);
                ItemMeta customA = customaxe.getItemMeta();
                customA.addEnchant(Enchantment.DIG_SPEED, 2, true);
                customaxe.setItemMeta(customA);


                ItemStack custompickaxe = new ItemStack(Material.STONE_PICKAXE);
                ItemMeta customP = custompickaxe.getItemMeta();
                customP.addEnchant(Enchantment.DIG_SPEED, 2, true);
                custompickaxe.setItemMeta(customP);

                ItemStack customsteak = new ItemStack(Material.COOKED_BEEF, 64);
                ItemMeta customC = customsteak.getItemMeta();
                customsteak.setItemMeta(customC);


                player.getInventory().addItem(customsword, customaxe, custompickaxe, customsteak);



            }
            if(cmd.getName().equalsIgnoreCase("start")) {

                int max = 300;
                int min = 100;

                int x = new Random().nextInt(max - min) + min;
                int z = new Random().nextInt(max - min) + min;

                Location loc = new Location(player.getWorld(), x, 0, z);

                int y = loc.getWorld().getHighestBlockYAt(loc) + 3;

                loc.setY(y);

                player.teleport(loc);

                player.sendMessage("tu a bien été téléporté aléatoirement en " + x +" " + y + " " + z);

            }



        }

        return false;
    }

}
