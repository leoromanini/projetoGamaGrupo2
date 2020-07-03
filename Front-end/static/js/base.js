function logout(){
    localStorage.removeItem("usuarioLogado");
    window.location = "login.html"
}

function homePage(){
    window.location = "home.html"
}
