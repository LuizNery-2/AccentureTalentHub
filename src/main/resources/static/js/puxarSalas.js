document.addEventListener('DOMContentLoaded', function () {
    // Simular dados do backend
    const url = "http://localhost:8080/salasUsuario/" + localStorage.getItem('idUsuario');
    fetch(url)
        .then(response => response.json())
        .then(data => {
            // Manipular o DOM para gerar a estrutura HTML
            const container = document.getElementById('dynamic-content-container');

            data.forEach(item => {
                const link = document.createElement('a');
                link.href = item.link;

                const imagem = document.createElement('img');
                imagem.src = item.banner;
                imagem.alt = '';

                link.appendChild(imagem);
                container.appendChild(link);
            });
        })
        .catch(error => console.error('Erro ao buscar dados do backend:', error));
});