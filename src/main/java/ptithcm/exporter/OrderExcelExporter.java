package ptithcm.exporter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ptithcm.entity.CartItem;
import ptithcm.entity.CustomerOrder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Tuong
 */
public class OrderExcelExporter {
    private final XSSFWorkbook workbook;
    private final List<CustomerOrder> listOrders;
    private XSSFSheet sheet;

    public OrderExcelExporter(List<CustomerOrder> listOrders) {
        this.workbook = new XSSFWorkbook();
        this.listOrders = listOrders;
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Orders");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Order ID", style);
        createCell(row, 1, "Time Order", style);
        createCell(row, 2, "Product Name", style);
        createCell(row, 3, "Quantity", style);
        createCell(row, 4, "Total Price", style);
        createCell(row, 5, "Username", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (CustomerOrder order : listOrders) {
            for (CartItem item : order.getCart().getCartItem()) {
                int columnCount = 0;
                Row row = sheet.createRow(rowCount++);
                createCell(row, columnCount++, order.getCustomerOrderId(), style);
                createCell(row, columnCount++, order.getTimeOrder(), style);
                createCell(row, columnCount++, item.getProduct().getProductName(), style);
                createCell(row, columnCount++, item.getQuantity(), style);
                createCell(row, columnCount++, item.getTotalPrice(), style);
                createCell(row, columnCount++, order.getCustomer().getUsername(), style);
            }
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}
