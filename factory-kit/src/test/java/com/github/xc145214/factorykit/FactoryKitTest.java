/*************************************************************************
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *
 *                COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 *    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *************************************************************************/
package com.github.xc145214.factorykit;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * @author xiachuan at 2017/4/21 17:37。
 */

public class FactoryKitTest {

    private WeaponFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = WeaponFactory.factory(builder -> {
            builder.add(WeaponType.SPEAR, Spear::new);
            builder.add(WeaponType.AXE, Axe::new);
            builder.add(WeaponType.BOW, Bow::new);
            builder.add(WeaponType.SWORD, Sword::new);
        });
    }

    @Test
    public void testSpearWeapon() throws Exception {

        Weapon weapon = factory.create(WeaponType.SPEAR);
        verifyWeapon(weapon, Spear.class);
    }

    @Test
    public void testAxeWeapon() throws Exception {
        Weapon weapon = factory.create(WeaponType.AXE);
        verifyWeapon(weapon, Axe.class);
    }

    @Test
    public void testBowWeapon() throws Exception {
        Weapon weapon = factory.create(WeaponType.BOW);
        verifyWeapon(weapon, Bow.class);
    }

    @Test
    public void testSwordWeapon() throws Exception {
        Weapon weapon = factory.create(WeaponType.SWORD);
        verifyWeapon(weapon, Sword.class);
    }

    /**
     * This method asserts that the weapon object that is passed is an instance of the clazz
     *
     * @param weapon weapon object which is to be verified
     * @param clazz  expected class of the weapon
     */
    private void verifyWeapon(Weapon weapon, Class clazz) {
        assertTrue("Weapon must be an object of: " + clazz.getName(), clazz.isInstance(weapon));
    }
}

