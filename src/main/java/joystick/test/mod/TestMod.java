/*

Welcome to JoystickTestMod

*/

package joystick.test.mod;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.Feature;

public class TestMod implements ModInitializer {

	public static final Item NOTHING_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));

	public static final Block NOTHING_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F, 5.0F).sounds(BlockSoundGroup.HONEY).breakByTool(FabricToolTags.HOES).requiresTool());

	public static final Item NOTHING_FOOD = new Item(new Item.Settings().group(ItemGroup.FOOD).food(FoodComponents.NOTHING_FOOD));

	public static final Block NOTHING_ORE = new NothingOre(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.ANVIL).breakByTool(FabricToolTags.PICKAXES).requiresTool());

	private static ConfiguredFeature<?, ?> NOTHING_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NOTHING_ORE.getDefaultState(),9)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(120)))).spreadHorizontally().repeat(20);

	@Override
	public void onInitialize() {


	// Registry for Items
		// Registering Nothing_Item
		Registry.register(Registry.ITEM, new Identifier("joysticktestmod", "nothing_item"), NOTHING_ITEM);


		// Registering Nothing_Block
		Registry.register(Registry.BLOCK, new Identifier("joysticktestmod", "nothing_block"), NOTHING_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("joysticktestmod", "nothing_block"), new BlockItem(NOTHING_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS)));


		// Registering Nothing_Food
		Registry.register(Registry.ITEM, new Identifier("joysticktestmod", "nothing_food"), NOTHING_FOOD);
		
		// Registering Nothing_Ore
		Registry.register(Registry.BLOCK, new Identifier("joysticktestmod", "nothing_ore"), NOTHING_ORE);
		Registry.register(Registry.ITEM, new Identifier("joysticktestmod", "nothing_ore"), new BlockItem(NOTHING_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		RegistryKey<ConfiguredFeature<?, ?>> nothingOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("joysticktestmod", "nothing_ore"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, nothingOreOverworld.getValue(), NOTHING_ORE_OVERWORLD);
		// BiomeModifications is not supported right now, so it identifies as deprecated.
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, nothingOreOverworld);

	}
}
