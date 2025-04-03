import org.example.Atendimento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Testes Unitários
public class AtendimentoTest {

    @Test
    void testProfessorA() {
        Atendimento horario = new Atendimento("Professor A", "Segunda 15h","Integral", 1);
        assertEquals("Professor A", horario.getNomeProfessor());
    }

    @Test
    void testHorarioA() {
        Atendimento horario = new Atendimento("Professor A", "Segunda 15h","Integral", 1);
        assertEquals("Segunda 15h", horario.getHorario());
    }

    @Test
    void testSalaA() {
        Atendimento horario = new Atendimento("Professor A", "Segunda 15h","Integral", 1);
        assertEquals(1, horario.getSala());
    }

    @Test
    void testPredioA() {
        Atendimento horario = new Atendimento("Professor A", "Segunda 15h","Integral", 1);
        assertEquals(1, horario.getPredio());
    }

    @Test
    void testProfessorB() {
        Atendimento horario = new Atendimento("Professor B", "Quarta 8h","Integral", 7);
        assertEquals("Professor B", horario.getNomeProfessor());
    }

    @Test
    void testHorarioB() {
        Atendimento horario = new Atendimento("Professor B", "Quarta 8h","Integral", 7);
        assertEquals("Quarta 8h", horario.getHorario());
    }

    @Test
    void testSalaB() {
        Atendimento horario = new Atendimento("Professor B", "Quarta 8hh","Integral", 7);
        assertEquals(7, horario.getSala());
    }

    @Test
    void testPredioB() {
        Atendimento horario = new Atendimento("Professor B", "Quarta 8h","Integral", 7);
        assertEquals(2, horario.getPredio());
    }

    @Test
    void testPredioC() {
        Atendimento horario = new Atendimento("Professor C", "Quarta 10h","Integral", 12);
        assertEquals(3, horario.getPredio());
    }

    @Test
    void testPredioD() {
        Atendimento horario = new Atendimento("Professor D", "Quarta 10h","Integral", 17);
        assertEquals(4, horario.getPredio());
    }

    @Test
    void testHorarioComSalaNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento("Professor F", "Sábado 8h","Integral", -1));
        assertEquals("Sala inválida", exception.getMessage());
    }

    @Test
    void testHorarioComSalaZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento("Professor G", "Domingo 10h","Integral", 0));
        assertEquals("Sala inválida", exception.getMessage());
    }

    @Test
    void testHorarioComProfessorVazio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento("", "Segunda 10h", "Integral",3));
        assertEquals("Nome do professor inválido", exception.getMessage());
    }

    @Test
    void testHorarioComHorarioVazio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento("Professor I", "", "Integral",3));
        assertEquals("Horário inválido", exception.getMessage());
    }

    @Test
    void testHorarioComProfessorNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento(null, "Segunda 10h","Integral", 3));
        assertEquals("Nome do professor inválido", exception.getMessage());
    }

    @Test
    void testHorarioComHorarioNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento("Professor J", null, "Integral",3));
        assertEquals("Horário inválido", exception.getMessage());
    }

    @Test
    void testHorarioComSalaExtremamenteAlta() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento("Professor K", "Quarta 14h","Integral", Integer.MAX_VALUE));
        assertEquals("Sala inválida", exception.getMessage());
    }

    @Test
    void testHorarioComSalaMuitoAlta() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento("Professor H", "Segunda 12h", "Integral",150));
        assertEquals("Sala inválida", exception.getMessage());
    }

    @Test
    void testHorarioComNomeProfessorComEspacosApenas() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento("  ", "Quinta 16h", "Integral",2));
        assertEquals("Nome do professor inválido", exception.getMessage());
    }

    @Test
    void testHorarioComHorarioComEspacosApenas() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Atendimento("Professor L", "   ","Integral", 2));
        assertEquals("Horário inválido", exception.getMessage());
    }

}
