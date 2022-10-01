import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Date;

public class Connection {
    public Array clientList;

    public boolean signIn(String mail, String pwd) throws SignInFailed {
        return true;
    }

    public IVODService login(String mail, String pwd) throws InvalidCredentialsException {
        return null;
    }
    /** * Java method to read dates from Excel file in Java. * This method read value from .XLS file, which is an OLE * format. * * @param file * @throws IOException */
    public static void readFromExcel(String file) throws IOException{
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Birthdays");
        HSSFRow row = myExcelSheet.getRow(0);
        if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING){
            String name = row.getCell(0).getStringCellValue(); System.out.println("name : " + name); }
        if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
            Date birthdate = row.getCell(1).getDateCellValue(); System.out.println("birthdate :" + birthdate);
        }
        myExcelBook.close();
    }


}
