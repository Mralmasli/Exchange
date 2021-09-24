package com.example.exchange.data.db.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "currency")
public class Currency {
    @Id(autoincrement = true)
    private Long id;

    @SerializedName("currency")
    @Property(nameInDb = "currency_name")
    private String name;

    @SerializedName("buy_rate")
    @Property(nameInDb = "buy_rate")
    private Double buyRate;

    @SerializedName("sale_rate")
    @Property(nameInDb = "sale_rate")
    private Double saleRate;

    @Generated(hash = 1337484271)
    public Currency(Long id, String name, Double buyRate, Double saleRate) {
        this.id = id;
        this.name = name;
        this.buyRate = buyRate;
        this.saleRate = saleRate;
    }

    @Generated(hash = 1387171739)
    public Currency() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBuyRate() {
        return this.buyRate;
    }

    public void setBuyRate(Double buyRate) {
        this.buyRate = buyRate;
    }

    public Double getSaleRate() {
        return this.saleRate;
    }

    public void setSaleRate(Double saleRate) {
        this.saleRate = saleRate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buyRate=" + buyRate +
                ", saleRate=" + saleRate +
                '}';
    }
}
