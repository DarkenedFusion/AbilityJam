package io.github.darkenedfusion.Bosses.Young;


import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import io.github.darkenedfusion.Misc.SkullCreator;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityZombie;
import net.minecraft.server.v1_16_R3.EnumItemSlot;
import net.minecraft.server.v1_16_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_16_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R3.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_16_R3.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomStroll;

public class TheYoungOne extends EntityZombie {
	
	private static final String YOUNG_ONE_HEAD = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjRiMDIwNDhhMWQ2YmExNjUxYzMxMDUwMDJlZDEzNWViN2U5MTYzYmUyMzk3NzA0NjUyOGE4ODUxZWM0M2I1NCJ9fX0=";
	
	public TheYoungOne(Location loc) {
		super(EntityTypes.ZOMBIE, ((CraftWorld) loc.getWorld()).getHandle());
		
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		this.setCustomName(new ChatComponentText(
				ChatColor.translateAlternateColorCodes('&', "&7The Young One")));
		this.setCustomNameVisible(true);
		this.setBaby(true);
		this.setHealth(500.0f);
		
		ItemStack helmet = SkullCreator.itemWithBase64(SkullCreator.createSkull(), YOUNG_ONE_HEAD);
		ItemMeta meta = helmet.getItemMeta();
		meta.setUnbreakable(true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
		helmet.setItemMeta(meta);
		
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta meta2 = (LeatherArmorMeta) chestplate.getItemMeta();
		meta2.setUnbreakable(true);
		meta2.setColor(Color.LIME);
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
		chestplate.setItemMeta(meta2);
		
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta lmeta = (LeatherArmorMeta) leggings.getItemMeta();
		lmeta.setColor(Color.LIME);
		lmeta.setUnbreakable(true);
		lmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
		leggings.setItemMeta(lmeta);
		
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bmeta = (LeatherArmorMeta) boots.getItemMeta();
		bmeta.setColor(Color.LIME);
		bmeta.setUnbreakable(true);
		bmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
		boots.setItemMeta(bmeta);
		
		ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta5 = diamondSword.getItemMeta();
		diamondSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
		diamondSword.setItemMeta(meta5);
		
		this.setSlot(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(helmet));
		this.setSlot(EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(chestplate));
		this.setSlot(EnumItemSlot.LEGS, CraftItemStack.asNMSCopy(leggings));
		this.setSlot(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(boots));
		this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(diamondSword));
		
		
	}
	
	@Override
	public void initPathfinder() {
		this.goalSelector.a(0, new PathfinderGoalFloat(this));
		
		this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 2.0D, true));
		this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 2.0D));
		this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 2.0D, false, 1, null));
		this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 2.0D));
		this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
		this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		
		this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this));
		this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true));
		
		
	}


}
