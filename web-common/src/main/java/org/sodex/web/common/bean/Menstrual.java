package org.sodex.web.common.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Menstrual extends BaseBean implements Serializable {

    @Column
    private LocalDate dt;

    public LocalDate getDt() {
        return dt;
    }

    public void setDt(LocalDate dt) {
        this.dt = dt;
    }
}
