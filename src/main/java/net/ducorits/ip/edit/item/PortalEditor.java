package net.ducorits.ip.edit.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import qouteall.imm_ptl.core.portal.Portal;

public class PortalEditor extends Item {
    public PortalEditor(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
//        Vec3d vec3d = user.getRotationVec(1.0f);
//        double f = user.getX() - (user.getX() - vec3d.x * 4.0);
////        double g = user.getBodyY(0.5) - (0.5 +
//        double g = user.getY() - (user.getY() - vec3d.y * 4.0);
//        double h = user.getZ() - (user.getZ() - vec3d.z * 4.0);
//        FireballEntity fireballEntity = new FireballEntity(world, user, f, g, h, 1);
//        fireballEntity.setPosition(user.getX() + vec3d.x * 2.0, user.getBodyY(.9) + vec3d.y * 2.0, fireballEntity.getZ() + vec3d.z * 2.0);
//        world.spawnEntity(fireballEntity);

        Vec3d vec3d = user.getRotationVec(1.0f);
        double x = user.getX() + (vec3d.x * 2.0);
//        double g = user.getBodyY(0.5);
        double y = user.getY() + (vec3d.y * 2.0);
        double z = user.getZ() + (vec3d.z * 2.0);
        Portal portal = Portal.entityType.create(world);
        portal.setOriginPos(new Vec3d(x, y, z));
        portal.setDestinationDimension(World.NETHER);
        portal.setDestination(new Vec3d(z / 8, (y + 88) / 3.3, x / 8));
        portal.setOrientationAndSize(
                new Vec3d(1, 0, 0), // axisW
                new Vec3d(0, 1, 0), // axisH
                4, // width
                4 // height
        );
        portal.world.spawnEntity(portal);
        if (!world.isClient) {
            user.sendMessage(new LiteralText("x:" + x + " y:" + y + " z:" + z), false);
            user.sendMessage(new LiteralText("AXISW vecx:" + vec3d.z + " vecy:" + vec3d.y + " vecz:" + vec3d.x * -1), false);
            user.sendMessage(new LiteralText("AXISH vecx:" + vec3d.y + " vecy:" + vec3d.x * -1 + " vecz:" + vec3d.z), false);
            user.sendMessage(new LiteralText("Vector vecx:" + vec3d.x + " vecy:" + vec3d.y + " vecz:" + vec3d.z), false);
        }

        return TypedActionResult.success(itemStack, true);
    }
}
