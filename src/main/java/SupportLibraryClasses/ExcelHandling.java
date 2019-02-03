package SupportLibraryClasses;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.thucydides.core.pages.PageObject;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExcelHandling extends PageObject implements ReportHandling {

	/**
	 * @param args
	 */

	static int i = 0;
	static Calendar cal = Calendar.getInstance();
	static Date date = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	static String systemdate = dateFormat.format(date);
	String folderdirectory = "C:\\TestResultImages";
	File deletefolderfiles = new File(folderdirectory);
	String Filepath = folderdirectory+ "\\Report" + systemdate + ".xlsx";
	String ImagePath = "C:\\TestResultImages\\";
	
	public void screenShot() {
		try {
			File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String FullAddress = ImagePath + i + ".PNG";
			FileUtils.copyFile(scrFile, new File(FullAddress));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void resultstatus(String x, String y, status z) {		
		if (i == 0) {
			try {
				FileUtils.cleanDirectory(deletefolderfiles);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Test Result");
			Row row = sheet.createRow(i);
			String[] headers = { "Test Step", "Description", "Status" };
			for (int j = 0; j < 3; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(headers[j]);
			}
			Row row1 = sheet.createRow(++i);
			String[] headers1 = { x, y, z.toString() };
			for (int j = 0; j < 3; j++) {
				Cell cell = row1.createCell(j);
				if (headers1[j].equalsIgnoreCase("Pass")) {
					workbook.createCellStyle();
					CreationHelper createHelper = workbook.getCreationHelper();
					CellStyle hlink_style = workbook.createCellStyle();
					Font hlink_font = workbook.createFont();
					hlink_font.setUnderline(Font.U_SINGLE);
					hlink_font.setColor(IndexedColors.GREEN.getIndex());
					screenShot();
					hlink_style.setFont(hlink_font);
					String FullAddress = ImagePath + i + ".PNG";
					File f2 = new File(FullAddress);
					String windowsPath = f2.toURI().toString();
					Hyperlink hp = createHelper.createHyperlink(Hyperlink.LINK_FILE);
					hp.setAddress(windowsPath);
					cell.setHyperlink(hp);
					cell.setCellStyle(hlink_style);

					cell.setCellValue(headers1[j]);
				} else if (headers1[j].equalsIgnoreCase("Fail")) {
					workbook.createCellStyle();
					CreationHelper createHelper = workbook.getCreationHelper();
					CellStyle hlink_style = workbook.createCellStyle();
					Font hlink_font = workbook.createFont();
					hlink_font.setUnderline(Font.U_SINGLE);
					hlink_font.setColor(IndexedColors.RED.getIndex());
					screenShot();
					hlink_style.setFont(hlink_font);
					String FullAddress = ImagePath + i + ".PNG";
					File f2 = new File(FullAddress);
					String windowsPath = f2.toURI().toString();
					Hyperlink hp = createHelper.createHyperlink(Hyperlink.LINK_FILE);
					hp.setAddress(windowsPath);
					cell.setHyperlink(hp);
					cell.setCellStyle(hlink_style);

					cell.setCellValue(headers1[j]);
				} else {
					cell.setCellValue(headers1[j]);
				}
			}
			try {
				FileOutputStream out = new FileOutputStream(new File(Filepath));
				workbook.write(out);
				out.close();
				System.out.println("AMS Automation Report.xlsx Successfully created");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			XSSFWorkbook workbook1;
			try {
				FileInputStream out1 = new FileInputStream(new File(Filepath));
				workbook1 = new XSSFWorkbook(out1);
				XSSFSheet sheet1 = workbook1.getSheetAt(0);
				Row row = sheet1.createRow(i);
				String[] headers = { x, y, z.toString() };
				for (int j = 0; j < 3; j++) {
					Cell cell = row.createCell(j);
					if (headers[j].equalsIgnoreCase("Pass")) {
						workbook1.createCellStyle();
						CreationHelper createHelper = workbook1.getCreationHelper();
						CellStyle hlink_style = workbook1.createCellStyle();
						Font hlink_font = workbook1.createFont();
						hlink_font.setUnderline(Font.U_SINGLE);
						hlink_font.setColor(IndexedColors.GREEN.getIndex());
						screenShot();
						hlink_style.setFont(hlink_font);
						String FullAddress = ImagePath + i + ".PNG";
						File f2 = new File(FullAddress);
						String windowsPath = f2.toURI().toString();
						Hyperlink hp = createHelper.createHyperlink(Hyperlink.LINK_FILE);
						hp.setAddress(windowsPath);
						cell.setHyperlink(hp);
						cell.setCellStyle(hlink_style);

						cell.setCellValue(headers[j]);
					} else if (headers[j].equalsIgnoreCase("Fail")) {
						workbook1.createCellStyle();
						CreationHelper createHelper = workbook1.getCreationHelper();
						CellStyle hlink_style = workbook1.createCellStyle();
						Font hlink_font = workbook1.createFont();
						hlink_font.setUnderline(Font.U_SINGLE);
						hlink_font.setColor(IndexedColors.RED.getIndex());
						screenShot();
						hlink_style.setFont(hlink_font);
						String FullAddress = ImagePath + i + ".PNG";
						File f2 = new File(FullAddress);
						String windowsPath = f2.toURI().toString();
						Hyperlink hp = createHelper.createHyperlink(Hyperlink.LINK_FILE);
						hp.setAddress(windowsPath);
						cell.setHyperlink(hp);
						cell.setCellStyle(hlink_style);

						cell.setCellValue(headers[j]);
					} else {

						cell.setCellValue(headers[j]);
					}

				}
				out1.close();
				FileOutputStream out = new FileOutputStream(new File(Filepath));
				workbook1.write(out);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		i++;

	}

	public enum status {
		Pass, Fail, Done, Warning, Debug;
	}

}
