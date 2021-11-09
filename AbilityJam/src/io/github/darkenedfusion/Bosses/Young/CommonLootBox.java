package io.github.darkenedfusion.Bosses.Young;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;

import io.github.darkenedfusion.AbilityJam;
import io.github.darkenedfusion.Weapons.WeaponDictionary;

public class CommonLootBox implements Listener {
	 private WeaponDictionary items = new WeaponDictionary();
	
	@EventHandler
	public void onRightClickCommon(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Common Loot Box")) {
				spawnFireworks(player.getLocation(), 0);
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				Random r = new Random();
				int chance = r.nextInt(100);
				if(chance >= 11) {
					player.getInventory().addItem(items.babyTear());
				}
				if(chance <= 10) {
					player.getInventory().addItem(items.toyGun());
				}
			} 
		}
	}
	

	@EventHandler
	public void onFireworkDamage(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Firework) {
		    Firework fw = (Firework) event.getDamager();
		    if (fw.hasMetadata("nodamage")) {
		    	event.setCancelled(true);
		    }
		}
		
	}
	 public static void spawnFireworks(Location location, int amount){
	        Location loc = location;
	        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
	        FireworkMeta fwm = fw.getFireworkMeta();
	        
	        fw.setMetadata("nodamage", new FixedMetadataValue(AbilityJam.getInstance(), true));
	       
	        fwm.setPower(2);
	        fwm.addEffect(FireworkEffect.builder().withColor(Color.GREEN).flicker(true).build());
	       
	        fw.setFireworkMeta(fwm);
	        fw.detonate();
	       
	        for(int i = 0;i<amount; i++){
	            Firework fw2 = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
	            fw2.setFireworkMeta(fwm);
	        }
	    }
	 
	 
	

}
