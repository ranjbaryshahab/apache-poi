package ir.maktab;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class WorkBookFactory {
    private XSSFWorkbook workbook;
    private Path path;

    public WorkBookFactory(Path path) throws IOException {
        this.path = path;
        this.workbook = new XSSFWorkbook(new FileInputStream(String.valueOf(path)));
    }

    public WorkBookFactory(XSSFWorkbook workbook, Path path) {
        this.workbook = workbook;
        this.path = path;
    }

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void write() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(path));
        workbook.write(fileOutputStream);
        workbook.close();
    }
}
