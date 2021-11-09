package io.github.darkenedfusion.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

import io.github.darkenedfusion.Bosses.Young.TheYoungOne;
import io.github.darkenedfusion.Weapons.WeaponDictionary;
import net.minecraft.server.v1_16_R3.WorldServer;

public class GrantCommand implements CommandExecutor   {
	 private WeaponDictionary items = new WeaponDictionary();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("grant")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Console cannot run this command!");
				return true;
			}
			Player player = (Player) sender;
			if(args.length == 0) {
				player.sendMessage(ChatColor.RED + "Please type in an item name!");
				return true;
			}
			if(player.isOp()) {
				if(args[0].equalsIgnoreCase("WOODEN_KATANA")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.Wood_Katana().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.Wood_Katana());
				}
				if(args[0].equalsIgnoreCase("WOODEN_BOW")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.Wood_Bow().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.Wood_Bow());
				}
				if(args[0].equalsIgnoreCase("COMMON_LOOT_BOX")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.commonLootBox().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.commonLootBox());
				}
				if(args[0].equalsIgnoreCase("RARE_LOOT_BOX")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.rareLootBox().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.rareLootBox());
				}
				if(args[0].equalsIgnoreCase("INSANE_LOOT_BOX")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.insaneLootBox().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.insaneLootBox());
				}
				if(args[0].equalsIgnoreCase("MYTHIC_LOOT_BOX")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.mythicLootBox().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.mythicLootBox());
				}
				if(args[0].equalsIgnoreCase("BABY_TEAR")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.babyTear().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.babyTear());
				}
				if(args[0].equalsIgnoreCase("TOY_GUN")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.toyGun().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.toyGun());
				}
				if(args[0].equalsIgnoreCase("UNDEAD_SOCKET")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.undeadSocket().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.undeadSocket());
				}
				if(args[0].equalsIgnoreCase("WATER_RUNE")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.waterRune().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.waterRune());
				}
				if(args[0].equalsIgnoreCase("BLUE_CORE")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.blueCore().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.blueCore());
				}
				if(args[0].equalsIgnoreCase("TOY_TRAIN")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.toyTrain().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.toyTrain());
				}
				if(args[0].equalsIgnoreCase("WOODEN_HELMET")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.woodenHelmet().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.woodenHelmet());
				}
				if(args[0].equalsIgnoreCase("WOODEN_TUNIC")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.woodenTunic().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.woodenTunic());
				}
				if(args[0].equalsIgnoreCase("WOODEN_PANTS")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.woodenPants().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.woodenPants());
				}
				if(args[0].equalsIgnoreCase("WOODEN_CLOGS")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.woodenClogs().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.woodenClogs());
				}
				
				
				
			//Bosses
				if(args[0].equalsIgnoreCase("YOUNG_BOSS")) {
					TheYoungOne youngBoss = new TheYoungOne(player.getLocation());
					
					WorldServer world = ((CraftWorld)player.getLocation().getWorld()).getHandle();
					world.addEntity(youngBoss);
				}
			}
			
			}
		return true;

}

}
