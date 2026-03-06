function crearInputs() {

    let n = document.getElementById("cantidad").value;
    let contenedor = document.getElementById("contenedor");

    contenedor.innerHTML = "";

    for (let i = 0; i < n; i++) {

        contenedor.innerHTML += `
        <div>
            Estudiante ${i+1}:
            <input type="number" id="n1_${i}">
            <input type="number" id="n2_${i}">
            <input type="number" id="n3_${i}">
            <span id="resultado_${i}"></span>
        </div>
        `;
    }

    contenedor.innerHTML += `<br><button onclick="calcular()">Calcular</button>`;
}

function calcular() {

    let n = document.getElementById("cantidad").value;

    for (let i = 0; i < n; i++) {

        let a = parseInt(document.getElementById(`n1_${i}`).value);
        let b = parseInt(document.getElementById(`n2_${i}`).value);
        let c = parseInt(document.getElementById(`n3_${i}`).value);

        let mayor = Math.max(a,b,c);
        let menor = Math.min(a,b,c);

        let medio = a + b + c - mayor - menor;

        document.getElementById(`resultado_${i}`).innerText = " Nota media: " + medio;
    }
}