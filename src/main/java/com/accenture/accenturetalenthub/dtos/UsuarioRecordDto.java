package com.accenture.accenturetalenthub.dtos;

import java.util.List;



public record UsuarioRecordDto( List<String> interesses,  String senha,  String usuario,  String nome, String cargo, String foto,  
                                int pontuacaoGeral,  int nivel, int nivelInteresse,  List<String> cursosConcluidos) {
   
}
