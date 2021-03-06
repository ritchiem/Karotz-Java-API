/*
 * The MIT License
 *
 * Copyright (c) 2011, Seiji Sogabe
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.peripheralware.karotz.action;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;
import org.junit.Test;
import org.peripheralware.karotz.action.led.LedColor;
import org.peripheralware.karotz.action.led.LedLightAction;

/**
 * Test for LedLightAction
 *
 * @author Seiji Sogabe <s.sogabe@gmail.com>
 * @author Martin Ritchie
 */
public class LedLightActionTest {

    @Test
    public void testGetParameters_setNullString_actionIsSetNoColor() {
        LedLightAction action = new LedLightAction((String)null);

        Map<String, String> params = action.getParameters();
        assertThat(params).isNotNull();

        assertThat(params.size()).isEqualTo(1);
        assertThat(params.get("action")).isEqualTo("light");
        assertThat(params.get("color")).isNull();
    }

    @Test
    public void testGetParameters_setViaString_setsColor() {
        LedLightAction action = new LedLightAction("FF0000");

        Map<String, String> params = action.getParameters();
        assertThat(params).isNotNull();

        assertThat(params.size()).isEqualTo(2);
        assertThat(params.get("action")).isEqualTo("light");
        assertThat(params.get("color")).isEqualTo("FF0000");

    }

    @Test
    public void testGetParameters_setViaLedColor_setsColorAsString() {
        LedLightAction action = new LedLightAction(LedColor.RED);

        Map<String, String> params = action.getParameters();
        assertThat(params).isNotNull();

        assertThat(params.size()).isEqualTo(2);
        assertThat(params.get("action")).isEqualTo("light");
        assertThat(params.get("color")).isEqualTo("FF0000");
    }
}
