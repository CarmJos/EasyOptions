/*
 * This file is part of EasyOptions, licensed under the MIT License.
 *
 * Copyright (c) 2024 Carm
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package cc.carm.tests.easyoptions;

import cc.carm.lib.easyoptions.OptionHolder;
import org.junit.Assert;
import org.junit.Test;

public class OptionTest {


    @Test
    public void test() {

        // Create holder
        OptionHolder holder = OptionHolder.createOptionHolder();

        // Get options if not set
        String separator = holder.get(DemoOptions.SEPARATOR);
        System.out.println(separator);
        Assert.assertTrue(DemoOptions.SEPARATOR.isDefault(separator));

        // Set value
        holder.set(DemoOptions.SEPARATOR, ":-)");
        Assert.assertEquals(":-)", holder.get(DemoOptions.SEPARATOR));

        // Set value to default
        String previous = holder.set(DemoOptions.SEPARATOR, null);
        Assert.assertTrue(DemoOptions.SEPARATOR.isDefault(holder.get(DemoOptions.SEPARATOR)));
        Assert.assertEquals(":-)", previous);
        System.out.println(previous);
    }


}
