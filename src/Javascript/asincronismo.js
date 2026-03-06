function ejecutar() {

    let segundos = document.getElementById("tiempo").value;

    if (segundos <= 0) {
        alert("Ingrese un tiempo válido");
        return;
    }

    let tiempoBase = segundos * 1000;

    setTimeout(function () {
        alert("Pasaron " + segundos + " segundos");
    }, tiempoBase);

    for (let i = 1; i <= 3; i++) {

        let aleatorio = Math.floor(Math.random() * 101);
        let tiempoFinal = tiempoBase + aleatorio;

        new Promise(function (resolve) {

            setTimeout(function () {
                resolve("Promesa " + i + 
                        " terminó en " + tiempoFinal + " ms");
            }, tiempoFinal);

        }).then(function (mensaje) {
            console.log(mensaje);
        });

    }
}