function generarFilas() {
    const n = document.getElementById('numCasos').value;
    const contenedor = document.getElementById('contenedorCasos');
    const controles = document.getElementById('controlesFinales');

    if (n < 1 || n > 100) {
        alert("Ingresa un número entre 1 y 100");
        return;
    }

    contenedor.innerHTML = '';
    
    for (let i = 0; i < n; i++) {
        const div = document.createElement('div');
        div.className = 'fila-conector';
        div.innerHTML = `
            <div class="inputs-group">
                <input type="text" class="conector" placeholder="Conector (ej: 0 1 0 1 0 1)">
                <input type="text" class="tomacorriente" placeholder="Toma (ej: 1 0 1 0 1 0)">
            </div>
            <div class="resultado-badge" id="res-${i}"></div>
        `;
        contenedor.appendChild(div);
    }
    controles.style.display = 'block';
}

function validarConexiones() {
    const conectores = document.querySelectorAll('.conector');
    const tomas = document.querySelectorAll('.tomacorriente');

    conectores.forEach((el, i) => {
        const cArr = el.value.trim().split(/\s+/);
        const tArr = tomas[i].value.trim().split(/\s+/);
        const resDiv = document.getElementById(`res-${i}`);

        if (cArr.length !== 6 || tArr.length !== 6) {
            resDiv.innerText = "ERROR: Deben ser 6 números";
            resDiv.style.color = "red";
            return;
        }

        let esCompatible = true;
        for (let j = 0; j < 6; j++) {
            if (cArr[j] === tArr[j]) {
                esCompatible = false;
                break;
            }
        }

        if (esCompatible) {
            resDiv.innerText = "COMPATIBLE";
            resDiv.style.color = "white";
        } else {
            resDiv.innerText = "INCOMPATIBLE";
            resDiv.style.color = "red";
        }
    });
}