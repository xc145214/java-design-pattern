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
package com.github.xc145214.singleton;

/**
 * Singleton class. Eagerly initialized static instance guarantees thread safety.
 * 线程安全。
 *
 * @author xiachuan at 2017/4/21 15:21。
 */

public final class IvoryTower {
    /**
     * Private constructor so nobody can instantiate the class.
     */
    private IvoryTower() {}

    /**
     * Static to class instance of the class.
     */
    private static final IvoryTower INSTANCE = new IvoryTower();

    /**
     * To be called by user to obtain instance of the class.
     *
     * @return instance of the singleton.
     */
    public static IvoryTower getInstance() {
        return INSTANCE;
    }

}

