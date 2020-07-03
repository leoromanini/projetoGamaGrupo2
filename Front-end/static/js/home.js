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

function solicitarParceiro(){
    var e = document.getElementById("parceiro");
    var idParceiro = e.options[e.selectedIndex].value;

    localStorage.setItem("nome",e.options[e.selectedIndex].innerHTML);

    let parceirosMsg = {
        agFinanceiro: idParceiro,
        idAgente: idParceiro 
    }

    let cabecalho = {
        method: 'POST',
        body: JSON.stringify(parceirosMsg),
        headers: {
            'Content-Type': 'application/json'
        }
    }

    fetch("http://localhost:8080/agentetransacao", cabecalho)
        .then(res => tratarVolumetria(res));

    fetch("http://localhost:8080/transacoesstatus", cabecalho)
        .then(res => tratarReposta(res));

}

function tratarVolumetria(res){
    res.json().then(res => persistirVolume(res));
}

function persistirVolume(res){
    localStorage.setItem("volumetria", JSON.stringify(res));
    let volumetria = localStorage.getItem("volumetria");

    let volume = JSON.parse(volumetria);
    localStorage.setItem("volume", volume[0].volumeTransacional);
}


function tratarReposta(res){
    res.json().then(res => setarStatus(res));
    
}

function setarStatus(res){
    localStorage.setItem("sucesso",String(res[0]).split(",")[0]);
    localStorage.setItem("falha",String(res[1]).split(",")[0]);
    localStorage.setItem("fraude",String(res[2]).split(",")[0]);
    location.href = "parceiros.html"
}

