package pl.sdacademy.vetclinic.service;

import org.springframework.stereotype.Service;

public class PetService {

    private String wlascicielKota;
    private String coRobiCalaSala;

    public PetService(String coRobiCalaSala) {
        this.coRobiCalaSala = coRobiCalaSala;
    }

    public void setKtoMaKota(String ktoMaKotaValue) {
        wlascicielKota = ktoMaKotaValue;
    }

    @Override
    public String toString() {
        return "PetService{" +
                "wlascicielKota='" + wlascicielKota + '\'' +
                ", coRobiCalaSala='" + coRobiCalaSala + '\'' +
                '}';
    }
}
