package cc.carm.tests.easyoptions;

import cc.carm.lib.easyoptions.OptionHolder;
import org.junit.Assert;
import org.junit.Test;

public class OptionTest {


    @Test
    public void test() {

        // Create holder
        OptionHolder holder = new OptionHolder();

        // Get options if not set
        String separator = holder.get(DemoOptions.SEPARATOR);
        Assert.assertTrue(DemoOptions.SEPARATOR.isDefault(separator));

        // Set value
        holder.set(DemoOptions.SEPARATOR, ":-)");
        Assert.assertEquals(":-)", holder.get(DemoOptions.SEPARATOR));

        // Set value to default
        String previous = holder.set(DemoOptions.SEPARATOR, null);
        Assert.assertTrue(DemoOptions.SEPARATOR.isDefault(holder.get(DemoOptions.SEPARATOR)));
        Assert.assertEquals(":-)", previous);
    }


}
