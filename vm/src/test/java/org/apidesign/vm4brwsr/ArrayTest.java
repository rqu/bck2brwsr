/**
 * Back 2 Browser Bytecode Translator
 * Copyright (C) 2012 Jaroslav Tulach <jaroslav.tulach@apidesign.org>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://opensource.org/licenses/GPL-2.0.
 */
package org.apidesign.vm4brwsr;

import javax.script.Invocable;
import javax.script.ScriptException;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Jaroslav Tulach <jtulach@netbeans.org>
 */
public class ArrayTest {
    @Test public void verifySimpleIntOperation() throws Exception {
            assertExec("CheckTheSum", Array.class, "simpleI", 
            Double.valueOf(15)
        );
    }
    
    @Test public void realOperationOnArrays() throws Exception {
        assertEquals(Array.sum(), 105.0, "Computes to 105");
    }
    
    @Test public void verifyOperationsOnArrays() throws Exception {
        assertExec("The sum is 105", Array.class, "sumD", 
            Double.valueOf(105)
        );
    }
    
    @Test public void doesCopyArrayWork() throws Exception {
        assertExec("Returns 'a'", Array.class, "copyArrayC", Double.valueOf('a'));
    }
    
    private static CharSequence codeSeq;
    private static Invocable code;
    
    @BeforeClass 
    public void compileTheCode() throws Exception {
        StringBuilder sb = new StringBuilder();
        code = StaticMethodTest.compileClass(sb, 
            "org/apidesign/vm4brwsr/Array"
        );
        codeSeq = sb;
    }
    private static void assertExec(String msg, Class clazz, String method, Object expRes, Object... args) throws Exception {
        StaticMethodTest.assertExec(code, codeSeq, msg, clazz, method, expRes, args);
    }
}
