import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import org.example.Atendimento;
import org.example.AtendimentoPage;
import org.example.AtendimentoService;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

// Testes MOCK
@RunWith(MockitoJUnitRunner.class)
public class AtendimentoPageTest {

    @Mock
    private AtendimentoService atendimentoService;
    private AtendimentoPage atendimentoPage;

    @Before
    public void setup(){
        atendimentoPage = new AtendimentoPage(atendimentoService);
    }

    // CASOS POSITIVOS
    @Test
    public void testeSearchYvo(){
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn(AtendimentoConst.YVO);
        Atendimento yvo = atendimentoPage.getAtendimento("Yvo");
        assertEquals("Yvo", yvo.getNomeProfessor());
    }

    @Test
    public void testeSearchSalaYvo(){
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn(AtendimentoConst.YVO);
        Atendimento yvo = atendimentoPage.getAtendimento("Yvo");
        assertEquals(14, yvo.getSala());
    }

    @Test
    public void testeSearchChris(){
        Mockito.when(atendimentoService.getAtendimento("Chris")).thenReturn(AtendimentoConst.CHRIS);
        Atendimento chris = atendimentoPage.getAtendimento("Chris");
        assertEquals("Chris", chris.getNomeProfessor());
    }

    @Test
    public void testeSearchSalaChris(){
        Mockito.when(atendimentoService.getAtendimento("Chris")).thenReturn(AtendimentoConst.CHRIS);
        Atendimento chris = atendimentoPage.getAtendimento("Chris");
        assertEquals(6, chris.getSala());
    }

    @Test
    public void testeSearchRenzo(){
        Mockito.when(atendimentoService.getAtendimento("Renzo")).thenReturn(AtendimentoConst.RENZO);
        Atendimento renzo = atendimentoPage.getAtendimento("Renzo");
        assertEquals("Renzo", renzo.getNomeProfessor());
    }

    @Test
    public void testeSearchSalaRenzo(){
        Mockito.when(atendimentoService.getAtendimento("Renzo")).thenReturn(AtendimentoConst.RENZO);
        Atendimento renzo = atendimentoPage.getAtendimento("Renzo");
        assertEquals(9, renzo.getSala());
    }

    @Test
    public void testeSearchRenan(){
        Mockito.when(atendimentoService.getAtendimento("Renan")).thenReturn(AtendimentoConst.RENAN);
        Atendimento renan = atendimentoPage.getAtendimento("Renan");
        assertEquals("Renan", renan.getNomeProfessor());
    }

    @Test
    public void testeSearchSalaRenan(){
        Mockito.when(atendimentoService.getAtendimento("Renan")).thenReturn(AtendimentoConst.RENAN);
        Atendimento renan = atendimentoPage.getAtendimento("Renan");
        assertEquals(8, renan.getSala());
    }


    @Test
    public void testeSearchMarcelo(){
        Mockito.when(atendimentoService.getAtendimento("Marcelo")).thenReturn(AtendimentoConst.MARCELO);
        Atendimento marcelo = atendimentoPage.getAtendimento("Marcelo");
        assertEquals("Marcelo", marcelo.getNomeProfessor());
    }

    @Test
    public void testeSearchSalaMarcelo(){
        Mockito.when(atendimentoService.getAtendimento("Marcelo")).thenReturn(AtendimentoConst.MARCELO);
        Atendimento marcelo = atendimentoPage.getAtendimento("Marcelo");
        assertEquals(10, marcelo.getSala());
    }

    // CASOS NEGATIVOS
    @Test
    public void testeJsonInvalido() {
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn("{nomeDoProfessor:Yvo, horarioDeAtendimento:20h00}");
        assertThrows(org.json.JSONException.class, () -> {
            atendimentoPage.getAtendimento("Yvo");
        });
    }

    @Test
    public void testeHorarioAusente() {
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn("{\"nomeDoProfessor\": \"Yvo\", \"periodo\": \"Noturno\", \"sala\": 14}");
        assertThrows(org.json.JSONException.class, () -> atendimentoPage.getAtendimento("Yvo"));
    }

    @Test
    public void testePeriodoInvalido() {
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn("{\"nomeDoProfessor\": \"Yvo\", \"horarioDeAtendimento\": \"20h00\", \"periodo\": \"Madrugada\", \"sala\": 14}");
        assertThrows(IllegalArgumentException.class, () -> atendimentoPage.getAtendimento("Yvo"));
    }

    @Test
    public void testeSalaNegativa() {
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn("{\"nomeDoProfessor\": \"Yvo\", \"horarioDeAtendimento\": \"20h00\", \"periodo\": \"Noturno\", \"sala\": -5}");
        assertThrows(IllegalArgumentException.class, () -> atendimentoPage.getAtendimento("Yvo"));
    }

    @Test
    public void testeSalaForaDoIntervalo() {
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn("{\"nomeDoProfessor\": \"Yvo\", \"horarioDeAtendimento\": \"20h00\", \"periodo\": \"Noturno\", \"sala\": 150}");
        assertThrows(IllegalArgumentException.class, () -> atendimentoPage.getAtendimento("Yvo"));
    }

    @Test
    public void testeRespostaVazia() {
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn("");
        assertThrows(org.json.JSONException.class, () -> atendimentoPage.getAtendimento("Yvo"));
    }

    @Test
    public void testeRetornoNulo() {
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> atendimentoPage.getAtendimento("Yvo"));
    }

    @Test
    public void testeNomeProfessorNulo() {
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenReturn("{\"nomeDoProfessor\": null, \"horarioDeAtendimento\": \"20h00\", \"periodo\": \"Noturno\", \"sala\": 14}");
        assertThrows(JSONException.class, () -> atendimentoPage.getAtendimento("Yvo"));
    }

    @Test
    public void testeServicoLancaExcecao() {
        Mockito.when(atendimentoService.getAtendimento("Yvo")).thenThrow(new RuntimeException("Erro no serviço externo"));
        assertThrows(RuntimeException.class, () -> atendimentoPage.getAtendimento("Yvo"));
    }

    @Test
    public void testeNomeProfessorVazio() {
        Mockito.when(atendimentoService.getAtendimento("")).thenThrow(new IllegalArgumentException("Nome do professor não pode ser vazio"));
        assertThrows(IllegalArgumentException.class, () -> atendimentoPage.getAtendimento(""));
    }






}