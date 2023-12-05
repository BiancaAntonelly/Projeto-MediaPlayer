package br.ufrn.imd.service;

import java.util.UUID;
public class GeradorDeId {
    public String gerarIdAleatorio() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
