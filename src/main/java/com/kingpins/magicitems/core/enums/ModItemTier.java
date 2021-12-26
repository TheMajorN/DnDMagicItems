package com.kingpins.magicitems.core.enums;

import com.kingpins.magicitems.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ModItemTier implements IItemTier {

    GOLDEN_HIND(0, 2000, 0.0F, 5.5F, 0, Ingredient.of(ItemInit.GOLDEN_HIND.get()));

    private final int level;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
                Ingredient repairMaterial) {
        this.level = harvestLevel;
        this.uses = maxUses;
        this.speed = efficiency;
        this.attackDamageBonus = attackDamage;
        this.enchantmentValue = enchantability;
        this.repairIngredient = repairMaterial;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }
}
