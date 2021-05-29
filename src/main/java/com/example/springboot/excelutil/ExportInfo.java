package com.example.springboot.excelutil;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class ExportInfo extends BaseRowModel {
    @ExcelProperty(value = "业务模块" ,index = 0)
    private String mainModule;

    @ExcelProperty(value = "子模块",index = 1)
    private String subModule;

    @ExcelProperty(value = "点击量",index = 2)
    private String clickNum ;

    public ExportInfo(String mainModule, String subModule, String clickNum) {
        this.mainModule = mainModule;
        this.subModule = subModule;
        this.clickNum = clickNum;
    }

    public ExportInfo() {
    }
}
