function logout(){
    localStorage.removeItem("usuarioLogado");
    window.location = "login.html"
}