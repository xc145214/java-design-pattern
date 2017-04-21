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
 * Thread-safe Singleton class. The instance is lazily initialized and thus needs synchronization
 * mechanism.
 * <p>
 * Note: if created by reflection then a singleton will not be created but multiple options in the
 * same classloader
 *
 * @author xiachuan at 2017/4/21 16:06。
 */

public final class ThreadSafeLazyLoadedIvoryTower {

    private static ThreadSafeLazyLoadedIvoryTower instance;

    private ThreadSafeLazyLoadedIvoryTower() {
    }

    /**
     * The instance gets created only when it is called for first time. Lazy-loading
     */
    public static synchronized ThreadSafeLazyLoadedIvoryTower getInstance() {

        if (instance == null) {
            instance = new ThreadSafeLazyLoadedIvoryTower();
        }

        return instance;
    }

}

