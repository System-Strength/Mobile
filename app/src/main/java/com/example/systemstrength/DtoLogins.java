package com.example.systemstrength;

/**
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 **/

public class DtoLogins {
    private int id;
    private String nomeusu, emailusu, telefoneusu, senhausu;

    public DtoLogins(int id, String nomeusu, String emailusu, String telefoneusu, String senhausu) {
        this.id = id;
        this.nomeusu = nomeusu;
        this.emailusu = emailusu;
        this.telefoneusu = telefoneusu;
        this.senhausu = senhausu;
    }

    public  DtoLogins(){}

    //  Declaration to Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeusu() {
        return nomeusu;
    }

    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }

    public String getEmailusu() {
        return emailusu;
    }

    public void setEmailusu(String emailusu) {
        this.emailusu = emailusu;
    }

    public String getTelefoneusu() {
        return telefoneusu;
    }

    public void setTelefoneusu(String telefoneusu) {
        this.telefoneusu = telefoneusu;
    }

    public String getSenhausu() {
        return senhausu;
    }

    public void setSenhausu(String senhausu) {
        this.senhausu = senhausu;
    }
}

/*
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 */
