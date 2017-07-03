package com.qicaisheng.util.cndistrict;

import java.util.Map;

public class District {
    public static District getInstance() {
        return new District();
    }

    private District() {
    }

    public String get(String code) throws Exception {
        if (code.endsWith("00")) return null;

        Map<String, String> map = AddressParser.getInstance().parse();
        if (!map.containsKey(code)) return null;

        return map.get(code);
    }

    public String getCity(String districtCode) {
        if (districtCode.endsWith("00")) return null;

        Map<String, String> map = AddressParser.getInstance().parse();
        if (!map.containsKey(districtCode)) return null;

        String cityCode = districtCode.substring(4,6).concat("00");
        return map.get(cityCode);
    }
}
