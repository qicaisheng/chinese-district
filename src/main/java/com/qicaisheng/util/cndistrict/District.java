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

        String cityCode = new StringBuilder(districtCode.substring(0,4)).append("00").toString();
        return map.get(cityCode);
    }

    public String getProvince(String districtCode) {
        if (districtCode.endsWith("00")) return null;

        Map<String, String> map = AddressParser.getInstance().parse();
        if (!map.containsKey(districtCode)) return null;

        String provinceCode = new StringBuilder(districtCode.substring(0,2)).append("0000").toString();
        return map.get(provinceCode);
    }

    public String getFullAddress(String districtCode) throws Exception {
        if (districtCode.endsWith("00")) return null;

        Map<String, String> map = AddressParser.getInstance().parse();
        if (!map.containsKey(districtCode)) return null;

        StringBuilder fullAddress = new StringBuilder();

        fullAddress.append(getProvince(districtCode)).append(getCity(districtCode)).append(get(districtCode));
        return fullAddress.toString();
    }
}
