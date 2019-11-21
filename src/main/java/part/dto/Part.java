package part.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Part {

    @JsonProperty("PN")
    private String partNumber;

    @JsonProperty("Part Name")
    private String partName;

    @JsonProperty("Vendor")
    private String vendor;

    @JsonProperty("Qty")
    private Integer qty;

    @JsonProperty("Shipped")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd, yyyy", locale = "en", timezone = "Europe/Moscow")
    private Date shipped;

    @JsonProperty("Receive")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd, yyyy", locale = "en", timezone = "Europe/Moscow")
    private Date receive;

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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public Date getReceive() {
        return receive;
    }

    public void setReceive(Date receive) {
        this.receive = receive;
    }

    @Override
    public String toString() {
        return "Part{" +
                "partName='" + partName + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", vendor='" + vendor + '\'' +
                ", qty=" + qty +
                ", shipped=" + shipped +
                ", receive=" + receive +
                '}';
    }
}
