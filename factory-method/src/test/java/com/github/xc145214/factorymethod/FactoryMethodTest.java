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
package com.github.xc145214.factorymethod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author xiachuan at 2017/4/25 15:06。
 */

public class FactoryMethodTest {

    @Test
    public void testOrcBlacksmithWithSpear() throws Exception {
        Blacksmith blacksmith = new OrcBlacksmith();
        Weapon weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        verifyWeapon(weapon, WeaponType.SPEAR, OrcWeapon.class);
    }

    /**
     * Testing {@link ElfBlacksmith} to produce a SHORT_SWORD asserting that the Weapon is an
     * instance of {@link ElfWeapon}.
     */
    @Test
    public void testElfBlacksmithWithShortSword() {
        Blacksmith blacksmith = new ElfBlacksmith();
        Weapon weapon = blacksmith.manufactureWeapon(WeaponType.SHORT_SWORD);
        verifyWeapon(weapon, WeaponType.SHORT_SWORD, ElfWeapon.class);
    }

    /**
     * Testing {@link ElfBlacksmith} to produce a SPEAR asserting that the Weapon is an instance
     * of {@link ElfWeapon}.
     */
    @Test
    public void testElfBlacksmithWithSpear() {
        Blacksmith blacksmith = new ElfBlacksmith();
        Weapon weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        verifyWeapon(weapon, WeaponType.SPEAR, ElfWeapon.class);
    }

    private void verifyWeapon(Weapon weapon, WeaponType expectedWeaponType, Class<?> clazz) {
        assertTrue("Weapon must be an object of: " + clazz.getName(), clazz.isInstance(weapon));
        assertEquals("Weapon must be of weaponType: " + clazz.getName(), expectedWeaponType,
                weapon.getWeaponType());
    }
}

