package com.example.springboot.excelutil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class ExcelExport {

    private List<Map<String, String>> getListFromHBase() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("mainModule", "办事窗");
        map1.put("subModule", "因私出境");
        map1.put("clickNum", "1500");
        Map<String, String> map2 = new HashMap<>();
        map2.put("mainModule", "办事窗");
        map2.put("subModule", "信息变更");
        map2.put("clickNum", "1000");
        Map<String, String> map3 = new HashMap<>();
        map3.put("mainModule", "办事窗");
        map3.put("subModule", "收入证明");
        map3.put("clickNum", "800");
        List<Map<String, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);

        return list;

    }

    private List<ExportInfo> getList() {
        List<ExportInfo> list = new ArrayList<>();
        List<Map<String, String>> data = getListFromHBase();
        for (Map<String, String> map : data) {
            ExportInfo exportInfo = new ExportInfo(map.get("mainModule"), map.get("subModule"), map.get("clickNum"));
            list.add(exportInfo);
        }
        return list;
    }

    @GetMapping("/download.htm")
    public void writeExcel(HttpServletResponse response) {
        List<ExportInfo> list = getList();
        String fileName = "test";
        String sheetName = "sheetOne";
        ExcelUtil.writeExcelWithSheets(response, list, fileName, sheetName, new ExportInfo());
    }
}