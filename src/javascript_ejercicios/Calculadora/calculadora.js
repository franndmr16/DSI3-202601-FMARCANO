const porcentajes = [0.05, 0.10, 0.10, 0.10, 0.15, 0.15, 0.15, 0.20];

function generarCamposNotas() {
    const contenedor = document.getElementById('contenedorNotas');
    const controles = document.getElementById('controlesFinales');

    contenedor.innerHTML = '';
    
    for (let i = 0; i < 8; i++) {
        const div = document.createElement('div');
        div.className = 'fila-nota';
        div.innerHTML = `
            <label>Nota ${i + 1} (${porcentajes[i] * 100}%):</label>
            <input type="number" class="nota-input" step="0.1" min="0" max="5" placeholder="0.0">
        `;
        contenedor.appendChild(div);
    }
    controles.style.display = 'block';
}

function calcularPromedio() {
    const inputs = document.querySelectorAll('.nota-input');
    let notaFinalPonderada = 0;
    inputs.forEach((input, index) => {
        let val = parseFloat(input.value);
        if (isNaN(val) || val < 0 || val > 5) {
            alert("Asegúrese de que todas las notas sean números entre 0 y 5.");
            return;
        }
        notaFinalPonderada += val * porcentajes[index];
    });

    const textoPromedio = document.getElementById('textoPromedio');
    const estadoFinal = document.getElementById('estadoFinal');

    textoPromedio.innerText = `La calificación definitiva es: ${notaFinalPonderada.toFixed(2)}`;
    
    if (notaFinalPonderada >= 3.0) {
        estadoFinal.innerText = "SITUACIÓN: APROBADO";
        estadoFinal.className = "aprobado";
    } else {
        estadoFinal.innerText = "SITUACIÓN: REPROBADO";
        estadoFinal.className = "reprobado";
    }
}