/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab9.exercise1.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Uses Lombok to get rid of boilerplate code.
 *
 * @author mihai.hulea
 * @author radu.miron
 */
@Data // it creates getters, setters, equals(), hashCode() and toString() (at compile time)
@AllArgsConstructor // it creates the constructor with arguments for all the attributes (at compile time)
public class UserPortfolio extends AbstractTableModel {

    private String[] columns = new String[]{"Symbol", "Quantity", "Price per unit", "Total price"};

    private BigDecimal cash;

    private Map<String, Integer> shares; // a map of number of shares by stock symbol

    private StockMarketQueryService stockMarketQueryService;

    public UserPortfolio(BigDecimal cash, Map<String, Integer> shares, StockMarketQueryService stockMarketQueryService) {
        this.cash = cash;
        this.shares = shares;
        this.stockMarketQueryService = stockMarketQueryService;
    }


    public void refreshPortofolioData() throws IOException {
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return shares.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        StockItem stockItemAtIndex = stockMarketQueryService.getStockItemBySymbol(getKeyAtIndex(shares, rowIndex));
        Integer quantity = shares.get(getKeyAtIndex(shares, rowIndex));

        switch (columnIndex) {
            case 0:
                return stockItemAtIndex.getName();
            case 1:
                return quantity;
            case 2:
                if (stockItemAtIndex.getPrice() != null) return stockItemAtIndex.getPrice().toPlainString();
                else return "N/A";
            case 3:

                if (stockItemAtIndex.getPrice() != null)
                    return stockItemAtIndex.getPrice().multiply(BigDecimal.valueOf(quantity));
                return stockItemAtIndex.getCurrency();
        }
        return "N/A";
    }

    @Override
    public String getColumnName(int index) {
        return columns[index];
    }


    public static <String, Integer> String getKeyAtIndex(Map<String, Integer> map, int index) {
        if (index < 0 || index >= map.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Iterator<String> iterator = map.keySet().iterator();
        for (int i = 0; i < index; i++) {
            iterator.next();
        }
        return iterator.next();
    }

}

