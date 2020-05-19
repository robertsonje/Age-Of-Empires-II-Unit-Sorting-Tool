package com.example.AOE2SortingTool.Model;
import com.fasterxml.jackson.databind.JsonNode;

/**
 *
 * @author robertsonje
 */
public class UnitCost {
    int Wood;
    int Food;
    int Stone;
    int Gold;
    public UnitCost(JsonNode Wood, JsonNode Food, JsonNode Stone, JsonNode Gold) {
        this.Wood = 0;
        this.Food = 0;
        this.Stone = 0;
        this.Gold = 0;
        if (Wood != null) {
            this.Wood = Wood.asInt();
        }
        if (Food != null) {
            this.Food = Food.asInt();
        }
        if (Stone != null) {
            this.Stone = Stone.asInt();
        }
        if (Gold != null) {
            this.Gold = Gold.asInt();
        }
    }
    public UnitCost(int Wood, int Food, int Stone, int Gold) {
        this.Wood = Wood;
        this.Food = Food;
        this.Stone = Stone;
        this.Gold = Gold;
    }
    public int getWood(){
        return Wood;
    }
    public int getFood(){
        return Food;
    }
    public int getStone(){
        return Stone;
    }
    public int getGold(){
        return Gold;
    }
}

