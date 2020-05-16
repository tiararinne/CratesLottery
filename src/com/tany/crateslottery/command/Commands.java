package com.tany.crateslottery.command;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.comphenix.protocol.utility.StreamSerializer;
import com.tany.crateslottery.Main;
import com.tany.crateslottery.gui.Gui;
import com.tany.crateslottery.way.ChatComponentAPI;

public class Commands implements CommandExecutor {
    Plugin config = Bukkit.getPluginManager().getPlugin("CratesLottery");
    File file=new File(config.getDataFolder(),"config.yml");
    File file1=new File(config.getDataFolder(),"data.yml");
    File file2=new File(config.getDataFolder(),"message.yml");
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    FileConfiguration config1=YamlConfiguration.loadConfiguration(file);
	    FileConfiguration config2=YamlConfiguration.loadConfiguration(file1);
	    FileConfiguration config3=YamlConfiguration.loadConfiguration(file2);
		if(args.length==1) {
			if(args[0].equalsIgnoreCase("help")) {
				if(sender.isOp()) {
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("gui")) {
				if(sender instanceof Player) {
					Gui.gui((Player) sender);
					return true;
				}
				sender.sendMessage("��c����̨����ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9ninetime")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl 9ninetime ��2[��������]  [��ô���] [���ʱ��] Ϊ������ӵġ�c�������2���䵥������ʱ��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("time")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl time ��2[��������]  [��ô���] [���ʱ��] Ϊ������ӵ���ͨ���䵥������ʱ��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9nine")) {
				if(sender.isOp()) {
					sender.sendMessage("��aд�������˽�����Ǻ�������ʲô����~");
					sender.sendMessage("��a9Nine���µ�һ����������");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("bc")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl bc [��������] [����] ");
					sender.sendMessage("��2�������ӿ���ʱȫ������[���д���ޡ�������]��[player]������ұ���");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("set")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl set [��������] [true/false] ��2�������ӵĳ齱��ʽ��trueΪ��������Ĭ��true��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("clear")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl clear [��������] [true/false] ��2���õ������������鵽����Ʒ����");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9nineset")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl 9Nineset [��������] [true/false] ��2���á�c�������2���ӵĳ齱��ʽ��trueΪ��������Ĭ��true��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9nineinfo")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl 9nineinfo [��������] [true/false] ��2���á�c�������2����齱������Ʒ");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("info")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl info [��������] [true/false] ��2���ù���齱������Ʒ");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("setcrate")) {
				if(sender instanceof Player) {
					if(sender.isOp()) {
						Player p = (Player) sender;
						ItemStack item=null;
							  if(p.getInventory().getItemInHand() == null || p.getInventory().getItemInHand().getType() == Material.AIR) {
								  p.sendMessage("��c����������Ҫ���÷������Ʒ״̬����Ʒ");
								  return true;
							  }
						  item = p.getInventory().getItemInHand();
						  ItemMeta meta = item.getItemMeta();
						  ItemMeta metas = item.getItemMeta();
						  meta.setDisplayName("��a���2�ӡ�5��");
						  ArrayList<String> lore = new ArrayList<String>();
						  lore.add(ChatColor.translateAlternateColorCodes('&', config3.getString("CrateLoreOne")));
						  lore.add(ChatColor.translateAlternateColorCodes('&', config3.getString("CrateLoreTwo")));
						  lore.add(ChatColor.translateAlternateColorCodes('&', config3.getString("CrateLoreThree")));
						  lore.add(ChatColor.translateAlternateColorCodes('&', config3.getString("CrateLoreFour")));
						  meta.setLore(lore);
						  item.setItemMeta(meta);
						  int amount = item.getAmount();
						  item.setAmount(1);
						  config2.set("CrateItem", ItemData(item));
					  		try {
					  			config2.save(file1);
					  		} catch (IOException e) {
					  			e.printStackTrace();
				        	}
						  item.setAmount(amount);
						  item.setItemMeta(metas);
						  sender.sendMessage("��a�ɹ�������������");
						  return true;
					}
					sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
					return true;
				}
				sender.sendMessage("��c����̨����ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("setkey")) {
				if(sender instanceof Player) {
					if(sender.isOp()) {
						Player p = (Player) sender;
						ItemStack item=null;
						if(p.getInventory().getItemInHand() == null || p.getInventory().getItemInHand().getType() == Material.AIR) {
						  p.sendMessage("��c���ϲ���Ϊ����");
						  return true;
						  }
						  item = p.getInventory().getItemInHand();
						  ItemMeta meta = item.getItemMeta();
						  ItemMeta metas = item.getItemMeta();
						  meta.setDisplayName("��a�����6Կ�ס�3��");
						  ArrayList<String> lore = new ArrayList<String>();
						  lore.add(ChatColor.translateAlternateColorCodes('&', config3.getString("KeyLoreOne")));
						  lore.add(ChatColor.translateAlternateColorCodes('&', config3.getString("KeyLoreTwo")));
						  lore.add(ChatColor.translateAlternateColorCodes('&', config3.getString("KeyLoreThree")));
						  meta.setLore(lore);
						  item.setItemMeta(meta);
						  int amount = item.getAmount();
						  item.setAmount(1);
						  config2.set("CrateKey", ItemData(item));
					  		try {
					  			config2.save(file1);
					  		} catch (IOException e) {
					  			e.printStackTrace();
				        	}
					  	  item.setAmount(amount);
					  	  item.setItemMeta(metas);
						  sender.sendMessage("��a�ɹ��������ÿ���Կ��");
						  return true;
					}
					sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
					return true;
				}
				sender.sendMessage("��c����̨����ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("key")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl key [��������] [���] [����]  ��2����齱Կ��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("crate")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl crate [��������]  [���] [ ����]  ��2����齱���飨����ʱ���յģ�");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			return true;
		}
		if(args.length==2) {
			if(args[0].equalsIgnoreCase("help")) {
				if(sender.isOp()) {
					int number = 1;
					try {
						number =Integer.parseInt(args[1]);
					}catch(NumberFormatException e) {
						sender.sendMessage("��c����������");
						return true;
					}
					if(number<=0) {
						sender.sendMessage("��cû�����ҳ����");
						return true;
					}
					if(number==1) {
						ChatComponentAPI.sendClickChat("[��ҳ]", "��a������һҳ", "cl help 2");
						sender.sendMessage("��a[]==================��2[������a����<1/4>]==================[]");
						sender.sendMessage("��2��l����ָ��");
						sender.sendMessage("��a/cl help <ҳ��> ��6ʹ��ָ���������");
						sender.sendMessage("");
						sender.sendMessage("��a/cl gui  ��6������gui");
						sender.sendMessage("��a/cl crate [��������]  [���] [����]  ��6����齱���飨����ʱ���յģ�");
						sender.sendMessage("��a/cl key [��������] [���] [����]  ��6����齱Կ��");
						sender.sendMessage("��a/cl setcrate ��6��������Ʒ���ӵ���������ó��ķ��鼴Ϊ�齱��");
						sender.sendMessage("��a/cl setkey ��6����������ƷΪ�齱Կ��");
						sender.sendMessage("��a[]========================��2============[��ҳ]=========[]");
						return true;
					}
					if(number==2) {
						ChatComponentAPI.sendClickChat("[��ҳ]", "��a������һҳ", "cl help 1");
						ChatComponentAPI.sendClickChat("[��ҳ]", "��a������һҳ", "cl help 3");
						sender.sendMessage("��a[]==================��2[������a����<2/4>]==================[]");
						sender.sendMessage("��2��l���ӵ���ʱ�����");
						sender.sendMessage("��a/cl help <ҳ��> ��6ʹ��ָ���������");
						sender.sendMessage("");
						sender.sendMessage("��a/cl time ��2[��������] [��ô���] [���ʱ��] ��6��ͨ���䵥������ʱ��");
						sender.sendMessage("��a/cl 9ninetime ��2[��������] [��ô���] [���ʱ��] ��c�������6���䵥������ʱ��");
						sender.sendMessage("��6Ϊ������ӵ�������ʱ�䣬ϸ��config.yml��ġ����䲿�֡���������");
						sender.sendMessage("��a[]===========[��ҳ]=========��2============[��ҳ]=========[]");
						return true;
					}
					if(number==3) {
						ChatComponentAPI.sendClickChat("[��ҳ]", "��a������һҳ", "/cl help 2");
						ChatComponentAPI.sendClickChat("[��ҳ]", "��a������һҳ", "/cl help 4");
						sender.sendMessage("��a[]==================��2[������a����<3/4>]==================[]");
						sender.sendMessage("��2��l�������");
						sender.sendMessage("��a/cl help <ҳ��> ��6ʹ��ָ���������");
						sender.sendMessage("");
						sender.sendMessage("��a/cl bc [��������] [����] ");
						sender.sendMessage("��a/cl 9nine [��������] [����] ");
						sender.sendMessage("��6�������ӡ�a[��ͨ����/��c������]��6����ʱȫ������[���д���ޡ�������]");
						sender.sendMessage("��6[player]������ұ���");
						sender.sendMessage("");
						sender.sendMessage("��a/cl info [��������] [true/false] ��6���ù���齱������Ʒ");
						sender.sendMessage("��a/cl 9nineinfo [��������] [true/false] ��6���á�c�������2����齱������Ʒ");
						sender.sendMessage("��a[]===========[��ҳ]=========��2============[��ҳ]=========[]");
						return true;
					}
					if(number==4) {
						ChatComponentAPI.sendClickChat("[��ҳ]", "��a������һҳ", "/cl help 3");
						sender.sendMessage("��a[]==================��2[������a����<4/4>]==================[]");
						sender.sendMessage("��2��l���ӵĶ���/���⿪�����");
						sender.sendMessage("��a/cl help <ҳ��> ��6ʹ��ָ���������");
						sender.sendMessage("");
						sender.sendMessage("��a/cl set [��������] [true/false] ��6�������ӳ齱����");
						sender.sendMessage("��a/cl 9nineset [��������] [true/false] ��6���á�c�������6���ӳ齱����");
						sender.sendMessage("��a/cl clear [��������] [true/false] ��6���õ������������鵽����Ʒ����");
						sender.sendMessage("��a[]===========[��ҳ]=========��2============[��ҳ]=========[]");
						return true;
					}
					sender.sendMessage("��cû�����ҳ����");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9nineinfo")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl 9nineinfo [��������] [true/false] ��2���á�c�������2����齱������Ʒ");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("info")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl info [��������] [true/false] ��2���ù���齱������Ʒ");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("clear")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl clear [��������] [true/false] ��2���õ������������鵽����Ʒ����");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9ninetime")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl 9ninetime ��2[��������]  [��ô���] [���ʱ��] Ϊ������ӵġ�c�������2���䵥������ʱ��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("time")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl time ��2[��������]  [��ô���] [���ʱ��] Ϊ������ӵ���ͨ���䵥������ʱ��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9nineset")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl 9Nineset [��������] [true/false] ��2���á�c�������2���ӵĳ齱��ʽ��trueΪ��������Ĭ��true��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9nine")) {
				if(sender.isOp()) {
					sender.sendMessage("��a�Ҵ��ɫ��Ų������磬ȭ���ж��磬ͷ��������");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("bc")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl bc [��������] [����] ");
					sender.sendMessage("��2�������ӿ���ʱȫ������[���д���ޡ�������]��[player]������ұ���");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("crate")) {
				if(sender instanceof Player) {
					if(sender.isOp()) {
						if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
							sender.sendMessage("��c��ǰû�д����κγ齱��");
							return true;
						}
						int a=0;
						for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
							if(crate.equals(args[1])) {
								break;
							}
							a++;
							if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
								sender.sendMessage("��c����������齱��");
								return true;
							}
						}
						if(config2.getString("CrateItem")==null) {
							sender.sendMessage("��cδ��������");
							return true;
						}
						a=0;
						ItemStack item = GetItemStack(config2.getString("CrateItem"));
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName(meta.getDisplayName()+config2.getString("Info."+args[1]+".color")+args[1]);
						item.setItemMeta(meta);
						((Player) sender).getInventory().addItem(item);
						sender.sendMessage(ChatColor.translateAlternateColorCodes('��', "��a�����b"+config2.getString("Info."+args[1]+".color")+args[1]+"��a�齱��ɹ�"));
						return true;
					}
					sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
					return true;
				}
				sender.sendMessage("��c���ܸ�����̨��Ʒ");
				return true;
			}
			if(args[0].equalsIgnoreCase("key")) {
				if(sender instanceof Player) {
					if(sender.isOp()) {
						if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
							sender.sendMessage("��c��ǰû�д����κγ齱��");
							return true;
						}
						int a=0;
						for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
							if(crate.equals(args[1])) {
								break;
							}
							a++;
							if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
								sender.sendMessage("��c����������齱��");
								return true;
							}
						}
						if(config2.getString("CrateKey") == null) {
							sender.sendMessage("��cδ����Կ��");
							return true;
						}
						a=0;
						ItemStack item = GetItemStack(config2.getString("CrateKey"));
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName(meta.getDisplayName()+config2.getString("Info."+args[1]+".color")+args[1]);
						item.setItemMeta(meta);
						((Player) sender).getInventory().addItem(item);
						if(config1.getBoolean("KeyMessage"))
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config3.getString("GetKeyMessage").replace("[key]", config2.getString("Info."+args[1]+".color")+args[1])));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('��', "��a�����b"+config2.getString("Info."+args[1]+".color")+args[1]+"��aԿ�׳ɹ�"));
						return true;
					}
					sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
					return true;
				}
				sender.sendMessage("��c���ܸ�����̨��Ʒ");
				return true;
			}
			if(args[0].equalsIgnoreCase("set")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl set [��������] [true/false] ��2�������ӵĳ齱��ʽ��trueΪ��������Ĭ��true��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9Nineset")) {	
				if(sender.isOp()) {
					sender.sendMessage("��a/cl 9Nineset [��������] [true/false] ��2���á�c�������2���ӵĳ齱��ʽ��trueΪ��������Ĭ��true��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			return true;
		}
		if(args.length==3) {
			if(args[0].equalsIgnoreCase("info")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
					}
					int a=0;
					for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
						if(crate.equals(args[1])) {
							break;
						}
						a++;
						if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
							sender.sendMessage("��c����������齱��");
							return true;
						}
					}
					a=0;
					if(!args[2].equalsIgnoreCase("true")&&!args[2].equalsIgnoreCase("false")) {
						sender.sendMessage("��c������true����false��");
						return true;
					}
					if(args[2].equalsIgnoreCase("true"))
					config2.set("Info."+args[1]+".info", true);
					else
					if(args[2].equalsIgnoreCase("false"))
					config2.set("Info."+args[1]+".info", false);
			  		try {
			  			config2.save(file1);
			  		} catch (IOException e) {
			  			e.printStackTrace();
		        	}
			  		sender.sendMessage("��a���óɹ�");
			  		return true;					
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9nineinfo")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
					}
					int a=0;
					for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
						if(crate.equals(args[1])) {
							break;
						}
						a++;
						if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
							sender.sendMessage("��c����������齱��");
							return true;
						}
					}
					a=0;
					if(!args[2].equalsIgnoreCase("true")&&!args[2].equalsIgnoreCase("false")) {
						sender.sendMessage("��c������true����false��");
						return true;
					}
					if(args[2].equalsIgnoreCase("true"))
					config2.set("Info."+args[1]+".nineinfo", true);
					else
					if(args[2].equalsIgnoreCase("false"))
					config2.set("Info."+args[1]+".nineinfo", false);
			  		try {
			  			config2.save(file1);
			  		} catch (IOException e) {
			  			e.printStackTrace();
		        	}
			  		sender.sendMessage("��a���óɹ�");
			  		return true;					
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9ninetime")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl 9ninetime ��2[��������]  [��ô���] [���ʱ��] Ϊ������ӵġ�c�������2���䵥������ʱ��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("time")) {
				if(sender.isOp()) {
					sender.sendMessage("��a/cl time ��2[��������]  [��ô���] [���ʱ��] Ϊ������ӵ���ͨ���䵥������ʱ��");
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("set")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
					}
					int a=0;
					for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
						if(crate.equals(args[1])) {
							break;
						}
						a++;
						if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
							sender.sendMessage("��c����������齱��");
							return true;
						}
					}
					a=0;
					if(!args[2].equalsIgnoreCase("true")&&!args[2].equalsIgnoreCase("false")) {
						sender.sendMessage("��c������true����false��");
						return true;
					}
					if(args[2].equalsIgnoreCase("true"))
					config2.set("Info."+args[1]+".animation", true);
					else
					if(args[2].equalsIgnoreCase("false"))
					config2.set("Info."+args[1]+".animation", false);
			  		try {
			  			config2.save(file1);
			  		} catch (IOException e) {
			  			e.printStackTrace();
		        	}
			  		sender.sendMessage("��a���óɹ�");
			  		return true;					
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9nineset")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
					}
					int a=0;
					for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
						if(crate.equals(args[1])) {
							break;
						}
						a++;
						if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
							sender.sendMessage("��c����������齱��");
							return true;
						}
					}
					a=0;
					if(!args[2].equalsIgnoreCase("true")&&!args[2].equalsIgnoreCase("false")) {
						sender.sendMessage("��c������true����false��");
						return true;
					}
					if(args[2].equalsIgnoreCase("true"))
					config2.set("Info."+args[1]+".nineanimation", true);
					else
					if(args[2].equalsIgnoreCase("false"))
					config2.set("Info."+args[1]+".nineanimation", false);
			  		try {
			  			config2.save(file1);
			  		} catch (IOException e) {
			  			e.printStackTrace();
		        	}
			  		sender.sendMessage("��a���óɹ�");
			  		return true;					
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("clear")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
					}
					int a=0;
					for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
						if(crate.equals(args[1])) {
							break;
						}
						a++;
						if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
							sender.sendMessage("��c����������齱��");
							return true;
						}
					}
					a=0;
					if(!args[2].equalsIgnoreCase("true")&&!args[2].equalsIgnoreCase("false")) {
						sender.sendMessage("��c������true����false��");
						return true;
					}
					if(args[2].equalsIgnoreCase("true"))
					config2.set("Info."+args[1]+".clear", true);
					else
					if(args[2].equalsIgnoreCase("false"))
					config2.set("Info."+args[1]+".clear", false);
			  		try {
			  			config2.save(file1);
			  		} catch (IOException e) {
			  			e.printStackTrace();
		        	}
			  		sender.sendMessage("��a���óɹ�");
			  		return true;					
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("bc")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
					}
					int a=0;
					for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
						if(crate.equals(args[1])) {
							break;
						}
						a++;
						if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
							sender.sendMessage("��c����������齱��");
							return true;
						}
					}
					a=0;
					if(args[2].equals("��")) {
						sender.sendMessage("��a�ɹ�ȡ��"+config2.getString("Info."+args[1]+".color")+args[1]+"��a����ʱ�Ĺ���");
						config2.set("Info."+args[1]+".announcement", "��");
					}else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "��a�ɹ�����"+config2.getString("Info."+args[1]+".color")+args[1]+"��a����ʱ�Ĺ���Ϊ"+args[2]));
						config2.set("Info."+args[1]+".announcement", args[2]);
					}
			  		try {
			  			config2.save(file1);
			  		} catch (IOException e) {
			  			e.printStackTrace();
		        	}
			  		return true;	
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9Nine")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
					}
					int a=0;
					for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
						if(crate.equals(args[1])) {
							break;
						}
						a++;
						if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
							sender.sendMessage("��c����������齱��");
							return true;
						}
					}
					a=0;
					if(args[2].equals("��")) {
						sender.sendMessage("��a�ɹ�ȡ��"+config2.getString("Info."+args[1]+".color")+args[1]+"��c������a����ʱ�Ĺ���");
						config2.set("Info."+args[1]+".nine", "��");
					}else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "��a�ɹ�����"+config2.getString("Info."+args[1]+".color")+args[1]+"��c������a����ʱ�Ĺ���Ϊ"+args[2]));
						config2.set("Info."+args[1]+".nine", args[2]);
					}
			  		try {
			  			config2.save(file1);
			  		} catch (IOException e) {
			  			e.printStackTrace();
		        	}
			  		return true;	
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("crate")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
						}
						int a=0;
						for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
						if(crate.equals(args[1])) {
						break;
						}
						a++;
						if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
						sender.sendMessage("��c����������齱��");
						return true;
						}
					}
					if(config2.getString("CrateItem")==null) {
						sender.sendMessage("��cδ��������");
						return true;
					}
					if(Bukkit.getServer().getPlayer(args[2]) == null) {
						sender.sendMessage("��c�����Ҳ�����/������");
						return true;
					}
					Player player = Bukkit.getServer().getPlayer(args[2]);
					a=0;						ItemStack item = GetItemStack(config2.getString("CrateItem"));
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName(meta.getDisplayName()+config2.getString("Info."+args[1]+".color")+args[1]);
					item.setItemMeta(meta);
					player.getInventory().addItem(item);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('��', "��a�����b"+config2.getString("Info."+args[1]+".color")+args[1]+"��a�齱��ɹ�"));
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("key")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
						}
						int a=0;
						for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
							if(crate.equals(args[1])) {
								break;
							}
							a++;
							if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
								sender.sendMessage("��c����������齱��");
								return true;
							}
						}
						if(config2.getString("CrateKey")==null) {
							sender.sendMessage("��cδ����Կ��");
							return true;
						}
						if(Bukkit.getServer().getPlayer(args[2]) == null) {
							sender.sendMessage("��c�����Ҳ�����/������");
							return true;
						}
						Player player = Bukkit.getServer().getPlayer(args[2]);
						a=0;
						ItemStack item = GetItemStack(config2.getString("CrateKey"));
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName(meta.getDisplayName()+config2.getString("Info."+args[1]+".color")+args[1]);
						item.setItemMeta(meta);
						player.getInventory().addItem(item);
						if(config1.getBoolean("KeyMessage"))
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', config3.getString("GetKeyMessage").replace("[key]", config2.getString("Info."+args[1]+".color")+args[1])));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('��', "��a�����b"+config2.getString("Info."+args[1]+".color")+args[1]+"��aԿ�׳ɹ�"));
						return true;
					}
					sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
					return true;
			}
			return true;
		}
		if(args.length==4) {
			if(args[0].equalsIgnoreCase("time")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
						}
						int a=0;
						for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
							if(crate.equals(args[1])) {
								break;
							}
							a++;
							if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
								sender.sendMessage("��c����������齱��");
								return true;
							}
						}
						int number = 1;
						try {
							number =Integer.parseInt(args[2]);
						}catch(NumberFormatException e) {
							sender.sendMessage("��c����ֻ��Ϊ����");
							return true;
						}
						double cd = 0.5;
						try {
							cd =Double.parseDouble(args[3]);
						}catch(NumberFormatException e) {
							sender.sendMessage("��c����������");
							return true;
						}
						if(number<=0) {
							sender.sendMessage("��c��������С�ڵ���0��");
							return true;
						}
						if(cd<=0) {
							sender.sendMessage("��cʱ�䲻��С�ڵ���0��");
							return true;
						}
						config2.set("Info."+args[1]+".number", number);
						config2.set("Info."+args[1]+".cd", cd);
				  		try {
				  			config2.save(file1);
				  		} catch (IOException e) {
				  			e.printStackTrace();
			        	}
				  		sender.sendMessage("��a�ɹ����ó齱��"+config2.getString("Info."+args[1]+".color")+args[1]+"��a�Ŀ���ʱ������Ϊ��2"+number+"��a��");
				  		sender.sendMessage("��a�ɹ����ó齱��"+config2.getString("Info."+args[1]+".color")+args[1]+"��a��ÿ�α���������Ϊ��2"+cd+"��a��");
				  		return true;
					}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("9ninetime")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
						}
						int a=0;
						for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
							if(crate.equals(args[1])) {
								break;
							}
							a++;
							if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
								sender.sendMessage("��c����������齱��");
								return true;
							}
						}
						int number = 1;
						try {
							number =Integer.parseInt(args[2]);
						}catch(NumberFormatException e) {
							sender.sendMessage("��c����ֻ��Ϊ����");
							return true;
						}
						double cd = 0.5;
						try {
							cd =Double.parseDouble(args[3]);
						}catch(NumberFormatException e) {
							sender.sendMessage("��c����������");
							return true;
						}
						if(number<=0) {
							sender.sendMessage("��c��������С�ڵ���0��");
							return true;
						}
						if(cd<=0) {
							sender.sendMessage("��cʱ�䲻��С�ڵ���0��");
							return true;
						}
						config2.set("Info."+args[1]+".ninenumber", number);
						config2.set("Info."+args[1]+".ninecd", cd);
				  		try {
				  			config2.save(file1);
				  		} catch (IOException e) {
				  			e.printStackTrace();
			        	}
				  		sender.sendMessage("��a�ɹ����ó齱��"+config2.getString("Info."+args[1]+".color")+args[1]+"��a�ġ�c�������a����ʱ������Ϊ��2"+number+"��a��");
				  		sender.sendMessage("��a�ɹ����ó齱��"+config2.getString("Info."+args[1]+".color")+args[1]+"��a�ġ�c�������aÿ�α���������Ϊ��2"+cd+"��a��");
				  		return true;
					}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			if(args[0].equalsIgnoreCase("key")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
						}
						int a=0;
						for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
							if(crate.equals(args[1])) {
								break;
							}
							a++;
							if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
								sender.sendMessage("��c����������齱��");
								return true;
							}
						}
						if(config2.getString("CrateKey")==null) {
							sender.sendMessage("��cδ����Կ��");
							return true;
						}
						if(Bukkit.getServer().getPlayer(args[2]) == null) {
							sender.sendMessage("��c�����Ҳ�����/������");
							return true;
						}
						int amount = 1;
						try {
							amount =Integer.parseInt(args[3]);
						}catch(NumberFormatException e) {
							sender.sendMessage("��c����������");
							return true;
						}
						Player player = Bukkit.getServer().getPlayer(args[2]);
						a=0;
						ItemStack item = GetItemStack(config2.getString("CrateKey"));
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName(meta.getDisplayName()+config2.getString("Info."+args[1]+".color")+args[1]);
						item.setItemMeta(meta);
						item.setAmount(amount);
						player.getInventory().addItem(item);
						if(config1.getBoolean("KeyMessage"))
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', config3.getString("GetKeyMessage").replace("[key]", config2.getString("Info."+args[1]+".color")+args[1])));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('��', "��a�����b"+config2.getString("Info."+args[1]+".color")+args[1]+"��aԿ�׳ɹ�"));
						return true;
					}
					sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
					return true;
			}
			if(args[0].equalsIgnoreCase("crate")) {
				if(sender.isOp()) {
					if(config2.getConfigurationSection("Info").getKeys(false).size()==0) {
						sender.sendMessage("��c��ǰû�д����κγ齱��");
						return true;
						}
						int a=0;
						for(String crate:config2.getConfigurationSection("Info").getKeys(false)) {
						if(crate.equals(args[1])) {
						break;
						}
						a++;
						if(a==config2.getConfigurationSection("Info").getKeys(false).size()) {
						sender.sendMessage("��c����������齱��");
						return true;
						}
					}
					if(config2.getString("CrateItem")==null) {
						sender.sendMessage("��cδ��������");
						return true;
					}
					if(Bukkit.getServer().getPlayer(args[2]) == null) {
						sender.sendMessage("��c�����Ҳ�����/������");
						return true;
					}
					int amount = 1;
					try {
						amount =Integer.parseInt(args[3]);
					}catch(NumberFormatException e) {
						sender.sendMessage("��c����������");
						return true;
					}
					Player player = Bukkit.getServer().getPlayer(args[2]);
					a=0;						
					ItemStack item = GetItemStack(config2.getString("CrateItem"));
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName(meta.getDisplayName()+config2.getString("Info."+args[1]+".color")+args[1]);
					item.setItemMeta(meta);
					item.setAmount(amount);
					player.getInventory().addItem(item);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('��', "��a�����b"+config2.getString("Info."+args[1]+".color")+args[1]+"��a�齱��ɹ�"));
					return true;
				}
				sender.sendMessage("��c��û��Ȩ��ʹ�ô�ָ��");
				return true;
			}
			return true;
		}
		if(sender.isOp()) {
		sender.sendMessage("��a/cl help <ҳ��> ��2ʹ��ָ���������");
//		sender.sendMessage("��a/cl gui  ��2������gui");
//		sender.sendMessage("��a/cl crate [��������]  [���] [ ����]  ��2����齱���飨����ʱ���յģ�");
//		sender.sendMessage("��a/cl key [��������] [���] [����]  ��2����齱Կ��");
//		sender.sendMessage("");
//		sender.sendMessage("��a/cl setcrate ��2��������Ʒ���ӵ���������ó��ķ��鼴Ϊ�齱��");
//		sender.sendMessage("��a/cl setkey ��2����������ƷΪ�齱Կ��");
//		sender.sendMessage("");
//		sender.sendMessage("��a/cl time ��2[��������] [��ô���] [���ʱ��] Ϊ������ӵ���ͨ���䵥������ʱ��");
//		sender.sendMessage("��a/cl 9ninetime ��2[��������] [��ô���] [���ʱ��] Ϊ������ӵġ�c�������2���䵥������ʱ��");
//		sender.sendMessage("��2Ϊ������ӵ�������ʱ�䣬ϸ��config.yml��ġ����䲿�֡���������");
//		sender.sendMessage("");
//		sender.sendMessage("��a/cl bc [��������] [����] ");
//		sender.sendMessage("��a/cl 9nine [��������] [����] ");
//		sender.sendMessage("��2��������[��ͨ����/��c������]��2����ʱȫ������[���д���ޡ�������]��[player]������ұ���");
//		sender.sendMessage("��a/cl info [��������] [true/false] ��2���ù���齱������Ʒ");
//		sender.sendMessage("��a/cl 9nineinfo [��������] [true/false] ��2���á�c�������2����齱������Ʒ");
//		sender.sendMessage("");
//		sender.sendMessage("��a/cl set [��������] [true/false] ��2�������ӳ齱����");
//		sender.sendMessage("��a/cl 9nineset [��������] [true/false] ��2���á�c�������2���ӳ齱����");
//		sender.sendMessage("��a/cl clear [��������] [true/false] ��2���õ������������鵽����Ʒ����");
		}else {
			sender.sendMessage("��c��һ���Ҫָ�����Ц��");
		}
		return true;
	}
//	ItemStackתString
	public static String ItemData(ItemStack item) {
		StreamSerializer data = new StreamSerializer();
		String s;
		try {
		    s = data.serializeItemStack(item);
		} catch (Exception e) {
		    s = null;
		}
		return s;
	}
//	StringתItemStack
	public static ItemStack GetItemStack(String data) {
		StreamSerializer item = new StreamSerializer();
		try {
			return item.deserializeItemStack(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}