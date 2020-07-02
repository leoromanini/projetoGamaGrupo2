function autenticar(event) {
    event.preventDefault();

    let user = document.getElementById("user").value;
    let senha = document.getElementById("password").value;

    let loginMsg = {
        login: user,
        senha: senha
    }

    let cabecalho = {
        method: 'POST',
        body: JSON.stringify(loginMsg),
        headers: {
            'Content-Type': 'application/json'
        }
    }

    fetch("http://localhost:8080/login", cabecalho)
        .then(res => tratarReposta(res));

}

function tratarReposta(res){
    if (res.status == 200){
        res.json().then(res => logarUsuario(res));
        location.href = "home.html"
    }else{
        elemento = document.getElementById("msgError")
        elemento.innerHTML = "Login inválido!"

        elemento = document.getElementById("container-erro")
        elemento.classList.add("alert");
        elemento.classList.add("alert-secondary");
    }
}


function logarUsuario(res){
    localStorage.setItem("usuarioLogado", JSON.stringify(res));
}