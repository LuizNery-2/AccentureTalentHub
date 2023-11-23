
const enviarDadosBtn = document.getElementById("enviarDados");


enviarDadosBtn.addEventListener("click", function() {
    
    if (selecionados !== '') {
        console.log(selecionados);
        var IDs = selecionados.map(function(string) {
            return Number(string);
        });

            const url = "http://localhost:8080/cursosInteresses/" + localStorage.getItem('idCurso');

            atualizarInteresses(url, IDs);

            alert("Interesses adicionados ao curso com sucesso!");
            
    } else {
        alert("Selecione pelo menos uma tecnologia para continuar!");
    }
});

async function atualizarInteresses(url, IDs) {
   await fetch(url, {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(IDs)
    })
        .then(function (res) {
            if (res.ok) {
                console.log("Interesses atualizados com sucesso!");
                // window.location.href = 'home.html';
            } else {
                console.error("Falha ao atualizar interesses.");
            }
        })
        .catch(function (error) {
            console.error("Erro na solicitação: " + error);
        });
}
