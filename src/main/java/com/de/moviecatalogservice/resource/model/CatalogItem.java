package com.de.moviecatalogservice.resource.model;

import java.io.Serializable;
import java.util.Objects;

public class CatalogItem implements Serializable {

    private String name;
    private String desc;
    private Integer rating;

    public CatalogItem() {
    }

    public CatalogItem(String name, String desc, Integer rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogItem that = (CatalogItem) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc, rating);
    }

    @Override
    public String toString() {
        return "CatalogItem{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", rating=" + rating +
                '}';
    }
}
