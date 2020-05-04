package PlanetBound.GameLogic.Dados.Nave;

import com.sun.org.omg.CORBA.Initializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CrewMember {

    String nome;
    String descricao;

    private CrewMember (String nome) {
        this.nome = nome;
    }

    public List<CrewMember> InitializerCrewMembers (List<String> membros) {
        List<CrewMember> officers = new ArrayList<>();
        for(String nome : membros) {
            officers.add(new CrewMember(nome));
        }

        return officers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CrewMember cM = (CrewMember) o;

        return nome.equals(cM.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
