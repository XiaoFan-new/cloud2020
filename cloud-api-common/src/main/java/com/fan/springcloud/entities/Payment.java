package com.fan.springcloud.entities;


import java.util.Objects;

public class Payment {
    private long id;
    private String serial;

    public Payment() {
    }

    public Payment(long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id &&
                Objects.equals(serial, payment.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serial);
    }
}
