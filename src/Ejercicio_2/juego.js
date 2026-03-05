function crearSelects() {
    const cantidad = parseInt(document.getElementById("cantidad").value);
    const contenedor = document.getElementById("contenedor");
    contenedor.innerHTML = ""; 

    if (!cantidad || cantidad < 1 || cantidad > 100) {
        alert("Ingrese un número entre 1 y 100");
        return;
    }

    // Crear los selects
    for (let i = 0; i < cantidad; i++) {
        const select = document.createElement("select");

        ["ALICE", "BOB", "EMPATE"].forEach(opcion => {
            const opt = new Option(opcion, opcion);
            select.add(opt);
        });

        contenedor.appendChild(select);
        contenedor.appendChild(document.createElement("br"));
    }

    const boton = document.createElement("button");
    boton.innerText = "Calcular";
    boton.onclick = calcular;
    contenedor.appendChild(boton);
}

function calcular() {
    const selects = document.getElementsByTagName("select");
    let puntosAlice = 0;
    let puntosBob = 0;

    for (let i = 0; i < selects.length; i++) {
        const valor = selects[i].value;
        if (valor === "ALICE") {
            puntosAlice += 2;
        } else if (valor === "BOB") {
            puntosBob += 2;
        } else {
            puntosAlice += 1;
            puntosBob += 1;
        }
    }

    if (puntosAlice > puntosBob) {
        alert("ALICE");
    } else if (puntosBob > puntosAlice) {
        alert("BOB");
    } else {
        alert("EMPATE");
    }
}