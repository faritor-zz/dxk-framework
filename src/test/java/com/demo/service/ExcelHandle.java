package com.demo.service;

import com.demo.mapper.ChannelMapper;
import com.demo.model.Channel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dxk on 2017/1/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelHandle {

    @Autowired
    private ChannelMapper channelMapper;

    @Test
    public void testReadExcel() {
        Long begin = System.currentTimeMillis();
        String path = "./渠道管理表.xls";
        readExcelToObj(path);
        Long end = System.currentTimeMillis();
        System.out.println("总共耗时：" + (end - begin));
    }

    /**
     * 读取excel数据
     */
    private void readExcelToObj(String path) {

        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(path));
            List<String> result = readExcel(wb, 0, 2, 0);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取excel文件
     *
     * @param sheetIndex    sheet页下标：从0开始
     * @param startReadLine 开始读取的行:从0开始
     * @param tailLine      去除最后读取的行
     */
    private List readExcel(Workbook wb, int sheetIndex, int startReadLine, int tailLine) {
        Sheet sheet = wb.getSheetAt(sheetIndex);
        Row row = null;

        List<String> list = new ArrayList<>();

        for (int i = startReadLine; i < sheet.getLastRowNum() - tailLine + 1; i++) {
            row = sheet.getRow(i);
            Channel channel = new Channel();
            for (Cell c : row) {
                boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
                String cellValue = "";
                if (isMerge) {//判断是否具有合并单元格
                    cellValue = getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());
                } else {
                    cellValue = c.getRichStringCellValue().toString();
                }
                if (c.getColumnIndex() == 1) {
                    channel.setDepart(cellValue);
                } else if (c.getColumnIndex() == 2) {
                    channel.setClazz(cellValue);
                } else if (c.getColumnIndex() == 3) {
                    channel.setSection(cellValue);
                } else if (c.getColumnIndex() == 4) {
                    channel.setChannelName(cellValue);
                } else if (c.getColumnIndex() == 5) {
                    channel.setChannelNo(cellValue);
                } else if (c.getColumnIndex() == 6) {
                    channel.setDescription(cellValue);
                }
            }
            list.add(channel.getChannelNo()+"="+channel.getChannelName());
//            channelMapper.saveChannel(channel);
//            System.out.println(channel.toString());
        }
        return list;
    }

    /**
     * 获取合并单元格的值
     */
    public String getMergedRegionValue(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {

                if (column >= firstColumn && column <= lastColumn) {
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell);
                }
            }
        }
        return null;
    }

    /**
     * 判断合并了行
     */
    private boolean isMergedRow(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row == firstRow && row == lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     *
     * @param row    行下标
     * @param column 列下标
     */
    private boolean isMergedRegion(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断sheet页中是否含有合并单元格
     */
    private boolean hasMerged(Sheet sheet) {
        return sheet.getNumMergedRegions() > 0 ? true : false;
    }

    /**
     * 合并单元格
     *
     * @param firstRow 开始行
     * @param lastRow  结束行
     * @param firstCol 开始列
     * @param lastCol  结束列
     */
    private void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
    }

    /**
     * 获取单元格的值
     */
    public String getCellValue(Cell cell) {
        if (cell == null) return "";
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return cell.getCellFormula();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        }
        return "";
    }
}
