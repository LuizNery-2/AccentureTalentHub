const url = "http://localhost:8080/usuario/" + localStorage.getItem('idUsuario');
function atualizarSenha(id) {
    fetch(url, {
        method: "PUT",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            senha: localStorage.getItem('novaSenha'),
            usuario: localStorage.getItem('usuario'),
            nome: localStorage.getItem('nome'),
            cargo: localStorage.getItem('cargo'),
            foto: localStorage.getItem('foto'),
            pontuacaoGeral: localStorage.getItem('pontuacaoGeral'),
            nivel: localStorage.getItem('nivel'),
            nivelInteresse: localStorage.getItem('nivelInteresse'),
            email: localStorage.getItem('email'),
            nivelUsuario: localStorage.getItem('nivelUsuario')
        })
    })
    .then(function (res) {
        if (res.ok) {
            console.log("Senha atualizada com sucesso!");
        } else {
            console.error("Falha ao atualizar senha.");
        }
    })
    .catch(function (error) {
        console.error("Erro na solicitação: " + error);
    });
}







senhaInput.addEventListener('input', function () {
    const senha = senhaInput.value;
    const senhaConfirmacao = senhaConfirmacaoInput.value;
    

    // Validação do tamanho mínimo
    if (senha.length >= 8) {
        validacaoMinimo.style.color = 'green';
    }

    // Validação de letras minúsculas e maiúsculas
    if (/[a-z]/.test(senha) && /[A-Z]/.test(senha)) {
        validacaoLetras.style.color = 'green';
    }

    // Validação de caracteres especiais (por exemplo, !, @, #, $, etc.)
    if (/[!@#$%^&*]/.test(senha)) {
        validacaoCaracteres.style.color = 'green';
    }
});

formNovaSenha.addEventListener('submit', function (e) {
e.preventDefault();

    const senha = senhaInput.value;
    const senhaConfirmacao = senhaConfirmacaoInput.value;
    const verificacao = codigoVerificacao.value;

    // Validação de confirmação de senha
    if (senha === senhaConfirmacao && verificacao === localStorage.getItem('codigoAleatorio')) {
        localStorage.setItem('novaSenha', senhaConfirmacao)

        atualizarSenha();

        window.location.href = 'areainteresse.html';
        
    } else {
        const mensagem = 'As senhas ou código não são correspondentes';
        mensagemErro.textContent = mensagem;
    }


});