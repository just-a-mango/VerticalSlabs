package com.mango.verticalslabs;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.function.Predicate;

public class VerticalSlabBlock extends Block {
    public static final BooleanProperty SIDED = BooleanProperty.of("sided");
    public static final Logger LOGGER = LogManager.getLogger("verticalslabs");

    public VerticalSlabBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(SIDED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.isHolding(VerticalSlabsItems.WRENCH_ITEM)) {
            player.playSound(SoundEvents.BLOCK_SCAFFOLDING_HIT, 1, 1);
            if(world.getBlockState(pos).get(SIDED)) {
                world.setBlockState(pos, state.with(SIDED, false));
                ItemStack itemStack = player.getStackInHand(hand);
                itemStack.damage(2, player, (p) -> {
                    p.sendToolBreakStatus(hand);
                });
                return ActionResult.SUCCESS;

            }
            else {
                world.setBlockState(pos, state.with(SIDED, true));
                ItemStack itemStack = player.getStackInHand(hand);
                itemStack.damage(2, player, (p) -> {
                    p.sendToolBreakStatus(hand);
                });
                return ActionResult.SUCCESS;

            }
        }
        else {
            return ActionResult.SUCCESS;
        }
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if(state.get(SIDED)) {
            LOGGER.info("SIDED TRUE");
            return VoxelShapes.cuboid(0, 0, 0, 1, 0.5, 1);
        }
        else {
            return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 1f, 0.5f);
        }
    }
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(SIDED);
    }
}
