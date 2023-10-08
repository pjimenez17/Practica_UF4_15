export async function getPreguntes(vueObject) {
  console.log("Fetching questions from server...");
  const response = await fetch('http://127.0.0.1:3001/questions/');
  const preguntas = await response.json();
  console.log("Questions obtained from server:", preguntas);

  // Assign preguntas directly to vueObject.preguntas
  vueObject.preguntas = preguntas;
}


export async function deletePregunta(id) {
  const response = await fetch(`http://localhost:3001/questions/${id}`,
    { method: 'DELETE' });
  console.log(response);

  console.log("quieres borrar la pregunta con id: " + id)
}

export async function addPregunta(dadesPregunta) {
  console.log("datos recibidos: " + dadesPregunta)
  const response = await fetch(`http://localhost:3001/questions`,
    {
      method: 'POST', headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(dadesPregunta)
    },);
}

export async function updatePregunta(updatedQuestion, id) {
  const response = await fetch(`http://localhost:3001/questions/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(updatedQuestion),
  });

  if (response.ok) {
    const updated = await response.json();
    return updated;
  } else {
    throw new Error(`Error al actualizar la pregunta: ${response.status}`);
  }
}
