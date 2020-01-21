package ir.maktab;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class PersonService {

    public void saveToNewFile(List<Person> personList) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        WorkBookFactory workBookFactory = new WorkBookFactory(workbook, Paths.get("Persons.xlsx"));
        PersonRepository personRepository = new PersonRepository(workBookFactory.getWorkbook());
        personRepository.save(personList);
        workBookFactory.write();
    }

    public void saveToExistFile(List<Person> personList) throws IOException {
        WorkBookFactory workBookFactory = new WorkBookFactory(Paths.get("Persons.xlsx"));
        PersonRepository personRepository = new PersonRepository(workBookFactory.getWorkbook());
        personRepository.save(personList);
        workBookFactory.write();
    }

    public List<Person> loadAll() throws IOException {
        WorkBookFactory workBookFactory = new WorkBookFactory(Paths.get("Persons.xlsx"));
        PersonRepository personRepository = new PersonRepository(workBookFactory.getWorkbook());
        return personRepository.loadAll();
    }

    public Person loadById(long id) throws IOException {
        WorkBookFactory workBookFactory = new WorkBookFactory(Paths.get("Persons.xlsx"));
        PersonRepository personRepository = new PersonRepository(workBookFactory.getWorkbook());
        return personRepository.loadById(id);
    }
}
