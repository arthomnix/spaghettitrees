package dev.arthomnix.spaghettitrees.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.InvalidIdentifierException;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

@Config(name = "spaghettitrees")
public class SpaghettiTreesConfig implements ConfigData {
    public boolean useLogsInsteadOfWood = false;

    public List<IdWithWeight> bushLeafTypes = List.of(
            new IdWithWeight("minecraft:azalea_leaves", 1),
            new IdWithWeight("minecraft:flowering_azalea_leaves", 1),
            new IdWithWeight("minecraft:oak_leaves", 1),
            new IdWithWeight("minecraft:dark_oak_leaves", 1),
            new IdWithWeight("minecraft:birch_leaves", 1)
    );

    public List<IdWithWeight> bushWoodTypes = List.of(
            new IdWithWeight("minecraft:oak_wood", 1),
            new IdWithWeight("minecraft:dark_oak_wood", 1),
            new IdWithWeight("minecraft:birch_wood", 1)
    );

    @ConfigEntry.Gui.CollapsibleObject
    public TrunkPlacerSettings oakTrunkSettings = new TrunkPlacerSettings(
            6, 6, 0, 0.85D, 1.25D, 0, 5, 0D, 1D, 0.3D, 0.95D
    );

    @ConfigEntry.Gui.CollapsibleObject
    public TrunkPlacerSettings birchTrunkSettings = new TrunkPlacerSettings(
            5, 3, 0, 0.75D, 2D, 2, 5, 0D, 1D, 0.45D, 1D
    );

    @ConfigEntry.Gui.CollapsibleObject
    public TrunkPlacerSettings tallBirchTrunkSettings = new TrunkPlacerSettings(
            10, 10, 0, 0.75D, 2D, 2, 5, 0D, 1D, 0.45D, 1D
    );

    @ConfigEntry.Gui.CollapsibleObject
    public TrunkPlacerSettings deadLogSettings = new TrunkPlacerSettings(
            4, 6, 0, 0.25D, 2D, 2, 6, 0D, 1D, 0D, 1D
    );

    @Override
    public void validatePostLoad() throws ValidationException {
        List<IdWithWeight> allIdentifiers = new ArrayList<>(bushLeafTypes);
        allIdentifiers.addAll(bushWoodTypes);

        for (IdWithWeight idWithWeight : allIdentifiers) {
            Identifier id;
            try {
                id = new Identifier(idWithWeight.getId());
            } catch (InvalidIdentifierException e) {
                id = new Identifier("minecraft", idWithWeight.getId());
            }

            if (!Registry.BLOCK.containsId(id)) {
                throw new ValidationException("Block %s does not exist!".formatted(idWithWeight.getId()));
            }
        }

        if (!(
                validateTrunkPlacerSettings(oakTrunkSettings)
                        && validateTrunkPlacerSettings(birchTrunkSettings)
                        && validateTrunkPlacerSettings(tallBirchTrunkSettings)
                        && validateTrunkPlacerSettings(deadLogSettings)
                )) {
            throw new ValidationException("Invalid trunk placer settings!");
        }
    }

    private boolean validateTrunkPlacerSettings(TrunkPlacerSettings settings) {
        return settings.getBaseHeight() >= 0
                && settings.getFirstRandomHeight() >= 0
                && settings.getSecondRandomHeight() >= 0
                && settings.getBranchProbabilityModifier() >= 0 && settings.getBranchProbabilityModifier() <= 1
                && settings.getSubBranchProbabilityDivisor() != 0
                && settings.getBranchLengthModifier() >= 0
                && settings.getInitialBranchLengthModifier() >= 0
                && settings.getMinLeftBias() >= 0 && settings.getMinLeftBias() <= 1
                && settings.getMaxLeftBias() >= 0 && settings.getMaxLeftBias() <= 1
                && settings.getMaxLeftBias() >= settings.getMinLeftBias()
                && settings.getMinUpBias() >= 0 && settings.getMinUpBias() <= 1
                && settings.getMaxUpBias() >= 0 && settings.getMaxUpBias() <= 1
                && settings.getMaxUpBias() >= settings.getMinUpBias();
    }

    public static @Data @AllArgsConstructor class TrunkPlacerSettings {
        public int baseHeight;
        public int firstRandomHeight;
        public int secondRandomHeight;
        public double branchProbabilityModifier;
        public double subBranchProbabilityDivisor;
        public int branchLengthModifier;
        public int initialBranchLengthModifier;
        public double minLeftBias;
        public double maxLeftBias;
        public double minUpBias;
        public double maxUpBias;
    }

    public static @Data @AllArgsConstructor class IdWithWeight {
        public String id;
        public int weight;

        @SuppressWarnings("unused")
        public IdWithWeight() {
            this("CHANGE ME", 1);
        }
    }
}