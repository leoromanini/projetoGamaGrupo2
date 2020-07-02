let user = localStorage.getItem("usuarioLogado");
let nomeUsuario = JSON.parse(user).nome;
let racf = JSON.parse(user).racf;

document.getElementById("user").innerHTML = nomeUsuario;
document.getElementById("racf").innerHTML = racf;


function carregarDados(){
    fetch("http://localhost:8080/agentes")
    .then(res => res.json())
    .then(res => preencher(res))
}


function preencher(res){
    let texto = "<table class='table table-striped orders table-center'> <thead> <tr><th scope='col'>Parceiro</th><th scope='col'>Volume Transacional</th></tr></thead><tbody>";

    for (let index = 0 ; index < res.length; index++){
        texto = texto + `<tr>
                            <td> ${res[index][0]}</td>
                            <td> ${res[index][1]}</td>
                        </tr>`;
    }

    texto = texto + "</tbody></table>";
    document.getElementById("conteudo").innerHTML = texto;
}

carregarDados();
