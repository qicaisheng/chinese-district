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

    @Test
    public void should_get_province_via_district_code() {
        District district = District.getInstance();

        Assert.assertEquals(null, district.getProvince("440000"));
        Assert.assertEquals(null, district.getProvince("error code"));
        Assert.assertEquals("广东省", district.getProvince("440305"));
    }

    @Test
    public void should_get_full_address_via_district_code() throws Exception {
        District district = District.getInstance();

        Assert.assertEquals(null, district.getFullAddress("440000"));
        Assert.assertEquals(null, district.getFullAddress("error code"));
        Assert.assertEquals("广东省深圳市南山区", district.getFullAddress("440305"));
    }
}
