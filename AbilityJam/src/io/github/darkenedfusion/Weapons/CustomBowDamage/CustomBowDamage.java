package io.github.darkenedfusion.Weapons.CustomBowDamage;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.darkenedfusion.AbilityJam;
import io.github.darkenedfusion.Misc.CooldownManager;
import io.github.darkenedfusion.Misc.CooldownManager.CustomEffects;
import net.md_5.bungee.api.ChatColor;

public class CustomBowDamage implements Listener {
	
	
	@EventHandler
	public void onWoodBowShoot(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		if(player.getInventory().getItemInMainHand().getType() == Material.BOW) {
		 if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Wooden Bow")) {
			if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
				event.setCancelled(true);
			}
			if(a.equals(Action.LEFT_CLICK_AIR) || a.equals(Action.LEFT_CLICK_BLOCK)) {
				if(!CooldownManager.hasCooldown(player.getUniqueId(), CustomEffects.WOOD_BOW)) {
				player.playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1.0F, 1.0F);
				Arrow arrow = player.launchProjectile(Arrow.class);
				arrow.setDamage(5);
				arrow.setVelocity(arrow.getVelocity().multiply(1));
				CooldownManager.setCooldown(player.getUniqueId(), CustomEffects.WOOD_BOW, (long) 1.1);
				}
			}
		}
		}
	}
	
	@EventHandler
	public void onToyBowShoot(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		if(player.getInventory().getItemInMainHand().getType() == Material.BOW) {
		 if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Toy Gun")) {
			if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
				event.setCancelled(true);
			}
			if(a.equals(Action.LEFT_CLICK_AIR) || a.equals(Action.LEFT_CLICK_BLOCK)) {
				if(!CooldownManager.hasCooldown(player.getUniqueId(), CustomEffects.TOY_GUN)) {
				player.playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1.0F, 1.0F);
				Arrow arrow = player.launchProjectile(Arrow.class);
				arrow.setDamage(10);
				arrow.setVelocity(arrow.getVelocity().multiply(1));
				CooldownManager.setCooldown(player.getUniqueId(), CustomEffects.TOY_GUN, (long) 1.1);
				}
			}
		}
		}
	}
	
	
	
	
	
	
	
	
	
	
	@EventHandler
	public void onArrowLand(ProjectileHitEvent event) {
		Entity proj = event.getEntity();
		if(proj instanceof Arrow) {
			Arrow arrow = (Arrow) event.getEntity();
			new BukkitRunnable() {

				@Override
				public void run() {
					arrow.remove();
					
				}
				
			}.runTaskLater(AbilityJam.getInstance(), 20);
		}
	}
	
}
