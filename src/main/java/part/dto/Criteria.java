package part.dto;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Locale;

public class Criteria {
    //    private SimpleDateFormat formatOut = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
    private static final long MIN_DATE = System.currentTimeMillis() / 5;
    private static final long MAX_DATE = System.currentTimeMillis() * 2;
    private SimpleDateFormat formatIn = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    private String partNumber;
    private String partName;
    private String vendor;
    private int qty;
    private Date shippedAfter;
    private Date shippedBefore;
    private Date receiveAfter;
    private Date receiveBefore;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(String qty) {
        if (isValueNullOrEmpty(qty)) {
            this.qty = 0;
            return;
        }
        this.qty = Integer.parseInt(qty);
    }

    public Date getShippedAfter() {
        return shippedAfter;
    }

    public void setShippedAfter(String shippedAfter) throws ParseException {
        if (isValueNullOrEmpty(shippedAfter)) {
            this.shippedAfter= new Date(MIN_DATE);
            return;
        }

        this.shippedAfter = new Date(formatIn.parse(shippedAfter).getTime());
    }

    public Date getShippedBefore() {
        return shippedBefore;
    }

    public void setShippedBefore(String shippedBefore) throws ParseException {
        if (isValueNullOrEmpty(shippedBefore)) {
            this.shippedBefore = new Date(MAX_DATE);
            return;
        }

        this.shippedBefore = new Date(formatIn.parse(shippedBefore).getTime());
    }

    public Date getReceiveAfter() {
        return receiveAfter;
    }

    public void setReceiveAfter(String receiveAfter) throws ParseException {
        if (isValueNullOrEmpty(receiveAfter)) {
            this.receiveAfter = new Date(MIN_DATE);
            return;
        }
        this.receiveAfter = new Date(formatIn.parse(receiveAfter).getTime());
    }

    public Date getReceiveBefore() {
        return receiveBefore;
    }

    public void setReceiveBefore(String receiveBefore) throws ParseException {
        if (isValueNullOrEmpty(receiveBefore)) {
            this.receiveBefore = new Date(MAX_DATE);
            return;
        }
        this.receiveBefore = new Date(formatIn.parse(receiveBefore).getTime());
    }

    private boolean isValueNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
