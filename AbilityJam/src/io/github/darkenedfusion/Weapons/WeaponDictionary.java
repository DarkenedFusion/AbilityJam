package io.github.darkenedfusion.Weapons;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import io.github.darkenedfusion.Misc.SkullCreator;

public class WeaponDictionary {
	
	private static final String Common_Loot_Box  = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWIzZjJjYWRmMTdkNGYxN2ZjMDgzZTk4N2UwZmZlNjIxODg2YmVmMmZmYmNhNDM3MDM4YjY2MGM3NDZiZWY5ZiJ9fX0=";
	private static final String Rare_Loot_Box  = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzJlNjA4MWM4MjVlODM5NzdhNjE0ODI4YjE5ZmFiNThjMWY2ZTYzMzcwY2IxMDk1ZGE1MzU5ODQwZDhjZTExNiJ9fX0=";
	private static final String Insane_Loot_Box  = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWU1NTc0YTRlZjk0ZWY0Y2EzMDBkMDJmNjQ0ZDk4YmUwN2RiZmJhN2RmNzg4MDhlOGE5YTAyMWIwNjdkOTk2ZCJ9fX0=";
	private static final String Mythic_Loot_Box  = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGYxNGQxYTQ2ZjdjMWMwODQ2ODhjNjM0ZjUwZDJhZDc3ZDk4Nzk2MTlmZjg4MmNkN2RiN2U0YTJlNTA1MTlmOSJ9fX0=";
	private static final String Blue_Core = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTlmMDI1ZjNmOWYxNDljYjZkMjkwOGM2ODcyMWZmNjYyMmE2Zjk0NTk1NmYwNzRlYTRmZGU0NDNjNWI1ZDdjNyJ9fX0=";
	private static final String Water_Rune = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzUxZDVhMWFjMTE0YTgyZmE2NTJmYzIzN2IzZTc4ZjIyZmU5ZDU4ZGU5N2M1MzdiZDVlZjk5YzM4ZmI2NmIyIn19fQ==";
	
	public ItemStack Wood_Katana() {
		ItemStack woodKatana = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta meta = woodKatana.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Wooden Katana");
		meta.setUnbreakable(true);
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Made out of the most normal wood.");
		lore.add("");
		lore.add(ChatColor.GRAY + "Damage" + ChatColor.YELLOW + ": 10");
		lore.add(ChatColor.GRAY + "Speed" + ChatColor.YELLOW + ": 1");
		lore.add("");
		lore.add(ChatColor.YELLOW + "Rarity: " + ChatColor.WHITE  + "Basic");
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage",
				10.0, Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed",  -2.00, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setLore(lore);
		woodKatana.setItemMeta(meta);
		return woodKatana;
	}
	public ItemStack Wood_Bow() {
		ItemStack woodBow = new ItemStack(Material.BOW);
		ItemMeta meta = woodBow.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Wooden Bow");
		meta.setUnbreakable(true);
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "It's a bow made of wood.");
		lore.add("");
		lore.add(ChatColor.GRAY + "Damage" + ChatColor.YELLOW + "5");
		lore.add(ChatColor.GRAY + "Speed" + ChatColor.YELLOW + ": 1");
		lore.add("");
		lore.add(ChatColor.YELLOW + "Rarity: " + ChatColor.WHITE  + "Basic");
		
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setLore(lore);
		woodBow.setItemMeta(meta);
		return woodBow;
	}
	
	public ItemStack woodenHelmet() {
		ItemStack woodenHelmet = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta meta = woodenHelmet.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Wooden Helmet");
		meta.setUnbreakable(true);
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "It's a hat, but made of wood?");
		lore.add("");
		lore.add(ChatColor.GRAY + "Defence" + ChatColor.YELLOW + ": 10");
		lore.add(ChatColor.GRAY + "Guard" + ChatColor.YELLOW + ": 0");
		lore.add("");
		lore.add(ChatColor.YELLOW + "Rarity: " + ChatColor.WHITE  + "Basic");
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor",
				10.0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setLore(lore);
		woodenHelmet.setItemMeta(meta);
		return woodenHelmet;
		
	}
	public ItemStack woodenTunic() {
		ItemStack woodenTunic = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta meta = woodenTunic.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Wooden Chestplate");
		meta.setUnbreakable(true);
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "It's a tunic, but made of wood?");
		lore.add("");
		lore.add(ChatColor.GRAY + "Defence" + ChatColor.YELLOW + ": 10");
		lore.add(ChatColor.GRAY + "Guard" + ChatColor.YELLOW + ": 0");
		lore.add("");
		lore.add(ChatColor.YELLOW + "Rarity: " + ChatColor.WHITE  + "Basic");
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor",
				10.0, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setLore(lore);
		woodenTunic.setItemMeta(meta);
		return woodenTunic;
		
	}
	public ItemStack woodenPants() {
		ItemStack woodenPants = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemMeta meta = woodenPants.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Wooden Pants");
		meta.setUnbreakable(true);
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "It's a pair of pants, but made of wood?");
		lore.add("");
		lore.add(ChatColor.GRAY + "Defence" + ChatColor.YELLOW + ": 10");
		lore.add(ChatColor.GRAY + "Guard" + ChatColor.YELLOW + ": 0");
		lore.add("");
		lore.add(ChatColor.YELLOW + "Rarity: " + ChatColor.WHITE  + "Basic");
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor",
				10.0, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setLore(lore);
		woodenPants.setItemMeta(meta);
		return woodenPants;
		
		
	}
	public ItemStack woodenClogs() {
		ItemStack woodenClogs = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta meta = woodenClogs.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Wooden Clogs");
		meta.setUnbreakable(true);
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "It's a pair of clogs, but made of wood?");
		lore.add("");
		lore.add(ChatColor.GRAY + "Defence" + ChatColor.YELLOW + ": 10");
		lore.add(ChatColor.GRAY + "Guard" + ChatColor.YELLOW + ": 0");
		lore.add("");
		lore.add(ChatColor.YELLOW + "Rarity: " + ChatColor.WHITE  + "Basic");
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor",
				10.0, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setLore(lore);
		woodenClogs.setItemMeta(meta);
		return woodenClogs;
	}
	
	
	
	//Loot Boxes
	public ItemStack commonLootBox() {
		ItemStack commonLootBox = SkullCreator.itemWithBase64(SkullCreator.createSkull(), Common_Loot_Box);
		ItemMeta meta = commonLootBox.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_GREEN + "Common Loot Box");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Right click to " + ChatColor.YELLOW + "open" + ChatColor.GRAY + "!");
		meta.setLore(lore);
		commonLootBox.setItemMeta(meta);
		
		return commonLootBox;
	}
	public ItemStack rareLootBox() {
		ItemStack rareLootBox = SkullCreator.itemWithBase64(SkullCreator.createSkull(), Rare_Loot_Box);
		ItemMeta meta = rareLootBox.getItemMeta();
		meta.setDisplayName(ChatColor.BLUE + "Rare Loot Box");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Right click to " + ChatColor.YELLOW + "open" + ChatColor.GRAY + "!");
		meta.setLore(lore);
		rareLootBox.setItemMeta(meta);
		
		return rareLootBox;
	}
	public ItemStack insaneLootBox() {
		ItemStack insaneLootBox = SkullCreator.itemWithBase64(SkullCreator.createSkull(), Insane_Loot_Box);
		ItemMeta meta = insaneLootBox.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Insane Loot Box");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Right click to " + ChatColor.YELLOW + "open" + ChatColor.GRAY + "!");
		meta.setLore(lore);
		insaneLootBox.setItemMeta(meta);
		
		return insaneLootBox;
	}
	public ItemStack mythicLootBox() {
		ItemStack mythicLootBox = SkullCreator.itemWithBase64(SkullCreator.createSkull(), Mythic_Loot_Box);
		ItemMeta meta = mythicLootBox.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Mythic Loot Box");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Right click to " + ChatColor.YELLOW + "open" + ChatColor.GRAY + "!");
		meta.setLore(lore);
		mythicLootBox.setItemMeta(meta);
		
		return mythicLootBox;
	}
	
	
	//Young One Boss Drops
	public ItemStack undeadSocket() {
		
		ItemStack undeadSocket = new ItemStack(Material.BUCKET);
		ItemMeta meta = undeadSocket.getItemMeta();
		meta.setDisplayName(ChatColor.BLUE + "Undead Socket");
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.GRAY + "To view recipe" + ChatColor.YELLOW + " right click" + ChatColor.GRAY + "!");
		lore.add("");
		lore.add(ChatColor.BLUE + "Rare Drop");
		meta.setLore(lore);
		undeadSocket.setItemMeta(meta);
		return undeadSocket;
		}
	public ItemStack blueCore() {	
		ItemStack blueCore = SkullCreator.itemWithBase64(SkullCreator.createSkull(), Blue_Core);
		ItemMeta meta = blueCore.getItemMeta();
		meta.setDisplayName(ChatColor.BLUE + "Blue Core");
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.GRAY + "To view recipe" + ChatColor.YELLOW + " right click" + ChatColor.GRAY + "!");
		lore.add("");
		lore.add(ChatColor.BLUE + "Rare Drop");
		meta.setLore(lore);
		blueCore.setItemMeta(meta);
		return blueCore;
		}
	public ItemStack waterRune() {
		
		ItemStack waterRune = SkullCreator.itemWithBase64(SkullCreator.createSkull(), Water_Rune);
		ItemMeta meta = waterRune.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Water Rune");
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.LIGHT_PURPLE + "Aqua Heal: " + ChatColor.DARK_PURPLE + "Heals 3 hearts of your health");
		lore.add(ChatColor.DARK_GRAY + "Cooldown: 3 Seconds");
		lore.add("");
		lore.add(ChatColor.LIGHT_PURPLE + "Insane Drop");
		meta.setLore(lore);
		waterRune.setItemMeta(meta);
		return waterRune;
		}
	public ItemStack babyTear() {
		ItemStack babyTear = new ItemStack(Material.GHAST_TEAR);
		ItemMeta meta = babyTear.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_GREEN + "Baby Tear");
		meta.addEnchant(Enchantment.DURABILITY, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.GRAY + "To view recipe" + ChatColor.YELLOW + " right click" + ChatColor.GRAY + "!");
		lore.add("");
		lore.add(ChatColor.DARK_GREEN + "Common Drop");
		meta.setLore(lore);
		babyTear.setItemMeta(meta);
		return babyTear;
	}
	public ItemStack toyGun() {
		ItemStack toyGun = new ItemStack(Material.BOW);
		ItemMeta meta = toyGun.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_GREEN + "Toy Gun");
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Temper Tantrum: " + ChatColor.DARK_GREEN + "Has a chance to fling enemies!");
		lore.add("");
		lore.add(ChatColor.DARK_GREEN + "Common Drop");
		meta.setLore(lore);
		toyGun.setItemMeta(meta);
		return toyGun;
	}
	public ItemStack toyTrain() {
		ItemStack toyTrain = new ItemStack(Material.POWERED_RAIL);
		ItemMeta meta = toyTrain.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Toy Train");
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.YELLOW + "Choo Choo: " + ChatColor.GOLD + "Throws a train at an enemy!");
		lore.add("");
		lore.add(ChatColor.GOLD + "Mythic Drop");
		meta.setLore(lore);
		toyTrain.setItemMeta(meta);
		return toyTrain;
	}
	//Young One Armor
	public ItemStack gChestplate(){
	ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
	LeatherArmorMeta meta2 = (LeatherArmorMeta) chestplate.getItemMeta();
	meta2.setUnbreakable(true);
	meta2.setColor(Color.LIME);
	meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
	chestplate.setItemMeta(meta2);
	return chestplate;
	}
	public ItemStack gLeggings(){
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta lmeta = (LeatherArmorMeta) leggings.getItemMeta();
		lmeta.setColor(Color.LIME);
		lmeta.setUnbreakable(true);
		lmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
		leggings.setItemMeta(lmeta);
		return leggings;
		}
	public ItemStack gBoots(){
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bmeta = (LeatherArmorMeta) boots.getItemMeta();
		bmeta.setColor(Color.LIME);
		bmeta.setUnbreakable(true);
		bmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
		boots.setItemMeta(bmeta);
		return boots;
		}
	public ItemStack rChestplate(){
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta meta2 = (LeatherArmorMeta) chestplate.getItemMeta();
		meta2.setUnbreakable(true);
		meta2.setColor(Color.RED);
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
		chestplate.setItemMeta(meta2);
		return chestplate;
		}
		public ItemStack rLeggings(){
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta lmeta = (LeatherArmorMeta) leggings.getItemMeta();
			lmeta.setColor(Color.RED);
			lmeta.setUnbreakable(true);
			lmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
			leggings.setItemMeta(lmeta);
			return leggings;
			}
		public ItemStack rBoots(){
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bmeta = (LeatherArmorMeta) boots.getItemMeta();
			bmeta.setColor(Color.RED);
			bmeta.setUnbreakable(true);
			bmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
			boots.setItemMeta(bmeta);
			return boots;
			}
	
	
}
