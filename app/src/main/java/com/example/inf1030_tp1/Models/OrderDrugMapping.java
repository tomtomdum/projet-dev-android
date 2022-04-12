package com.example.inf1030_tp1.Models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Order.class,
                parentColumns = "id",
                childColumns = "orderId"
        ),
        @ForeignKey(
                entity = Drug.class,
                parentColumns = "drugNumber",
                childColumns = "drugNumber"
        )
})
public class OrderDrugMapping {
    @PrimaryKey
    private long mapId;
    private int drugOrderQuantity;
    private long orderId;
    private String drugNumber;

    public OrderDrugMapping(long mapId, int drugOrderQuantity, long orderId, String drugNumber) {
        this.mapId = mapId;
        this.drugOrderQuantity = drugOrderQuantity;
        this.orderId = orderId;
        this.drugNumber = drugNumber;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public int getDrugOrderQuantity() {
        return drugOrderQuantity;
    }

    public void setDrugOrderQuantity(int drugOrderQuantity) {
        this.drugOrderQuantity = drugOrderQuantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getDrugNumber() {
        return drugNumber;
    }

    public void setDrugNumber(String drugNumber) {
        this.drugNumber = drugNumber;
    }
}
