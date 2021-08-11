package joystick.test.mod;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TestMod implements ModInitializer {

	public static final Item NOTHING_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));

	public static final Block NOTHING_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F, 5.0F).sounds(BlockSoundGroup.HONEY).breakByTool(FabricToolTags.HOES).requiresTool());

	public static final Item NOTHING_FOOD = new Item(new Item.Settings().group(ItemGroup.FOOD).food(FoodComponents.NOTHING_FOOD));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

	Registry.register(Registry.ITEM, new Identifier("joysticktestmod", "nothing_item"), NOTHING_ITEM);

	Registry.register(Registry.BLOCK, new Identifier("joysticktestmod", "nothing_block"), NOTHING_BLOCK);
	Registry.register(Registry.ITEM, new Identifier("joysticktestmod", "nothing_block"), new BlockItem(NOTHING_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS)));

		Registry.register(Registry.ITEM, new Identifier("joysticktestmod", "nothing_food"), NOTHING_FOOD);
		

	}
}
