package com.example.AOE2SortingTool.Model;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

/**
 *
 * @author robertsonje
 */
public class Unit implements Comparable<Unit> {
    int id;
    String name;
    String description;
    String expansion;
    String age;
    String created_in;
    UnitCost cost;
    int build_time;
    int reload_time;
    double attack_delay;
    double movement_rate;
    int line_of_sight;
    int hit_points;
    int range;
    int attack;
    String armor;
    List<String> attack_bonus;
    List<String> armor_bonus;
    int search_radius;
    String accuracy;
    int blast_radius;

    public Unit(int id,
        String name,
        String description,
        String expansion,
        String age,
        String created_in,
        UnitCost cost,
        int build_time,
        int reload_time,
        double attack_delay,
        double movement_rate,
        int line_of_sight,
        int hit_points,
        int range,
        int attack,
        String armor,
        List<String> attack_bonus,
        List<String> armor_bonus,
        int search_radius,
        String accuracy,
        int blast_radius ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expansion = expansion;
        this.age = age;
        this.created_in = created_in;
        this.cost = cost;
        this.build_time = build_time;
        this.reload_time = reload_time;
        this.attack_delay = attack_delay;
        this.movement_rate = movement_rate;
        this.line_of_sight = line_of_sight;
        this.hit_points = hit_points;
        this.range = range;
        this.attack = attack;
        this.armor = armor;
        this.attack_bonus = attack_bonus;
        this.armor_bonus = armor_bonus;
        this.search_radius = search_radius;
        this.accuracy = accuracy;
        this.blast_radius = blast_radius;
    }

    public Unit(JsonNode unitNode) {
                this.id = unitNode.get("id") == null ? 0 : unitNode.get("id").asInt();
                this.name = unitNode.get("name") == null ? "" : (String)unitNode.get("name").asText();
                this.description = unitNode.get("description") == null ? "" : unitNode.get("description").asText();
                this.expansion = unitNode.get("expansion") == null ? "" : unitNode.get("expansion").asText();
                this.age = unitNode.get("age") == null ? "" : unitNode.get("age").asText();
                this.created_in = unitNode.get("created_in") == null ? "" : unitNode.get("created_in").asText();
                this.cost = 
                        new UnitCost(unitNode.get("cost").get("Wood"),
                                unitNode.get("cost").get("Food"),
                                unitNode.get("cost").get("Stone"),
                                unitNode.get("cost").get("Gold"));
                this.build_time = unitNode.get("build_time") == null ? 0 : unitNode.get("build_time").asInt();
                this.reload_time = unitNode.get("reload_time") == null ? 0 : unitNode.get("reload_time").asInt();
                this.attack_delay = unitNode.get("attack_delay") == null ? 0.0 : unitNode.get("attack_delay").asDouble();
                this.movement_rate = unitNode.get("movement_rate") == null ? 0.0 : unitNode.get("movement_rate").asDouble();
                this.line_of_sight = unitNode.get("line_of_sight") == null ? 0 : unitNode.get("line_of_sight").asInt();
                this.hit_points = unitNode.get("hit_points") == null ? 0 : unitNode.get("hit_points").asInt();
                this.range = unitNode.get("range") == null ? 0 : unitNode.get("range").asInt();
                this.attack = unitNode.get("attack") == null ? 0 : unitNode.get("attack").asInt();
                this.armor = unitNode.get("armor") == null ? "" : unitNode.get("armor").asText();
                //null,
                //null,
                this.search_radius = unitNode.get("search_radius") == null ? 0 : unitNode.get("search_radius").asInt();
                this.accuracy = unitNode.get("accuracy") == null ? "0%" : unitNode.get("accuracy").asText();
                this.blast_radius = unitNode.get("blast_radius") == null ? 0 : unitNode.get("blast_radius").asInt();
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getExpansion() {
        return this.expansion;
    }
    
    public String getAge() {
        return this.age;
    }
    
    public String getCreatedIn() {
        return this.created_in;
    }
    
    public UnitCost getCost() {
        return this.cost;
    }
    
    public int getBuildTime() {
        return this.build_time;
    }
    
    public int getReloadTime() {
        return this.reload_time;
    }
    
    public double getAttackDelay() {
        return this.attack_delay;
    }
    
    public double getMovementRate() {
        return this.movement_rate;
    }
    
    public int getLineOfSight() {
        return this.line_of_sight;
    }
    
    public int getHitPoints() {
        return this.hit_points;
    }
    
    public int getRange() {
        return this.range;
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    public String getArmor() {
        return this.armor;
    }
    
    public int getSearchRadius() {
        return this.search_radius;
    }
    
    public String getAccuracy() {
        return this.accuracy;
    }
    
    public int getBlastRadius() {
        return this.blast_radius;
    }
    
    @Override
    public int compareTo(Unit au){
     /* 
      * Sorting by name
      */
    int last = this.name.compareTo(au.getName());
    //Sorting by first name if last name is same d
    return last;
  }
    
    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", expansion='" + expansion + '\'' +
                ", age='" + age + '\'' +
                ", created_in='" + created_in + '\'' +
                '}';
    }
}
