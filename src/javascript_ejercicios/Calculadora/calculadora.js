function generarCamposNotas() {
    const n = document.getElementById('numNotas').value;
    const contenedor = document.getElementById('contenedorNotas');
    const controles = document.getElementById('controlesFinales');

    if (n < 1 || n > 15) {
        alert("Por favor, ingrese un número de notas válido (1-15).");
        return;
    }

    contenedor.innerHTML = '';
    
    for (let i = 0; i < n; i++) {
        const div = document.createElement('div');
        div.className = 'fila-nota';
        div.innerHTML = `
            <label>Calificación ${i + 1}:</label>
            <input type="number" class="nota-input" step="0.1" min="0" max="5" placeholder="0.0">
        `;
        contenedor.appendChild(div);
    }
    controles.style.display = 'block';
}

function calcularPromedio() {
    const inputs = document.querySelectorAll('.nota-input');
    let suma = 0;
    let totalInputs = inputs.length;

    for (let input of inputs) {
        let val = parseFloat(input.value);
        if (isNaN(val) || val < 0 || val > 5) {
            alert("Asegúrese de que todas las notas sean números entre 0 y 5.");
            return;
        }
        suma += val;
    }

    const promedio = suma / totalInputs;
    const textoPromedio = document.getElementById('textoPromedio');
    const estadoFinal = document.getElementById('estadoFinal');

    textoPromedio.innerText = `El promedio final obtenido es: ${promedio.toFixed(2)}`;
    
    if (promedio >= 3.0) {
        estadoFinal.innerText = "SITUACIÓN: APROBADO";
        estadoFinal.className = "aprobado";
    } else {
        estadoFinal.innerText = "SITUACIÓN: REPROBADO";
        estadoFinal.className = "reprobado";
    }
}