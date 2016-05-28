package entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by birthright on 27.05.16.
 */
@Entity
@Table(name = "information", schema = "public", catalog = "postgres")
public class Information {
    private Long id;
    private Long type;
    private String name;
    private String pageText;
    private String urlImage;
    private Date fDate;
    private String previewText;

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

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "page_text")
    public String getPageText() {
        return pageText;
    }

    public void setPageText(String pageText) {
        this.pageText = pageText;
    }

    @Basic
    @Column(name = "url_image")
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Basic
    @Column(name = "f_date")
    public Date getfDate() {
        return fDate;
    }

    public void setfDate(Date fDate) {
        this.fDate = fDate;
    }

    @Basic
    @Column(name = "preview_text")
    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Information that = (Information) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pageText != null ? !pageText.equals(that.pageText) : that.pageText != null) return false;
        if (urlImage != null ? !urlImage.equals(that.urlImage) : that.urlImage != null) return false;
        if (fDate != null ? !fDate.equals(that.fDate) : that.fDate != null) return false;
        if (previewText != null ? !previewText.equals(that.previewText) : that.previewText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pageText != null ? pageText.hashCode() : 0);
        result = 31 * result + (urlImage != null ? urlImage.hashCode() : 0);
        result = 31 * result + (fDate != null ? fDate.hashCode() : 0);
        result = 31 * result + (previewText != null ? previewText.hashCode() : 0);
        return result;
    }
}
