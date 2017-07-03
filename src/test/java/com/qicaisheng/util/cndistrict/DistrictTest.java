package com.qicaisheng.util.cndistrict;

import org.junit.Assert;
import org.junit.Test;

public class DistrictTest {
    @Test
    public void should_get_district_via_code() throws Exception {
        District district = District.getInstance();

        Assert.assertEquals(null, district.get("440000"));
        Assert.assertEquals(null, district.get("error code"));
        Assert.assertEquals("南山区", district.get("440305"));
    }

    @Test
    public void should_get_city_via_district_code() {
        District district = District.getInstance();


        Assert.assertEquals(null, district.getCity("440000"));
        Assert.assertEquals(null, district.getCity("error code"));
        Assert.assertEquals("深圳市", district.getCity("440305"));
    }
}
