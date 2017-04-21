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

import com.github.xc145214.singleton.InitializingOnDemandHolderIdiom;


/**
 * XXXXXXXXXXXXXXXXXXXXX
 *
 * @author xiachuan at 2017/4/21 16:43。
 */

public class InitializingOnDemandHolderIdiomTest extends SingleTest<InitializingOnDemandHolderIdiom> {

    public InitializingOnDemandHolderIdiomTest() {
        super(InitializingOnDemandHolderIdiom::getInstance);
    }
}

