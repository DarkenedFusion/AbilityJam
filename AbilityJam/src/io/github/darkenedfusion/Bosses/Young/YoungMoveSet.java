package io.github.darkenedfusion.Bosses.Young;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import io.github.darkenedfusion.AbilityJam;
import io.github.darkenedfusion.Weapons.WeaponDictionary;
import net.md_5.bungee.api.ChatColor;

public class YoungMoveSet implements Listener {
	
	private WeaponDictionary items = new WeaponDictionary();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBossSpawn(EntitySpawnEvent event) {
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
			if(zombie.getCustomName().equals(ChatColor.GRAY + "The Young One")) {
			zombie.setMaxHealth(500.0);
			zombie.setHealth(500.0);
			Bukkit.broadcastMessage("Boss has spawned!");
			
			} else return;
		} else return;
		} 
	
	
	@EventHandler
    public void onYoungHit(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Zombie) {
            Zombie zombie = (Zombie) event.getEntity();
            if(zombie.getCustomName().equals(ChatColor.GRAY + "The Young One")) {
            if(event.getDamager() instanceof Player) {
                
                Player player = (Player) event.getDamager();
                
                
                
                player.sendMessage(ChatColor.GRAY + "Boss has " + ChatColor.RED + (int)zombie.getHealth() + ".0");
                double randDouble = Math.random();
                if(randDouble <= 0.25) {

                    //Temper Tantrum
                    new BukkitRunnable() {
                        double t = 0;
                        
                        public void run(){
                            t += 1;
                            zombie.setGlowing(true);
                            zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 5, 0));
                            zombie.getEquipment().setChestplate(items.rChestplate());
                            zombie.getEquipment().setLeggings(items.rLeggings());
                            zombie.getEquipment().setBoots(items.rBoots());
                            
                            
                            if(t >= 100) {
                                zombie.setGlowing(false);
                                zombie.getEquipment().setChestplate(items.gChestplate());
                                zombie.getEquipment().setLeggings(items.gLeggings());
                                zombie.getEquipment().setBoots(items.gBoots());
                                cancel();
                            }
                        }
                        
                    }.runTaskTimer(AbilityJam.getInstance(), 0, 1);
                    
                }
                if(zombie.getHealth() <= 200.0) {
                	if(randDouble <= 0.15) {
                		zombie.teleport(zombie.getLocation().add(new Vector(0, 5, 0)));
                		zombie.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 255));
                		
                		new BukkitRunnable() {
                			double t = 0;
							@Override
							public void run() {
								t += 1;
								
								if(t >= 2) {
									this.cancel();
									AreaEffectCloud GroundSlamAOE = (AreaEffectCloud) zombie.getWorld().spawnEntity(zombie.getLocation(), EntityType.AREA_EFFECT_CLOUD);
	                                GroundSlamAOE.setRadius(10);
	                                GroundSlamAOE.setWaitTime(20);
	                                GroundSlamAOE.setDuration(10);
	                                GroundSlamAOE.setCustomName("GroundSlam");
	                                GroundSlamAOE.setCustomNameVisible(false);
	                                GroundSlamAOE.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.WHITE, 1));
	                                player.setVelocity(player.getVelocity().setY(2));
								}
								
								
							}
                			
                		}.runTaskTimer(AbilityJam.getInstance(), 1, 20);
                	}
                }
            }
            }
        }
    }
	
	

	
	@EventHandler
	public void onYoungDie(EntityDeathEvent event) {
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
			Player killer = (Player) event.getEntity().getKiller();
			Random r = new Random();
			int chance = r.nextInt(100);
			if(zombie.getCustomName().equals(ChatColor.GRAY + "The Young One")) {
				event.getDrops().clear();
				
				if(chance >= 40) {
					killer.getInventory().addItem(items.commonLootBox());
				}
				if(chance <= 30) {
					killer.getInventory().addItem(items.rareLootBox());
				}
				if(chance == 20) {
					killer.getInventory().addItem(items.insaneLootBox());
				}
				if(chance == 5) {
					killer.getInventory().addItem(items.mythicLootBox());
				}
				
				Bukkit.broadcastMessage(ChatColor.GRAY + "The Boss was defeated by... " + ChatColor.GOLD + "" + event.getEntity().getKiller().getDisplayName() + "");
			} else return;
		} else return;
	}













}
