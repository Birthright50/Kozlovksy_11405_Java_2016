package com.birthright.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Birthright on 03.05.2016.
 */
@Entity
public class Information {
    private Long id;
    private Integer type;
    private String name;
    private String pageText;
    private String urlImage;
    private Date fDate;
    private String previewText;

    public Information() {
    }

    public Information(Integer type, String name, String pageText, String urlImage, Date fDate, String previewText) {
        this.type = type;
        this.name = name;
        this.pageText = pageText;
        this.urlImage = urlImage;
        this.fDate = fDate;
        this.previewText = previewText;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "information_id_seq")
    @SequenceGenerator(name = "information_id_seq", sequenceName = "information_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "page_text", nullable = false, length = -1)
    public String getPageText() {
        return pageText;
    }

    public void setPageText(String pageText) {
        this.pageText = pageText;
    }

    @Basic
    @Column(name = "url_image", nullable = false, length = -1)
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Basic
    @Column(name = "f_date", nullable = false)
    public Date getfDate() {
        return fDate;
    }

    public void setfDate(Date fDate) {
        this.fDate = fDate;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", pageText='" + pageText + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", fDate=" + fDate +
                ", previewText='" + previewText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Information that = (Information) o;

        return id != null ? id.equals(that.id) : that.id == null && (type != null ? type.equals(that.type)
                : that.type == null && (name != null ? name.equals(that.name)
                : that.name == null && (pageText != null ? pageText.equals(that.pageText)
                : that.pageText == null && (urlImage != null ? urlImage.equals(that.urlImage)
                : that.urlImage == null && (fDate != null ? fDate.equals(that.fDate) : that.fDate == null)))));

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pageText != null ? pageText.hashCode() : 0);
        result = 31 * result + (urlImage != null ? urlImage.hashCode() : 0);
        result = 31 * result + (fDate != null ? fDate.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "preview_text", nullable = false, length = -1)
    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }
}
