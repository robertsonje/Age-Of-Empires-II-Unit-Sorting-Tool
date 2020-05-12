package com.example.CrudRepository.Model;

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
