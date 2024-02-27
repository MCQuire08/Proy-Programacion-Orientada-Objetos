package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.logic.LineaAereaGestor;

import java.util.ArrayList;

public class Pruebas {
    LineaAereaGestor lineaAereaGestor = new LineaAereaGestor();

    public void listar() throws Exception {
        ArrayList<LineaAerea> lista = lineaAereaGestor.listarLineasAereas();
        for (LineaAerea lineaAerea:lista){
            System.out.println(lineaAerea.toString());
        }
    }
}
