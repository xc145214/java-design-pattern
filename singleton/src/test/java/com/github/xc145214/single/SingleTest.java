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
package com.github.xc145214.single;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * @author xiachuan at 2017/4/21 16:34。
 */

public abstract class SingleTest<S> {

    /**
     * The singleton's getInstance method
     */
    private final Supplier<S> singletonInstanceMethod;

    /**
     * 创建一个单例测试实例。
     *
     * @param singletonInstanceMethod
     */
    public SingleTest(Supplier<S> singletonInstanceMethod) {
        this.singletonInstanceMethod = singletonInstanceMethod;
    }

    /**
     * Test the singleton in a non-concurrent setting
     */
    @Test
    public void testMultipleCallsReturnTheSameObjectInSameThread() {
        // Create several instances in the same calling thread
        S instance1 = this.singletonInstanceMethod.get();
        S instance2 = this.singletonInstanceMethod.get();
        S instance3 = this.singletonInstanceMethod.get();
        // now check they are equal
        assertSame(instance1, instance2);
        assertSame(instance1, instance3);
        assertSame(instance2, instance3);
    }

    /**
     * Test singleton instance in a concurrent setting
     */
    @Test(timeout = 10000)
    public void testMultipleCallsReturnTheSameObjectInDifferentThreads() throws Exception {

        // Create 10000 tasks and inside each callable instantiate the singleton class
        final List<Callable<S>> tasks = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            tasks.add(this.singletonInstanceMethod::get);
        }

        // Use up to 8 concurrent threads to handle the tasks
        final ExecutorService executorService = Executors.newFixedThreadPool(8);
        final List<Future<S>> results = executorService.invokeAll(tasks);

        // wait for all of the threads to complete
        final S expectedInstance = this.singletonInstanceMethod.get();
        for (Future<S> res : results) {
            final S instance = res.get();
            assertNotNull(instance);
            assertSame(expectedInstance, instance);
        }

        // tidy up the executor
        executorService.shutdown();

    }

}

