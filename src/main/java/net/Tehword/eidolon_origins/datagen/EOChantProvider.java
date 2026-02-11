package net.Tehword.eidolon_origins.datagen;

import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.api.spells.Spell;
import elucent.eidolon.datagen.SimpleDataProvider;
import elucent.eidolon.recipe.ChantRecipe;
import elucent.eidolon.registries.Signs;
import net.Tehword.eidolon_origins.registries.EOsigns;
import net.Tehword.eidolon_origins.registries.EOspells;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EOChantProvider  extends SimpleDataProvider {
    List<ChantRecipe> chants = new ArrayList();

    public EOChantProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    public void collectJsons(CachedOutput pOutput) {
        this.addChants();

        for(ChantRecipe recipe : this.chants) {
            Path path = getRecipePath(this.output, recipe.getId().getPath());
            this.saveStable(pOutput, recipe.toJson(), path);
        }

    }
    protected void addChants() {
        this.addChant(EOspells.LIGHT3, EOsigns.CHAOS_SIGN);
        this.addChant(EOspells.FURRY, Signs.SOUL_SIGN);

    }

    private void addChant(ChantRecipe spell) {
        this.chants.add(spell);
    }

    private void addChant(Spell spell, Sign... signs) {
        this.chants.add(new ChantRecipe(spell.getRegistryName(), List.of(signs)));
    }

    public @NotNull String getName() {
        return "Eidolon Chants";
    }

    protected static Path getRecipePath(Path pathIn, Spell spell) {
        return getRecipePath(pathIn, spell.getRegistryName().getPath());
    }

    protected static Path getRecipePath(Path pathIn, String str) {
        return pathIn.resolve("data/eidolon/recipes/" + str + ".json");
    }
}
