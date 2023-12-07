package com.accenture.accenturetalenthub.services;


import com.accenture.accenturetalenthub.models.AulaModel;
import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.ModuloModel;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SortModels {
    public CursoModel ordenarModulosAulas(CursoModel curso)
    {
        List<ModuloModel> modulos = new ArrayList<>(curso.getModulos());
        List<AulaModel> aulas = new ArrayList<>();

        // Iterar sobre os módulos e adicionar todas as aulas à lista de aulas
        for (ModuloModel modulo : modulos) {
            aulas.addAll(modulo.getAulas());
        }

        // Ordenar as listas de módulos e aulas
        modulos.sort(Comparator.comparing(ModuloModel::getNomeModulo)); // Substitua 'getNome' pelo método desejado de comparação

        // Converter as listas ordenadas de volta para conjuntos
        Set<ModuloModel> modulosOrdenados = new LinkedHashSet<>(modulos);
        for (ModuloModel modulo : modulosOrdenados) {
            List<AulaModel> aulasDoModuloOrdenadas = modulo.getAulas().stream()
                    .sorted(Comparator.comparing(AulaModel::getNomeAula))
                    .collect(Collectors.toList());

            Set<AulaModel> aulasDoModuloSetOrdenadas = new LinkedHashSet<>(aulasDoModuloOrdenadas);

            modulo.setAulas(aulasDoModuloSetOrdenadas);
        }

        curso.setModulos(modulosOrdenados);
        return curso;
    }
}
