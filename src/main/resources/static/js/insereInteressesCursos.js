function buscarUltimoId(){
    const url = 'http://localhost:8080/cursos/last-id';

    fetch(url)
    .then(response => {
        if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        // O data conterá o último ID de curso, ou null se não houver cursos cadastrados
        // alert('Último ID de curso:' + data);
        localStorage.setItem('ultimoIdCurso', data);
    })
    .catch(error => {
        console.error('Erro ao obter o último ID de curso:', error);
    });
}


const enviarDadosBtn = document.getElementById("enviarDados");


enviarDadosBtn.addEventListener("click", function() {
    
    if (selecionados !== '') {
        console.log(selecionados);
        var IDs = selecionados.map(function(string) {
            return Number(string);
        });

            const idCurso = localStorage.getItem('idCurso');
            const url = "http://localhost:8080/cursosInteresses/" + localStorage.getItem('ultimoIdCurso');

            atualizarInteresses(url, IDs);

            alert("Interesses adicionados ao curso com sucesso!");
            
    } else {
        alert("Selecione pelo menos uma tecnologia para continuar!");
    }
});

function atualizarInteresses(url, IDs) {
    fetch(url, {
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