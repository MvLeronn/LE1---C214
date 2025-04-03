package org.example;

public class Atendimento {
    private String nomeProfessor;
    private String horario;
    private String periodo;
    private int sala;
    private int predio;

    public Atendimento(String nomeProfessor, String horario, String periodo, int sala) {
        if (nomeProfessor == null || nomeProfessor.isBlank()) {
            throw new IllegalArgumentException("Nome do professor inválido");
        }
        if (horario == null || horario.isBlank()) {
            throw new IllegalArgumentException("Horário inválido");
        }
        if (periodo == null || periodo.isBlank() || !(periodo.equals("Integral") || periodo.equals("Noturno"))) {
            throw new IllegalArgumentException("Periodo inválido");
        }
        if (sala <= 0 || sala > 100) {
            throw new IllegalArgumentException("Sala inválida");
        }
        this.nomeProfessor = nomeProfessor;
        this.horario = horario;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = ((sala - 1) / 5) + 1;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public String getHorario() {
        return horario;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getSala() {
        return sala;
    }

    public int getPredio() {
        return predio;
    }
}
