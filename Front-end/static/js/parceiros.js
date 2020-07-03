window.addEventListener('load', function () {
    let sucesso = localStorage.getItem("sucesso");
    let falha = localStorage.getItem("falha");
    let fraude = localStorage.getItem("fraude");

    document.getElementById("sucesso").innerHTML = sucesso
    document.getElementById("falha").innerHTML = falha
    document.getElementById("fraude").innerHTML = fraude

})