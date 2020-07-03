window.addEventListener('load', function () {
    let sucesso = localStorage.getItem("sucesso");
    let falha = localStorage.getItem("falha");
    let fraude = localStorage.getItem("fraude");
    let nome = localStorage.getItem("nome");
    let volume = localStorage.getItem("volume");

    document.getElementById("sucesso").innerHTML = sucesso
    document.getElementById("falha").innerHTML = falha
    document.getElementById("fraude").innerHTML = fraude
    document.getElementById("nome").innerHTML = nome
    document.getElementById("volume").innerHTML = "Volumetria: "+volume
})
