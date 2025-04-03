package org.example;

import org.json.JSONObject;

public class AtendimentoPage {

    private AtendimentoService remoteService;

    public AtendimentoPage(AtendimentoService remoteService) {
        this.remoteService = remoteService;
    }

    public Atendimento getAtendimento(String nomeProfessor) {
        String json = remoteService.getAtendimento(nomeProfessor);
        JSONObject jsonObj = new JSONObject(json);
        String nome = jsonObj.getString("nomeDoProfessor");
        String horario = jsonObj.getString("horarioDeAtendimento");
        String periodo = jsonObj.getString("periodo");
        int sala = jsonObj.getInt("sala");
        return new Atendimento(nome, horario,periodo, sala);
    }
}
