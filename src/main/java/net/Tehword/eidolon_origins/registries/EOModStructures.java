package net.Tehword.eidolon_origins.registries;

import net.Tehword.eidolon_origins.Eidolon_origins;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;


public class EOModStructures {

    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE, Eidolon_origins.MODID);

    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECES = DeferredRegister.create(Registries.STRUCTURE_PIECE, Eidolon_origins.MODID);

    public static final RegistryObject<StructureType<EOEidorCrypt>> EIDOR_STRUCTURE = STRUCTURES.register("eidor_crypt", () -> explicitStructureTypeTyping(EOEidorCrypt.CODEC));

    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(Codec<T> structureCodec) {
        return () -> structureCodec;
    }

    private static RegistryObject<StructurePieceType> registerStructurePiece(String name, StructurePieceType structurePieceType) {
        return STRUCTURE_PIECES.register(name.toLowerCase(Locale.ROOT), () -> structurePieceType);
    }
}
