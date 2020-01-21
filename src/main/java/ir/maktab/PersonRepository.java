package ir.maktab;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private XSSFSheet sheet;
    private XSSFWorkbook workbook;

    public PersonRepository(XSSFWorkbook workbook) {
        this.workbook = workbook;
        if (workbook.getSheet("Person") == null) {
            sheet = workbook.createSheet("Person");
        }
    }

    public void save(List<Person> personList) {
        if (sheet == null) sheet = workbook.getSheet("Person");
        XSSFRow firstRow = sheet.createRow(0);

        XSSFCell id = firstRow.createCell(0);
        XSSFCell firstName = firstRow.createCell(1);
        XSSFCell lastName = firstRow.createCell(2);
        XSSFCell phoneNumber = firstRow.createCell(3);

        id.setCellValue("Id");
        firstName.setCellValue("FirstName");
        lastName.setCellValue("LastName");
        phoneNumber.setCellValue("PhoneNumber");


        for (Person person : personList) {
            XSSFRow row = sheet.createRow(Math.toIntExact(person.getId()));
            XSSFCell cell1 = row.createCell(0);
            XSSFCell cell2 = row.createCell(1);
            XSSFCell cell3 = row.createCell(2);
            XSSFCell cell4 = row.createCell(3);
            cell1.setCellValue(person.getId());
            cell2.setCellValue(person.getFirstName());
            cell3.setCellValue(person.getLastName());
            cell4.setCellValue(person.getPhoneNumber());
        }

    }

    public Person loadById(Long id) {
        XSSFSheet sheet = workbook.getSheet("Person");
        if (sheet.getLastRowNum() < id) {
            id = (long) sheet.getLastRowNum();
            System.out.println("Max number is:" + (id + 1));
        }

        XSSFRow row = sheet.getRow(Math.toIntExact(id));
        return personMapper(row);
    }


    public List<Person> loadAll() {
        List<Person> personList = new ArrayList<>();
        XSSFSheet sheet1 = workbook.getSheet("Person");
        for (int j = 0; j <= sheet1.getLastRowNum(); j++) {
            XSSFRow row = sheet1.getRow(j);
            Person person = personMapper(row);
            if (person == null) continue;
            personList.add(person);
        }
        return personList;
    }

    private static Person personMapper(XSSFRow row) {
        if (row == null) return null;
        XSSFCell cell1 = row.getCell(0);
        XSSFCell cell2 = row.getCell(1);
        XSSFCell cell3 = row.getCell(2);
        XSSFCell cell4 = row.getCell(3);

        Person person = new Person();
        person.setId((long) cell1.getNumericCellValue());
        person.setFirstName(cell2.getStringCellValue());
        person.setLastName(cell3.getStringCellValue());
        person.setPhoneNumber(cell4.getStringCellValue());

        return person;
    }
}
