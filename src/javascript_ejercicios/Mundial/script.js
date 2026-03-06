function generarInputs() {
    const n = document.getElementById('cantidadCasos').value;
    const contenedor = document.getElementById('contenedorPartidos');
    const controles = document.getElementById('controlesFinales');

    if (n < 1 || n > 100) {
        alert("Por favor ingresa un número entre 1 y 100");
        return;
    }

    contenedor.innerHTML = ''; 
    
    for (let i = 0; i < n; i++) {
        const div = document.createElement('div');
        div.className = 'fila-partido';
        div.innerHTML = `
            <span>Goles Brasil: <input type="number" class="goles-brasil" value="0"></span>
            <span>Goles Colombia: <input type="number" class="goles-colombia" value="0"></span>
            <span class="mensaje-resultado" id="res-${i}"></span>
        `;
        contenedor.appendChild(div);
    }
    
    controles.style.display = 'block';
}

function procesarResultados() {
    const filasBrasil = document.querySelectorAll('.goles-brasil');
    const filasColombia = document.querySelectorAll('.goles-colombia');

    filasBrasil.forEach((inputBrasil, index) => {
        const golesBrasil = parseInt(inputBrasil.value);
        const golesColombia = parseInt(filasColombia[index].value);
        const labelResultado = document.getElementById(`res-${index}`);

        if (golesColombia < 0 || golesBrasil < 0) {
        alert("No se aceptan numeros negativos");
        return;
    }
        if (golesColombia > golesBrasil) {
            labelResultado.innerText = "ganamos";
            labelResultado.style.color = "green";
        } else if (golesBrasil > golesColombia) {
            labelResultado.innerText = "perdimos";
            labelResultado.style.color = "red";
        } else {
            labelResultado.innerText = "casi ganamos";
            labelResultado.style.color = "blue"
        }
    });
}