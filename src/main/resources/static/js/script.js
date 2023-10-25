$(document).ready(function() {
    
    //Exibir o menu resposivo
    $("#icon-menu-responsivo").click(function() {
        $(".nav-responsivo").css("display", "flex");
        if($(".nav-responsivo").css("display", "flex")){
            $(".nav-responsivo").animate({ left: "0px" }, 500); 
        }
    });

    //Fechar o menu resposivo
    $("#icon_fechar-responsivo").click(function() {
        $(".nav-responsivo").animate({ left: "-250px" }, 500)
        $(".nav-responsivo").css("display", "none");
    });

    //Animação do menu resposivo
    $("#icon-menu-responsivo").click(function() {
    });
    
    $("#icon_fechar-responsivo").click(function() {
    });

    //Botão suspeso de sair
    // const iconPerfil = document.getElementById('icon_usuario_menu-responsivo');
    // const menuSuspenso = document.getElementById('menu-suspenso');

    // iconPerfil.addEventListener('click', function() {
    //     menuSuspenso.classList.toggle('active');
    // });

    // document.addEventListener('click', function(event) {
    //     if (!menuSuspenso.contains(event.target) && event.target !== iconPerfil) {
    //         menuSuspenso.classList.remove('active');
    //     }
    // });



});

