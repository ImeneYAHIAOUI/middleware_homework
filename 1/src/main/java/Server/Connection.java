package Server;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Connection implements IConnection {
    private List<Client> clientList =new ArrayList<Client>();;
    private int LastRowNumberInFile;
    VODService VodService=new VODService();;
    File file= new File(System.getProperty("user.dir")+ Paths.get("/src/main/java/Server/DataBase/Clients.xls"));;
    protected Connection() throws RemoteException {
        super();
    }

    private boolean IsRegitered(HSSFSheet sheet, Client client ) {
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();
        Row row=null;
        while (rowIterator.hasNext() ) {
            row = rowIterator.next();
            if(row.getRowNum()==0) continue;
            // Get iterator to all cells of current row
            if (row.getCell(0).getStringCellValue().equals(client.GetMail()) && row.getCell(1).getStringCellValue().equals(client.GetPassword())) {
                return true;
            }
        }
        LastRowNumberInFile = row==null ? 2 : row.getRowNum()+1;
        return false;
    }

    @Override
    public boolean signIn(String mail, String pwd) throws SignInFailed {
        Client client=new Client(mail,pwd);
        try{
            // Read XSL file
            FileInputStream inputStream = new FileInputStream(file);
            // Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            // Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            if(!clientList.contains(client)){
                if(!IsRegitered(sheet,client)){
                    Row row = sheet.createRow(LastRowNumberInFile);
                    // Name
                    Cell cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue(client.GetMail());
                    //PassWord
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(client.GetPassword());
                    FileOutputStream outFile = new FileOutputStream(file);
                    workbook.write(outFile);
                    clientList.add(client);
                }
                else{
                    throw  new SignInFailed("You are already registered");
                }

            }else{
                throw  new SignInFailed("You are already registered");
            }
            return true;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }

    }
    @Override
    public IVODService login(String mail, String pwd) throws InvalidCredentialsException {
        Client client =new Client(mail,pwd);
        try{
            // Read XSL file
            FileInputStream inputStream = new FileInputStream(file);
            // Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            // Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            if(clientList.contains(client) ){
                client.setConnected(true);
                System.out.println("Welcome, you are now connected");
            }else{
                if(IsRegitered(sheet,client) ){
                    if( client.getConnected().equals(null)) {
                        client.setConnected(true);
                        System.out.println("Welcome, you are now connected");
                    }
                }else{
                    throw  new InvalidCredentialsException("You not registered. Please sign in.");
                }
            }

        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }

        return VodService;
    }



}
