package org.example.model;

import javax.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "poker_earnings")
public class Earning {

    public Earning() {
        setShikaEarning(0.0);
        setKateEarning(0.0);
        setDolgashaEarning(0.0);
        setPashaEarning(0.0);
        setEdutEarning(0.0);
        setBurmirEarning(0.0);
        setMakarichEarning(0.0);
        setMaksEarning(0.0);
        setSonyaEarning(0.0);
    }

    @Id
    @SequenceGenerator(name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    private Long id;

    @Column(name = "Шика")
    private Double shikaEarning;

    @Column(name = "Кейт")
    private Double kateEarning;

    @Column(name = "Долгаша")
    private Double dolgashaEarning;

    @Column(name = "Паша")
    private Double pashaEarning;

    @Column(name = "Едут")
    private Double edutEarning;

    @Column(name = "Бурмир")
    private Double burmirEarning;

    @Column(name = "Макарыч")
    private Double makarichEarning;

    @Column(name = "Макс")
    private Double maksEarning;

    @Column(name = "Соня")
    private Double sonyaEarning;

    @Column(name = "Дата")
    private String date;

    public Double getShikaEarning() {
        return shikaEarning;
    }

    public void setShikaEarning(Double shikaEarning) {
        this.shikaEarning = shikaEarning;
    }

    public Double getKateEarning() {
        return kateEarning;
    }

    public void setKateEarning(Double kateEarning) {
        this.kateEarning = kateEarning;
    }

    public Double getDolgashaEarning() {
        return dolgashaEarning;
    }

    public void setDolgashaEarning(Double dolgashaEarning) {
        this.dolgashaEarning = dolgashaEarning;
    }

    public Double getPashaEarning() {
        return pashaEarning;
    }

    public void setPashaEarning(Double pashaEarning) {
        this.pashaEarning = pashaEarning;
    }

    public Double getEdutEarning() {
        return edutEarning;
    }

    public void setEdutEarning(Double edutEarning) {
        this.edutEarning = edutEarning;
    }

    public Double getBurmirEarning() {
        return burmirEarning;
    }

    public void setBurmirEarning(Double burmirEarning) {
        this.burmirEarning = burmirEarning;
    }

    public Double getMakarichEarning() {
        return makarichEarning;
    }

    public void setMakarichEarning(Double makarichEarning) {
        this.makarichEarning = makarichEarning;
    }

    public Double getMaksEarning() {
        return maksEarning;
    }

    public void setMaksEarning(Double maksEarning) {
        this.maksEarning = maksEarning;
    }

    public Double getSonyaEarning() {
        return sonyaEarning;
    }

    public void setSonyaEarning(Double sonyaEarning) {
        this.sonyaEarning = sonyaEarning;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String message = "Зарабаток таков:\n";
        if (getShikaEarning() > 0.0) {
            message += "Шика - " + getShikaEarning() + "\n";
        }
        if (getKateEarning() > 0.0) {
            message += "Кейт - " + getKateEarning() + "\n";
        }
        if (getPashaEarning() > 0.0) {
            message += "Паша - " + getPashaEarning() + "\n";
        }
        if (getEdutEarning() > 0.0) {
            message += "Едут - " + getEdutEarning() + "\n";
        }
        if (getMaksEarning() > 0.0) {
            message += "Макс - " + getMaksEarning() + "\n";
        }
        if (getBurmirEarning() > 0.0) {
            message += "Бурмир - " + getBurmirEarning() + "\n";
        }
        if (getMakarichEarning() > 0.0) {
            message += "Макарыч - " + getMakarichEarning() + "\n";
        }
        if (getDolgashaEarning() > 0.0) {
            message += "Долгаша - " + getDolgashaEarning() + "\n";
        }
        return message;
    }
}
