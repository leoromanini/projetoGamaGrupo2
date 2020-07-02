let user = localStorage.getItem("usuarioLogado");
let nomeUsuario = JSON.parse(user).nome;
let racf = JSON.parse(user).racf;

document.getElementById("user").innerHTML = nomeUsuario;
document.getElementById("racf").innerHTML = racf;