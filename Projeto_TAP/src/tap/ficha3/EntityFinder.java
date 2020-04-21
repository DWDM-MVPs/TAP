//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pokeradar.entities;

import com.pixelmonmod.pixelmon.blocks.enums.EnumPokeChestType;
import com.pixelmonmod.pixelmon.blocks.enums.EnumPokechestVisibility;
import com.pixelmonmod.pixelmon.blocks.machines.BlockShrine;
import com.pixelmonmod.pixelmon.blocks.tileEntities.TileEntityPokeChest;
import com.pixelmonmod.pixelmon.blocks.tileEntities.TileEntityShrine;
import com.pixelmonmod.pixelmon.entities.npcs.EntityNPC;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.BaseStats;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.IVStore;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Level;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Stats;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import com.pixelmonmod.pixelmon.enums.EnumBossMode;
import com.pixelmonmod.pixelmon.enums.EnumNature;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import pokeradar.entities.EntityFinder.1;
import pokeradar.gui.RadarGui;
import pokeradar.map.MapRenderer;
import pokeradar.map.PKMarker;
import pokeradar.util.Utils;

public class EntityFinder {
    public static List<PKMarker> pkMarkers = new ArrayList();
    public static boolean evolved = false;

    public EntityFinder() {
    }

    public static void getAndDraw(MapRenderer mp, Minecraft mc) {
        if (mc.field_71441_e != null && mc.field_71441_e.func_72910_y().size() > 1) {
            List<Entity> entityList = mc.field_71441_e.field_72996_f;
            List<TileEntity> tileList = mc.field_71441_e.field_147482_g;
            Iterator entityIt = entityList.iterator();
            Iterator tileIt = tileList.iterator();

            while(true) {
                Object entityObj;
                while(entityIt.hasNext()) {
                    entityObj = entityIt.next();
                    if (entityObj instanceof EntityPixelmon) {
                        EntityPixelmon entity = (EntityPixelmon)entityObj;

                        try {
                            Object spawnLocation = entity.getSpawnLocation();
                            Boolean hasOwner = entity.hasOwner();
                            if (!hasOwner) {
                                String name = entity.getPokemonName();
                                EnumBossMode bossMode = entity.getBossMode();
                                Boolean isShiny = entity.getIsShiny();
                                Field levelField = Utils.findUnderlying(entity.getClass(), "level");
                                levelField.setAccessible(true);
                                Level level = (Level)levelField.get(entity);
                                BaseStats baseStats = entity.baseStats;
                                Stats stats = entity.stats;
                                LinkedHashMap<StatsType, Integer> eVsStore = null;
                                IVStore ivStore = null;
                                EnumNature nature = entity.getNature();
                                int ivSum = 0;
                                if (baseStats != null) {
                                    eVsStore = entity.baseStats.evYields;
                                }

                                EntityType type = EntityType.REGULAR;
                                String nameLower = name.toLowerCase();
                                String desc = "";
                                String levelStr = "Lvl " + level.getLevel();
                                String ivStr = "IV " + (int)((double)ivSum / 186.0D * 100.0D) + "%";
                                String natureStr = nature.getLocalizedName();
                                if (isShiny) {
                                    type = EntityType.SHINY;
                                }

                                if (RadarGui.searchString != null) {
                                    String[] nameArr = RadarGui.searchString.toLowerCase().split(",");

                                    for(int na = 0; na < nameArr.length; ++na) {
                                        if (nameArr[na].trim().length() >= 3 && nameLower.contains(nameArr[na].trim())) {
                                            if (isShiny) {
                                                type = EntityType.SPECIAL;
                                            } else {
                                                type = EntityType.SEARCHED;
                                            }
                                        }
                                    }
                                }

                                if (RadarGui.getEV() != null && eVsStore != null) {
                                    Boolean badEV = false;
                                    if (eVsStore.get(StatsType.HP) != null && !RadarGui.getEV().equals(EVType.HP)) {
                                        badEV = true;
                                    }

                                    if (eVsStore.get(StatsType.Attack) != null && !RadarGui.getEV().equals(EVType.Attack)) {
                                        badEV = true;
                                    }

                                    if (eVsStore.get(StatsType.Defence) != null && !RadarGui.getEV().equals(EVType.Defense)) {
                                        badEV = true;
                                    }

                                    if (eVsStore.get(StatsType.SpecialAttack) != null && !RadarGui.getEV().equals(EVType.SpecialAttack)) {
                                        badEV = true;
                                    }

                                    if (eVsStore.get(StatsType.SpecialDefence) != null && !RadarGui.getEV().equals(EVType.SpecialDefense)) {
                                        badEV = true;
                                    }

                                    if (eVsStore.get(StatsType.Speed) != null && !RadarGui.getEV().equals(EVType.Speed)) {
                                        badEV = true;
                                    }

                                    if (badEV) {
                                        type = isShiny ? type : EntityType.REGULAR;
                                    } else if (isShiny) {
                                        type = EntityType.SPECIAL;
                                    } else {
                                        type = EntityType.SEARCHED;
                                    }
                                }

                                if (RadarGui.getNature() != null && nature != null && (type == EntityType.SEARCHED || type == EntityType.SPECIAL)) {
                                    boolean foundNature = false;
                                    if (RadarGui.getNature().equals(nature)) {
                                        foundNature = true;
                                    }

                                    if (!foundNature) {
                                        type = isShiny ? type : EntityType.REGULAR;
                                    } else if (isShiny) {
                                        type = EntityType.SPECIAL;
                                    } else {
                                        type = EntityType.SEARCHED;
                                    }
                                }

                                if (EnumPokemon.legendaries.contains(entity.func_70005_c_())) {
                                    type = EntityType.SPECIAL;
                                    desc = "Legendary";
                                }

                                if (bossMode != EnumBossMode.NotBoss && bossMode != EnumBossMode.Equal) {
                                    switch(1.$SwitchMap$com$pixelmonmod$pixelmon$enums$EnumBossMode[bossMode.ordinal()]) {
                                        case 1:
                                            type = EntityType.BOSS_UNCOMMON;
                                            break;
                                        case 2:
                                            type = EntityType.BOSS_RARE;
                                            break;
                                        case 3:
                                            type = EntityType.BOSS_LEGENDARY;
                                            break;
                                        case 4:
                                            type = EntityType.BOSS_ULTIMATE;
                                    }

                                    desc = desc + (desc.isEmpty() ? "" : " ") + bossMode.toString() + " Boss";
                                } else {
                                    desc = desc + (desc.isEmpty() ? "" : " ") + levelStr;
                                }

                                if (spawnLocation != null && spawnLocation.toString().equals("Statue")) {
                                    type = EntityType.STATUE;
                                    desc = "Statue";
                                }

                                pkMarkers.add(new PKMarker(type, entity, name, desc, type.getRadius(), mp, entity.field_71093_bK));
                            }
                        } catch (Exception var32) {
                            var32.printStackTrace();
                        }
                    } else if (entityObj instanceof EntityOtherPlayerMP) {
                        try {
                            EntityOtherPlayerMP entity = (EntityOtherPlayerMP)entityObj;
                            if ("da5e4167-84c4-4c1c-95b7-de18354f77bf".equals(entity.func_110124_au().toString())) {
                                pkMarkers.add(new PKMarker(EntityType.SPECIAL, entity, entity.getDisplayNameString(), "OMG IT'S RAS!", EntityType.SPECIAL.getRadius(), mp, entity.field_71093_bK));
                            } else {
                                pkMarkers.add(new PKMarker(EntityType.PLAYER, entity, entity.getDisplayNameString(), "Player", EntityType.PLAYER.getRadius(), mp, entity.field_71093_bK));
                            }
                        } catch (IllegalArgumentException | SecurityException var31) {
                            var31.printStackTrace();
                        }
                    } else if (entityObj instanceof NPCTrainer) {
                        try {
                            NPCTrainer entity = (NPCTrainer)entityObj;
                            pkMarkers.add(new PKMarker(EntityType.NPC, entity, "NPC Trainer", "Level: " + entity.getDisplayText(), EntityType.NPC.getRadius(), mp, entity.field_71093_bK));
                        } catch (IllegalArgumentException | SecurityException var30) {
                            var30.printStackTrace();
                        }
                    } else if (entityObj instanceof EntityNPC) {
                        try {
                            EntityNPC entity = (EntityNPC)entityObj;
                            pkMarkers.add(new PKMarker(EntityType.NPC, entity, entity.getDisplayText(), "NPC", EntityType.NPC.getRadius(), mp, entity.field_71093_bK));
                        } catch (IllegalArgumentException | SecurityException var29) {
                            var29.printStackTrace();
                        }
                    }
                }

                while(tileIt.hasNext()) {
                    entityObj = tileIt.next();
                    String desc;
                    if (entityObj instanceof TileEntityPokeChest) {
                        TileEntityPokeChest tile = (TileEntityPokeChest)entityObj;
                        EnumPokeChestType chestType = tile.getType();
                        desc = "";
                        switch(1.$SwitchMap$com$pixelmonmod$pixelmon$blocks$enums$EnumPokeChestType[chestType.ordinal()]) {
                            case 1:
                                desc = "Special";
                                break;
                            case 2:
                                desc = "Tier 1";
                                break;
                            case 3:
                                desc = "Tier 2";
                                break;
                            case 4:
                                desc = "Tier 3";
                        }

                        if (tile.getVisibility() == EnumPokechestVisibility.Hidden) {
                            desc = "Hidden";
                        }

                        pkMarkers.add(new PKMarker(EntityType.LOOT, tile, "PokeLoot", desc, EntityType.LOOT.getRadius(), mp, mc.field_71441_e.field_73011_w.getDimension()));
                    }

                    if (entityObj instanceof TileEntityShrine) {
                        TileEntityShrine tile = (TileEntityShrine)entityObj;
                        BlockShrine blockShrine = (BlockShrine)tile.func_145838_q();
                        desc = "";
                        if (blockShrine != null && blockShrine.rockType != null) {
                            desc = blockShrine.rockType.toString();
                        }

                        pkMarkers.add(new PKMarker(EntityType.SHRINE, tile, "PokeShrine", desc, EntityType.SHRINE.getRadius(), mp, mc.field_71441_e.field_73011_w.getDimension()));
                    }
                }
                break;
            }
        }

    }
}
