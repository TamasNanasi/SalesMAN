package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData extends base{
	
	FileInputStream exFile;
	XSSFWorkbook exWorkBook;
	XSSFSheet exWorkSheet;
	XSSFCell celltoSave;
	
	public void initialize() throws IOException {
		//exFile = openXlsfile(prop.getProperty("Excel_Data"));
		exFile = openXlsfile(Excel_Data_Path);
		exWorkBook = openWorkbook(exFile);
		exWorkSheet = openSheet(exWorkBook, 0);
	}
	
	public void openExcel() throws IOException {
		exFile = openXlsfile("D:\\TA\\PerformanceTestHistory.xlsx");
		exWorkBook = openWorkbook(exFile);
		exWorkSheet = openSheet(exWorkBook, 0);
	}
	
	public boolean isRowBlank(Row r) {
		boolean ret = true;
 
		/*
		 * If a row is null, it must be blank.
		 */
		if (r != null) {
			Iterator<Cell> cellIter = r.cellIterator();
			/*
			 * Iterate through all cells in a row.
			 */
			while (cellIter.hasNext()) {
				/*
				 * If one of the cells in given row contains data, the row is
				 * considered not blank.
				 */
				if (!this.isCellBlank(cellIter.next())) {
					ret = false;
					break;
				}
			}
		}
 
		return ret;
	}
	
	public boolean isCellBlank(Cell c) {
		return (c == null || c.getCellType() == CellType.BLANK);
		
	}
 
	public boolean isCellEmpty(Cell c) {
		return (c == null || c.getCellType() == CellType.BLANK || (c
				.getCellType() == CellType.STRING && c
				.getStringCellValue().isEmpty()));
		
	}
	
	public int getLastRowWithData() {
		//exFile = openXlsfile(Excel_Data_Path);
		//exWorkBook = openWorkbook(exFile);
		//exWorkSheet = openSheet(exWorkBook, 0);
		int rowCount = 0;
		Iterator<Row> iter = exWorkSheet.rowIterator();
		while (iter.hasNext()) {
			Row r = iter.next();
			if (!this.isRowBlank(r)) {
				rowCount = r.getRowNum();
			}
		}
 
		return rowCount;
	}
	
	public int get_firsNotUsedRow() throws IOException {
		exFile = openXlsfile(Excel_Data_Path);
		exWorkBook = openWorkbook(exFile);
		exWorkSheet = openSheet(exWorkBook, 0);
		boolean notVerbraucht = true;
		int rn = 3;
		int column = 0;
		while (notVerbraucht) {
			if (getStringvalue(exWorkSheet, rn, column) != null) {
				if (getStringvalue(exWorkSheet, rn, column).equals("Ja")) {
					rn ++;
					continue;
				} else {
					break;
				}
			} else {
				return -1;
			}
		}	
		return rn;				
	}
	
	public int get_firsNotUsedRowContact() throws IOException {
		exFile = openXlsfile(Excel_Data_Path);
		exWorkBook = openWorkbook(exFile);
		exWorkSheet = openSheet(exWorkBook, 0);
		boolean notVerbraucht = true;
		int rn = 3;
		int column = 0;
		while (notVerbraucht) {
			if (getStringvalue(exWorkSheet, rn, column).equals("Ja")) {
				rn ++;
				continue;
			} else {
				break;
			}
		}	
		return rn;				
	}
	
	public void cellToWrite(int rownr, int cellnr, String value) throws IOException {
		XSSFRow row = exWorkSheet.getRow(rownr);
		celltoSave = row.getCell(cellnr);
		celltoSave.setCellValue(value);
		//openXlsfiletoWrite(Excel_Data_Path, exWorkBook);
		//closeExcel(exFile, exWorkBook);		
	}
	
	public void cellToSave() throws IOException {
		openXlsfiletoWrite(Excel_Data_Path, exWorkBook);
		closeExcel(exFile, exWorkBook);		
	}
	
	
	public String get_Accountname(int rn) {
		int column = 1;
		String Accountname = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Accountname = cell.getStringCellValue();
		}
			return Accountname;
	}
	
	public String get_Telefon(int rn) {
		int column = 2;
		String Telefon = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Telefon = cell.getStringCellValue();
		}
			return Telefon;
	}
	
	public String get_Accountame2(int rn) {
		int column = 3;
		String Accountame2 = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Accountame2 = cell.getStringCellValue();
		}
			return Accountame2;
	}
	
	public String get_Fax(int rn) {
		int column = 4;
		String Fax = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Fax = cell.getStringCellValue();
		}
			return Fax;
	}
	
	public String get_Umsatzsteueridentifikationsnummer(int rn) {
		int column = 5;
		String Umsatzsteueridentifikationsnummer = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Umsatzsteueridentifikationsnummer = cell.getStringCellValue();
		}
			return Umsatzsteueridentifikationsnummer;
	}
	
	public String get_FirmenEmailAdresse(int rn) {
		int column = 6;
		String FirmenEmailAdresse = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			FirmenEmailAdresse = cell.getStringCellValue();
		}
			return FirmenEmailAdresse;
	}
	
	public String get_WeitereSteuernummer(int rn) {
		int column = 7;
		String WeitereSteuernummer = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			WeitereSteuernummer = cell.getStringCellValue();
		}
			return WeitereSteuernummer;
	}
	
	public String get_Website(int rn) {
		int column = 8;
		String Website = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Website = cell.getStringCellValue();
		}
			return Website;
	}
	
	public String get_Kundentyp(int rn) {
		int column = 9;
		String Kundentyp = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v1 = cell.getStringCellValue();
			Kundentyp = prop_ddl.getProperty(v1);	
		}
			return Kundentyp;
	}
	
	public String get_Partnertyp(int rn) {
		int column = 10;
		String Partnertyp = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v2 = cell.getStringCellValue();
			Partnertyp = prop_ddl.getProperty(v2);
		}
			return Partnertyp;
	}
	
	public String get_KeyAccountName(int rn) {
		int column = 11;
		String KeyAccountName = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			KeyAccountName = cell.getStringCellValue();
		}
			return KeyAccountName;
	}
	
	public String get_Rechtsform(int rn) {
		int column = 12;
		String Rechtsform = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Rechtsform = cell.getStringCellValue();
		}
			return Rechtsform;
	}
	
	public String get_KeyAccountNummer(int rn) {
		int column = 13;
		String KeyAccountNummer = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			KeyAccountNummer = cell.getStringCellValue();
		}
			return KeyAccountNummer;
	}
	
	public String get_MilitaerischerEndkunde(int rn) {
		int column = 14;
		String MilitaerischerEndkunde = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			MilitaerischerEndkunde = cell.getStringCellValue();
		}
			return MilitaerischerEndkunde;
	}
	
	public String get_Beschreibung(int rn) {
		int column = 15;
		String Beschreibung = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Beschreibung = cell.getStringCellValue();
		}
			return Beschreibung;
	}
	
	public String get_Land(int rn) {
		int column = 16;
		String Land = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v3 = cell.getStringCellValue();
			Land = prop_ddl.getProperty(v3);
		}
			return Land;
	}
	
	public String get_LandValue(int rn) {
		int column = 16;
		String Land = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Land = cell.getStringCellValue();
		}
			return Land;
	}
	
	public String get_Strasse(int rn) {
		int column = 17;
		String Strasse = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Strasse = cell.getStringCellValue();
		}
			return Strasse;
	}
	
	public String get_Stadt(int rn) {
		int column = 18;
		String Stadt = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Stadt = cell.getStringCellValue();
		}
			return Stadt;
	}
	
	public String get_Bundesland(int rn) {
		int column = 19;
		String Bundesland = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v3 = cell.getStringCellValue();
			Bundesland = prop_ddl.getProperty(v3);
		}
			return Bundesland;
	}
	
	public String get_BundeslandValue(int rn) {
		int column = 19;
		String Bundesland = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Bundesland = cell.getStringCellValue();
		}
			return Bundesland;
	}
	
	public String get_PLZ(int rn) {
		int column = 20;
		String PLZ = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			PLZ = cell.getStringCellValue();
		}
			return PLZ;
	}
	
	public String get_SAPStrasse1(int rn) {
		int column = 21;
		String SAPStrasse1 = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			SAPStrasse1 = cell.getStringCellValue();
		}
			return SAPStrasse1;
	}
	
	public String get_SAPHausnummer(int rn) {
		int column = 22;
		String SAPHausnummer = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			SAPHausnummer = cell.getStringCellValue();
		}
			return SAPHausnummer;
	}
	
	public String get_BezirksGebietsname(int rn) {
		int column = 23;
		String BezirksGebietsname = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			BezirksGebietsname = cell.getStringCellValue();
		}
			return BezirksGebietsname;
	}
	
	public String get_BezirksGebietsnummer(int rn) {
		int column = 24;
		String BezirksGebietsnummer = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			BezirksGebietsnummer = cell.getStringCellValue();
		}
			return BezirksGebietsnummer;
	}
	
	public String get_PrimaereBranche(int rn) {
		int column = 25;
		String PrimaereBranche = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v4 = cell.getStringCellValue();
			PrimaereBranche = prop_ddl.getProperty(v4);
		}
			return PrimaereBranche;
	}
	
	public String get_SekundaereBranche(int rn) {
		int column = 26;
		String SekundaereBranche = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v5 = cell.getStringCellValue();
			SekundaereBranche = prop_ddl.getProperty(v5);
		}
			return SekundaereBranche;
	}
	
	public String get_PrimaereSubbranche(int rn) {
		int column = 27;
		String PrimaereSubbranche = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			PrimaereSubbranche = cell.getStringCellValue();
		}
			return PrimaereSubbranche;
	}
	
	public String get_SekundaereSubbranche(int rn) {
		int column = 28;
		String SekundaereSubbranche = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			SekundaereSubbranche = cell.getStringCellValue();
		}
			return SekundaereSubbranche;
	}
	
	public String get_Applikationssegment(int rn) {
		int column = 29;
		String Applikationssegment = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v6 = cell.getStringCellValue();
			Applikationssegment = prop_ddl.getProperty(v6);
		}
			return Applikationssegment;
	}
	
	public String get_FuhrparkgroesseTruck(int rn) {
		int column = 30;
		String FuhrparkgroesseTruck = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v7 = cell.getStringCellValue();
			FuhrparkgroesseTruck = prop_ddl.getProperty(v7);
		}
			return FuhrparkgroesseTruck;
	}
	
	public String get_FuhrparkgroesseTruckValue(int rn) {
		int column = 30;
		String FuhrparkgroesseTruck = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			FuhrparkgroesseTruck = cell.getStringCellValue();
		}
			return FuhrparkgroesseTruck;
	}
	
	public String get_KontaktklasseTruck(int rn) {
		int column = 31;
		String KontaktklasseTruck = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v8 = cell.getStringCellValue();
			KontaktklasseTruck = prop_ddl.getProperty(v8);
		}
			return KontaktklasseTruck;
	}
	
	public String get_MANFleetShare(int rn) {
		int column = 32;
		String MANFleetShare = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			MANFleetShare = cell.getStringCellValue();
		}
			return MANFleetShare;
	}
	
	public String get_Datenspeicherung(int rn) {
		int column = 33;
		String Datenspeicherung = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v9 = cell.getStringCellValue();
			Datenspeicherung = prop_ddl.getProperty(v9);
		}
			return Datenspeicherung;
	}
	
	public String get_Datenweitergabe(int rn) {
		int column = 34;
		String Datenweitergabe = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v10 = cell.getStringCellValue();
			Datenweitergabe = prop_ddl.getProperty(v10);
		}
			return Datenweitergabe;
	}
	
	public String get_Marketing(int rn) {
		int column = 35;
		String Marketing = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Marketing = cell.getStringCellValue();
		}
			return Marketing;
	}
	
	public String get_UebergeordneterAccount(int rn) {
		int column = 36;
		String UebergeordneterAccount = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			UebergeordneterAccount = cell.getStringCellValue();
		}
			return UebergeordneterAccount;
	}
	
	public String get_Rahmenvertragsnummer(int rn) {
		int column = 37;
		String Rahmenvertragsnummer = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Rahmenvertragsnummer = cell.getStringCellValue();
		}
			return Rahmenvertragsnummer;
	}
	
	public String get_FuhrparkgroesseUnternehmensgruppe(int rn) {
		int column = 38;
		String FuhrparkgroesseUnternehmensgruppe = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			FuhrparkgroesseUnternehmensgruppe = cell.getStringCellValue();
		}
			return FuhrparkgroesseUnternehmensgruppe;
	}
	
	public String get_Rahmenvertragsname(int rn) {
		int column = 39;
		String Rahmenvertragsname = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			Rahmenvertragsname = cell.getStringCellValue();
		}
			return Rahmenvertragsname;
	}
	
	public String get_SAPSyncState(int rn) {
		int column = 40;
		String SAPSyncState = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			SAPSyncState = cell.getStringCellValue();
		}
			return SAPSyncState;
	}
	
	public String get_ContactTelefon(int rn) throws FileNotFoundException {
		int column = 2;
		String ContactTelefon = null;
		exWorkSheet = openSheet(exWorkBook, 1);
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			ContactTelefon = cell.getStringCellValue();
		}
			return ContactTelefon;
	}
	
	public String get_ContactAnrede(int rn) throws FileNotFoundException {
		int column = 3;
		String ContactAnrede = null;
		exWorkSheet = openSheet(exWorkBook, 1);
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			String v = cell.getStringCellValue();;
			ContactAnrede = prop_ddl.getProperty(v);
		}
			return ContactAnrede;
	}
	
	public String get_ContactAnredeValue(int rn) {
		int column = 3;
		String ContactAnrede = null;
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			ContactAnrede = cell.getStringCellValue();
		}
			return ContactAnrede;
	}
	
	public String get_ContactNachname(int rn) throws FileNotFoundException {
		int column = 6;
		String ContactNachname = null;
		exWorkSheet = openSheet(exWorkBook, 1);
		XSSFRow row = exWorkSheet.getRow(rn);
		XSSFCell cell = row.getCell(column);
		if (cell != null) {
			ContactNachname = cell.getStringCellValue();
		}
			return ContactNachname;
	}
	
	
}
