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
    document.getElementById("volume").innerHTML = "Volumetria: " + volume

    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'pie',

        // The data for our dataset
        data: {
            labels: ['Sucesso', 'Falha', 'Fraude'],
            datasets: [{
                label: 'My First dataset',
                backgroundColor: ["#5cb85c","#f0ad4e","#d9534f"],
                borderColor: 'rgb(0, 0, 0)',
                data: [sucesso, falha, fraude]
            }]
        },

        // Configuration options go here
        options: {}
    });
})


