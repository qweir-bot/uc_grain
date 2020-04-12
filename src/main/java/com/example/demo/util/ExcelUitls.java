package com.example.demo.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.*;

/**
 * @author baitao
 * @time 2019/9/17
 */
public class ExcelUitls {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUitls.class);

    public static File writeExcel(String uuid, List<Map<String, Object>> beans, String needString, String needWord) throws Exception {
        ExportHelper exportHelper = new ExportHelper();
        File tempFile = new File(uuid);
        FileOutputStream stream = null;
        try {
            List<Map<String, Object>> processList_new = new ArrayList<>();
            String[] needs = needString.split(",");
            String[] needWords = needWord.split(",");
            if (CollectionUtils.isEmpty(beans)) {
                Map<String, Object> map = new LinkedHashMap<String, Object>();
                for (int i = 0; i < needs.length; i++) {
                    map.put(needWords[i].trim(), "");
                }
                processList_new.add(map);
            } else {
                for (Map<String, Object> processMap : beans) {
                    Map<String, Object> map = new LinkedHashMap<String, Object>();
                    for (int i = 0; i < needs.length; i++) {
                        Object value = processMap.get(needs[i].trim());
                        if (value != null) {
                            if(value instanceof Date){
                                Object value1 = DateFormatUtils.format((Date)value, "yyyy-MM-dd HH:mm:ss");
                                map.put(needWords[i].trim(), value1);
                            } else{
                                map.put(needWords[i].trim(), value);
                            }
                        } else {
                            map.put(needWords[i].trim(), "");
                        }
                    }
                    processList_new.add(map);
                }
            }
            XSSFWorkbook wb = exportHelper.ExportExcel(processList_new, "process");
            stream = FileUtils.openOutputStream(tempFile);
            wb.write(stream);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (null != stream) {
                stream.close();
            }
        }
        return tempFile;
    }

    public static void readEXCEL2003(InputStream stream, List<List<Map<String, Object>>> result, String[][] cellNamesArray) throws IOException {
        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(stream);
        }catch(Exception e){
            throw new IOException("解析文件失败，请通知管理员！",e);
        }
        int cellNamesSize = ArrayUtils.getLength(cellNamesArray);
        for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
            if (numSheets >= cellNamesSize) {
                break;
            }
            String[] cellNameArray = cellNamesArray[numSheets];
            int cellNameSize = ArrayUtils.getLength(cellNameArray);
            Sheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
            List<Map<String, Object>> list = new ArrayList<>();
            for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
                Map<String, Object> rowMap = new HashMap<>();
                Row aRow = aSheet.getRow(rowNumOfSheet);    // 获得一个行
                if(null == aRow){
                    continue;
                }
                for (short cellNumOfRow = 0; cellNumOfRow <= aRow
                        .getLastCellNum(); cellNumOfRow++) {
                    if (cellNumOfRow >= cellNameSize) {
                        break;
                    }
                    String cellName = cellNameArray[cellNumOfRow];
                    Cell aCell = aRow.getCell(cellNumOfRow);// 获得列值
                    String value = convertCell(aCell);
                    rowMap.put(cellName, value);
                }
                list.add(rowMap);
            }
            result.add(list);
        }
        workbook.close();
    }

    public static void readEXCEL2007(InputStream stream, List<List<Map<String, Object>>> result, String[][] cellNamesArray) throws IOException {
        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(stream);
        }catch(Exception e){
            throw new IOException("解析文件失败，请通知管理员！",e);
        }
        int cellNamesSize = ArrayUtils.getLength(cellNamesArray);
        for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
            if (numSheets >= cellNamesSize) {
                break;
            }
            String[] cellNameArray = cellNamesArray[numSheets];
            int cellNameSize = ArrayUtils.getLength(cellNameArray);
            Sheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
            List<Map<String, Object>> list = new ArrayList<>();
            for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
                Map<String, Object> rowMap = new HashMap<>();
                Row aRow = aSheet.getRow(rowNumOfSheet);    // 获得一个行
                if(null == aRow){
                    continue;
                }
                for (short cellNumOfRow = 0; cellNumOfRow <= aRow
                        .getLastCellNum(); cellNumOfRow++) {
                    if (cellNumOfRow >= cellNameSize) {
                        break;
                    }
                    String cellName = cellNameArray[cellNumOfRow];
                    Cell aCell = aRow.getCell(cellNumOfRow);// 获得列值
                    String value = convertCell(aCell);
                    rowMap.put(cellName, value);
                }
                list.add(rowMap);
            }
            result.add(list);
        }
        workbook.close();
    }

    private static String convertCell(Cell cell) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        String cellValue = StringUtils.EMPTY;
        if (cell == null) {
            return cellValue;
        }
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                cellValue = numberFormat.format(cell.getNumericCellValue());
                // 判断是日期类型 避免读取excel文件中的日期格式数据被转换成数字
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    cellValue = DateFormatUtils.format(date, "yyyy-MM-dd");
                }
                break;
            case HSSFCell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                cellValue = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = Boolean.toString(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                cellValue = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                cellValue = StringUtils.EMPTY;
        }
        return StringUtils.trim(cellValue);
    }

}
