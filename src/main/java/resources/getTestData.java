package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getTestData {
	public String Excel_Data = "D:\\TA\\SalesForce\\Testdata.xlsx";
	public int sheet = 0;
	public int rn = 4;
	public int column = 1;
	
	public String Accountname;
	public String Telefon;
	public String Accountame2;
	public String Fax;
	public String Umsatzsteueridentifikationsnummer;
	public String FirmenEmailAdresse;
	public String WeitereSteuernummer;
	public String Website;
	public String Kundentyp;
	public String Partnertyp;
	public String KeyAccountName;
	public String Rechtsform;
	public String KeyAccountNummer;
	public String MilitaerischerEndkunde;
	public String Beschreibung;
	public String Land;
	public String Strasse;
	public String Stadt;
	public String Bundesland;
	public String PLZ;
	public String SAPStrasse1;
	public String SAPHausnummer;
	public String BezirksGebietsname;
	public String BezirksGebietsnummer;
	public String PrimaereBranche;
	public String SekundaereBranche;
	public String PrimaereSubbranche;
	public String SekundaereSubbranche;
	public String Applikationssegment;
	public String FuhrparkgroesseTruck;
	public String KontaktklasseTruck;
	public String MANFleetShare;
	public String Datenspeicherung;
	public String Datenweitergabe;
	public String Marketing;
	public String OebergeordneterAccount;
	public String Rahmenvertragsnummer;
	public String FuhrparkgroesseUnternehmensgruppe;
	public String Rahmenvertragsname;
	public String SAPSyncState;

	public HashMap getTestDataoriginal() throws FileNotFoundException, IOException {
		HashMap<String, String> tdmap = new HashMap<String, String>();
		FileInputStream Exfile = null;
		Exfile = new FileInputStream(new File(Excel_Data));
		XSSFWorkbook workbook = new XSSFWorkbook(Exfile);
		XSSFSheet worksheet = workbook.getSheetAt(sheet);
		XSSFRow row = worksheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Accountname", cell.getStringCellValue());
		} else {
			tdmap.put("Accountname", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Telefon", cell.getStringCellValue());
		} else {
			tdmap.put("Telefon", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Accountame2", cell.getStringCellValue());
		} else {
			tdmap.put("Accountame2", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Fax", cell.getStringCellValue());
		} else {
			tdmap.put("Fax", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Umsatzsteueridentifikationsnummer", cell.getStringCellValue());
		} else {
			tdmap.put("Umsatzsteueridentifikationsnummer", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("FirmenEmailAdresse", cell.getStringCellValue());
		} else {
			tdmap.put("FirmenEmailAdresse", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("WeitereSteuernummer", cell.getStringCellValue());
		} else {
			tdmap.put("WeitereSteuernummer", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Website", cell.getStringCellValue());
		} else {
			tdmap.put("Website", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Kundentyp", cell.getStringCellValue());
		} else {
			tdmap.put("Kundentyp", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Partnertyp", cell.getStringCellValue());
		} else {
			tdmap.put("Partnertyp", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("KeyAccountName", cell.getStringCellValue());
		} else {
			tdmap.put("KeyAccountName", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Rechtsform", cell.getStringCellValue());
		} else {
			tdmap.put("Rechtsform", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("KeyAccountNummer", cell.getStringCellValue());
		} else {
			tdmap.put("KeyAccountNummer", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Milit�rischerEndkunde", cell.getStringCellValue());
		} else {
			tdmap.put("Milit�rischerEndkunde", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Beschreibung", cell.getStringCellValue());
		} else {
			tdmap.put("Beschreibung", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Land", cell.getStringCellValue());
		} else {
			tdmap.put("Land", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Strasse", cell.getStringCellValue());
		} else {
			tdmap.put("Strasse", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Stadt", cell.getStringCellValue());		
		} else {
			tdmap.put("Stadt", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Bundesland", cell.getStringCellValue());
		} else {
			tdmap.put("Bundesland", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("PLZ", cell.getStringCellValue());
		} else {
			tdmap.put("PLZ", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("SAPStrasse1", cell.getStringCellValue());
		} else {
			tdmap.put("SAPStrasse1", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("SAPHausnummer", cell.getStringCellValue());
		} else {
			tdmap.put("SAPHausnummer", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("BezirksGebietsname", cell.getStringCellValue());
		} else {
			tdmap.put("BezirksGebietsname", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("BezirksGebietsnummer", cell.getStringCellValue());
		} else {
			tdmap.put("BezirksGebietsnummer", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("PrimaereBranche", cell.getStringCellValue());
		} else {
			tdmap.put("PrimaereBranche", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("SekundaereBranche", cell.getStringCellValue());
		} else {
			tdmap.put("SekundaereBranche", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("PrimaereSubbranche", cell.getStringCellValue());
		} else {
			tdmap.put("PrimaereSubbranche", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("SekundaereSubbranche", cell.getStringCellValue());
		} else {
			tdmap.put("SekundaereSubbranche", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Applikationssegment", cell.getStringCellValue());
		} else {
			tdmap.put("Applikationssegment", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("FuhrparkgroesseTruck", cell.getStringCellValue());
		} else {
			tdmap.put("FuhrparkgroesseTruck", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("KontaktklasseTruck", cell.getStringCellValue());
		} else {
			tdmap.put("KontaktklasseTruck", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("MANFleetShare", cell.getStringCellValue());
		} else {
			tdmap.put("MANFleetShare", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Datenspeicherung", cell.getStringCellValue());
		} else {
			tdmap.put("Datenspeicherung", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Datenweitergabe", cell.getStringCellValue());
		} else {
			tdmap.put("Datenweitergabe", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Marketing", cell.getStringCellValue());
		} else {
			tdmap.put("Marketing", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("UebergeordneterAccount", cell.getStringCellValue());
		} else {
			tdmap.put("UebergeordneterAccount", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Rahmenvertragsnummer", cell.getStringCellValue());
		} else {
			tdmap.put("Rahmenvertragsnummer", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("FuhrparkgroesseUnternehmensgruppe", cell.getStringCellValue());
		} else {
			tdmap.put("FuhrparkgroesseUnternehmensgruppe", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("Rahmenvertragsname", cell.getStringCellValue());
		} else {
			tdmap.put("Rahmenvertragsname", "");
		}
		column ++;
		cell = row.getCell(column);
		if (cell != null) {
			tdmap.put("SAPSyncState", cell.getStringCellValue());
		} else {
			tdmap.put("SAPSyncState", "");
		}
		
		
		
	return tdmap;
	}

}
