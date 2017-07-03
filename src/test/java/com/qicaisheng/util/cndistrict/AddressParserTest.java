package com.qicaisheng.util.cndistrict;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class AddressParserTest {
    @Test
    public void should_get_the_map_list_for_the_districts() throws Exception {
        AddressParser parser = AddressParser.getInstance();
        Map<String, String > map = parser.parse();

        Assert.assertEquals(3508, map.size());
        Assert.assertEquals("广东省", map.get("440000"));
        Assert.assertEquals("深圳市", map.get("440300"));
        Assert.assertEquals("南山区", map.get("440305"));
    }
}
