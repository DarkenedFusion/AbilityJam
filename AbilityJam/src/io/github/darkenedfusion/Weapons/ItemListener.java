package io.github.darkenedfusion.Weapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import io.github.darkenedfusion.AbilityJam;
import io.github.darkenedfusion.Misc.CooldownManager;
import io.github.darkenedfusion.Misc.CooldownManager.CustomEffects;

public class ItemListener implements Listener {
	
	
	@EventHandler
	public void toyTrain(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Toy Train") &&
				player.getInventory().getItemInMainHand() != null) {
		if(a.equals(Action.RIGHT_CLICK_AIR) ||  a.equals(Action.LEFT_CLICK_AIR)) {
				if(!CooldownManager.hasCooldown(player.getUniqueId(), CustomEffects.TOY_TRAIN)) {
				Minecart train = (Minecart) player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.MINECART);
				Vector dir = player.getEyeLocation().getDirection();
				train.setVelocity(dir.multiply(2.0F));
				new BukkitRunnable() {
					double t = 0;
					@Override
					public void run() {
						t += 1;
						
						if(train.isOnGround() || train.isDead()) {
							train.getWorld().createExplosion(train.getLocation(), 3);
							cancel();
						}
						
						
						if(t >= 500) {
							train.remove();
						}
					}
					
				}.runTaskTimer(AbilityJam.getInstance(), 0, 20);
				CooldownManager.setCooldown(player.getUniqueId(), CustomEffects.TOY_TRAIN, 1);
			}
			}
		} 
	}
	@EventHandler
	public void waterRune(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
	if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Water Rune") &&
			player.getInventory().getItemInMainHand() != null) {
		if(a.equals(Action.RIGHT_CLICK_AIR) ||  a.equals(Action.LEFT_CLICK_AIR)) {
				if(!CooldownManager.hasCooldown(player.getUniqueId(), CustomEffects.WATER_RUNE)) {
							player.setHealth(player.getHealth() + 2.5f);
							player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been healed!");
							
						CooldownManager.setCooldown(player.getUniqueId(), CustomEffects.WATER_RUNE, 3);
				
			}
			}
		} else {
			event.setCancelled(true);
			return;
		}
	}

}
