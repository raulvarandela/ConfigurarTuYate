package com.rvmarra17.configurartuyate.core;

public class yate {
    private boolean motor;
    private boolean velas;
    private boolean lancha;
    private boolean calefaccion;
    private boolean radar;
    private String nombre;

    public yate() {
        setVelas(true);
        setRadar(true);
        setNombre("Corina I de España");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public boolean isVelas() {
        return velas;
    }

    public void setVelas(boolean velas) {
        this.velas = velas;
    }

    public boolean isLancha() {
        return lancha;
    }

    public void setLancha(boolean lancha) {
        this.lancha = lancha;
    }

    public boolean isCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(boolean calefaccion) {
        this.calefaccion = calefaccion;
    }

    public boolean isRadar() {
        return radar;
    }

    public void setRadar(boolean radar) {
        this.radar = radar;
    }

    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Yate ");
        toret.append(getNombre());
        toret.append(" con: ");

        if (isVelas()) toret.append(" velas, ");
        if (isMotor()) toret.append(" motor, ");
        if (isLancha()) toret.append(" lancha, ");
        if (isCalefaccion()) toret.append(" calefaccion, ");
        if (isRadar()) toret.append(" radar");

        return toret.toString();
    }

    public boolean[] getOpciones() {
        boolean[] toret = new boolean[5];

        if (isVelas()) toret[0] = true;
        if (isMotor()) toret[1] = true;
        if (isLancha()) toret[2] = true;
        if (isCalefaccion()) toret[3] = true;
        if (isRadar()) toret[4] = true;

        return toret;
    }
}

