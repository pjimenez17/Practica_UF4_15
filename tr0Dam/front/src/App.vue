<script>
import { getPreguntes, deletePregunta, addPregunta, updatePregunta } from './communicationsManager';

export default {

  data() {
    return {
      preguntas: [],
      nuevaPregunta: {
        id: "",
        pregunta: "",
        opciones: ["",
          "",
          "",
          ""
        ],
        respuesta_correcta: 0,
        imagen: ""
      },
      preguntaEditada: {
        id: "",
        pregunta: "",
        opciones: ["",
          "",
          "",
          ""
        ],
        respuesta_correcta: 0,
        imagen: ""
      },
      verAfegirPregunta: false,
      verEditarPregunta: false,
    }
  },

  created() {
    getPreguntes(this);
  },

  methods: {
    afegirPregunta() {
      this.verAfegirPregunta = true;
    },
    editarPregunta(pregunta) {
      this.verEditarPregunta = true;
      //Recibe la pregunta entera
      this.preguntaEditada = { ...pregunta }
    },
    esborrarPregunta(id) {
      deletePregunta(id);
      getPreguntes(this)

    },

    afegirnovaPregunta() {
      const fecha = new Date();
      const novaid = "id_" + fecha.getHours() + "_" + fecha.getMinutes() + "_" + fecha.getSeconds() + "_" + fecha.getMilliseconds();
      this.nuevaPregunta.id = novaid;
      addPregunta(this.nuevaPregunta);
      getPreguntes(this);
      this.nuevaPregunta = {
        id: "",
        pregunta: "",
        opciones: ["", "", "", ""],
        respuesta_correcta: 0,
        imagen: ""
      };
    },
    actualizarPregunta() {
      updatePregunta(this.preguntaEditada, this.preguntaEditada.id);
      this.verEditarPregunta = false;
      getPreguntes(this);
      this.preguntaEditada = {
        id: "",
        pregunta: "",
        opciones: ["", "", "", ""],
        respuesta_correcta: 0,
        imagen: ""
      };
    }



  }
}
</script>

<template>
  <div class="mostrarMenu" aria-setsize="6">
    <button @click="afegirPregunta" style="background-color: green; color: white;">Afegir Pregunta</button><br>
    <button @click="" style="background-color: blue; color: white;">Veure Estadistiques</button><br><br>
    <br>
    <ul>
      <!-- Entre parentesis se crea la pregunta y un indice que va iterando en preguntas, el indice es una variable que va aumentando++ -->
      <li v-for="(pregunta, indice) in preguntas" :key="indice">
        {{ console.log(pregunta) }}
        <!-- el key seria como un ++ que va aumentando a cada vuelta -->
        <img :src="pregunta.imagen" alt="" style="height: auto; width: 300px;"><br>
        <!-- Y se muestra con la pregunta creada. pregunta que es contenido de in preguntas -->
        {{ pregunta.pregunta }}<br>
        <button @click="editarPregunta(pregunta)">Editar pregunta</button>
        <button @click="esborrarPregunta(pregunta.id)" style="background-color: red; color: white;">Eliminar
          pregunta</button>
        <ul>
          <!-- Se crea la opcion como antes y el index y ahora lo busca en pregunta la creada antes. opciones y muestra unicamente la opcion -->
          <li v-for="(opcion, index) in pregunta.opciones" :key="index">
            {{ opcion }}
          </li>
          <br><br>
        </ul>
      </li>
    </ul>
  </div>
  <!-- Menu de afegir preguntas -->
  <div class="mostrarAfegirPregunta" aria-setsize="6" v-if="verAfegirPregunta">
    <h2>Añadir Pregunta</h2>
    <form @submit="afegirnovaPregunta()">
      <label for="pregunta">Pregunta:</label>
      <input type="text" v-model="nuevaPregunta.pregunta" required><br><br>

      <label for="opciones">Opciones:</label>
      <div v-for="(opcion, index) in nuevaPregunta.opciones" :key="index">
        <input type="text" v-model="nuevaPregunta.opciones[index]" required>
        <input type="radio" v-model="nuevaPregunta.respuesta_correcta" :value="index"> Correcta
      </div>

      <label for="imagen">URL de la Imagen:</label>
      <input type="text" v-model="nuevaPregunta.imagen"><br>

      <button type="submit">Agregar Pregunta</button>
    </form>
  </div>

  <!-- Menu de editar preguntes-->
  <div class="mostrarEditarPregunta" aria-setsize="6" v-if="verEditarPregunta">
    <h2>Editar pregunta</h2>
    <form @submit="actualizarPregunta()">
      <label for="pregunta">Pregunta: </label>
      <input type="text" v-model="preguntaEditada.pregunta"><br><br>

      <label for="opciones">Opciones:</label>
      <div v-for="(opcion, index) in preguntaEditada.opciones" :key="index">
        <input type="text" v-model="preguntaEditada.opciones[index]" required>
        <input type="radio" v-model="preguntaEditada.respuesta_correcta" :value="index"> Correcta
      </div>

      <label for="imagen">URL de la Imagen:</label>
      <input type="text" v-model="preguntaEditada.imagen"><br>

      <button type="submit">Guardar Edición</button>
    </form>

  </div>
</template>


<style scoped>
button {
  font-weight: bold;
}
</style>